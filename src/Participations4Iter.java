public class Participations4Iter implements PartIterator {
    // This class implements an iterator for the class Participations4
    
    private Participations1[] lists;
    private int i;
    private PartIterator iter;

    public Participations4Iter (Participations1[] tree) {
        this.lists = tree;
    }
    
    // returns the next 'Participation' object in the container that
    // 'this' iterates over.
    @Override
    public Participation next() {
        if (hasNext()) {
            return iter.next();
        }
        return null;
    }

    // returns true if there is another 'Participation' object that
    // this.next() can return.
    @Override
    public boolean hasNext() {
        if (lists != null) {
            while (iter == null || !iter.hasNext()) {
                if (i >= lists.length) {
                    return false;
                }
                Participations1 l = lists[i++];
                if (l != null) {
                    iter = l.iterator();
                }
            }
            return true;
        }
        return false;
    }
}
