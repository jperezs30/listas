package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Lista {

    private Nodo primero;

    @Override
    public String toString() {
        return "=>" + primero;
    }

    /**
     * Constructor para inicializar una lista
     */
    public Lista() {
        primero = null;
    }

    /**
     * Devuelve el nodo inicial
     *
     * @return
     */
    public Nodo leerPrimero() {
        return primero;
    }

    /**
     * Inserta valores a la lista
     *
     * @param entrada
     */
    public void insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;

    }

    /**
     * inserta un elemento a partir de anterior
     *
     * @param anterior
     * @param entrada
     */
    public void insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;

    }

    /**
     * elimina el elemento entrada
     *
     * @param entrada
     */
    public void eliminar(int entrada) {
        Nodo actual, anterior;
        boolean encontrado;
        actual = primero;
        anterior = null;
        encontrado = false;
        // Bucle de búsqueda
        while ((actual != null) && !(actual.dato == entrada)) {
            if (!(actual.dato == entrada)) {
                anterior = actual;
                actual = actual.enlace;
            }
        }
        if (actual != null) {
            // Se distingue entre que el nodo sea el cabecera
            // o del resto de la lista
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null;
        }
    }

    /**
     * busca el elemento destino
     *
     * @param destino
     * @return
     */
    public Nodo buscarLista(int destino) {
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace) {
            if (indice.dato == destino) {
                return indice;
            }
        }
        return null;
    }

    /**
     * recorre la lista y muestra cada dato
     */
    public void visualizar() {
        Nodo n;
        n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
    }
    
	/*
	* Crear los metodos que se solicitan
    /*
     * 1 - Método para invertir la lista enlazada
     */
    public void invertirLista() {
        Nodo anterior = null;
        Nodo actual = primero;
        Nodo siguiente = null;

        while (actual != null) {
            siguiente = actual.enlace;    // Guardamos el siguiente nodo
            actual.enlace = anterior;     // Invertimos el enlace del nodo actual
            anterior = actual;            // Avanzamos anterior al nodo actual
            actual = siguiente;           // Avanzamos actual al siguiente nodo guardado
        }
        primero = anterior;               // Primero ahora es el último nodo invertido
    }

    /*
     * 2 - Método para obtener el elemento en la posición n desde el final
     */
    public Nodo obtenerElementoDesdeFinal(int n) {
        if (primero == null || n <= 0) {
            return null; // lista vacía o posición inválida
        }

        Nodo punteroPrincipal = primero;
        Nodo punteroSecundario = primero;

        // Avanza el puntero principal n nodos adelante
        for (int i = 0; i < n; i++) {
            if (punteroPrincipal == null) {
                return null; // la lista tiene menos de n nodos
            }
            punteroPrincipal = punteroPrincipal.enlace;
        }

        // Ahora avanza ambos punteros hasta que punteroPrincipal llegue al final
        while (punteroPrincipal != null) {
            punteroPrincipal = punteroPrincipal.enlace;
            punteroSecundario = punteroSecundario.enlace;
        }

        // punteroSecundario ahora apunta al nodo en la posición deseada desde el final
        return punteroSecundario;
    }

    
    
    /*
     * 3 - Método para eliminar duplicados en una lista enlazada
     */
    public void eliminarDuplicados() {
        Nodo actual = primero;

        while (actual != null) {
            Nodo comparador = actual;

            // Recorremos el resto de la lista buscando duplicados
            while (comparador.enlace != null) {
                if (comparador.enlace.dato == actual.dato) {
                    // Si se encuentra un duplicado, lo saltamos
                    comparador.enlace = comparador.enlace.enlace;
                } else {
                    comparador = comparador.enlace;
                }
            }

            // avanzamos al siguiente nodo
            actual = actual.enlace;
        }
    }

    /*
     * 4 - Método para obtener el tamaño de la lista enlazada
     */
    public int obtenerTamano() {
        int contador = 0;
        Nodo actual = primero;

        while (actual != null) {
            contador++;
            actual = actual.enlace;
        }

        return contador;
    }
    
    /*
        Orden ascendente
    */
    public void ordenarAscendente() {
        if (primero == null || primero.enlace == null) {
            return; // Lista vacía o de un solo elemento, ya está ordenada.
        }

        boolean huboIntercambio;
        Nodo actual;

        do {
            huboIntercambio = false;
            actual = primero;

            while (actual.enlace != null) {
                if (actual.dato > actual.enlace.dato) {
                    // Intercambiar valores
                    int temp = actual.dato;
                    actual.dato = actual.enlace.dato;
                    actual.enlace.dato = temp;

                    huboIntercambio = true;
                }
                actual = actual.enlace;
            }
        } while (huboIntercambio);
    }

    /*
    Unir listas
    */
    public void unirListas(Lista segundaLista) {
        if (primero == null) {
            // Si la primera lista está vacía, se asigna la segunda
            primero = segundaLista.primero;
            return;
        }

        Nodo actual = primero;

        // Recorremos hasta llegar al último nodo de la primera lista
        while (actual.enlace != null) {
            actual = actual.enlace;
        }

        // Unimos el último nodo de la primera lista con el primero de la segunda
        actual.enlace = segundaLista.primero;
    }
    
    
      public void separarParesImpares(Lista listaPares, Lista listaImpares) {
            Nodo actual = primero;

            while (actual != null) {
                if (actual.dato % 2 == 0) {
                    // Insertar en lista de pares
                    listaPares.insertarCabezaLista(actual.dato);
                } else {
                    // Insertar en lista de impares
                    listaImpares.insertarCabezaLista(actual.dato);
                }
                actual = actual.enlace;
            }
       }

}
