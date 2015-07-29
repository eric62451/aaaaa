
import org.alice.apis.moveandturn.*;
import org.alice.virtualmachine.ForEachTogether;
import org.alice.virtualmachine.DoTogether;
import org.alice.virtualmachine.ForEachRunnable;

public class MyProgram extends Program {

    private MyScene scene = new MyScene();

    public MyProgram() {
    }

    protected void initialize() {
        this.setScene(this.scene);
    }

    protected void run() {
        this.scene.run();
    }

    public static void main(String[] args) {
        MyProgram myProgram = new MyProgram();
        myProgram.showInJFrame(args, true);
    }
}
