
import org.alice.apis.moveandturn.gallery.vehicles.Car;
import org.alice.apis.moveandturn.*;
import org.alice.virtualmachine.ForEachTogether;
import org.alice.virtualmachine.DoTogether;
import org.alice.virtualmachine.ForEachRunnable;

public class MyCar extends Car {
private double milesDriven;
private double gas;
private double efficiency;
   /**
      Constructs a car with a given fuel efficiency.
      @param anEfficiency the fuel efficiency of the car
   */
   public MyCar(double anEfficiency)
   {
       milesDriven = 0;
       gas = 0;
       efficiency = anEfficiency
;   }

   /** Adds gas to the tank.
       @param amount the amount of fuel to add
   */
   public void addGas(double amount)
   {
       gas = gas + amount;
   }

   /**

       Drives a certain amount, consuming gas.
       @param distance the distance driven
   */
   public void drive(double distance)
   {
       milesDriven = milesDriven + distance;
       double gasConsumed = distance / efficiency;
       gas = gas - gasConsumed;
       move(MoveDirection.FORWARD, distance / 100);
   }

   /**
       Gets the amount of gas left in the tank.
       @return the amount of gas
   */
   public double getGasInTank()
   {
      return gas;
   }

   /**
       Gets the total miles driven by this car.
       @return the miles driven
   */
   public double getMilesDriven()
   {
      return milesDriven;
   }
}
