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



        // Format: after each manipulation procedure I will call ALL access functions
        List myList = new List();

        //Acess function block
        System.out.println();
        System.out.println("lenth(): " + myList.length());
        System.out.println("index(): " + myList.index());
        //System.out.println("front(): " + myList.front());
        //System.out.println("back(): " + myList.back());
        //System.out.println("get(): " + myList.get());
        System.out.println("toString(): " + myList);
        System.out.println();

        //insert 2,3,4,5 using append() and moveFront()
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        myList.moveFront();


        //Acess function block
        System.out.println("insert 2,3,4,5 using append() and moveFront()");
        System.out.println("lenth(): " + myList.length());
        System.out.println("index(): " + myList.index());
        System.out.println("front(): " + myList.front());
        System.out.println("back(): " + myList.back());
        System.out.println("get(): " + myList.get());
        System.out.println("toString(): " + myList);
        System.out.println();

        // move cursor to index 2
        myList.moveNext();
        myList.moveNext();

        //Acess function block
        System.out.println("move cursor to index 2");
        System.out.println("lenth(): " + myList.length());
        System.out.println("index(): " + myList.index());
        System.out.println("front(): " + myList.front());
        System.out.println("back(): " + myList.back());
        System.out.println("get(): " + myList.get());
        System.out.println("toString(): " + myList);
        System.out.println();

        //insertBefore() 7,8,9 index() should change to 5
        myList.insertBefore(7);
        myList.insertBefore(8);
        myList.insertBefore(9);

        //Acess function block
        System.out.println("insertBefore() 7,8,9 index() should change to 5");
        System.out.println("lenth(): " + myList.length());
        System.out.println("index(): " + myList.index());
        System.out.println("front(): " + myList.front());
        System.out.println("back(): " + myList.back());
        System.out.println("get(): " + myList.get());
        System.out.println("toString(): " + myList);
        System.out.println();

        //insertAfter() 3,2,1 index() should NOT change
        myList.insertAfter(1);
        myList.insertAfter(2);
        myList.insertAfter(3);

        //Acess function block
        System.out.println("insertAfter() 3,2,1 index() should NOT change");
        System.out.println("lenth(): " + myList.length());
        System.out.println("index(): " + myList.index());
        System.out.println("front(): " + myList.front());
        System.out.println("back(): " + myList.back());
        System.out.println("get(): " + myList.get());
        System.out.println("toString(): " + myList);
        System.out.println();

        //deleteFront() and deleteBack()
        myList.deleteFront();
        myList.deleteBack();

        //Acess function block
        System.out.println("deleteFront() and deleteBack()");
        System.out.println("lenth(): " + myList.length());
        System.out.println("index(): " + myList.index());
        System.out.println("front(): " + myList.front());
        System.out.println("back(): " + myList.back());
        System.out.println("get(): " + myList.get());
        System.out.println("toString(): " + myList);
        System.out.println();

        // delete() index should be -1 should delete '4' from the list
        myList.delete();

        //Acess function block
        System.out.println("delete() index should be -1 should delete '4' from the list");
        System.out.println("lenth(): " + myList.length());
        System.out.println("index(): " + myList.index());
        System.out.println("front(): " + myList.front());
        System.out.println("back(): " + myList.back());
        //System.out.println("get(): " + myList.get());
        System.out.println("toString(): " + myList);
        System.out.println();

        //moveNext() on undefined cursor should do nothing
        myList.moveNext();
        myList.moveNext();

        //Acess function block
        System.out.println("moveNext() on undefined cursor should do nothing");
        System.out.println("lenth(): " + myList.length());
        System.out.println("index(): " + myList.index());
        System.out.println("front(): " + myList.front());
        System.out.println("back(): " + myList.back());
        //System.out.println("get(): " + myList.get());
        System.out.println("toString(): " + myList);
        System.out.println();

        // moveFront(), moveNext(), moveNext(), delete()
        myList.moveFront();
        myList.moveNext();
        myList.moveNext();
        myList.delete();

        //Acess function block
        System.out.println("moveFront(), moveNext(), moveNext(), delete()");
        System.out.println("lenth(): " + myList.length());
        System.out.println("index(): " + myList.index());
        System.out.println("front(): " + myList.front());
        System.out.println("back(): " + myList.back());
        //System.out.println("get(): " + myList.get());
        System.out.println("toString(): " + myList);
        System.out.println();

        // clear()
        myList.clear();

        //Acess function block
        System.out.println("clear()");
        System.out.println("lenth(): " + myList.length());
        System.out.println("index(): " + myList.index());
        //System.out.println("front(): " + myList.front());
        //System.out.println("back(): " + myList.back());
        //System.out.println("get(): " + myList.get());
        System.out.println("toString(): " + myList);
        System.out.println();



    }
}
