
import org.alice.apis.moveandturn.*;
import org.alice.virtualmachine.ForEachTogether;
import org.alice.virtualmachine.DoTogether;
import org.alice.apis.moveandturn.gallery.kitchen.Toaster;
import org.alice.virtualmachine.ForEachRunnable;

public class MyScene extends Scene {

    private MySunLight sunLight = new MySunLight();
    private MySandyGround sandyGround = new MySandyGround();
    private MyCamera camera = new MyCamera();
    private MyBeachChair chair = new MyBeachChair();

    public MyScene() {
        this.performSetUp();
    }

    public void performSetUp() {
        this.performSceneEditorGeneratedSetUp();
        this.performCustomPropertySetUp();
    }

    protected void performCustomPropertySetUp() {
    }

    protected void performSceneEditorGeneratedSetUp() {
        this.setName("scene");
        this.setAtmosphereColor(new Color(0.5, 0.5, 1.0));
        this.sunLight.setName("sunLight");
        this.sunLight.setLocalPointOfView(new PointOfView(new Quaternion(-0.7071067811865475, 0.0, 0.0, 0.7071067811865476), new Position(0.0, 0.0, 0.0)));
        this.addComponent(this.sunLight);
        this.sandyGround.setName("sandyGround");
        this.sandyGround.setLocalPointOfView(new PointOfView(new Quaternion(0.0, 0.0, 0.0, 1.0), new Position(0.0, 0.0, -0.0)));
        this.addComponent(this.sandyGround);
        this.camera.setName("camera");
        this.camera.setLocalPointOfView(new PointOfView(new Quaternion(0.0, 0.9968450230602549, 0.07937253933193686, 6.123233995736766E-17), new Position(0.0, 2.56, -16.0)));
        this.addComponent(this.camera);
        this.chair.setName("BeachChair");
        this.chair.setLocalPointOfView(new PointOfView(new Quaternion(1.3826796793443374E-18, -0.1704032579528108, -6.397083167085138E-17, 0.9853744109114402), new Position(-0.2703700498577938, 0.004366925569799007, -7.903805240793016)));
        this.addComponent(this.chair);
    }

    public void run() {
        this.chair.say("Hello, World!");
        this.chair.move(MoveDirection.LEFT, 1);
        Toaster fred = new Toaster();
        addComponent(fred);
        fred.move(MoveDirection.FORWARD, 5);
        fred.resize(17);
    }
}
