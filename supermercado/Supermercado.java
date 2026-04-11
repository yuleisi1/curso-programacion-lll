package supermercado;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Supermercado {

    public static void main(String[] args) {

        int TOTAL_CARRITOS = 25;
        int TOTAL_CLIENTES = 40;

        Queue<Integer> carritos = new LinkedList<>();

        
        for (int i = 1; i <= TOTAL_CARRITOS; i++) {
            carritos.add(i);
        }

       
        Queue<Integer> caja1 = new LinkedList<>();
        Queue<Integer> caja2 = new LinkedList<>();
        Queue<Integer> caja3 = new LinkedList<>();

        new Random();

        for (int cliente = 1; cliente <= TOTAL_CLIENTES; cliente++) {

            System.out.println("\nCliente " + cliente + " llega");

            
            if (carritos.isEmpty()) {
                System.out.println("No hay carritos, cliente espera...");
                continue; // en simulación simple
            }

            int carrito = carritos.poll();
            System.out.println("Cliente " + cliente + " toma carrito " + carrito);

            System.out.println("Cliente " + cliente + " está comprando...");

            Queue<Integer> cajaMenor = caja1;

            if (caja2.size() < cajaMenor.size()) cajaMenor = caja2;
            if (caja3.size() < cajaMenor.size()) cajaMenor = caja3;

            cajaMenor.add(cliente);
            System.out.println("Cliente " + cliente + " va a la caja");

            int atendido = cajaMenor.poll();
            System.out.println("Cliente " + atendido + " paga y se va");

            carritos.add(carrito);
            System.out.println("Carrito " + carrito + " disponible");
        }

        System.out.println("\nSimulación finalizada");
    }
}