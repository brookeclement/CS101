//-----------------------------------------------------------------------------
//  List.java
//  Christopher S. Gradwohl
//  cgradwoh
//  pa1
//  ListADT for Lex.java using a doubley linked queue
//-----------------------------------------------------------------------------


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
        index = -1;
    }


    // ----------------------------------------------------------------------
    // Access functions
    // ----------------------------------------------------------------------


    // Returns the number of elements in this List.
    // Pre: none
    public int length() {
        return numElements;
    }

    // If cursor is defined, returns the index of the cursor element,
    // otherwise returns -1.
    // Pre: none
    public int index() {
        return index;
    }


    //-------------------------
    // Lookup
    //-------------------------

    // Returns front element.
    // Pre: length()>0
    public int front() {
        if( this.length()==0 ){
            throw new RuntimeException(
                "Queue Error: front() called on empty Queue");
        }
        return front.data;
    }

    // Returns back element.
    // Pre: length()>0
    public int back() {
        if( this.length()==0 ){
            throw new RuntimeException(
                "Queue Error: back() called on empty Queue");
        }
        return back.data;
    }

    // Returns cursor element.
    // Pre: length()>0, index()>=0
    public int get() {
        if( this.length()==0 ){
            throw new RuntimeException(
                "List Error: get() called on empty Queue");
        }else if( this.index()<0 ){
            throw new RuntimeException(
                "List Error: get() called on undefined cursor position");
        }
        return cursor.data;
    }

    // Returns true if this List and L are the same integer
    // sequence. The cursor is ignored in both lists.
    // Pre: none
    //boolean equals(List L);


    // ----------------------------------------------------------------------
    // Manipulation procedures
    // ----------------------------------------------------------------------

    // Resets this List to its original empty state.
    // Pre: none
    public void clear(){
        front = null;
        back = null;
        cursor = null;
        numElements = 0;
        index = -1;
    }

    //-------------------------
    // cursor
    //-------------------------

    // If List is non-empty, places the cursor under the front element,
    // otherwise does nothing.
    // Pre: none
    public void moveFront(){
        if( this.numElements>0 ){
            cursor = front;
            index = 0;
        }
    }

    // If List is non-empty, places the cursor under the back element,
    // otherwise does nothing.
    // Pre: none
    public void moveBack(){
        if( numElements>0 ){
            cursor = back;
            index = numElements - 1;
        }
    }

    // If cursor is defined and not at front, moves cursor one step toward
    // front of this List, if cursor is defined and at front, cursor becomes
    // undefined, if cursor is undefined does nothing.
    // Pre: none
    //void movePrev();
        //index--;


    // If cursor is defined and not at back, moves cursor one step toward
    // back of this List, if cursor is defined and at back, cursor becomes
    // undefined, if cursor is undefined does nothing.
    // Pre: none
    public void moveNext(){
        if( cursor!=null && cursor!=back ){
            cursor = cursor.next;
            index++;
        }else if( cursor!=null && cursor==back ){
            cursor = null;
            index = -1;
        }else if ( cursor==null ){
            cursor = null;
            index = -1;
        }
    }



    //-------------------------
    // Insert
    //-------------------------

    // Insert new element into this List. If List is non-empty,
    // insertion takes place before front element.
    // Pre: none
    public void prepend(int data){
        Node C = new Node(data);
        if( numElements==0 ){
            front = C;
            back = C;
        }else {
            front.prev = C;
            C.next = front;
            front = C;
        }
        numElements++;
    }

    // Insert new element into this List. If List is non-empty,
    // insertion takes place after back element.
    // Pre: none
    //void append(int data);

    // Insert new element before cursor.
    // Pre: length()>0, index()>=0
    public void insertBefore(int data){
        if( this.length()==0 ){
            throw new RuntimeException(
                "List Error: insertBefore() called on empty list");
        }else if( this.index()<0 ){
            throw new RuntimeException(
                "List Error: insertBefore() called on undefined cursor position");
        }

        Node C = new Node(data);
        if( cursor==front ){
            cursor.prev = C;
            C.next = cursor;
            front = C;
        }else {
            Node P = cursor.prev;

            P.next = C;
            cursor.prev = C;
            C.prev = P;
            C.next = cursor;
        }
        index++;
        numElements++;
    }

    // Inserts new element after cursor.
    // Pre: length()>0, index()>=0
    public void insertAfter(int data){
        if( this.length()==0 ){
            throw new RuntimeException(
                "List Error: insertBefore() called on empty list");
        }else if( this.index()<0 ){
            throw new RuntimeException(
                "List Error: insertBefore() called on undefined cursor position");
        }

        Node C = new Node(data);
        if( cursor==back ){
            cursor.next = C;
            C.prev = cursor;
            back = C;
            numElements++;
        }else {
            Node P = cursor.next;
            cursor.next = C;
            P.prev = C;
            C.prev = cursor;
            C.next = P;
        }
        numElements++;
    }





    //-------------------------
    // Delete
    //-------------------------

    // Deletes the front element.
    // Pre: length()>0
    //void deleteFront();

    // Deletes the back element.
    // Pre: length()>0
    //void deleteBack();

    // Deletes cursor element, making cursor undefined.
    // Pre: length()>0, index()>=0
    //void delete();


    // ----------------------------------------------------------------------
    // Other methods
    // ----------------------------------------------------------------------


    // Overrides Object's toString method. Returns a String
    // representation of this List consisting of a space
    // separated sequence of integers, with front on left.
    // Pre: none
    //public String toString();

    // Returns a new List representing the same integer sequence as this
    // List. The cursor in the new list is undefined, regardless of the
    // state of the cursor in this List. This List is unchanged.
    // Pre: none
    //List copy();

    // The following operation is optional, and may come in handy in some future assignment:
    // Returns a new List which is the concatenation of
    // this list followed by L. The cursor in the new List
    // is undefined, regardless of the states of the cursors
    // in this List and L. The states of this List and L are
    // unchanged.
    //List concat(List L);

}
