import java.awt.Graphics;

import javax.swing.JPanel;


public class PictureAdapter implements Switchable{
	private Pictures pictures;
	public PictureAdapter(Pictures p) {
		pictures = p;
	}
	@Override
	public void turnOff() {
		pictures.turnOff();
	}
	@Override
	public void turnOn() {
		pictures.turnOn();
	}
	
	public Pictures getPic(){
		return pictures;
	}

}
