package tipoPila;

public class PilaLineal{
    private static final int TAMPILA = 49;
    private int cima;
    private Object[] listaPila;
	 
     public PilaLineal(){
        cima = -1;
        listaPila = new Object[TAMPILA];
     }

	 public void insertar(Object elemento){
        if (cima == TAMPILA - 1){
            System.out.println("pila llena");
        }else{
            cima++;
            listaPila[cima] = elemento;
        }
     }
        public Object quitar() throws Exception{
            if (estaVacia()){
            throw new Exception("pila vacia");
            }
        return listaPila[cima--];
        }
        public Object cimaPila() throws Exception {
            if (estaVacia()){
            throw new Exception("pila vacia");
        }
        return listaPila[cima--];
     }
        public boolean estaVacia(){
            return cima == -1;
        }
}
