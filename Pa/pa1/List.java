//-----------------------------------------------------------------------------
//  List.java
//  Christopher S. Gradwohl
//  cgradwoh
//  pa1
//  ListADT for Lex.java using a doubley linked queue
//-----------------------------------------------------------------------------

// test

public class List {


    private class Node {
        // fields for private Node class
        int data;
        Node prev;
        Node next;

        // constructor
        Node(int i) {
            data = i;
            prev = null;
            next = null;
        }
    }

    // ----------------------------------------------------------------------
    // Fields
    // ----------------------------------------------------------------------
    private Node front;
    private Node back;
    private Node cursor;
    private int numElements;
    private int index;

    // Constructor
    // Creates a new empty list.
    List() {
        front = null;
        back = null;
        cursor = null;
        numElements = 0;
        index = 0;
    }


    // ----------------------------------------------------------------------
    // Access functions
    // ----------------------------------------------------------------------


    // Returns the number of elements in this List.
    // Pre: none
    int length() {
        return numElements;
    }

    // If cursor is defined, returns the index of the cursor element,
    // otherwise returns -1.
    // Pre: none
    int index() {
        if ( cursor==null ) {
            index = -1;
            return index;
        } else {
            index = cursor.data;
            return index;
        }
    }




    //-------------------------
    // Lookup
    //-------------------------

    // Returns front element.
    // Pre: length()>0
    int front() {
        if( this.length()==0 ){
            throw new RuntimeException(
                "Queue Error: front() called on empty Queue");
        }
        return front.next.data; // the .next might not be necessary since front is a "pointer"
    }

    // Returns back element.
    // Pre: length()>0
    int back() {
        if( this.length()==0 ){
            throw new RuntimeException(
                "Queue Error: back() called on empty Queue");
        }
    return back.prev.data; // the .prev might not be necessary since back is a "pointer"
}

    // Returns cursor element.
    // Pre: length()>0, index()>=0
    int get() {
        if( this.length()==0 ){
            throw new RuntimeException(
                "Queue Error: get() called on empty Queue");
        }
        return cursor.data;
    }

    // Returns true if this List and L are the same integer
    // sequence. The cursor is ignored in both lists.
    // Pre: none
    boolean equals(List L);


    // ----------------------------------------------------------------------
    // Manipulation procedures
    // ----------------------------------------------------------------------


    //-------------------------
    // MakeEmpty
    //-------------------------

    // Resets this List to its original empty state.
    // Pre: none
    void clear();



    //-------------------------
    // cursor
    //-------------------------

    // If List is non-empty, places the cursor under the front element,
    // otherwise does nothing.
    // Pre: none
    void moveFront();

    // If List is non-empty, places the cursor under the back element,
    // otherwise does nothing.
    // Pre: none
    void moveBack();

    // If cursor is defined and not at front, moves cursor one step toward
    // front of this List, if cursor is defined and at front, cursor becomes
    // undefined, if cursor is undefined does nothing.
    // Pre: none
    void movePrev();

    // If cursor is defined and not at back, moves cursor one step toward
    // back of this List, if cursor is defined and at back, cursor becomes
    // undefined, if cursor is undefined does nothing.
    // Pre: none
    void moveNext();



    //-------------------------
    // Insert
    //-------------------------

    // Insert new element into this List. If List is non-empty,
    // insertion takes place before front element.
    // Pre: none
    void prepend(int data);

    // Insert new element into this List. If List is non-empty,
    // insertion takes place after back element.
    // Pre: none
    void append(int data);

    // Insert new element before cursor.
    // Pre: length()>0, index()>=0
    void insertBefore(int data);

    // Inserts new element after cursor.
    // Pre: length()>0, index()>=0
    void insertAfter(int data);





    //-------------------------
    // Delete
    //-------------------------

    // Deletes the front element.
    // Pre: length()>0
    void deleteFront();

    // Deletes the back element.
    // Pre: length()>0
    void deleteBack();

    // Deletes cursor element, making cursor undefined.
    // Pre: length()>0, index()>=0
    void delete();


    // ----------------------------------------------------------------------
    // Other methods
    // ----------------------------------------------------------------------


    // Overrides Object's toString method. Returns a String
    // representation of this List consisting of a space
    // separated sequence of integers, with front on left.
    // Pre: none
    public String toString();

    // Returns a new List representing the same integer sequence as this
    // List. The cursor in the new list is undefined, regardless of the
    // state of the cursor in this List. This List is unchanged.
    // Pre: none
    List copy();

    // The following operation is optional, and may come in handy in some future assignment:
    // Returns a new List which is the concatenation of
    // this list followed by L. The cursor in the new List
    // is undefined, regardless of the states of the cursors
    // in this List and L. The states of this List and L are
    // unchanged.
    List concat(List L);

}
