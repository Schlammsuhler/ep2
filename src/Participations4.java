import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

    // Returns a StringIterable (see StringIterable.java) that contains
    // the set of 'race's (i.e., each race occurs only once) of all
    // Participation entries in 'this' (at the time when copyRaces() is
    // called).
    public StringIterable copyRaces() {
        List<String> races = new ArrayList<>();
        for (Participation p: this) {
            String race = p.getRace();
            if (!races.contains(race)) {
                races.add(race);
            }
        }
        return new MyStringIterable(races);
    }

    // As in copyRaces(), but selects only those races where the racer equals 'r'.
    public StringIterable copyRaces(String r) {
        List<String> races = new ArrayList<>();
        for (Participation p: this) {
            String race = p.getRace();
            if (p.getRacer().equals(r) && !races.contains(race)) {
                races.add(race);
            }
        }
        return new MyStringIterable(races);
    }

    // Returns a StringIterable that contains the set of 'race's of all
    // Participation entries in 'this'.  Iterating through the
    // StringIterable enumerates all the 'race's in 'this' at the time
    // when the iterator is created.  It is allowed to enumerate none,
    // some, or all of the new races that are added between the creation
    // of the iterator and its exhaustion (i.e., hasNext() returns false).
    public StringIterable viewRaces() {
        return new MyRaceIterable(this);
    }

    // As in viewRaces(), but selects only those races where the racer equals 'r'.
    public StringIterable viewRaces(String r) {
        return new MyRaceIterable(this, r);
    }


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

        System.out.println("\n--StringIterable--");
        for (String i: p.copyRaces()) {
            System.out.println(i);
        }

        System.out.println("\n--find racers--");
        for (String i: p.copyRaces("Franz")) {
            System.out.println(i);
        }

        System.out.println("\n--viewRaces--");
        StringIterable races = p.viewRaces();
        p.add(new Participation("race5", "Herbert", 6));
        for (String i: races) {
            System.out.println(i);
        }
        System.out.println("\n--viewRaces, filtered--");
        races = p.viewRaces("Herbert");
        for (String i: races) {
            System.out.println(i);
        }
    }

    private class MyStringIterable implements StringIterable {
        Iterable<String> strings;

        public MyStringIterable(Iterable<String> strings) {
            this.strings = strings;
        }

        @Override
        public StringIterator iterator() {
            return new MyStringIterator(strings.iterator());
        }
    }

    private class MyRaceIterable implements StringIterable {
        PartIterable parts;
        String racer;

        public MyRaceIterable(PartIterable parts) {
            this.parts = parts;
        }

        public MyRaceIterable(PartIterable parts, String racer) {
            this(parts);
            this.racer = racer;
        }

        @Override
        public StringIterator iterator() {
            List<String> races = new ArrayList<>();
            for (Participation p: parts) {
                if (racer == null || racer.equals(p.getRacer())) {
                    if (!races.contains(p.getRace())) {
                        races.add(p.getRace());
                    }
                }
            }
            return new MyStringIterator(races.iterator());
        }
    }

    private class MyStringIterator implements StringIterator {
        Iterator<String> iterator;

        public MyStringIterator(Iterator<String> iterator) {
            this.iterator = iterator;
        }

        @Override
        public String next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }
}


