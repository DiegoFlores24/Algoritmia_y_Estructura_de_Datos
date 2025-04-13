package Actividad_04;

import java.util.*;

public class SetVectors {
    private PriorityQueue<Limits> queue;

    public SetVectors() {
        queue = new PriorityQueue<>((a, b) -> b.length() - a.length());
    }

    public void insertar(Limits p) {
        if (p.prim <= p.ult) {
            queue.offer(p);
        }
    }

    public Limits mayor() {
        return queue.poll();
    }

    public int longMayor() {
        if (queue.isEmpty()) return 0;
        return queue.peek().length();
    }

    public boolean esVacio() {
        return queue.isEmpty();
    }

    public void destruir() {
        queue.clear();
    }
}
