//-----------------------------------------------------------------------------
//  MatrixTest.java
//  Christopher S. Gradwohl
//  cgradwoh
//  pa3
//  Test client for Matrix.java
//-----------------------------------------------------------------------------

import java.io.*;

public class MatrixTest{
    public static void main(String[] args) throws IOException {



        Matrix A = new Matrix(3);
        A.changeEntry(1, 1, 1);
        A.changeEntry(1, 2, 2);
        A.changeEntry(1, 3, 3);
        A.changeEntry(2, 1, 0);
        A.changeEntry(2, 2, 1);
        A.changeEntry(2, 3, 2);
        A.changeEntry(3, 1, 4);
        A.changeEntry(3, 2, 5);
        A.changeEntry(3, 3, 6);
        System.out.println("Matrix A:");
        System.out.println(A);

        Matrix B = new Matrix(3);
        B.changeEntry(1, 1, 7);
        B.changeEntry(1, 2, 0);
        B.changeEntry(1, 3, 1);
        B.changeEntry(2, 1, 1);
        B.changeEntry(2, 2, 2);
        B.changeEntry(2, 3, 1);
        B.changeEntry(3, 1, 3);
        B.changeEntry(3, 2, 2);
        B.changeEntry(3, 3, 1);
        System.out.println("Matrix B:");
        System.out.println(B);

        Matrix C = A.copy();
        System.out.println("Matrix A copy:");
        System.out.println(C);

        Matrix D = new Matrix(3);
        System.out.println("Matrix D:");
        System.out.println(D);

        Matrix E = D.copy();
        System.out.println("Matrix E:");
        System.out.println(E);

        B.makeZero();
        System.out.println("Matrix B( makeZero() test ):");
        System.out.println(B);







        /*Matrix A = new Matrix(3);
        A.changeEntry(1, 1, 1);
        A.changeEntry(1, 2, 2);
        A.changeEntry(1, 3, 3);
        A.changeEntry(2, 1, 4);
        A.changeEntry(2, 2, 0);
        A.changeEntry(2, 3, 5);
        A.changeEntry(3, 1, 6);
        A.changeEntry(3, 2, 0);
        A.changeEntry(3, 3, 0);
        System.out.println("Matrix A:");
        System.out.println(A);


        Matrix B = new Matrix(3);
        B.changeEntry(1, 1, 7);
        B.changeEntry(1, 2, 8);
        B.changeEntry(1, 3, 0);
        B.changeEntry(2, 1, 9);
        B.changeEntry(2, 2, 0);
        B.changeEntry(2, 3, 0);
        B.changeEntry(3, 1, 0);
        B.changeEntry(3, 2, 0);
        B.changeEntry(3, 3, 0);
        System.out.println("Matrix B:");
        System.out.println(B);

        Matrix C = new Matrix(3);
        C = A.add(B);
        System.out.println("Matrix C:");
        System.out.println(C);


        System.out.println("Matrix C:");
        System.out.println(C);

        Matrix D = new Matrix(3);
        D = C.sub(C);
        System.out.println("Matrix C-C:");
        System.out.println(D);*/

























        /*Matrix A = new Matrix(2);
        Matrix B = new Matrix(2);

        A.changeEntry(1,1,3);
        A.changeEntry(1,2,0);
        A.changeEntry(2,1,0);
        A.changeEntry(2,2,4);
        System.out.println("Matrix A:");
        System.out.println(A);

        B.changeEntry(1,1,3);
        B.changeEntry(1,2,0);
        B.changeEntry(2,1,0);
        B.changeEntry(2,2,4);
        System.out.println("Matrix B:");
        System.out.println(B);

        Matrix C = A.mult(B);

        System.out.println("Matrix A*B:");
        System.out.println(C);*/









        /*Matrix A = new Matrix(3);

        A.changeEntry(1, 1, 1);
        A.changeEntry(1, 2, 2);
        A.changeEntry(1, 3, 3);

        A.changeEntry(2, 1, 4);
        A.changeEntry(2, 2, 5);
        A.changeEntry(2, 3, 6);

        A.changeEntry(3, 1, 7);
        A.changeEntry(3, 2, 8);
        A.changeEntry(3, 3, 9);
        System.out.println("matrix A: ");
        System.out.println(A);

        Matrix B = A.transpose();

        System.out.println("matrix A.transpose(): ");
        System.out.println(B);*/

        /*System.out.println("NNZ = " + A.getNNZ());
        System.out.println();

        A.changeEntry(1, 1, 0);
        A.changeEntry(1, 2, 2);
        A.changeEntry(1, 3, 3);

        A.changeEntry(2, 1, 4);
        A.changeEntry(2, 2, 0);
        A.changeEntry(2, 3, 6);

        A.changeEntry(3, 1, 7);
        A.changeEntry(3, 2, 8);
        A.changeEntry(3, 3, 0);
        System.out.print(A);
        System.out.println("NNZ = " + A.getNNZ());
        System.out.println();

        A.changeEntry(1, 1, 0);
        A.changeEntry(1, 2, 0);
        A.changeEntry(1, 3, 0);

        A.changeEntry(2, 1, 4);
        A.changeEntry(2, 2, 0);
        A.changeEntry(2, 3, 0);

        A.changeEntry(3, 1, 7);
        A.changeEntry(3, 2, 8);
        A.changeEntry(3, 3, 0);
        System.out.print(A);
        System.out.println("NNZ = " + A.getNNZ());
        System.out.println();

        A.changeEntry(2, 1, 1);
        A.changeEntry(2, 2, 2);
        A.changeEntry(2, 3, 3);
        System.out.println(A);

        A.changeEntry(2, 1, 1);
        A.changeEntry(2, 2, 2);
        A.changeEntry(2, 3, 3);
        System.out.println(A);*/


    }
}
