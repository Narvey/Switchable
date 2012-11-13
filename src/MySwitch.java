/**
 * Author: Cyndi Rader
 * Date:
 * Purpose:
 */

public class MySwitch {
	private Clock clock;
	
	public MySwitch(Clock clock)
	{
		this.clock = clock;
	}
	
	public void switchOn()
	{
		clock.turnOn();
	}

	public void switchOff()
	{
		clock.turnOff();
	}
}
