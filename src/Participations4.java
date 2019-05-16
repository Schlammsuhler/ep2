public class Participations4 implements PartIterable {
    // Objects of class 'Participations3' contain participations from
    // several races.  The implementation uses a hash table as follows:
    //   - the tuple ('racer','race') is the key (i.e., what the 'equals'
    //     method of 'Participation' implements);
    //   - the values of the hash table are 'Participations' objects.
    // However, the array of the hash table contains 'Participations1'
    // objects.  'Participation' objects with the same index in the
    // array are inserted in the same 'Participations1' object.
    // This variant of hash table implementation is known as separate chaining.

    // This implementation does not use classes from the Collections
    // Framework (e.g., HashMap)
    // <https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html>.

    // Assignment 5.2

    Participations1[] table;

    // Creates an empty hash table with room for n 'Participation1' objects
    public Participations4(int n) {
        table = new Participations1[n];
    }

    // Adds p to 'this'.
    public void add(Participation p) {
        if (table[position(p)] == null) {
            table[position(p)] = new Participations1();
        }
        table[position(p)].add(p);
    }

    private int position(Participation p) {
        return p.hashCode() % table.length;
    }
    
    // returns a string that contains the participations in arbitrary
    // order, each participation in the format produced by print() in
    // Participation, followed by a newline.
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                s.append(table[i]);
            }
        }
        return s.toString();
    }

    // Print the participations in the format produced by 'toString()'.
    public void print() {
        System.out.println(this);
    }

    // Returns the first participation (the one that was inserted
    // earliest) in 'this' that equals() 'p'.  If there is no such
    // participation, return null.
    public Participation lookupRacer(Participation p) {
        if (table[position(p)] == null) {
            return null;
        }
        return table[position(p)].lookupRacer(p);
    }

    public PartIterator iterator () {
        return new Participations4Iter(table);
    }

    // Fragen:

    // 1) Wenn in so eine Hash-Tabelle mit n 'Participations1'-Listen
    // m unterschiedliche Participation-Einträge eingefügt werden, wie
    // gross ist die durchschnittliche Länge l der Listen?  Warum kann
    // der durchschnittliche Zugriff deutlich länger dauern als ein
    // durchschnittlicher Zugriff auf eine Liste der Länge l plus der
    // Aufwand, bis die Liste erreicht ist?  Überlegen Sie sich einen
    // besonders langsamen Fall, und wann der garantiert auftritt.
    // Worauf sollte man daher bei der Verwendung von Hash-Tabellen
    // achten?
    
    // 2) Vergleichen Sie diese Art der Kollisionsbehandlung mit der im
    // Skriptum gezeigten. Was sind die Vor- und Nachteile der Methoden?

    // 3) Vergleichen Sie die Klassen
    // 'Participations' bis 'Participations4'.  Was sind die
    // Gemeinsamkeiten und Unterschiede im Verhalten (nicht in der
    // Implementierung). Überlegen Sie sich, wie Sie diese drei
    // Klassen in einer Typhierarchie organisieren würden; welche
    // Typen übernehmen welche Eigenschaften von den übergeordneten
    // Typen, und welche fügen sie hinzu?


    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        Participations4 p = new Participations4(10);
        p.add(new Participation("race1", "Herbert", 1));
        p.add(new Participation("race2", "Franz", 2));
        p.add(new Participation("race2", "Herbert", 3));
        p.add(new Participation("race4", "Franz", 4));
        p.add(new Participation("race4", "Franz", 5));

        p.print();
        Participation racer = p.lookupRacer(new Participation("race4", "Franz", 0));
        System.out.println(racer);

        System.out.println("\n--iterable--");
        for (Participation i: p) {
            System.out.println("- " + i);
        }
    }
}
