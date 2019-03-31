// Objects of CharStack1 are stacks holding chars.  The stack is
// implemented using a linked list.  It does not
// use classes from the Collections Framework (e.g. LinkedList)
// <https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html>.
public class CharStack1 {

    // Assignment 3.4 (partly also in Aufgabenblatt3.txt)

    // introduce (private) object variables as needed
    private CharNode top;
    // Create an empty stack
    public CharStack1() {
    }

    // Push c on 'this'.  
    public void push(char c) {
        top = new CharNode(c, top);
    }

    // Pop the most recent character that was pushed, but has not been
    // popped yet
    public char pop() {
        Character c = top.value;
        top = top.next;
        return c;
    }

    // returns true if all characters pushed on 'this' have been popped.
    public boolean isEmpty() {
        return top == null;
    }

    // Frage:

    // Vergleichen Sie diese Implementierung mit CharStack.  Was sind
    // die Vor- und Nachteile der beiden Implementierungen?

    
    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        CharStack1 stack = new CharStack1();
        System.out.println(stack.isEmpty());
        stack.push('a');
        stack.push('b');
        stack.push('c');
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push('d');
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }

    class CharNode {
        Character value;
        CharNode next;

        CharNode (Character c, CharNode next) {
            value = c;
            this.next = next;
        }
    }
}
