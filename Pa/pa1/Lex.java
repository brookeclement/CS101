//-----------------------------------------------------------------------------
//  Lex.java
//  Christopher S. Gradwohl
//  cgradwoh
//  pa1
//  Sorts a specified input file in alphabetical order
//-----------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

public class Lex{


    public static void main(String[] args) throws IOException {

        if( args.length!=2 ){
            System.err.println("Lex Usage: Lex <input file> <output file>");
            System.exit(1);
        }

        // opens input file
        Scanner in = new Scanner(new File(args[0]));
        // opens output file and creates FileWriter Object
        PrintWriter out = new PrintWriter(new FileWriter( args[1] ) );

        // matches the end of file character
        in.useDelimiter("\\Z");

        // read in whole file as a single String separated by a new line character
        String s = in.next();

        // place strings from input file into String array
        String[] stringArray = s.split("\n");

    //  InsertionSort (indirect version)
    //  indirectly sorts a string array using a ListADT, and
    //  sorts List Object by 'calling from' the string array
        List L = new List();
        int n = stringArray.length;
        int i, j;

        if( L.length()==0 ) L.append(0);

        for( j=1; j<n; j++){
            L.moveFront();
            while( L.index()!=-1 && stringArray[j].compareTo(stringArray[L.get()])>0 ){
                L.moveNext();
            }
            if( L.index()==-1 ){
                L.append(j);
            }
            else
            L.insertBefore(j);
        }

        // prints out sorted String array using the List Object
        // by 'calling from' the string array
        L.moveFront();
        for( i=0; i<n; i++){
            out.println(stringArray[L.get()]);
            L.moveNext();
        }

        in.close();
        out.close();
    }


}
