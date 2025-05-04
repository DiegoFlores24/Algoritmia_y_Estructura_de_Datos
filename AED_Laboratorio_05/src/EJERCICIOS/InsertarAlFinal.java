package EJERCICIOS;

public class InsertarAlFinal {  

 static class Nodo<T> {   // Clase que define un nodo genérico de la lista enlazada
     T dato;               // Valor que almacena el nodo
     Nodo<T> siguiente;    // Referencia al siguiente nodo en la lista

     public Nodo(T dato) {  
         this.dato = dato;  
         this.siguiente = null;  
     }  
 }  

 public static <T> Nodo<T> insertarAlFinal(Nodo<T> cabeza, T valor) {  
     Nodo<T> nuevoNodo = new Nodo<>(valor);       // Crea un nuevo nodo con el valor proporcionado

     if (cabeza == null) {       // Si la lista está vacía el nuevo nodo será la nueva cabeza
         return nuevoNodo;  
     }  
     Nodo<T> actual = cabeza;       // Recorre la lista hasta llegar al último nodo
     while (actual.siguiente != null) {  
         actual = actual.siguiente;  
     }  

     actual.siguiente = nuevoNodo;       // Enlaza el nuevo nodo al final de la lista

     return cabeza;       // Devuelve la cabeza original, que no ha cambiado
 }  

 public static void main(String[] args) {  
     Nodo<String> cabeza = null;       // Se define la cabeza de la lista como null 

     cabeza = insertarAlFinal(cabeza, "Uno");  
     cabeza = insertarAlFinal(cabeza, "Dos");  
     cabeza = insertarAlFinal(cabeza, "Tres");  
     cabeza = insertarAlFinal(cabeza, "Cuatro");  

     System.out.println("La lista enlaza queda así: "); 

     Nodo<String> actual = cabeza;  
     while (actual != null) {  
         System.out.print(actual.dato + " -> ");  
         actual = actual.siguiente;  
     }  
     System.out.println("null");       // Indica el final de la lista
 }  
}
