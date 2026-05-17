package proyecto;

public class RutaEdificio {
 
    private static final int NUM_EDIFICIOS = 5;
    private static final int INF = Integer.MAX_VALUE;
    private int[][] distancias;
    private String[] edificios;
 
    public RutaEdificio() {
        distancias = new int[NUM_EDIFICIOS][NUM_EDIFICIOS];
        edificios = new String[NUM_EDIFICIOS];
 
        for (int i = 0; i < NUM_EDIFICIOS; i++) {
            for (int j = 0; j < NUM_EDIFICIOS; j++) {
                if (i == j) {
                    distancias[i][j] = 0;
                } else {
                    distancias[i][j] = INF;
                }
            }
        }
        edificios[0] = "Ingenieria";
        edificios[1] = "Biblioteca";
        edificios[2] = "Cafeteria";
        edificios[3] = "Rectoria";
        edificios[4] = "Laboratorios";
    }

    public void agregarConexion(int origen, int destino, int distancia) {
        if (origen < 0 || origen >= NUM_EDIFICIOS || destino < 0 || destino >= NUM_EDIFICIOS) {
            System.out.println("Error: Indice de edificio invalido.");
            return;
        }
        distancias[origen][destino] = distancia;
        distancias[destino][origen] = distancia; // grafo no dirigido
        System.out.println("Conexion agregada: " + edificios[origen] + " <-> " + edificios[destino] + " (" + distancia + "m)");
    }
 
    public void calcularRutaMasCorta(int origen, int destino) {
        if (origen < 0 || origen >= NUM_EDIFICIOS || destino < 0 || destino >= NUM_EDIFICIOS) {
            System.out.println("Error: Indice de edificio invalido.");
            return;
        }
 
        int[] dist = new int[NUM_EDIFICIOS];
        boolean[] visitado = new boolean[NUM_EDIFICIOS];
        int[] anterior = new int[NUM_EDIFICIOS];
 
        for (int i = 0; i < NUM_EDIFICIOS; i++) {
            dist[i] = INF;
            visitado[i] = false;
            anterior[i] = -1;
        }
        dist[origen] = 0;
 
        for (int count = 0; count < NUM_EDIFICIOS - 1; count++) {
            int u = minimoNoVisitado(dist, visitado);
            if (u == -1) break;
            visitado[u] = true;
 
            for (int v = 0; v < NUM_EDIFICIOS; v++) {
                if (!visitado[v]
                        && distancias[u][v] != INF
                        && dist[u] != INF
                        && dist[u] + distancias[u][v] < dist[v]) {
                    dist[v] = dist[u] + distancias[u][v];
                    anterior[v] = u;
                }
            }
        }
 
        if (dist[destino] == INF) {
            System.out.println("No existe ruta entre " + edificios[origen] + " y " + edificios[destino]);
            return;
        }
 
        System.out.println("\n--- RESULTADO ---");
        System.out.print("Ruta mas corta: ");
        imprimirCamino(anterior, destino, origen);
        System.out.println("\nDistancia TOTAL: " + dist[destino] + " metros");
    }
 
    private int minimoNoVisitado(int[] dist, boolean[] visitado) {
        int min = INF;
        int indice = -1;
        for (int i = 0; i < NUM_EDIFICIOS; i++) {
            if (!visitado[i] && dist[i] <= min) {
                min = dist[i];
                indice = i;
            }
        }
        return indice;
    }
    private void imprimirCamino(int[] anterior, int destino, int origen) {
        int[] camino = new int[NUM_EDIFICIOS];
        int longitud = 0;
        int actual = destino;
 
        while (actual != -1) {
            camino[longitud++] = actual;
            actual = anterior[actual];
        }
        for (int i = longitud - 1; i >= 0; i--) {
            System.out.print(edificios[camino[i]]);
            if (i > 0) System.out.print(" -> ");
        }
    }
 
    public void mostrarEdificios() {
        System.out.println("\nEdificios registrados:");
        for (int i = 0; i < NUM_EDIFICIOS; i++) {
            System.out.println(i + ": " + edificios[i]);
        }
    }
 
    public void mostrarMatriz() {
        System.out.println("\nMatriz de distancias:");
        System.out.print("       ");
        for (int i = 0; i < NUM_EDIFICIOS; i++) {
            System.out.printf("%-12s", edificios[i]);
        }
        System.out.println();
        for (int i = 0; i < NUM_EDIFICIOS; i++) {
            System.out.printf("%-7s", edificios[i]);
            for (int j = 0; j < NUM_EDIFICIOS; j++) {
                if (distancias[i][j] == INF) {
                    System.out.printf("%-12s", "INF");
                } else {
                    System.out.printf("%-12d", distancias[i][j]);
                }
            }
            System.out.println();
        }
    }
 
    public void mostrarRuta() {
        mostrarEdificios();
        System.out.println("Use la opcion 'Calcular ruta mas corta' para ver Dijkstra.");
    }
}
 
