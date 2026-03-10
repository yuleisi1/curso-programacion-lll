public class RegistroBuques {
    
    private String nombre;
    private int id;

    public RegistroBuques (String nombre, int id){

        this.nombre = nombre;
        this.id = id; 
    }

    public String getnombre(){
        return nombre;
    }
    public int setid(){
        return id;

    }
}
