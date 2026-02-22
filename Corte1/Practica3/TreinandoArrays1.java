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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TreinandoArrays1 ob1 = new TreinandoArrays1(8);

        // Ciclo para llenar el vector
        for (int i = 0; i < ob1.n; i++) {
            System.out.print("Ingrese el numero para la posicion " + i + ": ");
            ob1.data[i] = sc.nextInt();
        }

        ob1.print("Hola"); 

        System.out.println(ob1.data[0]);
        System.out.println(ob1.data[1]);
        System.out.println(ob1.data[2]);
        System.out.println(ob1.data[3]);

        sc.close();
    }
}
