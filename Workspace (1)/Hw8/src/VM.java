import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class VM {
	ArrayList<Command> program;
	int pc;
	Map<String, Integer> vars;
	ArrayList<String> var;
	int executedtimes;
	boolean printInfo = true;

	public VM() {
		program = new ArrayList<Command>();
		vars = new HashMap<String, Integer>();
		var = new ArrayList<String>();
		// TODO Auto-generated constructor stub
	}

	public void add(String cmmd) {
		program.add(new Command(cmmd, pc++));
	}

	public void run() throws Exception {
		resolveLabels();
		executedtimes = 0;
		pc = 0;
		while (pc < program.size()) {
			execute(program.get(pc++));
		}
		if (printInfo) {
			System.out.println("pc = " + pc);
			System.out.println("Instructions executed = " + executedtimes);
			System.out.println("Number of variables = " + var.size());
			String variables = "vars = {";
			for (String i : var) {
				variables = variables + i + "=" + vars.get(i) + ", ";
			}
			variables = variables.substring(0, variables.length() - 2) + "}";
			System.out.println(variables);
		}
	}

	private void execute(Command cmmd) {
		executedtimes++;
		if (cmmd.getOpcode().equals("load")) {
			if (Pattern.matches("[a-z]+", cmmd.arg2))
				vars.put(cmmd.arg1, vars.get(cmmd.arg2));
			else
				vars.put(cmmd.arg1, Integer.parseInt(cmmd.arg2));
			if (!var.contains(cmmd.arg1))
				var.add(cmmd.arg1);
		} else if (cmmd.getOpcode().equals("inc")) {
			vars.put(cmmd.arg1, vars.get(cmmd.arg1) + 1);
		} else if (cmmd.getOpcode().equals("goto")) {
			pc = cmmd.target;
		} else if (cmmd.getOpcode().equals("loop")) {
			if (cmmd.count == -5) {
				if (Pattern.matches("[a-z]+", cmmd.arg1))
					cmmd.count = vars.get(cmmd.arg1);
				else
					cmmd.count = Integer.parseInt(cmmd.arg1);
			}
			if (cmmd.count > 0) {
				cmmd.count--;
			} else if (cmmd.count == 0) {
				pc = cmmd.target + 1;
				cmmd.count = -5;
			}
		} else if (cmmd.getOpcode().equals("end")) {
			pc = cmmd.target;
		} else
			System.out.println("Unrecognized opcode");
	}

	private void resolveLabels() {
		Stack<Command> loopStack = new Stack<Command>();
		Map<String, Integer> targets = new HashMap<String, Integer>();
		// pass 1
		for (Command cmmd : program) {
			if (cmmd.label != null) {
				targets.put(cmmd.label, cmmd.pc);
			}
			if (cmmd.getOpcode().equals("loop")) {
				loopStack.push(cmmd);
			}
			if (cmmd.getOpcode().equals("end")) {
				Command temp = loopStack.pop();
				temp.target = cmmd.pc;
				cmmd.target = temp.pc;
			}

		}
		// pass 2
		for (Command cmmd : program) {
			if (cmmd.opcode.equals("goto")) {
				cmmd.target = targets.get(cmmd.arg1);
			}
		}
	}
	
	public void compile(String filename) throws FileNotFoundException{
		Scanner in = new Scanner(new File(filename));
		while(in.hasNextLine()){
			String temp = in.nextLine();
			if(!temp.isEmpty()){
				add(temp);
			}
		}
		
	}

	public int getVariable(String temp) {
		return vars.get(temp);
	}
}
