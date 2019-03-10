/*
This class will be extended in the ad-hoc-assignment, and will be used
in future assignments, so it is highly recommended to solve this
assignment.

This class is part of software for ski racing administration.
 */
public class Participation {

    // Assignment 1.1:
    
    // TODO: The object variables 'race', 'racer' and 'bibnumber'
    //  (Startnummer) shall be declared here.
    private String race;
    private String racer;
    private int bibnumber;

    // TODO: A constructor for this class shall be defined here.
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
    }

    // Returns the 'race' of this participation.
    public String getRace() {
        // TODO: Implement this method
        return race;
    }

    // Returns the 'racer' of this participation.
    public String getRacer() {
        // TODO: Implement this method
        return racer;
    }

    // Returns the 'bibnumber' of this participation.
    public int getBibnumber() {
        // TODO: Implement this method
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
        System.out.print(bibnumber + " " + racer + " (" + race + ")");
    }

}
