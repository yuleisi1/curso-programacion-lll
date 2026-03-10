public class PuertoContenedores {

    private String[][] matriz;

    public PuertoContenedores (){
        matriz = new String[10][10];
    }
    public void agregarContenedor(int fila, int columna, String c){
        if (matriz[fila][columna] == null) {
            matriz[fila][columna] = c;
            System.out.println("contenedor agregado");    
        }
        else{
            System.out.println("puesto ocupado");
        }
    }
    public void mostrarMatriz(){

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
            
                if (matriz[i][j] == null){
                    System.out.println("[ ]");
                }
                else{
                    System.out.println("[x]");
            }
        }
        System.out.println();
    }
}}
    