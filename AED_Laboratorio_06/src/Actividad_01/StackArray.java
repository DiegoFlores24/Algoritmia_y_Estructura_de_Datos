package Actividad_01;

public class  StackArray<E> implements Stack<E> {
	private E[] array;// Arreglo que almacena los elementos de la pila
	private int tope;// Índice del elemento en el tope de la pila
	
	
	public StackArray(int n) {
		this.array = (E[])new Object[n]; // Inicializa el arreglo genérico
		tope = -1; // Inicialmente la pila está vacía
	}
	
    // Inserta un elemento en el tope de la pila
	@Override
	public void push(E x) {
		if(isFull()) {
			throw new IllegalStateException("Pila llena");
		}
		array[++tope] = x;// Incrementa el tope y luego inserta el elemento
	}
	
    // Elimina y retorna el elemento del tope
	@Override
	public E pop() throws ExceptionIsEmpty { 
		if(isEmpty()) {
			throw new ExceptionIsEmpty("Pila vacia");
		}
		return array[tope--];// Devuelve el tope y luego lo decrementa
	}
	
    // Retorna el elemento en el tope sin eliminarlo
	@Override
	public E top() throws ExceptionIsEmpty {
		if(isEmpty()) {
			throw new ExceptionIsEmpty("Pila vacia");
		}
		return array[tope];
	}
	
    // Verifica si la pila está vacía
	@Override
	public boolean isEmpty() { 
		  return this.tope == -1; 
	}
	
    // Verifica si la pila está llena (solo útil porque usamos un arreglo)
	public boolean isFull() {
		return tope == array.length - 1;
	}
	
    // Devuelve una representación en texto de los elementos en la pila (de tope a fondo)
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = tope; i >= 0; i--) {
            sb.append(array[i]).append(" ");
        }
        return sb.toString().trim();
    }	
}
