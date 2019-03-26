import java.util.Arrays;

// Objects of CharStack are stacks holding chars.  The stack is
// implemented using an array, without using other classes.
// The array grows whenever the number of entries is insufficient.
public class CharStack {

    // Assignment 2.2 (partly also in Parse.java)

    // introduce (private) object variables as needed
    private Character[] characters;
    private int current;

    // Create an empty stack
    public CharStack() {
        characters = new Character[1];
        current = 0;
    }

    // Push c on 'this'.  
    public void push(char c) {
        if (current >= characters.length - 1) {
            characters = Arrays.copyOf(characters, current + 1);
        }
        characters[current++] = c;
    }

    // Pop the most recent character that was pushed, but has not been
    // popped yet
    public char pop() {
        if (current == 0) {
            return ' ';
        } else {
            return characters[--current];
        }
    }

    @Override
    public String toString() {
        StringBuilder concat = new StringBuilder();
        for (int i = 0; i< current; i++) {
            concat.append(characters[i]);
        }
        return concat.toString();
    }

    // returns true if all characters pushed on 'this' have been popped.
    public boolean isEmpty() {
        return current == 0;
    }

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        CharStack stack = new CharStack();
        System.out.println(stack.isEmpty());
        stack.push('a');
        stack.push('b');
        stack.push('c');
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
