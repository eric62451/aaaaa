package meta;
import java.lang.reflect.*;

public class MetaMachine {
	public String execute(String... args) throws Exception {
		if (args.length > 1) {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c.toString());
			Object obj = c.newInstance();
			Class[] cArr = new Class[1];
			cArr[0] = String[].class;
			Method m = c.getDeclaredMethod(args[1], cArr);
			if (args.length > 2) {
				String[] arguments = new String[args.length - 2];
				for (int i = 2; i < args.length; i++) {
					arguments[i-2] = args[i];
				}
				m.invoke(obj, (Object) arguments);
			}
		}
		return null;
	}
}
