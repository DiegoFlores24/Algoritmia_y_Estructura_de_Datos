package Ejercicio_01;

import java.util.*;

public class SubconjuntoDePotenciasRestringidas {

    public static boolean esPotenciaDe2(int num) {
        return (num > 0) && (num & (num - 1)) == 0;
    }

    public static boolean esMultiploDe5(int num) {
        return num % 5 == 0;
    }

    public static boolean esPosibleSubconjunto(int[] arreglo, int objetivo) {
        int n = arreglo.length;
        
        boolean[] dp = new boolean[objetivo + 1];
        dp[0] = true;  

        List<Integer> potenciasDe2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (esPotenciaDe2(arreglo[i])) {
                potenciasDe2.add(arreglo[i]);
            }
        }

        for (int potencia : potenciasDe2) {
            for (int j = objetivo; j >= potencia; j--) {
                dp[j] = dp[j] || dp[j - potencia];
            }
        }

        for (int i = 0; i < n; i++) {
            if (esPotenciaDe2(arreglo[i])) continue;

            if (esMultiploDe5(arreglo[i]) && (i + 1 < n && arreglo[i + 1] % 2 != 0)) {
                continue;
            }

            for (int j = objetivo; j >= arreglo[i]; j--) {
                dp[j] = dp[j] || dp[j - arreglo[i]];
            }
        }

        return dp[objetivo];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arreglo = new int[n];
        for (int i = 0; i < n; i++) {
            arreglo[i] = scanner.nextInt();
        }
        int objetivo = scanner.nextInt(); 

        if (esPosibleSubconjunto(arreglo, objetivo)) {
            System.out.println("Sí, es posible encontrar un subconjunto con la suma " + objetivo);
        } else {
            System.out.println("No, no es posible encontrar un subconjunto con la suma " + objetivo);
        }

        scanner.close();
    }
}

