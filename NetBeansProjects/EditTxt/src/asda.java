
public class asda {

    public static void main(String argv[]){

        asda s = new asda();
        s.fib(3);
        s.fib(4);

    }
    static int check = -1;
    public int fib(int n){
        if(n == 0) {
            if(check<n){
                System.out.println(1);
                check++;
            }
            return 1;
        } else if (n==1){
            if(check<n){
                System.out.println(1);
                check++;
            }
            return 1;
        } else {
            int temp = fib(n-2)+fib(n-1);
            if(check<temp){
                System.out.println(temp);
                check++;
            }
            return temp;
        }
    }

}
