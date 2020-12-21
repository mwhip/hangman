package hangman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

public class picturePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	picturePanel(){
		
	}
	
	public void paint(Graphics object) {
		Font f = new Font("ZapfDingbats", Font.BOLD, 26);
		object.setColor(Color.BLACK);
		object.fillRect(10,250,100,10);//base
		object.fillRect(50,50,10,200);//upright
		object.fillRect(50,50,80,10);//top
		object.setColor(Color.YELLOW);
		object.fillRect(120,60,5,25);//rope
		if(hangMan.getMisses()==11) {
			object.setColor(Color.RED);
			object.fillRect(0, 0, 200, 300);
			object.setColor(Color.WHITE);
			object.setFont(f);
			object.drawString("You Lost", 50, 150);
		}
		else if(hangMan.getWin()) {
			object.setColor(Color.GREEN);
			object.fillRect(0, 0, 200, 300);
			object.setColor(Color.WHITE);
			object.setFont(f);
			object.drawString("You Won!!", 30, 150);
		}
		else if(hangMan.getMisses()==10) {// ten hangMan.getMisses() == full man
			object.setColor(Color.GREEN);
			object.fillOval(107, 85, 30,30);//head
			object.fillRect(120, 115, 5, 50);//body
			object.fillRect(100, 135, 20, 5);//left arm
			object.fillOval(90, 133, 10, 10);//left hand
			object.fillRect(125, 135, 20, 5);//right arm
			object.fillOval(145, 133, 10, 10);//right hand
			object.fillRect(100, 160, 20, 5);//left leg
			object.fillOval(90, 155, 10, 15);//left foot
			object.fillRect(125, 160, 20, 5);//right leg
			object.fillOval(145, 155, 10, 15);//right foot
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(hangMan.getMisses()==9) {
			object.setColor(Color.GREEN);
			object.fillOval(107, 85, 30,30);//head
			object.fillRect(120, 115, 5, 50);//body
			object.fillRect(100, 135, 20, 5);//left arm
			object.fillOval(90, 133, 10, 10);//left hand
			object.fillRect(125, 135, 20, 5);//right arm
			object.fillOval(145, 133, 10, 10);//right hand
			object.fillRect(100, 160, 20, 5);//left leg
			object.fillOval(90, 155, 10, 15);//left foot
			object.fillRect(125, 160, 20, 5);//right leg
		}
		else if(hangMan.getMisses()==8) {
			object.setColor(Color.GREEN);
			object.fillOval(107, 85, 30,30);//head
			object.fillRect(120, 115, 5, 50);//body
			object.fillRect(100, 135, 20, 5);//left arm
			object.fillOval(90, 133, 10, 10);//left hand
			object.fillRect(125, 135, 20, 5);//right arm
			object.fillOval(145, 133, 10, 10);//right hand
			object.fillRect(100, 160, 20, 5);//left leg
			object.fillOval(90, 155, 10, 15);//left foot
		}
		else if(hangMan.getMisses()==7) {
			object.setColor(Color.GREEN);
			object.fillOval(107, 85, 30,30);//head
			object.fillRect(120, 115, 5, 50);//body
			object.fillRect(100, 135, 20, 5);//left arm
			object.fillOval(90, 133, 10, 10);//left hand
			object.fillRect(125, 135, 20, 5);//right arm
			object.fillOval(145, 133, 10, 10);//right hand
			object.fillRect(100, 160, 20, 5);//left leg
		}
		else if(hangMan.getMisses()==6) {
			object.setColor(Color.GREEN);
			object.fillOval(107, 85, 30,30);//head
			object.fillRect(120, 115, 5, 50);//body
			object.fillRect(100, 135, 20, 5);//left arm
			object.fillOval(90, 133, 10, 10);//left hand
			object.fillRect(125, 135, 20, 5);//right arm
			object.fillOval(145, 133, 10, 10);//right hand
		}
		else if(hangMan.getMisses()==5) {
			object.setColor(Color.GREEN);
			object.fillOval(107, 85, 30,30);//head
			object.fillRect(120, 115, 5, 50);//body
			object.fillRect(100, 135, 20, 5);//left arm
			object.fillOval(90, 133, 10, 10);//left hand
			object.fillRect(125, 135, 20, 5);//right arm
		}
		else if(hangMan.getMisses()==4) {
			object.setColor(Color.GREEN);
			object.fillOval(107, 85, 30,30);//head
			object.fillRect(120, 115, 5, 50);//body
			object.fillRect(100, 135, 20, 5);//left arm
			object.fillOval(90, 133, 10, 10);//left hand
		}
		else if(hangMan.getMisses()==3) {
			object.setColor(Color.GREEN);
			object.fillOval(107, 85, 30,30);//head
			object.fillRect(120, 115, 5, 50);//body
			object.fillRect(100, 135, 20, 5);//left arm
		}
		else if(hangMan.getMisses()==2) {
			object.setColor(Color.GREEN);
			object.fillOval(107, 85, 30,30);//head
			object.fillRect(120, 115, 5, 50);//body
		}
		else if(hangMan.getMisses()==1) {
			object.setColor(Color.GREEN);
			object.fillOval(107, 85, 30,30);//head
		}
	}// end of paint

}
