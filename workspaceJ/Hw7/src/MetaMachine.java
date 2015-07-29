import java.lang.reflect.*;

class MetaMachine {
    public static String execute(String ... args) throws Exception {
        if(args.length > 1){
            Class<?> c = Class.forName(args[0]);
            Object obj = c.newInstance();
            Method m = c.getDeclaredMethod(args[1], String.class);
            return (String) m.invoke(null, "hi");
        }
        return null;
    }
   
    public static void main(String[] args) throws Exception {
        System.out.println(execute("meta","Greeter"));
    }
}
