public class Test{


    public static List insertionSort(String[] A){
        List L = new List();
        int n = A.length;
        int i, j;

        if( L.length()==0 ) L.append(0);

        for( j=1; j<n; j++){
            L.moveFront();
            while( L.index()!=-1 && A[j].compareTo(A[L.get()])>0 ){
                L.moveNext();
            }
            if( L.index()==-1 ){
                L.append(j);
            }
            else
            L.insertBefore(j);
        }
        return L;
    }


    public static void main(String[] args){
        String[] G = {"d","c","a","b","e"};
        System.out.println("please work: " + insertionSort(G));

    }
}
