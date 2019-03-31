/*
This class will be used in future assignments and in the ad-hoc
assignment.  It is recommended to solve Assignment 3.1, 3.2 and 3.3
*/
// Objects of class 'Participations1' contain participations from
// several races.  The implementation uses a linked list.  It does not
// use classes from the Collections Framework (e.g. LinkedList)
// <https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html>.

public class Participations1 {

    // Assignment 3.1

    // Introduce (private) object variables and classes as needed.
    private MyParticipationNode first;
    // Creates an empty object of this class
    public Participations1(int n) {
        this();
    }

    // Creates an empty object of this class
    public Participations1() {
    }

    // Adds p to 'this'.
    public void add(Participation p) {
        MyParticipationNode newNode = new MyParticipationNode(p);
        if (first == null) {
            first = newNode;
        } else {
            MyParticipationNode last = first;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }
    
    // Print the entries in the order of insertion; each participation
    // is printed in the same format as produced by print() in
    // Participation, followed by a newline.
    public void print() {
        MyParticipationNode node = first;
        while (node != null) {
            node.part.print();
            System.out.println();
            node = node.next;
        }
    }

    // Returns the first participation (the one that was inserted
    // earliest) in 'this' where the 'racer' equals 'r'.  If there is
    // no such participation, return null.
    public Participation lookupRacer(String r) {
        MyParticipationNode node = first;
        while (node != null) {
            if (node.part.getRacer().equals(r)) {
                return node.part;
            }
            node = node.next;
        }
        return null;
    }

    // Fragen:

    // 1) Wie unterscheidet sich Ihre Implementierung von
    // Participations1 bis hierher von Ihrer Implementierung von
    // Participations?  Welche Vor- und Nachteile haben die beiden
    // Implementierungen im Vergleich?  Wäre eine
    // Array-Implementierung, die das Array gegen ein doppelt so
    // großes tauscht, wenn der Platz nicht mehr reicht, für diese
    // Aufgabe weniger aufwändig?

    // 2) Hat der Parameter des Konstruktors eine Funktion? Wenn doch,
    // welche? Wenn nicht, ist es sinnvoll, den Parameter zu behalten?
    // Warum, bzw. warum nicht?

    // 3) Muss Ihre Implementierung bei jedem add-Aufruf die ganze
    // Liste durchgehen? Wenn ja, wie könnte man das vermeiden und
    // wieviel Programmieraufwand wäre nötig? Wenn nein, wieviel
    // Programmieraufwand hat das gekostet?

    
    // Assignment 3.2 (continued in Participations2.java)
    
    // Returns the first participation (the one that was inserted
    // earliest) in 'this'.  If there is no such participation, return
    // null.
    public Participation first() {
        if (first != null) {
            return first.part;
        } else {
            return null;
        }
    }


    // Assignment 3.3 (continued in Participations2.java)

    // print the entries with bibnumber<=x in the order of insertion;
    // each participation is printed in the same format as produced by
    // print() in Participation, followed by a newline.
    void print(int x) {
        MyParticipationNode node = first;
        while (node != null) {
            if (node.part.getBibnumber() <= x) {
                System.out.println(node.part);
            }
            node = node.next;
        }
    }

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        Participations1 p = new Participations1(4);
        System.out.println("FirstNull: " + p.first());
        p.add(new Participation("race1", "Herbert", 1));
        p.add(new Participation("race2", "Franz", 2));
        p.add(new Participation("race2", "Herbert", 3));
        p.add(new Participation("race4", "Franz", 4));
        System.out.println("First: " + p.first());
        p.print();
        System.out.println("--lookup--");
        System.out.println(p.lookupRacer("Herbert"));
        System.out.println(p.lookupRacer("Franz"));

        System.out.println("--bibno_0--");
        p.print(0);
        System.out.println("--bibno_2--");
        p.print(2);
        System.out.println("--bibno_3--");
        p.print(3);
    }

    private class MyParticipationNode {
        Participation part;
        MyParticipationNode next;

        MyParticipationNode (Participation p) {
            this.part = p;
        }
    }
}




