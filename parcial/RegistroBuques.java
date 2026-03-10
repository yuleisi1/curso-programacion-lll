public class RegistroBuques {

    private Buque[] buques;

    public RegistroBuques(){
        buques = new Buque[10];  
    }

    public void agregarBuque(Buque b){

        for(int i =0; i < buques.length; i++){
            if(buques[i] == null){
                buques[i] = b;
                System.out.println("Buque registrado");
                return;
            }
        }
        System.out.println("No hay espacio para mas buques");
    }
    
}
