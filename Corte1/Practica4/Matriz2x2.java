package matriz2x2;

import java.util.Scanner;

public class Matriz2x2 {

    public int[][] data;
    public int filas;
    public int columnas;

    public Matriz2x2() {
        filas = 2;
        columnas = 2;
        data = new int[filas][columnas];
    }

    public void set() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("data[" + i + "][" + j + "]: ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    public void get() {
        System.out.println("\nMatriz 2x2:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Metodo suma
    public Matriz2x2 suma(Matriz2x2 m) {
        Matriz2x2 resultado = new Matriz2x2();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.data[i][j] = this.data[i][j] + m.data[i][j];
            }
        }

        return resultado;
    }
    
    //Metodo multiplicación
    public Matriz2x2 multiplicar(Matriz2x2 m) {
        Matriz2x2 resultado = new Matriz2x2();
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.data[i][j] = this.data[i][0] * m.data[0][j]
                                     + this.data[i][1] * m.data[1][j];                      
            }
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        Matriz2x2 m1 = new Matriz2x2();
        Matriz2x2 m2 = new Matriz2x2();

        System.out.println("Ingrese datos de la matriz 1");
        m1.set();

        System.out.println("Ingrese datos de la matriz 2");
        m2.set();

        Matriz2x2 suma = m1.suma(m2);
        Matriz2x2 multiplicacion = m1.multiplicar(m2);

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

