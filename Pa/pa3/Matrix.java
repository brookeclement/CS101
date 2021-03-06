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
        public boolean equals(Object x){
            boolean eq = false;
            Entry that;

            if(x instanceof Entry){
               that = (Entry) x;
               eq   = (this.column==that.column && this.value==that.value);
            }
            return eq;
        }

        public String toString(){
            return "(" + column + ", " + value + ")";
        }
    }


    // ----------------------------------------------------------------------
    // Fields
    // ----------------------------------------------------------------------


    private List[] row;
    private int size;
    private int nnz;

    // Matrix Constructor
    // Makes a new n x n zero matrix
    // Pre: n>=1
    Matrix(int n){
        if( n<1 ){
            throw new RuntimeException(
                "Matrix Error: Matrix size must be greater than or equal to 1");
        }

        this.size = n;
        this.nnz  = 0;
        this.row  = new List[n+1];

        for( int i=1; i<=n; i++ ) this.row[i] = new List();
    }


    // ----------------------------------------------------------------------
    // Access Functions
    // ----------------------------------------------------------------------


    // Returns n, the number of rows and columns of this Matrix
    int getSize(){
        return size;
    }

    // Returns the number of non-zero entries in this Matrix
    int getNNZ(){
        return nnz;
    }

    // overrides Object's equals() method
    @SuppressWarnings("unchecked")
    public boolean equals(Object x){
        int i;
        Matrix that;
        boolean eq = false;

        if(x instanceof Matrix){

            that = (Matrix) x;

            if( this.size!=that.getSize() ) return eq;
            if( this.nnz!=that.getNNZ() ) return eq;

            for( i=1; i<=this.size; i++ ){
                eq = ( this.row[i].equals(that.row[i]) );
                if( !eq ) return eq;
            }
        }
        return eq;
    }


    // ----------------------------------------------------------------------
    // Manipulation Procedures
    // ----------------------------------------------------------------------


    // sets this Matrix to the zero state
    void makeZero(){
        int i;

        for( i=1; i<=this.size; i++ ){
            this.row[i] = new List();
        }
        this.nnz = 0;
    }

    // changes ith row, jth column of this Matrix to x
    // pre: 1<=i<=getSize(), 1<=j<=getSize()
    void changeEntry(int i, int j, double x){
        if( 1>i || i>this.size ){
            throw new RuntimeException(
                "Matrix Error: changeEntry() called on undefined row");
        }
        if( 1>j || j>this.size ){
            throw new RuntimeException(
                "Matrix Error: changeEntry() called on undefined column");
        }

        Entry C;
        Entry E = new Entry(j, x);
        List L  = row[i];

        L.moveFront();
        while( L.index()!=-1 ){
            C = (Entry) L.get();
            if( j==C.column ){
                if( x!=0.0 ){
                    C.value = x;
                    break;
                }else{
                    L.delete();
                    nnz--;
                    break;
                }
            }
            else if( j<C.column ) break;
            L.moveNext();
        }

        if( L.index()==-1 && x!=0.0 ) {
            L.append(E);
            nnz++;
        }else if( x!=0.0 ) {
            C = (Entry) L.get();
            if( j!=C.column ){
                L.insertBefore(E);
                nnz++;
            }
        }
    }

    // returns a new Matrix having the same entries as this Matrix
    Matrix copy(){
        Matrix that = new Matrix(this.size);
        Matrix zero = new Matrix(this.size);

        that        = this.add(zero);
        return that;
    }

    // returns a new Matrix that is the scalar product of this Matrix with x
    Matrix scalarMult(double x){
        int i;
        List thatRow;           Entry thatEntry;

        Matrix that = new Matrix(this.size);
        that        = this.copy();

        for( i=1; i<=this.size; i++ ){
            thatRow = that.row[i];
            thatRow.moveFront();

            while( thatRow.index()!=-1 ){
                thatEntry = (Entry) thatRow.get();
                thatEntry.value = x*thatEntry.value;
                thatRow.moveNext();
            }
            that.row[i] = thatRow;
        }
        that.nnz = this.nnz;
        return that;
    }

    // returns a new Matrix that is the sum of this Matrix with M
    // pre: getSize()==M.getSize()
    Matrix add(Matrix M){
        if( this.size!=M.getSize() ){
            throw new RuntimeException(
                "Matrix Error: add() called on undefined Matrix size");
        }

        int i;
        List thisList, thatList;
        Matrix N = new Matrix(this.size);

        if ( this==M ) return this.scalarMult(2);
        else if( this!=M ){
            for( i=1; i<=this.size; i++ ){
                thisList = this.row[i];
                thatList = M.row[i];
                N.row[i] = rowAdd(thisList, thatList);
            }
        }
        N.nnz = this.nnz;
        return N;
    }


    // returns a new Matrix that is the difference of this Matrix with M
    // pre: getSize()==M.getSize()
    Matrix sub(Matrix M){
        if( this.size!=M.getSize() ){
            throw new RuntimeException(
                "Matrix Error: sub() called on incompatible Matricies.");
        }

        Matrix that = new Matrix(this.size);

        if( this==M ) return that;
        else that   = this.add(M.scalarMult(-1));
        return that;
    }

    // returns a new Matrix that is the transpose of this Matrix
    Matrix transpose(){
        int i, j, k;        double x;
        List L;             Entry C;

        Matrix that = new Matrix(this.size);

        for( k=1; k<=this.size; k++){
            L = this.row[k];
            L.moveFront();

            while( L.index()!=-1 ){
                C = (Entry) L.get();
                i = C.column;
                j = k;
                x = C.value;

                that.changeEntry(i, j, x);
                L.moveNext();
            }
        }
        return that;
    }

    // returns a new Matrix that is the product of this Matrix with M
    // pre: getSize()==M.getSize()
    Matrix mult(Matrix M){
        if( this.size!=M.getSize() ){
            throw new RuntimeException(
                "Matrix Error: mult() called on incompatible Matricies");
        }

        int i, j;
        Matrix that = M.transpose();
        Matrix N    = new Matrix(this.size);

        for( i=1; i<=this.size; i++ ){
            for( j=1; j<=this.size; j++){

                N.changeEntry(i, j, dot(this.row[i], that.row[j]));

            }
        }
        return N;
    }


    // ----------------------------------------------------------------------
    // Other Functions
    // ----------------------------------------------------------------------


    // overrides Object's toString() method
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for( int i=1; i<=size; i++){
            if( row[i].length()!=0 ){
                sb.append(i).append(": ").append(row[i]).append("\n");
            }
        }
        return new String(sb);
    }

    // computes the vector dot product of two matrix rows represented
    // by Lists P and Q.
    // pre: none
    private static double dot(List P, List Q){
        double dotProduct = 0.0;

        Entry pCursor;          Entry qCursor;
        P.moveFront();          Q.moveFront();

        if( P.index()==-1 || Q.index()==-1) return 0.0;

        else while( P.index()!=-1 && Q.index()!=-1 ){
            pCursor    = (Entry) P.get();
            qCursor    = (Entry) Q.get();
            if( pCursor.column == qCursor.column ){
                dotProduct = dotProduct + (pCursor.value * qCursor.value);
                P.moveNext();
                Q.moveNext();
            }else if( pCursor.column>qCursor.column ) Q.moveNext();
            else if ( pCursor.column<qCursor.column ) P.moveNext();
        }

        return dotProduct;
    }

    // adds two Entry Lists together
    // pre: none
    private List rowAdd(List P, List Q){
        List R = new List();

        Entry pCursor;          Entry qCursor;
        P.moveFront();          Q.moveFront();

        while( P.index()!=-1 && Q.index()!=-1 ){
            pCursor     = (Entry) P.get();
            qCursor     = (Entry) Q.get();

            if( pCursor.column == qCursor.column ){

                if( pCursor.value+qCursor.value==0 ){
                    P.moveNext();
                    Q.moveNext();
                }else{
                    Entry rCursor = new Entry(pCursor.column, pCursor.value+qCursor.value);
                    R.append(rCursor);
                    P.moveNext();
                    Q.moveNext();
                }
            }else if( pCursor.column>qCursor.column ){

                Entry rCursor = new Entry(qCursor.column, qCursor.value);
                R.append(rCursor);
                Q.moveNext();

            }else if( pCursor.column<qCursor.column ){

                Entry rCursor = new Entry(pCursor.column, pCursor.value);
                R.append(rCursor);
                P.moveNext();
            }
        }

        while( P.index()!=-1 || Q.index()!=-1 ){

            if( P.index()!=-1 ){

                pCursor       = (Entry) P.get();
                Entry rCursor = new Entry(pCursor.column, pCursor.value);
                R.append(rCursor);
                P.moveNext();

            }else if ( Q.index()!=-1 ){

                qCursor       = (Entry) Q.get();
                Entry rCursor = new Entry(qCursor.column, qCursor.value);
                R.append(rCursor);
                Q.moveNext();
            }
        }

        return R;
    }

}
