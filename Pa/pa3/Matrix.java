//-----------------------------------------------------------------------------
//  Matrix.java
//  Christopher S. Gradwohl
//  cgradwoh
//  pa3
//  MatrixADT for the Sparse.java client
//-----------------------------------------------------------------------------

@SuppressWarnings("overrides")
public class Matrix{

    @SuppressWarnings("overrides")
    private class Entry{

        // fields for private class Entry
        int column;
        double value;

        // Entry Constructor
        Entry(int col, double val){
            column = col;
            value  = val;
        }

        // methods for private class Entry
        @SuppressWarnings("unchecked")
        public boolean equals(Object x);
        public String toString();
    }

    // ----------------------------------------------------------------------
    // Fields
    // ----------------------------------------------------------------------

    private List[] R;
    private int size;

    // Matrix Constructor
    // Makes a new n x n zero matrix
    // Pre: n>=1
    Matrix(int n){
        if( n<1 ){
            throw new RuntimeException(
                "Matrix Error: Matrix size must be greater than or equal to 1");
        }
        R    = new List[n+1];
        size = 0;
    }

    // ----------------------------------------------------------------------
    // Access Functions
    // ----------------------------------------------------------------------

    // Returns n, the number of rows and columns of this Matrix
    int getSize();

    // Returns the number of non-zero entries in this Matrix
    int getNNZ();

    // overrides Object's equals() method
    @SuppressWarnings("unchecked")
    public boolean equals(Object x);


    // ----------------------------------------------------------------------
    // Manipulation Procedures
    // ----------------------------------------------------------------------

    // sets this Matrix to the zero state
    void makeZero();

    // changes ith row, jth column of this Matrix to x
    // pre: 1<=i<=getSize(), 1<=j<=getSize()
    void changeEntry(int i, int j, double x);

    // returns a new Matrix having the same entries as this Matrix
    Matrix copy();

    // returns a new Matrix that is the scalar product of this Matrix with x
    Matrix scalarMult(double x);

    // returns a new Matrix that is the sum of this Matrix with M
    // pre: getSize()==M.getSize()
    Matrix add(Matrix M);

    // returns a new Matrix that is the difference of this Matrix with M
    // pre: getSize()==M.getSize()
    Matrix sub(Matrix M);

    // returns a new Matrix that is the transpose of this Matrix
    Matrix transpose();

    // returns a new Matrix that is the product of this Matrix with M
    // pre: getSize()==M.getSize()
    Matrix mult(Matrix M);


    // ----------------------------------------------------------------------
    // Other Functions
    // ----------------------------------------------------------------------


    // overrides Object's toString() method
    public String toString();


}
