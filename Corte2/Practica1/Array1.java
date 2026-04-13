package treinandoarrays1;

import java.util.Scanner;

public class TreinandoArrays1 {

    private final int [] data ;
    private final int n ;

    // Constructor : crea vector de tamaño n
    public TreinandoArrays1( int n ) {
       this . n = n ;
       this . data = new int[n];
    }
    
    public int getN(){
        return n;
    }
    
    public int getElemento(int i){
         return data[i];
    }
    
    public void setElemento(int i, int valor){
        data[i] = valor;
    }
    
    public void print( String name ) {
        System.out.print(name + " = [ " ) ;
        for (int i = 0; i < n ; i ++) {
           System . out . print ( data [ i ]) ;
           if(i < n - 1) System . out . print ( " , " ) ;
        }
        System.out.println(" ] ") ;
    }
    
    //Metodo suma
    public int sum (){
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += getElemento(i);
        }
        return s;
    }
    
    //Metodo promedio
    public double mean (){
        if (n == 0) return 0.0;
        return (double) sum() / (double) n;
    }
    
    //Metodo maximo
    public int max () {
        int m = getElemento(0);
        for (int i = 1; i < n; i++){
            if (getElemento(i) > m) 
                m = getElemento(i);
        }
        return m;
    }
    
    //Metodo min
    public int min () {
        int m = getElemento(0);
        for (int i = 1; i < n; i++){
        if (getElemento(i) < m) { 
            m = getElemento(i);
            }
        }
        return m;
    }
    
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            TreinandoArrays1 ob1 = new TreinandoArrays1(8);
            
            // Ciclo para llenar el vector
            for (int i = 0; i < ob1.getN(); i++) {
                System.out.print("Ingrese el numero para la posicion " + i + ": ");
                ob1.setElemento(i, sc.nextInt());
            }
            
            ob1.print("Vector");
            
            System.out.println("La suma de los elementos del vector: " + ob1.sum());
            System.out.println("El promedio de los elementos del vector: " + ob1.mean());
            System.out.println("El max de los elementos del vector: " + ob1.max());
            System.out.println("El min de los elementos del vector: " + ob1.min());
        }
    }
}
