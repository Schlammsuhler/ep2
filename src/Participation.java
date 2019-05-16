/*
This class will be extended in the ad-hoc-assignment, and will be used
in future assignments, so it is highly recommended to solve this
assignment.

This class is part of software for ski racing administration.
 */
public class Participation {

    // Assignment 1.1:

    private String race;
    private String racer;
    private int bibnumber;

    // A new object constructed by
    //
    //   new Participation("Lienz 2011 Ladies' Slalom", "Mikaela Shiffrin", 40)
    //
    // shall specify the name of the race, the racer, and the bibnumber.

    public Participation(String race, String racer, int bibnumber) {
        this.race = race;
        this.racer = racer;
        this.bibnumber = bibnumber;
    }

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        Participation test = new Participation("Lienz 2011 Ladies' Slalom", "Mikaela Shiffrin", 40);
        System.out.println(test.getRace());
        System.out.println(test.getRacer());
        System.out.println(test.getBibnumber());
        test.print();
        System.out.println("hash: " + test.hashCode());
    }

    // Returns the 'race' of this participation.
    public String getRace() {
        return race;
    }

    // Returns the 'racer' of this participation.
    public String getRacer() {
        return racer;
    }

    // Returns the 'bibnumber' of this participation.
    public int getBibnumber() {
        return bibnumber;
    }

    // Question:

    // Should there also be setter methods for the object variables?
    // Why or why not?
//    NO, if it was incorrect when creating the Object you should depose of it and create a new one with correct parameters.

    // Output the following (without newline at the start or end) for
    // the participation created by the constructor call above:
    //
    // 40 Mikaela Shiffrin (Lienz 2011 Ladies' Slalom)
    //
    public void print() {
        System.out.print(this);
    }

    @Override
    public String toString() {
        return bibnumber + " " + racer + " (" + race + ")";
    }

    // In addition to the standard requirements for equals, a
    // participation is equal to another object of class Participation if
    // and only if the 'racer's are equal and the 'race's are equal.
    public boolean equals(Object o) {
        if (o == null || o.getClass() != Participation.class) {
            return false;
        }
        Participation p = (Participation) o;
        return p.race.equals(race) && p.racer.equals(racer);
    }

    // Computes a hash code for 'this' that satisfies the requirements for
    // hash codes (see Section 3.1.3 in the Skriptum).
    public int hashCode() {
        int h = 0;
        String s = Participation.class + race  + "/" + racer;
        for (int i = 0; i < s.length(); i++) {
            h += s.charAt(i) * 7103 * i;
        }
        return h;
    }
}
