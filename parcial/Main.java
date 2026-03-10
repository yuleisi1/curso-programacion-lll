import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PuertoContenedores puertoContenedores = new PuertoContenedores();
        RegistroBuques registro = new RegistroBuques();
        
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
                    System.out.println("id de buque");
                    int id = sc.nextInt();

                    System.out.println("Nombre del buque");
                    String nombre = sc.next();

                    Buque b = new Buque(nombre, id); 
                    Buque b = new Buque(nombre, id); 
                    registro.agregarBuque(b);

                    break;
            
                case 2:
                   System.out.println("Origen:");
                   String origen = sc.next();

                   System.out.println("peso:");
                   double peso = sc.nextDouble();

                   System.out.println("Fila:");
                   int fila = sc.nextInt();

                   System.out.println("Columna:");
                   int columna =sc.nextInt();

                   RegistroContenedores c = new RegistroContenedores(origen,peso);

                   puertoContenedores.agregarContenedor(fila, columna, origen);

                    break;
                    
                case 3:
                    puertoContenedores.mostrarMatriz();
                    break;
            }
        } while (opcion !=5) ;
            
        }
    
    
}
