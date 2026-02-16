package calculator;

public class Calculator {
    public int x1, x2;

//Constructor
    public Calculator (int a, int b){
        x1 = a;
        x2 = b;
    }
    public int add(){
        return x1 + x2;
}
    
    public int subs(){
        return x1 - x2;
}
    public int multiplication(){
        return x1 * x2;
}
    public int div(){
        if (x2==0){
            System.out.println("No se puede dividir entre cero");
            return 0;
        } else{
            return x1/x2;
        }
}
    
    public static void main(String[] args) {
        Calculator m = new Calculator(34, 43);
        System.out.println("La suma m es:" + m.add());
        System.out.println("La resta m es:" + m.subs());
        System.out.println("La multiplicacion m es:" + m.multiplication());
        System.out.println("La division m es:" + m.div());
        
        Calculator n = new Calculator(15, 0);
        System.out.println("La suma n es:" + n.add());
        System.out.println("La resta n es:" + n.subs());
        System.out.println("La multiplicacion n es:" + n.multiplication());
        System.out.println("La division n es:" + n.div());
    }
} 




