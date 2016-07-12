//-----------------------------------------------------------------------------
//  List.java
//  Christopher S. Gradwohl
//  cgradwoh
//  pa3
//  ListADT for the Matrix.java client using a doubley linked list of Objects
//-----------------------------------------------------------------------------


@SuppressWarnings("overrides")
public class List {

    @SuppressWarnings("overrides")
    private class Node {

        // fields for private Node class
        Object data;
        Node prev;
        Node next;

        // Node Constructor
        Node(Object entry) {
            data = entry;
            prev = null;
            next = null;
        }

        // methods for private Node class
        @SuppressWarnings("unchecked")
        public boolean equals(Object x){
           boolean eq = false;
           Node that;
           if(x instanceof Node){
              that = (Node) x;
              eq   = (this.data==that.data);
           }
           return eq;
        }

    }

    // ----------------------------------------------------------------------
    // Fields
    // ----------------------------------------------------------------------

    private Node front;
    private Node back;
    private Node cursor;
    private int length;
    private int index;

    // List Constructor
    // Creates a new empty list.
    List() {
        front  = null;
        back   = null;
        cursor = null;
        length = 0;
        index  = -1;
    }

    // ----------------------------------------------------------------------
    // Access functions
    // ----------------------------------------------------------------------

    // Returns the number of elements in this List.
    // Pre: none
    public int length() {
        return length;
    }

    // If cursor is defined, returns the index of the cursor element,
    // otherwise returns -1.
    // Pre: none
    public int index() {
        return index;
    }

    // Returns front element.
    // Pre: length()>0
    public Object front() {
        if( length==0 ){
            throw new RuntimeException(
                "List Error: front() called on empty List");
        }
        return front.data;
    }

    // Returns back element.
    // Pre: length()>0
    public Object back() {
        if( length==0 ){
            throw new RuntimeException(
                "List Error: back() called on empty list");
        }
        return back.data;
    }

    // Returns cursor element.
    // Pre: length()>0, index()>=0
    public Object get() {
        if( length==0 ){
            throw new RuntimeException(
                "List Error: get() called on empty list");
        }
        if( index<0 ){
            throw new RuntimeException(
                "List Error: get() called on undefined cursor position");
        }
        return cursor.data;
    }

    // Returns true if this List and L are the same integer
    // sequence. The cursor is ignored in both lists.
    // Pre: none
    @SuppressWarnings("unchecked")
    public boolean equals(Object x){
        boolean eq = false;
        List L;
        Node N, M;

        if(x instanceof List){
            L = (List)x;
            N = this.front;
            M = L.front;
            eq = (this.length==L.length);
            while( eq && N!=null ){
                eq = N.equals(M);
                N  = N.next;
                M  = M.next;
            }
        }
        return eq;
    }

    // ----------------------------------------------------------------------
    // Manipulation procedures
    // ----------------------------------------------------------------------

    // Resets this List to its original empty state.
    // Pre: none
    public void clear(){
        front  = null;
        back   = null;
        cursor = null;
        length = 0;
        index  = -1;
    }

    // If List is non-empty, places the cursor under the front element,
    // otherwise does nothing.
    // Pre: none
    public void moveFront(){
        if( length>0 ){
            cursor = front;
            index  = 0;
        }
    }

    // If List is non-empty, places the cursor under the back element,
    // otherwise does nothing.
    // Pre: none
    public void moveBack(){
        if( length>0 ){
            cursor = back;
            index  = length - 1;
        }
    }

    // If cursor is defined and not at front, moves cursor one step toward
    // front of this List, if cursor is defined and at front, cursor becomes
    // undefined, if cursor is undefined does nothing.
    // Pre: none
    public void movePrev(){
        if( cursor!=null && cursor!=front ){
            cursor = cursor.prev;
            index--;
        }else if( cursor!=null && cursor==front ){
            cursor = null;
            index  = -1;
        }else if ( cursor==null ){
            cursor = null;
            index  = -1;
        }
    }

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
            index  = -1;
        }else if ( cursor==null ){
            cursor = null;
            index  = -1;
        }
    }

    // Insert new element into this List. If List is non-empty,
    // insertion takes place before front element.
    // Pre: none
    public void prepend(Object data){
        Node C = new Node(data);
        if( length==0 ){
            front = C;
            back  = C;
        }else{
            front.prev = C;
            C.next     = front;
            front      = C;
        }
        length++;
    }

    // Insert new element into this List. If List is non-empty,
    // insertion takes place after back element.
    // Pre: none
    public void append(Object data){
        Node C = new Node(data);
        if( length==0 ){
            front = C;
            back  = C;
        }else{
            back.next = C;
            C.prev    = back;
            back      = C;
        }
        length++;
    }

    // Insert new element before cursor.
    // Pre: length()>0, index()>=0
    public void insertBefore(Object data){
        if( length<=0 ){
            throw new RuntimeException(
                "List Error: insertBefore() called on empty list");
        }
        if( index<0 ){
            throw new RuntimeException(
                "List Error: insertBefore() called on undefined cursor position");
        }

        Node C = new Node(data);
        if( cursor==front ){
            cursor.prev = C;
            C.next      = cursor;
            front       = C;
        }else {
            cursor.prev.next = C;
            cursor.prev      = C;
            C.prev           = cursor.prev;
            C.next           = cursor;
        }
        index++;
        length++;
    }

    // Inserts new element after cursor.
    // Pre: length()>0, index()>=0
    public void insertAfter(Object data){
        if( length==0 ){
            throw new RuntimeException(
                "List Error: insertAfter() called on empty list");
        }
        if( index<0 ){
            throw new RuntimeException(
                "List Error: insertAfter() called on undefined cursor position");
        }

        Node C = new Node(data);
        if( cursor==back ){
            cursor.next = C;
            C.prev      = cursor;
            back        = C;
        }else {
            cursor.next      = C;
            cursor.next.prev = C;
            C.prev           = cursor;
            C.next           = cursor.next;
        }
        length++;
    }

    // Deletes the front element.
    // Pre: length()>0
    public void deleteFront(){
        if( length==0 ){
            throw new RuntimeException(
                "List Error: deleteFront() called on empty list");
        }
        if( cursor==front ){
            cursor = cursor.next;
        }
        front      = front.next;
        front.prev = null;
        index--;
        length--;
    }

    // Deletes the back element.
    // Pre: length()>0
    public void deleteBack(){
        if( length<=0 ){
            throw new RuntimeException(
                "List Error: deleteBack() called on empty list");
        }
        if( cursor==back ){
            cursor = cursor.prev;
            index--;
        }
        back      = back.prev;
        back.next = null;
        length--;
    }

    // Deletes cursor element, making cursor undefined.
    // Pre: length()>0, index()>=0
    public void delete(){
        if( length<=0 ){
            throw new RuntimeException(
                "List Error: delete() called on empty list");
        }
        if ( index<0 ){
            throw new RuntimeException(
                "List Error: delete() called on invalid cursor position");
        }
        if( cursor==front ){
            front      = front.next;
            front.prev = null;
            cursor     = null;
        }
        if( cursor==back ){
            back      = back.prev;
            back.next = null;
            cursor    = null;
        }
        cursor.prev.next = cursor.next;
        cursor.next.prev = cursor.prev;
        cursor           = null;

        index = -1;
        length--;
    }

    // ----------------------------------------------------------------------
    // Other methods
    // ----------------------------------------------------------------------

    // Overrides Object's toString method. Returns a String
    // representation of this List consisting of a space
    // separated sequence of integers, with front on left.
    // Pre: none
    public String toString(){
        StringBuffer sb = new StringBuffer();
        Node N          = front;
        Object data;
        while(N!=null){
            data = N.data;
            sb.append(data);
            sb.append(" ");
            N    = N.next;
        }
        return new String(sb);
    }


}
