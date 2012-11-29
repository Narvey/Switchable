

/**
 * Author: Cyndi Rader
 * Date:
 * Purpose:
 */

public class MySwitch{
	private Switchable toSwitch;
	
	public MySwitch(Switchable switchy)
	{
		this.toSwitch = switchy;
	}
	
	public void switchOn()
	{
		toSwitch.turnOn();
	}

	public void switchOff()
	{
		toSwitch.turnOff();
	}
	
	public Object getSwitchable(){
		return toSwitch;
	}
}
