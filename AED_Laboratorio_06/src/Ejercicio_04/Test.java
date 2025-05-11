package Ejercicio_04;

public class Test {
    public static void main(String[] args) {
        String[] entradas = {
            "()()()[()]()",     // Simulación como en la tabla del documento
            "((()))[]",         
            "([])[](",          
            "([{)]}",           
            "[",                
            "[][][]{{{}}}"      
        };

        for (String s : entradas) {
            boolean resultado = Application.symbolBalancing(s);
            System.out.println("Entrada: " + s + " → " + resultado);
        }
    }
}
