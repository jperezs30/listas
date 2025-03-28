package umg.edu.progra.listas.doblementeEnlazada;

public class DoblementeEnlazada {

	private Nodo head;
	private Nodo tail;

	public DoblementeEnlazada() {
		this.head = null;
		this.tail = null;
	}

	public void insertAtEnd(int data) {
		Nodo newNode = new Nodo(data);
		if (tail == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	public void insertAtBeginning(int data) {
		Nodo newNode = new Nodo(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	public boolean delete(int data) {
		Nodo current = head;
		while (current != null) {
			if (current.data == data) {
				if (current == head) {
					head = current.next;
					if (head != null)
						head.prev = null;
				} else if (current == tail) {
					tail = current.prev;
					if (tail != null)
						tail.next = null;
				} else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public boolean search(int data) {
		Nodo current = head;
		while (current != null) {
			if (current.data == data) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public void displayForward() {
		Nodo current = head;
		while (current != null) {
			System.out.print(current.data + " <-> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public void displayBackward() {
		Nodo current = tail;
		while (current != null) {
			System.out.print(current.data + " <-> ");
			current = current.prev;
		}
		System.out.println("null");
	}
	
	// Método 1: Contar el número de nodos en la lista
	public int contarNodos() {
            int contador = 0;
            Nodo actual = head;
            while (actual != null) {
                contador++;
                actual = actual.next;
            }
            return contador;
        }

	// Método 2: Insertar un nodo después de un valor específico
	public void insertarDespues(int valor, int nuevoValor) {
		Nodo actual = head;
		while (actual != null) {
			if (actual.data == valor) {
				Nodo nuevoNodo = new Nodo(nuevoValor);
				nuevoNodo.next = actual.next;
				nuevoNodo.prev = actual;
				if (actual.next != null) {
					actual.next.prev = nuevoNodo;
				} else {
					tail = nuevoNodo;
				}
				actual.next = nuevoNodo;
				return;
			}
			actual = actual.next;
		}
	}

	// Método 3: Revertir la lista doblemente enlazada
	public void revertirLista() {
		Nodo actual = head;
		Nodo temp = null;
		while (actual != null) {
			temp = actual.prev;
			actual.prev = actual.next;
			actual.next = temp;
			actual = actual.prev;
		}
		if (temp != null) {
			head = temp.prev;
		}
	}

}
