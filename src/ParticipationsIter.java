public class ParticipationsIter implements PartIterator {
    // This class implements an iterator for the class Participations
    
    private Participation[] parts;
    private int i = 0, max;

    public ParticipationsIter (Participation[] parts, int max) {
        this.parts = parts;
        this.max = max;
    }
    
    // returns the next 'Participation' object in the container that
    // 'this' iterates over.
    @Override
    public Participation next() {
        if (parts != null &&i < max) {
            return parts[i++];
        }
        return null;
    }

    // returns true if there is another 'Participation' object that
    // this.next() can return.
    @Override
    public boolean hasNext() {
        return parts != null && i < max && parts[i] != null;
    }
}
