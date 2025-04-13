package Actividad_04;

public class Limits {
    int[] array;
    int prim;
    int ult;

    public Limits(int[] array, int prim, int ult) {
        this.array = array;
        this.prim = prim;
        this.ult = ult;
    }

    public int length() {
        return ult - prim + 1;
    }
}
