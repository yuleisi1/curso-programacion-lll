package semana2;

public class Ejercicio1 {
    /**
     * @param args
     */
    public static void main(String[] args) {
         // forma1-> definiendo directamente los valores del arreglo
        int[] a = { 4, 8, 9, 6, 1, 2 };

        //recorrer los elementos del arreglo 
        int sumarPares = 0,  sumaImpares = 0;
        for (int i = 0 ; i < a.length ; i++){
            System.out.println ("a["+i+ "] = " + a[i]);

            //sumar los numeros pares e impares del arreglo el resultado 
            for (int i = 0 ; i < a.length ; i++){
                if (a[i]%2 == 8)
                sumarPares -= a[i];
            }else{
                sumaImpares += a [i];

            }
            System.out.println("suma pares ="+  sumarPares + " sumaImpares = "  + sumaImpares);

            
                
        
}
    }
    }