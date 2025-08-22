// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

package t1;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

public class GoogleMapsSample {
   public static void main(String[] args) {
       final Browser browser = new Browser();
       BrowserView browserView = new BrowserView(browser);

       JFrame frame = new JFrame("JxBrowser Google Maps");
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       frame.add(browserView, BorderLayout.CENTER);
       frame.setSize(900, 500);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);

       browser.loadURL("http://maps.google.com");
   }
}