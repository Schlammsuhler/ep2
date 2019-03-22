/*
This class will be used in future assignments and in the ad-hoc
assignment.  It is recommended to solve Assignment 2.3 and 2.4
*/
// Objects of class 'Participations' contain participations from
// several races.  The implementation uses an array.
public class Participations {

    // Assignment 2.3

    // Introduce (private) object variables as needed.

    // Creates an empty object of this class with space for n entries.
    public Participations(int n) {
        // TODO: implement this constructor
    }

    // Adds p to 'this'.
    public void add(Participation p) {
        // TODO: Implement this method without using methods from
        //  other classes
    }
    
    // Print the filled entries in the order of insertion; each
    // participation is printed in the same format as produced by
    // print() in Participation, followed by a newline.
    public void print() {
        // TODO: Implement this method
    }

    // Frage:

    // Wie unterscheidet sich Ihre Implementierung von Participations
    // bis hierher von Ihrer Implementierung von StartList?  Wenn Sie
    // in StartList Vorbedingungen ausgenutzt haben, um die
    // Implementierung zu vereinfachen, hat sich das in der
    // Gesamtsicht ausgezahlt?  Begründen Sie Ihre Antwort.


    // Returns the first participation (the one that was inserted
    // earliest) in 'this' where the 'racer' equals 'r'.  If there is
    // no such participation, return null.
    public Participation lookupRacer(String r) {
        // TODO: Implement this method without using methods from
        //  other classes
        return null;
    }

    // Frage:

    // Sie können die erste participation finden, indem Sie beim
    // ersten eingefügten Element anfangen, oder beim letzten.  Welche
    // Variante haben Sie gewählt?  Welche ist aufwändiger zu
    // Programmieren?  Welche ist zur Laufzeit aufwändiger?  Begründen
    // Sie Ihre Antworten.


    // Assignment 2.4

    // introduce additional object variables if needed

    // Creates a 'Participations' object that contains all
    // participations where race.compareTo(r1)>=0 and
    // race.compareTo(r2)<=0.  The entries are in the same order as in
    // l; add will not be used on objects produced with this
    // constructor.
    public Participations(Participations l, String r1, String r2) {
        // TODO: Implement this constructor
    }

    // Frage:

    // Welche Auswirkung hat die Einschränkung, dass add nicht auf mit
    // diesem Konstruktor erzeugte Objekte angewendet wird, auf Ihr
    // Programm?
    

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
