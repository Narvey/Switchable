/**
 * Author: Cyndi Rader
 * Date:
 * Purpose:
 */
import java.util.*;
import java.text.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Clock extends JPanel implements Runnable {
	private volatile Thread clockThread = null;
	// Time between clock updates, in ms
	public static int SLEEP_TIME = 1000;
	private JTextField timeField;
	
	public Clock()
	{
		
		timeField = new JTextField(6);
		add(timeField);
		setSize(15, 20);
		// set original time
		updateTime();		
	}
	
	public void start()
	{
		// if no thread, create one and start it. 
		if (clockThread == null)
		{
			clockThread = new Thread(this);
			clockThread.start();
		}
	}
	public void run()
	{
		Thread thisThread = Thread.currentThread();
		
		// will continue until clockThread reset to null
		while(clockThread == thisThread)
		{
			try {
				Thread.sleep(SLEEP_TIME);			
			}
			catch (InterruptedException e) { }
			updateTime();
		}
	}
	
    public void turnOn()
    {
    	start();
    	run();
    }
    
    public void turnOff()
    {
    	clockThread = null;
    }
	
	public void updateTime()
	{
		DateFormat justTime = DateFormat.getTimeInstance();
		String time = justTime.format(System.currentTimeMillis());
		timeField.setText(time);
		repaint();
	}
	
	public static void main(String[] args)
	{
	    JFrame frame = new JFrame("Test Clock");
	    Clock clock = new Clock();
	    frame.setContentPane(clock);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);    
	    // Just to test functionality
	    clock.turnOn();
	    System.out.println("Continue?");
	    Scanner s = new Scanner(System.in);
	    s.next();
	    clock.turnOff();
	    System.out.println("Continue?");
	    s.next();
	    clock.turnOn();

	}
}
