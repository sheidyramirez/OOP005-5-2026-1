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
       if (x2 == 0) {
            System.out.println("No se puede dividir entre cero");
            return 0;
        } else {
            return x1 / x2;
        }
    }
    
    public static void main(String[] args) {
        Calculator m = new Calculator(34, 43);
        System.out.println(m.add());
        System.out.println(m.subs());
        System.out.println(m.multiplication());
        System.out.println(m.div());
    }
}  

