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

        A.changeEntry(1, 1, 13.0);
        A.changeEntry(1, 2, 14.0);
        A.changeEntry(2, 1, 15.0);
        A.changeEntry(2, 2, 16.0);
        A.changeEntry(3, 3, 16.0);

        System.out.print(A);

    }
}
