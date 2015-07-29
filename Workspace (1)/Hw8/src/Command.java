import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command {
	
	String label, opcode, arg1, arg2;
	int target, pc, count;
	Pattern cmmdPattern = Pattern.compile("(([A-Z]+):\\s)?(((load) ([a-z]+)\\s([a-z]+|[0-9]+))|((inc) ([a-z]+))|(loop) ([a-z]+|[0-9]+)|((goto) ([A-Z]+))|(end))");
	
	public Command(String cmmd, int pc) {
		this.pc = pc;
		count = -5;
		extract(cmmd);
		//System.out.println(label + " " + opcode + " " + arg1 + " " + arg2);
	}
	
	public String getOpcode() {
		return opcode;
	}
	
	private void extract(String cmmd){
		Matcher m = cmmdPattern.matcher(cmmd);
		if(m.matches()){
			m.find(0);
			label = m.group(2);
			if(m.group(5) != null){
				opcode = m.group(5);
				arg1 = m.group(6);
				arg2 = m.group(7);
			} else if(m.group(9) != null){
				opcode = m.group(9);
				arg1 = m.group(10);
			} else if(m.group(11) != null){
				opcode = m.group(11);
				arg1 = m.group(12);
			}else if(m.group(14) != null){
				opcode = m.group(14);
				arg1 = m.group(15);
			} else if(m.group(16) != null){
				opcode = m.group(16);
			}
		}
	}
}
