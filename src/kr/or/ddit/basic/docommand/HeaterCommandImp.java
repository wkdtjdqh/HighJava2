package kr.or.ddit.basic.docommand;

public class HeaterCommandImp implements ICommand {
	private Heater heater; 

	public HeaterCommandImp(Heater heater) {
		this.heater = heater;
	}

	@Override
	public void execute() {
		heater.powerOn();
	}

}
