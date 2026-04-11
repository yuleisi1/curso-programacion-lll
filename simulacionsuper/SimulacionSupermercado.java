package simulacionsuper;

import java.util.*;

public class SimulacionSupermercado {

    static class Cliente {
        int llegada;
        int inicioAtencion;

        public Cliente(int llegada) {
            this.llegada = llegada;
        }
    }

    static class Caja {
        boolean ocupada = false;
        int tiempoRestante = 0;
        Cliente clienteActual = null;

        double min, max;

        public Caja(double min, double max) {
            this.min = min;
            this.max = max;
        }

        int generarTiempo() {
            return (int) Math.round(min + Math.random() * (max - min));
        }
    }

    public static void main(String[] args) {

        int TIEMPO_TOTAL = 420; // 7 horas

        Queue<Cliente> fila = new LinkedList<>();

        Caja caja1 = new Caja(1.5, 2.5);
        Caja caja2 = new Caja(2, 5);
        Caja caja3 = new Caja(2, 4);
        Caja caja4 = new Caja(2, 4.5);

        boolean caja4Activa = false;
        int tiempoCaja4Activa = 0;

        int clientesAtendidos = 0;
        int maxFila = 0;
        int sumaFila = 0;
        int tiempoMaxEspera = 0;

        int tiempo = 0;

        while (tiempo < TIEMPO_TOTAL) {

            if (Math.random() < 0.7) {
                fila.add(new Cliente(tiempo));
            }

            if (fila.size() > 20) {
                caja4Activa = true;
            }
            if (fila.isEmpty()) {
                caja4Activa = false;
            }

            if (caja4Activa) {
                tiempoCaja4Activa++;
            }

            // Atender clientes
            atenderCaja(caja1, fila, tiempo);
            atenderCaja(caja2, fila, tiempo);
            atenderCaja(caja3, fila, tiempo);

            if (caja4Activa) {
                atenderCaja(caja4, fila, tiempo);
            }

            // Actualizar cajas
            clientesAtendidos += actualizarCaja(caja1);
            clientesAtendidos += actualizarCaja(caja2);
            clientesAtendidos += actualizarCaja(caja3);

            if (caja4Activa) {
                clientesAtendidos += actualizarCaja(caja4);
            }

            sumaFila += fila.size();
            if (fila.size() > maxFila) {
                maxFila = fila.size();
            }

            tiempo++;
        }

        double promedioFila = (double) sumaFila / TIEMPO_TOTAL;

        System.out.println("\nRESULTADOS:");
        System.out.println("Clientes atendidos: " + clientesAtendidos);
        System.out.println("Tamaño medio de la fila: " + promedioFila);
        System.out.println("Tamaño máximo de la fila: " + maxFila);
        System.out.println("Tiempo caja 4 abierta: " + tiempoCaja4Activa + " minutos");
    }

    static void atenderCaja(Caja caja, Queue<Cliente> fila, int tiempo) {
        if (!caja.ocupada && !fila.isEmpty()) {
            Cliente c = fila.poll();
            caja.clienteActual = c;
            caja.ocupada = true;
            caja.tiempoRestante = caja.generarTiempo();
            c.inicioAtencion = tiempo;
        }
    }

    static int actualizarCaja(Caja caja) {
        if (caja.ocupada) {
            caja.tiempoRestante--;

            if (caja.tiempoRestante <= 0) {
                caja.ocupada = false;
                return 1;
            }
        }
        return 0;
    }
}
