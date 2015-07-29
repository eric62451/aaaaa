
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class Phrase {

    Stack<String> back;//... define instance variable
    Queue<String> front;
    String text;

    /**
     * Constructs a Phase object with the given String
     * @param text the string to use for this Phrase
     */
    public Phrase(String text) {
        this.text = text;//... complete the constructor
    }

    /**
     * Determines if this Phrase is a palindrome
     * @return true if the Phrase is a palindrome else false
     */
    public boolean isPalindrome() {
        back = new Stack<String>();
        front = new LinkedList<String>();
        for (int i = 0; i < text.length(); i++) {
            if ("0123456789".contains(text.subSequence(i, i + 1))) {
                back.add(text.substring(i, i + 1));
                front.add(text.substring(i, i + 1));
            }
        }
        while(!(back.size()==0))
        {
            if(!(back.pop().equalsIgnoreCase(front.remove()))) return false;
        }
        return true;
    }
}
