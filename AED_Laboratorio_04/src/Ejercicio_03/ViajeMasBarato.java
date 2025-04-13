package Ejercicio_03;
import java.util.Scanner;

public class ViajeMasBarato {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer número de embarcaderos
        System.out.print("Introduce el número de embarcaderos (n): ");
        int n = sc.nextInt();

        // Crear matriz de tarifas T (triangular superior)
        double[][] T = new double[n][n];
        System.out.println("Introduce la matriz de tarifas (solo parte superior, T[i][j] donde i < j):");

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.print("T[" + i + "][" + j + "]: ");
                T[i][j] = sc.nextDouble();
            }
        }

        // Calcular la matriz de costes mínimos C usando programación dinámica
        double[][] C = calcularCostesMinimos(T, n);

        // Mostrar matriz de costes mínimos
        System.out.println("\nMatriz de costes mínimos C[i][j]:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j) {
                    System.out.printf("%6.2f ", C[i][j]);
                } else {
                    System.out.print("   -   "); // No se puede remontar
                }
            }
            System.out.println();
        }

        sc.close();
    }

    public static double[][] calcularCostesMinimos(double[][] T, int n) {
        double[][] C = new double[n][n];

        for (int i = 0; i < n; i++) {
            C[i][i] = 0; 
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                C[i][j] = T[i][j]; 
                for (int k = i + 1; k < j; k++) {
                    double costeAlternativo = T[i][k] + C[k][j];
                    if (costeAlternativo < C[i][j]) {
                        C[i][j] = costeAlternativo; 
                    }
                }
            }
        }

        return C;
    }
}

