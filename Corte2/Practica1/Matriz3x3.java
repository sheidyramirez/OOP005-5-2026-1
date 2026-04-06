package matriz3x3;

import java.util.Scanner;

public class Matriz3x3 {
    
    public int[][] data;
    public int filas;
    public int columnas;
    
    public Matriz3x3(){
        filas = 3; 
        columnas = 3;
        data = new int[filas][columnas];
    }
    
    public void set() {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                System.out.print("data[" + i +"][" + j + "]: ");
                data[i][j] = sc.nextInt();
            }
        }
    }
    
    public void get(){
        System.out.println("\nMatriz 3x3:");
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    // Metodo suma
    public Matriz3x3 suma(Matriz3x3 m) {
        Matriz3x3 resultado = new Matriz3x3();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.data[i][j] = this.data[i][j] + m.data[i][j];
            }
        }

        return resultado;
    }
    
    // Metodo multiplicacion
    public Matriz3x3 multiplicar(Matriz3x3 m) {
        Matriz3x3 resultado = new Matriz3x3();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.data[i][j] = 0;
                for (int k = 0; k < columnas; k++) {
                    resultado.data[i][j] += this.data[i][k] * m.data[k][j];
                }
            }
        }

        return resultado;
    }
    
    public static void main(String[] args){
        
        Matriz3x3 m1 = new Matriz3x3();
        Matriz3x3 m2 = new Matriz3x3();

        System.out.println("Ingrese datos de la matriz 1");
        m1.set();

        System.out.println("Ingrese datos de la matriz 2");
        m2.set();

        Matriz3x3 suma = m1.suma(m2);
        Matriz3x3 multiplicacion = m1.multiplicar(m2);

        System.out.println("\nMatriz 1:");
        m1.get();

        System.out.println("\nMatriz 2:");
        m2.get();

        System.out.println("\nSuma de matrices:");
        suma.get();

        System.out.println("\nMultiplicacion de matrices:");
        multiplicacion.get();
    }
}