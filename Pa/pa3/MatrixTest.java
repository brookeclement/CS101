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

        Matrix A = new Matrix(2);
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
        System.out.println(C);









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
