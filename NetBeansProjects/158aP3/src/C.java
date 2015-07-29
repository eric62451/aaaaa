
public class C {

    static double generate(int L) {
        double u = 0;
        while (u == 0) {
            u = Math.random();
        }
        return L * Math.log(u) * (-1);
    }

    static double simulate(int L) {
        double current = generate(L);
        double previous = -1;
        double next = current + generate(L);
        while (current - previous < 1 || next - current < 1) {
            previous = current;
            current = next;
            next = next + generate(L);
        }
        return current;
    }

    public static void main(String[] args) {
        int L = 4;
        double[] average = new double[9];
        double[] minimum = new double[9];
        for (int j = 4; j <= 20; j = j + 2) {
            double avg = 0;
            double min = Double.MAX_VALUE;
            for (int i = 0; i < 50; i++) {
                double temp = simulate(j);
                avg = avg + temp;
                if (temp < min) {
                    min = temp;
                }
            }
            average[(j-4)/2] = avg/50;
            minimum[(j-4)/2] = min;
        }
        System.out.println("Average:");
        for(int i = 0;i<9;i++){
            System.out.println("Lambda = "+((i*2)+4)+" - "+average[i]);
        }
        System.out.println("\n Minimum:");
        for(int i = 0;i<9;i++){
            System.out.println("Lambda = "+((i*2)+4)+" - "+minimum[i]);
        }
    }
}
