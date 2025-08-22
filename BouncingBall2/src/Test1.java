// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test1 {

	public static void main(String[] args) {
		//  Create JFrame
		JFrame frame = new JFrame();
		frame.setTitle("Battleship");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new TestPane());
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class TestPane extends JPanel {
	//	Ship 1 & Bullet 1 size
	int lengthShip1 = 50;  int widthShip1 = 20;  int bulletSize1 = 12;
	//	Ship 2 & Bullet 2 size
	int lengthShip2 = 50;  int widthShip2 = 20;  int bulletSize2 = 12;
	//	Ship 1 Parameter
	int X1 = 100;  int Y1 = 100;  int vel1 = 17;  int theta1 = 315;  int ang1 = 45;
	//	Ship 2 Parameter
	int X2 = 300;  int Y2 = 300;  int vel2 = 16;  int theta2 = 140;  int ang2 = 60;

	int grav = 10;
	Point p1 = new Point();   Point p2 = new Point();

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		//  Ship 1 & Ship 2 Center Coordinate
		p1.x = X1+lengthShip1/2;  p1.y = Y1+widthShip1/2;
		p2.x = X2+lengthShip2/2;  p2.y = Y2+widthShip2/2;

		//  Ship 1 
		graphics.setColor(Color.BLACK);  graphics.drawRect(X1,Y1,lengthShip1,widthShip1);  
		graphics.setColor(Color.RED);    graphics.fillRect(X1,Y1,lengthShip1,widthShip1);

		//  Ship 1 Center    
		graphics.setColor(Color.BLACK);  graphics.drawOval(p1.x,p1.y,2,2);
		graphics.setColor(Color.BLACK);  graphics.fillOval(p1.x,p1.y,2,2);

		//  Ship 2
		graphics.setColor(Color.BLACK);  graphics.drawRect(X2,Y2,lengthShip2,widthShip2);  
		graphics.setColor(Color.BLUE);   graphics.fillRect(X2,Y2,lengthShip2,widthShip2);

		//  Ship 2 Center    
		graphics.setColor(Color.BLACK);  graphics.drawOval(p2.x,p2.y,2,2);
		graphics.setColor(Color.BLACK);  graphics.fillOval(p2.x,p2.y,2,2);

		//  get Coordinate & Direction Shot for Ship 1
		float cor1[] = pointCoordinate(ang1, vel1, grav);
		int radius1 = 10*(int) cor1[0];
		int nD1[] = newDirection(radius1, theta1, p1.x, p1.y);
		int bX1 = nD1[0];   int bY1 = nD1[1];

		//  Bullet 1
		graphics.setColor(Color.BLACK);  graphics.drawOval(bX1,bY1,bulletSize1,bulletSize1);
		graphics.setColor(Color.RED);    graphics.fillOval(bX1,bY1,bulletSize1,bulletSize1);

		//  get Coordinate & Direction Shot for Ship 2
		float cor2[] = pointCoordinate(ang2, vel2, grav);
		int radius2 = 10*(int) cor2[0];
		int nD2[] = newDirection(radius2, theta2, p2.x, p2.y);
		int bX2 = nD2[0];   int bY2 = nD2[1];

		//  Bullet 2
		graphics.setColor(Color.BLACK);  graphics.drawOval(bX2,bY2,bulletSize2,bulletSize2);
		graphics.setColor(Color.BLUE);   graphics.fillOval(bX2,bY2,bulletSize2,bulletSize2);

		printShotCoordinate();
	}

	//  Compute Shot Coordinate
	public float[] pointCoordinate(float ang, float velc, float g) {
		float Vx, Vy;
		float rad = (float) Math.toRadians(ang);
		Vx = (float) (velc*Math.cos(rad));
		Vy = (float) (velc*Math.sin(rad));

		float time = (Vy/g)*2;
		float height = (float) (0.5f*g*(Math.pow((time/2), 2)));
		float arg[] = new float[3];
		arg[0] = Vx*time;
		arg[1] = height;
		arg[2] = time;
		return arg;
	}

	//  Compute Shot Direction
	public int[] newDirection(int r, int theta, int X, int Y) {
		int arg2[] = new int[2];
		int newPointX = 0, newPointY = 0;
		float rad = (float) Math.toRadians(theta);
		if(theta == 0 || theta == 360) {
			newPointX = X+r;
			newPointY = Y;
		} else if(theta<90 && theta>0) {
			newPointX = X+(int) (r*Math.cos(rad));
			newPointY = Y-(int) (r*Math.sin(rad));
		} else if(theta == 90) {
			newPointX = X;
			newPointY = Y-r;
		} else if(theta<180 && theta>90) {
			newPointX = X+(int) (r*Math.cos(rad));
			newPointY = Y-(int) (r*Math.sin(rad));
		} else if(theta == 180) {
			newPointX = X-r;
			newPointY = Y;
		} else if(theta<270 && theta>180) {
			newPointX = X+(int) (r*Math.cos(rad));
			newPointY = Y-(int) (r*Math.sin(rad));
		} else if(theta == 270) {
			newPointX = X;
			newPointY = Y+r;
		} else if(theta<360 && theta>270) {
			newPointX = X+(int) (r*Math.cos(rad));
			newPointY = Y-(int) (r*Math.sin(rad));
		}
		arg2[0] = newPointX;
		arg2[1] = newPointY;
		return arg2 ;
	}

	//  Print Shot Coordinate
	public void printShotCoordinate() {
		float cor1[]= pointCoordinate(ang1, vel1, grav);
		float cor2[]= pointCoordinate(ang2, vel2, grav);
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		System.out.println("First Ship: ");
		System.out.println("X: "+df.format(cor1[0])+"(m)");
		System.out.println("Max Height: "+df.format(cor1[1])+"(m)");
		System.out.println("Total Time: "+df.format(cor1[2])+"(s)\n\n");
		System.out.println("Second Ship: ");
		System.out.println("X: "+df.format(cor2[0])+"(m)");
		System.out.println("Max Height: "+df.format(cor2[1])+"(m)");
		System.out.println("Total Time: "+df.format(cor2[2])+"(s)");
	}
}