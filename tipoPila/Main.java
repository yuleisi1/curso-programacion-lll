package tipoPila;

public class Main {
    public static void main(String[] args) {
        try{
            PilaLineal pila = new PilaLineal();
            pila.insertar(11);
            pila.insertar(50);
            pila.insertar(22);

            Integer dato;

            dato = (Integer) pila.quitar();
            System.out.println("Dato extraido:" + dato);

            dato = (Integer) pila.quitar();
            System.out.println("Dato extraño:" + dato);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
