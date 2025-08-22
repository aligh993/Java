// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

import java.io.IOException;

import fiftyone.mobile.detection.Match;
import fiftyone.mobile.detection.Provider;
import fiftyone.mobile.detection.factories.StreamFactory;

public class DeviceDetect {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName = System.getProperty("user.home")+"/Desktop/2000 User Agents 2.csv";
		Provider p = new Provider(StreamFactory.create(fileName, false));
		Match match = p.match("HTTP User-Agent string");
		boolean isTablet = match.getValues("IsTablet").toBool();
		boolean isMobile = match.getValues("IsMobile").toBool();
		if(isTablet) {
			System.out.println("Tablet");
		} else {
			System.out.println("Mobile");
		}
	}

}