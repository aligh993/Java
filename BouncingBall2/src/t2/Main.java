// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

package t2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new TestPane());
    frame.pack();
    frame.setVisible(true);
  }
}

class TestPane extends JPanel {
  int x = 0,y = 100,radius = 20,xDelta = 2;

  public TestPane() {
    Timer timer = new Timer(40, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        x += xDelta;
        y += xDelta;
//        if (x + (radius * 2) > getWidth() && y + (radius * 2) > getWidth()) {
//          x = getWidth() - (radius * 2);
//          y = getWidth() - (radius * 2);
//          xDelta *= -1;
//        } else if (x < 0 && y<0) {
//          x = 0;
//          y = 0;
//          xDelta *= -1;
//        }
        repaint();
      }
    });
    timer.start();
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(600, 600);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.RED);
    g.fillOval(x, y - radius, radius * 2, radius * 2);
  }
}