public class PartTreeBinary implements PartTreeNodable {
    // An object of class 'PartTreeBinary' represents a nonempty node
    // in a binary search tree, using 'racer' as key.
    
    // Variables and expressions of type 'PartTreeNodable' and its
    // subtypes are never null.  Instead, an empty subtree is
    // represented by a 'PartTreeNull' object.
    
    // Do not use 'if', 'while', or '? :' to check whether a node is
    // empty or not; instead, call the appropriate method
    // implementation with dynamic binding.

    Participations1 parts = new Participations1();
    String racer;
    PartTreeNodable[] branches = {PartTreeNull.NIL, PartTreeNull.NIL};

    PartTreeBinary (Participation p) {
        parts.add(p);
        racer = p.getRacer();
    }

    @Override
    public PartTreeNodable add(Participation p) {
        if (racer.equals(p.getRacer())) {
            parts.add(p);
        } else {
            int direction = p.getRacer().compareTo(racer) < 0 ? 0 : 1;
            branches[direction] = branches[direction].add(p);
        }
        return this;
    }

    @Override
    public String toString() {
        return "" + branches[0] + parts + branches[1];
    }

    @Override
    public void print() {
        branches[0].print();
        parts.print();
        branches[1].print();
    }

    @Override
    public Participation lookupRacer(String r) {
        if (racer.equals(r)) {
            return parts.first();
        }
        int direction = r.compareTo(racer) < 0 ? 0 : 1;
        return branches[direction].lookupRacer(r);
    }

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
