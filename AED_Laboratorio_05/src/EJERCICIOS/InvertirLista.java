package EJERCICIOS;

import java.util.List;  
import java.util.ArrayList;  
  
public class InvertirLista {  

    public static <T> List<T> invertirLista(List<T> lista) {  
        List<T> invertida = new ArrayList<>();          // Crea una nueva lista vacía donde se almacenarán los elementos en orden invertido
        for (int i = lista.size() - 1; i >= 0; i--) {          // Recorre la lista original desde el último elemento hasta el primero
            invertida.add(lista.get(i));              // Agrega cada elemento a la nueva lista invertida
        }  
        return invertida;  
    }  
      public static void main(String[] args) {  
        // Crea una lista de números enteros
        List<Integer> numeros = new ArrayList<>();  
        numeros.add(10);  
        numeros.add(25);  
        numeros.add(13);  
        numeros.add(2);  
  
        // Llama al método invertirLista y guarda el resultado
        List<Integer> resultado = invertirLista(numeros);  

        System.out.println("La lista original es así: " + numeros); 
        System.out.println("La lista invertida queda así: " + resultado);   
    }  
  
}  
 