// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

package t1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test2 extends JPanel {

	int X1 = 200;  int Y1 = 300;  int theta1 = 10;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLACK); 
		g.drawRect(X1,Y1,20,20);  
		g.setColor(Color.RED);  
		g.fillRect(X1,Y1,20,20);

		int r1 = 40;
		int nw1[] = newDirection(r1, 290);
		int bX1 = nw1[0];
		int bY1 = nw1[1];
		g.setColor(Color.BLACK); 
		g.drawOval(bX1,bY1,5,5);
		g.setColor(Color.BLUE);  
		g.fillOval(bX1,bY1,5,5);

		int r2 = 40;
		int nw2[] = newDirection(r2, 350);
		int bX2 = nw2[0];
		int bY2 = nw2[1];
		g.setColor(Color.BLACK); 
		g.drawOval(bX2,bY2,5,5);
		g.setColor(Color.RED);  
		g.fillOval(bX2,bY2,5,5);
	}

	public int[] newDirection(int r, int theta) {
		int ar2[] = new int[2];
		int newPointX = 0, newPointY = 0;
		float rad = (float) Math.toRadians(theta);
		if(theta == 0 || theta == 360) {
			newPointX = (X1+10)+r;
			newPointY = Y1;
		} else if(theta<90 && theta>0) {
			newPointX = (X1+10)+(int) (r*Math.cos(rad));
			//		  System.out.println(r*Math.cos(rad));
			newPointY = (Y1+10)-(int) (r*Math.sin(rad));
			//		  System.out.println(r*Math.sin(rad));
		} else if(theta == 90) {
			newPointX = X1;
			newPointY = (Y1+10)-r;
		} else if(theta<180 && theta>90) {
			newPointX = (X1+10)+(int) (r*Math.cos(rad));
			//		  System.out.println(r*Math.cos(rad));
			newPointY = (Y1+10)-(int) (r*Math.sin(rad));
			//		  System.out.println(r*Math.sin(rad));
		} else if(theta == 180) {
			newPointX = (X1+10)-r;
			newPointY = Y1;
		} else if(theta<270 && theta>180) {
			newPointX = (X1+10)+(int) (r*Math.cos(rad));
			//		  System.out.println(r*Math.cos(rad));
			newPointY = (Y1+10)-(int) (r*Math.sin(rad));
			//		  System.out.println(r*Math.sin(rad));
		} else if(theta == 270) {
			newPointX = X1;
			newPointY = (Y1+10)+r;
		} else if(theta<360 && theta>270) {
			newPointX = (X1+10)+(int) (r*Math.cos(rad));
			//		  System.out.println(r*Math.cos(rad));
			newPointY = (Y1+10)-(int) (r*Math.sin(rad));
			//		  System.out.println(r*Math.sin(rad));
		}
		ar2[0] = newPointX;
		ar2[1] = newPointY;
		return ar2 ;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("BattleShip");
		frame.setSize(600, 600);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		Container contentPane = frame.getContentPane();
		contentPane.add(new Test2());

		frame.show();

	}
}