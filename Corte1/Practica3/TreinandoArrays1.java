package treinandoarrays1;

public class TreinandoArrays1 {

    public int [] data ;
    public int n ;

// Constructor : crea vector de t a m a o n
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
        TreinandoArrays1 ob1 = new TreinandoArrays1(8);
        ob1.print("Hola"); 
        System.out.println(ob1.data[0]);
        System.out.println(ob1.data[1]);
        System.out.println(ob1.data[2]);
        System.out.println(ob1.data[3]);
    }
}