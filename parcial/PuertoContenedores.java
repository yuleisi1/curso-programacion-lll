import java.util.Scanner;

public class PuertoContenedores {
    
    static void registrarBuque(){
        System.out.println("Registrar Buque");
    }
    static void registrarContenedor(){
        System.out.println("Registrar Contenedor");
    }
    static void pesoTotal(){
        System.out.println("Peso Total");
    }
    static void listaOrigen(){
        System.out.println("Lista de Origen");
    }
    static Scanner sc = new Scanner(System.in);

    static int[][] matriz = new int[10][10];

    static String[] buques = new String[10];

    public static void main(String[] args) {
        
        int opcion;
        do{
            System.out.println("Menu");
            System.out.println("1. Registrar Buque");
            System.out.println("2. Registrar Contenedor ");
            System.out.println("3. Mostrar peso total" );
            System.out.println("4. Lista de origen de contenedores");
            System.out.println("5. Cierre de la aplicacion");

            opcion = sc.nextInt();

            switch (opcion){

                case 1:
                    registrarBuque();           
                    break;
            
                case 2:
                    registrarContenedor();
                    break;
                    
                case 3:
                    pesoTotal();
                    break;

                case 4:
                    listaOrigen();
                    break;

                case 5:
                    System.out.println("saliendo...");
                    break;

                default:
                    System.out.println("obcion invalida");
            }

        } while (opcion !=5) ;
            
        }
    }
