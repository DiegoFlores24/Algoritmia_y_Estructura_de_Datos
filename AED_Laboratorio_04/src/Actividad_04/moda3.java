package Actividad_04;

public class moda3 {

    public static int moda3(int[] a, int prim, int ult) {
        SetVectors homogeneo = new SetVectors();
        SetVectors heterogeneo = new SetVectors();

        Limits p = new Limits(a, prim, ult);
        heterogeneo.insertar(p);

        while (heterogeneo.longMayor() > homogeneo.longMayor()) {
            p = heterogeneo.mayor();
            int mediana = p.array[(p.prim + p.ult) / 2];

            int[] izqDer = new int[2];
            pivote2(p.array, mediana, p.prim, p.ult, izqDer);

            Limits p1 = new Limits(p.array, p.prim, izqDer[0] - 1);
            Limits p2 = new Limits(p.array, izqDer[0], izqDer[1] - 1);
            Limits p3 = new Limits(p.array, izqDer[1], p.ult);

            if (p1.prim <= p1.ult) heterogeneo.insertar(p1);
            if (p3.prim <= p3.ult) heterogeneo.insertar(p3);
            if (p2.prim <= p2.ult) homogeneo.insertar(p2);
        }

        if (homogeneo.esVacio()) return a[prim];

        p = homogeneo.mayor();
        homogeneo.destruir();
        heterogeneo.destruir();
        return p.array[p.prim];
    }

    public static void pivote2(int[] a, int valor, int prim, int ult, int[] izqDer) {
        int izq = prim;
        int der = ult + 1;
        int i = prim;

        while (i < der) {
            if (a[i] < valor) {
                int temp = a[i];
                a[i] = a[izq];
                a[izq] = temp;
                izq++;
                i++;
            } else if (a[i] > valor) {
                der--;
                int temp = a[i];
                a[i] = a[der];
                a[der] = temp;
            } else {
                i++;
            }
        }

        izqDer[0] = izq;
        izqDer[1] = der;
    }
}


