//-----------------------------------------------------------------------------
//  ListTest.java
//  Christopher S. Gradwohl
//  cgradwoh
//  pa3
//  Test client for List.java
//-----------------------------------------------------------------------------

public class ListTest{
    public static void main(String[] args) {

        List A = new List();
        List B = new List();
        List C = new List();
        int[] intArray = {2,3,4,5,6,7};
        String nullString = "null";

        A.append(2.33);
        A.moveFront();
        A.insertBefore(intArray);
        A.insertAfter(nullString);
        A.prepend("Hello World");
        A.append(14);
        A.append("pi");
        A.moveFront();

        B.append(2.33);
        B.moveFront();
        B.insertBefore(intArray);
        B.insertAfter(nullString);
        B.prepend("Hello World");
        B.append(14);
        B.append("pi");
        B.moveFront();

        C.append(2.33);

        System.out.println("List A: " + A);

        System.out.println();
        System.out.println("A.length()" + A.length());
        System.out.println("A.index()" + A.index());
        System.out.println("A.front()" + A.front());
        System.out.println("A.back()" + A.back());
        System.out.println("A.get()" + A.get());
        System.out.println();

        A.moveNext();
        System.out.println("A.index()" + A.index());
        System.out.println("A.get()" + A.get());
        A.moveNext();
        System.out.println("A.index()" + A.index());
        System.out.println("A.get()" + A.get());
        A.moveNext();
        System.out.println("A.index()" + A.index());
        System.out.println("A.get()" + A.get());
        A.moveNext();
        System.out.println("A.index()" + A.index());
        System.out.println("A.get()" + A.get());
        A.moveNext();
        System.out.println("A.index()" + A.index());
        System.out.println("A.get()" + A.get());
        A.moveNext();
        System.out.println("A.index()" + A.index());
        System.out.println();

        System.out.println("A.equals(B): " + A.equals(B));
        System.out.println("B.equals(A): " + B.equals(A));
        System.out.println("A.equals(C): " + A.equals(C));

        A.clear();
        B.clear();
        C.clear();

        System.out.println("Empty List A:" + A);
        System.out.println("Empty List B:" + B);
        System.out.println("Empty List C:" + C);

    }
}
