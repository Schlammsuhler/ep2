/*
This class will be used in future assignments and in the ad-hoc
assignment.  It is recommended to solve Assignment 3.2 and 3.3 (and
this also requires 3.1)
*/
// Objects of class 'Participations2' contain participations from
// several races.  The implementation uses a binary search tree as
// associative data structure, using 'racer' as key; the value
// associated with the key is a 'Participations1' object containing
// all participations of this racer.  This implementation does not use
// classes from the Collections Framework (e.g., TreeMap)
// <https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html>.

public class Participations2 {

    // Assignment 3.2 (continued from Participations1.java)

    // Introduce (private) object variables and classes as needed.
    private MyTreeNode root;

    // Creates an empty object of this class
    public Participations2(int n) {
    }

    // Creates an empty object of this class
    public Participations2() {
    }

    // Adds p to 'this'.
    public void add(Participation p) {
        if (root == null) {
            root = new MyTreeNode(p);
        } else {
            root.add(p);
        }
    }
    
    // Print the entries in the following order: The participations of
    // different racers are printed in the order given by compareTo,
    // with x being printed before y if x.compareTo(y)<0.  The
    // participations of the same racer are printed in the order of
    // insertion.  Each participation is printed in the same format as
    // produced by print() in Participation, followed by a newline.
    public void print() {
        if (root != null) {
            root.print();
        }
    }

    // Returns the first participation (the one that was inserted
    // earliest) in 'this' where the 'racer' equals 'r'.  If there is
    // no such participation, return null.
    public Participation lookupRacer(String r) {
        if (root != null) {
            return root.lookupRacer(r);
        }
        return null;
    }

    // Fragen:

    // 1) Wie unterscheidet sich Ihre Implementierung von
    // Participations2 bis hierher von Ihrer Implementierung von
    // Participations1 und Participations?  Welche Vor- und Nachteile
    // haben die Implementierungen im Vergleich?

    // 2) Was sind die Vorteile der Verwendung von 'racer' als
    // Schlüssel?  Könnte man stattdessen auch 'race' oder 'bibnumber'
    // verwenden?  In welchen Fällen wäre das hilfreich?  Wie kann
    // man die Daten organisieren, wenn man die Vorteile von
    // verschiedenen Schlüsseln kombinieren will?  Und was wären die
    // Nachteile?

    
    // Assignment 3.3 (continued from Participations1.java)

    // print the entries with bibnumber<=x in the same order as used
    // by print() in Participations2; each participation is printed in
    // the same format as produced by print() in Participation,
    // followed by a newline.
    void print (int x) {
        if (root != null) {
            root.print(x);
        }
    }

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        Participations2 p = new Participations2(4);
        p.add(new Participation("race1", "Herbert", 1));
        p.add(new Participation("race2", "Franz", 2));
        p.add(new Participation("race2", "Herbert", 3));
        p.add(new Participation("race4", "Franz", 4));
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

    private class MyTreeNode {
        Participations1 parts;
        String racer;
        MyTreeNode[] branches;

        MyTreeNode (Participation p) {
            parts = new Participations1();
            parts.add(p);
            racer = p.getRacer();
            branches = new MyTreeNode[2];
        }

        void add (Participation p) {
            if (racer.equals(p.getRacer())) {
                parts.add(p);
            } else {
                int direction = p.getRacer().compareTo(racer) < 0 ? 0 : 1;
                if (branches[direction] == null) {
                    branches[direction] = new MyTreeNode(p);
                } else {
                    branches[direction].add(p);
                }
            }
        }

        void print () {
            if (branches[0] != null) {
                branches[0].print();
            }
            parts.print();
            if (branches[1] != null) {
                branches[1].print();
            }
        }

        void print (int x) {
            if (branches[0] != null) {
                branches[0].print(x);
            }
            parts.print(x);
            if (branches[1] != null) {
                branches[1].print(x);
            }
        }

        Participation lookupRacer(String r) {
            if (racer.equals(r)) {
                return parts.first();
            }
            int direction = r.compareTo(racer) < 0 ? 0 : 1;
            if (branches[direction] == null) {
                return null;
            }
            return branches[direction].lookupRacer(r);
        }
    }
}
