/*
This class will be used in future assignments.  It is highly
recommended to solve Assignment 1.2.
*/
public class Startlist {

    // Assignment 1.2:

    // The object variable 'participations', which is an array
    //  of Participation objects, shall be declared here.
    private Participation[] participations;

    // A constructor for this class shall be defined here.
    // A new object constructed by
    //  
    //   new Startlist(100)
    //  
    // has room for 100 participations (all 'null' at first)
    public Startlist(int size) {
        participations = new Participation[size];
    }

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        Startlist list = new Startlist(3);
        list.add(new Participation("Sauhügelabfahrt", "Der Peter", 75));
        list.add(new Participation("Sauhügelabfahrt", "Die Susi", 22));
        System.out.println("size: " + list.count());
        list.add(new Participation("Sauhügelabfahrt", "Papa", 69));
        list.add(new Participation("Sauhügelabfahrt", "Waldemar", 1));
        System.out.println("size: " + list.count());
        System.out.println();
        list.print();
        System.out.println();
        list.printOrdered();
        System.out.println();
        list.printPermutations();
    }

    // adds p to 'this'
    public void add(Participation p) {
        for (int i = 0; i < participations.length; i++) {
            if (participations[i] == null) {
                participations[i] = p;
                return;
            }
        }
        setSize(participations.length + 1);
        participations[participations.length - 1] = p;
        System.out.println("Warning: Startlist size increased to fit in new participants.");
    }

    private void setSize(int size) {
        if (size > count()) {
            Participation[] bigger = new Participation[size];
            System.arraycopy(participations, 0, bigger, 0, participations.length);
            participations = bigger;
        } else {
            System.out.println("Cant decrease the size lower than the number of participants.");
        }
    }
    
    // Print the filled entries in an arbitrary order; each
    // participation is printed in the same format as produced by
    // print() in Participation, followed by a newline.
    public void print() {
        for (Participation el : getEntries()) {
            el.print();
            System.out.println();
        }
    }

    // Print the filled entries in the order of increasing bib
    // numbers; each participation is printed in the same format as
    // produced by print() in Participation, followed by a newline.
    public void printOrdered() {
        for (Participation el : getSortedParticipants()) {
            el.print();
            System.out.println();
        }
    }

    public int count() {
        int size = 0;
        for (Participation el : participations) {
            if (el != null) {
                size++;
            }
        }
        return size;
    }

    private Participation[] getEntries() {
        Participation[] entries = new Participation[count()];
        int j = 0;
        for (Participation el : participations) {
            if (el != null) {
                entries[j++] = el;
            }
        }
        return entries;
    }

    // Questions:

    // 1) In which sensible ways can the program react if more entries
    // are added to 'this' than the array has entries?  What does your
    // program do?
//        Depends, but here i found it best to auto increase size.
    // 
    // 2) Frequent requirements for start lists are that all the bib
    // numbers in a race are different, contiguous, and start at 1.
    // We did not require these in this assignment.  Did you?  If so,
    // did this simplify the implementation?  How much more complex
    // would your program become if you lifted one or several of these
    // requirements?  With such requirements, what are sensible ways
    // to react to violations of these requirements?  In particular,
    // what happens if the same bib number is inserted twice?
    //
//        Here I want to keep it simple and ignore any restrictions. But the next sensible step woulb be to use the array index for the start number. So you wouldnt need to sort it.
    // 
    // 3) Another requirement for a start list is that all
    // participations are for the same race.  Do you check this?
    // What is a sensible way to react if this is violated?
    //
//        It wouldnt make sense to have a participant own the race data if it was used in multiple races, so no restrictions. But It could be helpful to group the entries by race before printing.

    // Assignment 1.3:

    private Participation[] getSortedParticipants() {
        Participation[] sorted = getEntries();
        Participation temp;
//        getEntries returns an array with no null entries
        for (int j = 1; j < sorted.length; j++) {
            for (int i = 0; i < sorted.length - j; i++) {
                if (sorted[i].getBibnumber() > sorted[i + 1].getBibnumber()) {
                    temp = sorted[i];
                    sorted[i] = sorted[i + 1];
                    sorted[i + 1] = temp;
                }
            }
        }
        return sorted;
    }

    // Print all the permutations of the start list, with each
    // permutation followed by an empty line.
    public void printPermutations() {
        printPermutations(getEntries(), "");
    }

    // Question:

    // How many calls to your recursive method do you get when you
    // call printPermutations() on a start list with n filled entries?

//        n!

    private void printPermutations(Participation[] permutate, String concat) {
        if (permutate.length == 0) {
            System.out.println(concat);
        } else {
            Participation[] subpermutate = new Participation[permutate.length - 1];

            if (!concat.equals("")) {
                concat += ", ";
            }
            for (int i = 0; i < permutate.length; i++) {
                for (int j = 0; j < subpermutate.length; j++) {
                    subpermutate[j] = permutate[j < i ? j : j + 1];
                }

                printPermutations(subpermutate, concat + permutate[i].getBibnumber());
            }
        }

    }
}
