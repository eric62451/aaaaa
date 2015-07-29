
import java.util.function.UnaryOperator;

class Combinators {

   public static UnaryOperator<Double> iter(UnaryOperator<Double> f, int n) {
      return (x) -> {
         if (n == 0) return x;
         return f.apply(iter(f, n - 1).apply(x));
      };
   }
   
   public static UnaryOperator<Double> iter2(UnaryOperator<Double> f, int n) {
      return (Double x) -> {
         Double result = 0.0;
         for(int i = 0; i < n; i++) {
            result = f.apply(result);
         }
         return result;
      };
   }

   public static void main(String[] args) {
      UnaryOperator g = iter((Double x)->{return 2 * x;}, 5);
      System.out.println("g(2) = " + g.apply(2.0));
   }
}