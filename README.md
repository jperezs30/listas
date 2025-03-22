# listas
José Fernando Pérez Sipaque
7690-18-24917
Programación III

- Invertir lista: se recorre la lista hasta que el enlace sea nulo.  Se manejan dos nodos porque se necesita guardar el nodo actual, el siguiente e intercambiar las referencias.  Por último se cambia el primer nodo con el último encontrado.
- Obtener el elemento n: se guarda el primer nodo y se avanza los n espacios, al alcanzarlo, se hace otra iteración para llegar al último, así tendríamos el nodo n desde el final.
- Eliminar duplicados: se realizan dos recorridos, uno para recorrer todo el listado y otro para recorrer el listado hacia adelante e ir buscando los números iguales.  Al momento de encontrar un número igual, se cambia la referencia hacia el siguiente, para que el nodo ya no pertenezca a la lista.
- Tamaño de lista: se hace un recorrido hasta encontrar el último nodo y a paralelamente se lleva un contador.
- Ordener ascendente: se utilizó el método burbuja donde se revisa la lista y se empiezan a mover siempre y cuando el actual sea mayor al siguiente.
- Unir listas: se busca el último nodo de la lista y se asigna el enlace el primero de la segunda lista.
- Pares, impares: se recorre la lista y se van validando si son pares o impares y se van agregando a la respectiva lista.