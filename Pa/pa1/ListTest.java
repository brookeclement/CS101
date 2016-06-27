//-----------------------------------------------------------------------------
//  ListTest.java
//  Christopher S. Gradwohl
//  cgradwoh
//  pa1
//  a rigoroius test client for List.java
// NOTE: this file will not be submitted
//-----------------------------------------------------------------------------

public class ListTest {
    public static void main(String[] args) {
        // try using and tetsing method with AND without the 'this' keyword to get an intuition on the matter

        List myList = new List();

        System.out.println("empty state: ");
        System.out.println("List Length: " + myList.length());
        System.out.println("Cursor Index: " + myList.index());
        System.out.println();


        System.out.println("prepend(7)");
        myList.prepend(7);
        myList.moveBack();
        myList.moveNext();
        myList.moveNext();
        myList.moveFront();


        System.out.println("List Length: " + myList.length());
        System.out.println("Cursor Index: " + myList.index());
        System.out.println("get(): " + myList.get());
        System.out.println("front(): " + myList.front());
        System.out.println("back(): " + myList.back());

        System.out.println();
        System.out.println("insertBefore(2)");
        myList.insertBefore(2);
        System.out.println();

        System.out.println("List Length: " + myList.length());
        System.out.println("Cursor Index: " + myList.index());
        System.out.println("get(): " + myList.get());
        System.out.println("front(): " + myList.front());
        System.out.println("back(): " + myList.back());

        System.out.println();
        System.out.println("moveBack()");
        myList.moveBack();
        System.out.println();

        System.out.println("List Length: " + myList.length());
        System.out.println("Cursor Index: " + myList.index());
        System.out.println("get(): " + myList.get());
        System.out.println("front(): " + myList.front());
        System.out.println("back(): " + myList.back());

        System.out.println();
        System.out.println("moveFront()");
        myList.moveFront();
        System.out.println();

        System.out.println("List Length: " + myList.length());
        System.out.println("Cursor Index: " + myList.index());
        System.out.println("get(): " + myList.get());
        System.out.println("front(): " + myList.front());
        System.out.println("back(): " + myList.back());

        System.out.println();
        System.out.println("insertAfter(14)");
        myList.insertAfter(14);
        System.out.println();

        System.out.println("List Length: " + myList.length());
        System.out.println("Cursor Index: " + myList.index());
        System.out.println("get(): " + myList.get());
        System.out.println("front(): " + myList.front());
        System.out.println("back(): " + myList.back());

        System.out.println();
        System.out.println("moveBack()");
        myList.moveBack();
        System.out.println();

        System.out.println("List Length: " + myList.length());
        System.out.println("Cursor Index: " + myList.index());
        System.out.println("get(): " + myList.get());
        System.out.println("front(): " + myList.front());
        System.out.println("back(): " + myList.back());

        System.out.println();
        System.out.println("clear()");
        myList.clear();
        System.out.println();

        System.out.println("List Length: " + myList.length());
        System.out.println("Cursor Index: " + myList.index());

    }
}
