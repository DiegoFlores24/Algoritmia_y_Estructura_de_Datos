package EJERCICIOS;
import java.util.List;  
import java.util.ArrayList;  
  
public class BuscarElemento {  

    // Método genérico que busca un elemento en una lista
    public static <T> boolean buscarElemento(List<T> lista, T valor) {      // <T> indica que el método puede trabajar con cualquier tipo de dato
        return lista.contains(valor);  // Devuelve true si la lista contiene el valor especificado, false en caso contrario
    }  
  
    // Método principal que se ejecuta al iniciar el programa
    public static void main(String[] args) {  
        // Crea una lista de tipo String
        List<String> frutas = new ArrayList<>();  
        frutas.add("Barcelona");  
        frutas.add("Melgar");  
        frutas.add("Arsenal");  
  
        System.out.println("El elemento a buscar es: " + buscarElemento(frutas, "Melgar"));   
        System.out.println("El elemento a buscar es: " + buscarElemento(frutas, "Madrid"));   
    }  
}
