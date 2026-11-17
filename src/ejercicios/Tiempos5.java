package ejercicios;

public class Tiempos5 {
    static void tarea(String nombre) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 5;
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            tarea("T" + i);
        }
        long sec = System.currentTimeMillis() - inicio;
        System.out.println("Secuencial: " + (sec / 100 * 100) + " ms aprox.");

        inicio = System.currentTimeMillis();
        Thread[] hilos = new Thread[n];
        for (int i = 0; i < n; i++) {
            String nombre = "T" + i;
            hilos[i] = new Thread(() -> tarea(nombre));
            hilos[i].start();
        }
        for (Thread h : hilos) h.join();
        long par = System.currentTimeMillis() - inicio;
        System.out.println("Con hilos: " + (par / 100 * 100) + " ms aprox.");
    }
}
