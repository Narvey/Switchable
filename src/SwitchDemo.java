/**
 * Author: Cyndi Rader
 * Purpose: Abstract Server and Adapter exercise
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class SwitchDemo extends JPanel {
	private Clock myClock;
	private MySwitch mySwitch;
	private JRadioButton onButton, offButton;
	private ButtonGroup buttonGroup;
	
	public SwitchDemo()
	{
		myClock = new Clock();
		mySwitch = new MySwitch(myClock);
		setLayout(new BorderLayout());
		createRadioPanel();
		createClockPanel();
	}
	
	public void createClockPanel()
	{
		JPanel clockPanel = new JPanel();
		clockPanel.add(myClock);
		add(clockPanel, BorderLayout.SOUTH);
	}
	
	public void createRadioPanel()
	{
		JPanel radioPanel = new JPanel();
		onButton = new JRadioButton("On");
		onButton.setMnemonic(KeyEvent.VK_N);
		offButton = new JRadioButton("Off");
		offButton.setMnemonic(KeyEvent.VK_F);
		offButton.setSelected(true);
		ActionListener listener = new ButtonListener();
		onButton.addActionListener(listener);
		offButton.addActionListener(listener);

		// Need a button group for this set of buttons
		buttonGroup = new ButtonGroup();
		buttonGroup.add(onButton);
		buttonGroup.add(offButton);
		radioPanel.add(onButton);
		radioPanel.add(offButton);
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Switch");
		radioPanel.setBorder(title);
		add(radioPanel, BorderLayout.NORTH);
	}
	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == onButton)
				mySwitch.switchOn();
			else
				mySwitch.switchOff();
		}
	}
	
	public static void main(String[] args)
	{
	    JFrame frame = new JFrame("Test Switch");
	    SwitchDemo app = new SwitchDemo();
	    frame.setContentPane(app);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(200, 150);
	    frame.setVisible(true);    

	}

}
