package Ejercicio_02;

import java.util.*;

public class KEsimoMenor {

    public static int encontrarKEsimoMenor(int[] nums, int k) {
        if (k < 1 || k > nums.length) {
            throw new IllegalArgumentException("k está fuera del rango válido.");
        }
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    private static int quickSelect(int[] arr, int izq, int der, int k) {
        if (izq == der) {
            return arr[izq];
        }

        Random rand = new Random();
        int pivoteIndex = izq + rand.nextInt(der - izq + 1);
        pivoteIndex = particionar(arr, izq, der, pivoteIndex);

        if (k == pivoteIndex) {
            return arr[k];
        } else if (k < pivoteIndex) {
            return quickSelect(arr, izq, pivoteIndex - 1, k);
        } else {
            return quickSelect(arr, pivoteIndex + 1, der, k);
        }
    }

    private static int particionar(int[] arr, int izq, int der, int pivoteIndex) {
        int pivoteValor = arr[pivoteIndex];
        intercambiar(arr, pivoteIndex, der);
        int almacenIndex = izq;

        for (int i = izq; i < der; i++) {
            if (arr[i] < pivoteValor) {
                intercambiar(arr, almacenIndex, i);
                almacenIndex++;
            }
        }

        intercambiar(arr, der, almacenIndex);
        return almacenIndex;
    }

    private static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar números separados por coma
        System.out.print("Introduce los números separados por comas : ");
        String entrada = sc.nextLine();
        String[] partes = entrada.trim().split(",");

        // Convertir a array de enteros
        int[] numeros = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {
            numeros[i] = Integer.parseInt(partes[i].trim());
        }

        // Solicitar el valor de k
        System.out.print("Introduce el valor de k: ");
        int k = sc.nextInt();

        try {
            int resultado = encontrarKEsimoMenor(numeros, k);
            System.out.println("El " + k + "-ésimo elemento más pequeño es: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
