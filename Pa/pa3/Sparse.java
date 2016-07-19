//-----------------------------------------------------------------------------
//  Sparse.java
//  Christopher S. Gradwohl
//  cgradwoh
//  pa3
//  MatrixADT client that performs basic Matrix Arithmatic
//-----------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

public class Sparse{


   public static void main(String[] args) throws IOException{

        if(args.length < 2){
            System.err.println("Usage: Sparse infile outfile");
            System.exit(1);
        }

        int i, j;
        Scanner in      = null;
        PrintWriter out = null;

        in = new Scanner(new File(args[0]));
        out = new PrintWriter(new FileWriter(args[1]));

        int size = in.nextInt();
        int nnzA = in.nextInt();
        int nnzB = in.nextInt();

        Matrix A = new Matrix(size);
        Matrix B = new Matrix(size);

        for( i=1; i<=nnzA; i++ ){
            A.changeEntry(in.nextInt(), in.nextInt(), in.nextDouble());
        }

        for( j=1; j<=nnzB; j++ ){
            B.changeEntry(in.nextInt(), in.nextInt(), in.nextDouble());
        }

        out.println("A has "+nnzA+" non-zero entries:");
        out.println(A);
        out.println("B has "+nnzB+" non-zero entries:");
        out.println(B);
        out.println("(1.5)*A = ");
        out.println(A.scalarMult(1.5));
        out.println("A+B = ");
        out.println(A.add(B));
        out.println("A+A = ");
        out.println(A.add(A));
        out.println("B-A = ");
        out.println(B.sub(A));
        out.println("A-A = ");
        out.println(A.sub(A));
        out.println("Transpose(A) = ");
        out.println(A.transpose());
        out.println("A*B = ");
        out.println(A.mult(B));
        out.println("B*B = ");
        out.println(B.mult(B));

        in.close();
        out.close();
   }
}
