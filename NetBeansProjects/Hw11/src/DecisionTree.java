
import java.util.Scanner;

public class DecisionTree {

    private BinaryTree tree;//... add instance varibale here is needed

    /**
    Constructs a new DecisionTree with the given node tree as a root node.
    @param root The root node for the tree.
     */
    public DecisionTree(BinaryTree tree) {
        this.tree = tree;//... complete the constructor
    }

    /**
    Runs the game.
     */
    public void ask(Scanner in) {
        ask(tree, in);
    }

    private static void ask(BinaryTree currentTree, Scanner in) {
        if (currentTree.isLeaf()) {
            System.out.println("Is it " + currentTree.data() + "? (Y/N)");
            if (in.nextLine().equalsIgnoreCase("N")) {
                System.out.println("What is it?");
                String answer = in.nextLine();
                System.out.println("Please give me a question that is true for "+answer+" and false for "+currentTree.data()+".");
                String question = in.nextLine();
                String temp = currentTree.data().toString();
                currentTree.setData(question);
                BinaryTree answertree = new BinaryTree(answer);
                BinaryTree temptree = new BinaryTree(temp);
                currentTree.setLeft(answertree);
                currentTree.setRight(temptree);
                //...
            }
        } else {
            System.out.println(currentTree.data() + " (Y/N)");
            if (in.nextLine().equalsIgnoreCase("Y")) {
                currentTree = currentTree.left();//...\
                ask(currentTree, in);

            } else {
                currentTree = currentTree.right();//...\
                ask(currentTree, in);
            }

            // ... any private helper methods you need
        }
    }
}
