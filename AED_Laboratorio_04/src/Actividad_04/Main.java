package Actividad_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce los números separados por comas :");
        String entrada = sc.nextLine();

        String[] partes = entrada.trim().split(",");
        int[] array = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {
            array[i] = Integer.parseInt(partes[i].trim());
        }

        int moda = moda3.moda3(array, 0, array.length - 1);
        System.out.println("La moda es: " + moda);

        sc.close();
    }
}



