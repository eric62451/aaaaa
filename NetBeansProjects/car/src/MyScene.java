
import org.alice.apis.moveandturn.*;
import org.alice.virtualmachine.ForEachTogether;
import org.alice.virtualmachine.DoTogether;
import org.alice.virtualmachine.ForEachRunnable;

public class MyScene extends Scene {

    private MySunLight sunLight = new MySunLight();
    private MySandyGround sandyGround = new MySandyGround();
    private MyCamera camera = new MyCamera();
    private MyCar car1 = new MyCar(50);

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
        this.car1.setName("Car");
        this.car1.setLocalPointOfView(new PointOfView(new Quaternion(-2.867837590493866E-19, 0.6159774168522542, -8.984774678731483E-20, 0.7877638110043037), new Position(0.752764880657196, 0.49841633439064026, 1.1891015768051147)));
        this.addComponent(this.car1);
    }

    public void run() {
        this.car1.move(MoveDirection.UP, 0.5, 0.0);
        car1.addGas(20);
car1.drive(50);
car1.drive(50);
car1.say("Gas: " + car1.getGasInTank());
    }
}
