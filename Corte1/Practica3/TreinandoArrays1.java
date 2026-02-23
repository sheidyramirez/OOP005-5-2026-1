package treinandoarrays1;

import java.util.Scanner;

public class TreinandoArrays1 {

    public int [] data ;
    public int n ;

    // Constructor : crea vector de tamaño n
    public TreinandoArrays1( int n ) {
       this . n = n ;
       this . data = new int[n];
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
        for (int i = 0; i < n; i++) s += data[i];
        return s;
    }
    
    //Metodo promedio
    public double mean (){
        if (n == 0) return 0.0;
        return (double) sum() / (double) n;
    }
    
    //Metodo maximo
    public int max () {
        int m = data [0];
        for (int i = 1; i < n; i++){
            if (data[i] > m) 
                m = data[i];
        }
        return m;
    }
    
    //Metodo min
    public int min () {
        int m = data [0];
        for (int i = 1; i < n; i++){
        if (data[i] < m) 
            m = data[i];
        }
        return m;
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TreinandoArrays1 ob1 = new TreinandoArrays1(8);

        // Ciclo para llenar el vector
        for (int i = 0; i < ob1.n; i++) {
            System.out.print("Ingrese el numero para la posicion " + i + ": ");
            ob1.data[i] = sc.nextInt();
        }

        ob1.print("Vector"); 
        
        System.out.println("La suma de los elementos del vector: " + ob1.sum());
        System.out.println("El promedio de los elementos del vector: " + ob1.mean());
        System.out.println("El max de los elementos del vector: " + ob1.max());
        System.out.println("El min de los elementos del vector: " + ob1.min());
        sc.close();
    }
}
