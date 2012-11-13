import javax.swing.*;

/**
 * Author: Cyndi Rader
 * Date:
 * Purpose: Adapter Exercise
 */

public class Pictures extends JPanel {
	private ImageIcon onIcon, offIcon;
	private JLabel pictureLabel = null;
	
	public Pictures()
	{
	       //Get the images and put them into ImageIcons.
	       onIcon = createImageIcon("/images/MtGoats.jpg");
	       offIcon = createImageIcon("/images/MrDeer.jpg");

	       // Create a label with border for displaying the pictures.
	        pictureLabel = new JLabel();
	        pictureLabel.setHorizontalAlignment(JLabel.CENTER);
	        pictureLabel.setVerticalAlignment(JLabel.CENTER);
	        pictureLabel.setVerticalTextPosition(JLabel.CENTER);
	        pictureLabel.setHorizontalTextPosition(JLabel.CENTER);
	        pictureLabel.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createLoweredBevelBorder(),
	            BorderFactory.createEmptyBorder(5,5,5,5)));

	        pictureLabel.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createEmptyBorder(0,0,10,0),
	            pictureLabel.getBorder()));

	        //Display the first image using setIcon option of JLabel
	        pictureLabel.setIcon(offIcon);
	        pictureLabel.setText("Off");
	        
	        add(pictureLabel);	     
	}
	
	   /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
    	
        java.net.URL imageURL = Pictures.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return new ImageIcon(imageURL);
        }
    }
    
    public void turnOn()
    {
        pictureLabel.setIcon(onIcon);
        pictureLabel.setText("On");            	
    }
    
    public void turnOff()
    {
        pictureLabel.setIcon(offIcon);
        pictureLabel.setText("Off");    
    }

}
