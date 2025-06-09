package ACT;

public class ListLinked<T> {
    private Node<T> head;
    private Node<T> current;

    public ListLinked() {
        this.head = null;
        this.current = null;
    }

    // Inserta un elemento al final de la lista
    public void insertLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Busca un elemento por equals()
    public boolean search(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Elimina un elemento si existe
    public boolean remove(T data) {
        if (head == null) return false;

        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }

        Node<T> temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(data)) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Reinicia el puntero de iteración
    public void rewind() {
        current = head;
    }

    // Devuelve true si hay un siguiente elemento en la iteración
    public boolean hasNext() {
        return current != null;
    }

    // Devuelve el siguiente elemento en la iteración
    public T next() {
        if (current == null) return null;
        T data = current.data;
        current = current.next;
        return data;
    }

    // Verifica si está vacía
    public boolean isEmpty() {
        return head == null;
    }

    // Representación en cadena
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> temp = head;
        while (temp != null) {
            sb.append(temp.data.toString());
            temp = temp.next;
        }
        return sb.toString();
    }
}