
public class Sentence {

    private String text;
    private int subNum = 0;

    /**
    Constructs a sentence.
    @param aText a string containing all characters of the sentence
     */
    public Sentence(String aText) {
        text = aText;
    }

    /**
    Tests whether this sentence is a palindrome.
    @return true if this sentence is a palindrome, false otherwise
     */
    public boolean isPalindrome() {
        int length = text.length();

        // Separate case for shortest strings.
        if (length <= 1) {
            return true;
        }

        // Get first and last characters, converted to lowercase.
        char first = Character.toLowerCase(text.charAt(0));
        char last = Character.toLowerCase(text.charAt(length - 1));

        if (Character.isLetter(first) && Character.isLetter(last)) {
            // Both are letters.
            if (first == last) {
                // Remove both first and last character.
                Sentence shorter = new Sentence(text.substring(1, length - 1));
                return shorter.isPalindrome();
            } else {
                return false;
            }
        } else if (!Character.isLetter(last)) {
            // Remove last character.
            Sentence shorter = new Sentence(text.substring(0, length - 1));
            return shorter.isPalindrome();
        } else {
            // Remove first character.
            Sentence shorter = new Sentence(text.substring(1));
            return shorter.isPalindrome();
        }
    }

    public String getText() {
        return text;
    }

    public void reverse() {
        String letter = text.substring(0, 1);
        text = text.replaceFirst(letter, "");
        if(!(text.length()==0)) reverse();
        text = text + letter;
    }
    public boolean find(String t){
        if(t.length()>text.length()) return false;
        if(subNum+t.length()>text.length()) return false;
        if(t.equals(text.substring(subNum, subNum+t.length()))) return true;
        subNum++;
        if(find(t)){
            subNum = 0;
            return true;
        }
        return false;
    }
}
