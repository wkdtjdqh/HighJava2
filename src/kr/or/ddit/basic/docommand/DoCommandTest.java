package kr.or.ddit.basic.docommand;

public class DoCommandTest {
	public static void main(String[] args) {
		// 램프켜기
		Lamp lamp = new Lamp();
		ICommand lampCommand = new LampCommandImpl(lamp);
		
		DoCommand test = new DoCommand();
		test.setCommand(lampCommand);
		test.run();
		
		// 히터켜기
		Heater heater = new Heater();
		ICommand heaterCommand = new HeaterCommandImp(heater);
		
//		DoCommand test = new DoCommand();
		test.setCommand(heaterCommand);
		test.run();
	}
}
