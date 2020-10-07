package kr.or.ddit.basic.noncommand;

public class NonCommandTest {
	public static void main(String[] args) {
		// 램프 켜기 기능 수행하기
//		Lamp lamp = new Lamp();
//		NonCommand test = new NonCommand(lamp);
//		test.run();
		
		// 히터 켜는 기능 수행하기
		Heater heater = new Heater();
		NonCommand test = new NonCommand(heater);
		test.run();
	}
}
