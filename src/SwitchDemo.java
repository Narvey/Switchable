/**
 * Author: Cyndi Rader
 * Purpose: Abstract Server and Adapter exercise
 * 
 * Modified by Nathan Harvey
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class SwitchDemo extends JPanel {
	private Clock myClock;
	private MySwitch switch1;
	private ButtonGroup buttonGroup;
	private PictureAdapter myPictures;
	private MySwitch switch2;
	private JPanel switchPanel;
	
	public SwitchDemo()
	{
		myClock = new Clock();
		myPictures = new PictureAdapter(new Pictures());
		switch1 = new MySwitch(myClock);
		switch2 = new MySwitch(myPictures);
		setLayout(new BorderLayout());
		switchPanel=new JPanel(new FlowLayout());
		switchPanel.add(createRadioPanel(switch1));
		switchPanel.add(createRadioPanel(switch2));
		switchPanel.setSize(500,10);
		add(switchPanel,BorderLayout.NORTH);
		add(myPictures.getPic(),BorderLayout.CENTER);
		createClockPanel();
	}
	
	public void createClockPanel()
	{
		JPanel clockPanel = new JPanel();
		clockPanel.add(myClock);
		add(clockPanel, BorderLayout.SOUTH);
	}
	
	public JPanel createRadioPanel(MySwitch whichswitch)
	{
		JPanel radioPanel = new JPanel();
		JRadioButton onButton = new JRadioButton("On");
		onButton.setMnemonic(KeyEvent.VK_N);
		JRadioButton offButton = new JRadioButton("Off");
		offButton.setMnemonic(KeyEvent.VK_F);
		offButton.setSelected(true);
		ActionListener listener = new ButtonListener(whichswitch);
		onButton.addActionListener(listener);
		offButton.addActionListener(listener);

		// Need a button group for this set of buttons
		buttonGroup = new ButtonGroup();
		buttonGroup.add(onButton);
		buttonGroup.add(offButton);
		radioPanel.add(onButton);
		radioPanel.add(offButton);
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder(whichswitch.getSwitchable().getClass().getCanonicalName()+ " Switch");
		radioPanel.setBorder(title);
		radioPanel.setSize(900, 50);
		return radioPanel;
	}
	
	class ButtonListener implements ActionListener
	{
		private MySwitch sw;
		public ButtonListener(MySwitch whichswitch) {
			sw = whichswitch;
		}
		public void actionPerformed(ActionEvent e)
		{
			if (((JRadioButton)e.getSource()).getText()=="On")
				sw.switchOn();
			else
				sw.switchOff();
		}
	}
	
	public static void main(String[] args)
	{
	    JFrame frame = new JFrame("Test Switch");
	    SwitchDemo app = new SwitchDemo();
	    frame.setContentPane(app);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500, 500);
	    frame.setVisible(true);    

	}

}
