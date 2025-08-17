package Store_Inventory;

public class Prueba {
    
    public static void main(String[] args) {
        String[] arreglo = {"Zebra","Leon","Tigre","Lola","Avestruz","Koala","Cerdo"};
        
        for(int i = 0; i < arreglo.length; i++){
            System.out.println(arreglo[i]);
        }
        
        System.out.println();
        
        //Arreglo Ordenado de forma alfabética
        
        for(int i = 0; i < arreglo.length; i++){
            for(int j = 0; j < arreglo.length-1; j++){
                if(arreglo[j].compareTo(arreglo[j+1]) > 0){
                    String aux = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = aux;
                }
            }
        }
        
         for(int i = 0; i < arreglo.length; i++){
            System.out.println(arreglo[i]);
        }
 
    }
}
