// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

package t2;

import java.text.DecimalFormat;

public final class LatLon {
    private double latitude;
    private double longitude;

    public LatLon(double lat, double lon) {
        latitude  = fix90(lat);
        longitude = fix180(lon);
    }
    
    public LatLon(double lat, double lon, double bearing, double distance) {
        latitude  = fix90(lat);
        longitude = fix180(lon);

        LatLon newPosition = direct(bearing, distance);
        
        latitude  = newPosition.latitude;
        longitude = newPosition.longitude;
    }
	
    public LatLon(double extLat, double extLon, double bearing, double offset, double circleLat, double circleLon, double radius) {
        LatLon extStart     = new LatLon(extLat, extLon);
        LatLon circleCenter = new LatLon(circleLat, circleLon);
        
        // Calculate the adjustment due to the start position of the bearing line and the center of the circle not being the same
        double adjust = extStart.distance(circleCenter) * Math.sin(Math.toRadians(extStart.bearing(circleCenter) - bearing));
        
        // Calculate the intersection
        LatLon intersection = circleCenter.direct(bearing - Math.toDegrees(Math.asin((offset + adjust) / radius)), radius);
        
        latitude  = intersection.latitude;
        longitude = intersection.longitude;
    }
	
    public LatLon(double extLat, double extLon, double bearing, double distance, double offset) {
        LatLon newPosition = new LatLon(extLat, extLon, bearing - Math.toDegrees(Math.atan(offset / distance)), Math.sqrt((distance * distance) + (offset * offset)));

        latitude  = newPosition.latitude;
        longitude = newPosition.longitude;
    }
	
    public final double getLat() {
        return latitude;
    }
	
    public final double getLon() {
        return longitude;
    }
    
    public final String toString() {
        double num;
        int    part;
        
        DecimalFormat dfMins = new DecimalFormat("00");
        DecimalFormat dfSecs = new DecimalFormat("00.0");
        
        num = latitude;
        
        StringBuffer lat = new StringBuffer();
        
        if (num >= 0.0) {
            lat.append('N');
        } else {
            lat.append('S');
            num *= -1.0;
        }

        part = new Double(Math.floor(num)).intValue();
        
        lat.append(part).append('�');
        
        num = (num - part) * 60;
        
        part = new Double(Math.floor(num)).intValue();
        
        lat.append(dfMins.format(part)).append('\'');

        num = (num - part) * 60;
        
        lat.append(dfSecs.format(num)).append("\" ");
        
        num = longitude;
        
        StringBuffer lon = new StringBuffer();
        
        if (num >= 0.0) {
            lat.append('E');
        } else {
            lat.append('W');
            num *= -1.0;
        }

        part = new Double(Math.floor(num)).intValue();
        
        lat.append(part).append('�');
        
        num = (num - part) * 60;
        
        part = new Double(Math.floor(num)).intValue();
        
        lat.append(dfMins.format(part)).append('\'');

        num = (num - part) * 60;
        
        lat.append(dfSecs.format(num)).append('\"');

        StringBuffer ret = new StringBuffer(lat).append(", ").append(lon);
        
        return ret.toString();
    }
	
    public final double distance(LatLon to) {
        if (latitude == to.latitude && longitude == to.longitude) { // Trap equal positions
            return 0.0;
        }
    
//   Use WGS-84 constants

        double a = 6378137.0;
        double b = 6356752.3142;
        double f = 1 / 298.257223563;
         
        double L         = Math.toRadians(to.longitude) - Math.toRadians(longitude);
        double U1        = Math.atan((1.0 - f) * Math.tan(Math.toRadians(latitude)));
        double U2        = Math.atan((1.0 - f) * Math.tan(Math.toRadians(to.latitude)));
        double sinU1     = Math.sin(U1);
        double cosU1     = Math.cos(U1);
        double sinU2     = Math.sin(U2);
        double cosU2     = Math.cos(U2);
        double lambda    = L;
        double lambdaP   = 2.0 * Math.PI;
        double iterLimit = 20.0;
      
        double sinLambda  = 0.0;
        double cosLambda  = 0.0;
        double sinSigma   = 0.0;
        double cosSigma   = 0.0;
        double sigma      = 0.0;
        double sinAlpha   = 0.0;
        double cosSqAlpha = 0.0;
        double cos2SigmaM = 0.0;
        double C          = 0.0;
      
        while (Math.abs(lambda - lambdaP) > 1e-12 && --iterLimit > 0) {
            sinLambda  = Math.sin(lambda);
            cosLambda  = Math.cos(lambda);
            sinSigma   = Math.sqrt((cosU2 * sinLambda) * (cosU2 * sinLambda) + (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda) * (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda));
            cosSigma   = sinU1 * sinU2 + cosU1 * cosU2 * cosLambda;
            sigma      = Math.atan2(sinSigma, cosSigma);
            sinAlpha   = cosU1 * cosU2 * sinLambda / sinSigma;
            cosSqAlpha = 1 - sinAlpha * sinAlpha;
            cos2SigmaM = cosSigma - 2.0 * sinU1 * sinU2 / cosSqAlpha;
            C          = f / 16.0 * cosSqAlpha * (4.0 + f * (4.0 - 3.0 * cosSqAlpha));
            lambdaP    = lambda;
            lambda     = L + (1.0 - C) * f *sinAlpha * (sigma + C * sinSigma * (cos2SigmaM + C * cosSigma * (-1.0 + 2.0 * cos2SigmaM * cos2SigmaM)));
        }
        
        if (iterLimit == 0) {
            return Double.NaN; // Formula failed to converge
        }
        
        double uSq        = cosSqAlpha * (a * a - b * b) / (b * b);
        double A          = 1.0 + uSq / 16384.0 * (4096.0 + uSq * (-768.0 + uSq * (320.0 - 175.0 * uSq)));
        double B          = uSq / 1024.0 * (256.0 + uSq * (-128.0 + uSq * (74.0 - 47.0 * uSq)));
        double deltaSigma = B * sinSigma * (cos2SigmaM + B / 4.0 * (cosSigma * (-1.0 + 2.0 * cos2SigmaM * cos2SigmaM) - B / 6.0 * cos2SigmaM * (-3.0 + 4.0 * sinSigma * sinSigma) * (-3.0 + 4.0 * cos2SigmaM * cos2SigmaM)));
        double s          = b * A * (sigma - deltaSigma);
      
        return s;
    }
	
    public final double bearing(LatLon to) {
        if (latitude == to.latitude && longitude == to.longitude) { // Trap equal positions (ignoring altitude)
            return 0.0;
        }
    
//   Use WGS-84 constants

        double f = 1 / 298.257223563;
         
        double L         = Math.toRadians(to.longitude) - Math.toRadians(longitude);
        double U1        = Math.atan((1.0 - f) * Math.tan(Math.toRadians(latitude)));
        double U2        = Math.atan((1.0 - f) * Math.tan(Math.toRadians(to.latitude)));
        double sinU1     = Math.sin(U1);
        double cosU1     = Math.cos(U1);
        double sinU2     = Math.sin(U2);
        double cosU2     = Math.cos(U2);
        double lambda    = L;
        double lambdaP   = 2.0 * Math.PI;
        double iterLimit = 20.0;
      
        double sinLambda  = 0.0;
        double cosLambda  = 0.0;
        double sinSigma   = 0.0;
        double cosSigma   = 0.0;
        double sigma      = 0.0;
        double sinAlpha   = 0.0;
        double cosSqAlpha = 0.0;
        double cos2SigmaM = 0.0;
        double C          = 0.0;

        while (Math.abs(lambda - lambdaP) > 1e-12 && --iterLimit > 0) {
            sinLambda  = Math.sin(lambda);
            cosLambda  = Math.cos(lambda);
            sinSigma   = Math.sqrt((cosU2 * sinLambda) * (cosU2 * sinLambda) + (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda) * (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda));
            cosSigma   = sinU1 * sinU2 + cosU1 * cosU2 * cosLambda;
            sigma      = Math.atan2(sinSigma, cosSigma);
            sinAlpha   = cosU1 * cosU2 * sinLambda / sinSigma;
            cosSqAlpha = 1 - sinAlpha * sinAlpha;
            cos2SigmaM = cosSigma - 2.0 * sinU1 * sinU2 / cosSqAlpha;
            C          = f / 16.0 * cosSqAlpha * (4.0 + f * (4.0 - 3.0 * cosSqAlpha));
            lambdaP    = lambda;
            lambda     = L + (1.0 - C) * f *sinAlpha * (sigma + C * sinSigma * (cos2SigmaM + C * cosSigma * (-1.0 + 2.0 * cos2SigmaM * cos2SigmaM)));
        }
        
        if (iterLimit == 0) {
            return Double.NaN;  // Formula failed to converge
        }
        
        double bearing = Math.atan2(cosU2 * sinLambda, cosU1 * sinU2 - sinU1 * cosU2 * cosLambda);
    
        return norm360(Math.toDegrees(bearing));
    }
	
    public final LatLon direct(double bearing, double distance) {
        if (distance == 0.0) {
            return this;
        }
    
        double a = 6378137.0;
        double b = 6356752.3142;
        double f = 1 / 298.257223563;

        double radBearing = Math.toRadians(bearing);
        double tanU1      = (1.0 - f) * Math.tan(Math.toRadians(latitude));
        double tanSigma1  = tanU1 / Math.cos(radBearing);
        double u1         = Math.atan(tanU1);
        double sinU1      = Math.sin(u1);
        double cosU1      = Math.cos(u1);
        double sinAlpha   = cosU1 * Math.sin(radBearing);
        double cosSqAlpha = 1.0 - sinAlpha * sinAlpha;
        double uSq        = cosSqAlpha * (a * a - b * b) / (b * b);
        double A          = 1.0 + (uSq / 16384.0) * (4096.0 + uSq * (-768.0 + uSq * (320.0 - 175 * uSq)));
        double B          = (uSq / 1024.0) * (256.0 + uSq * (-128.0 + uSq * (74.0 - 47.0 * uSq)));
        double sigma      = distance / (b * A);
        double sigma1     = Math.atan(tanSigma1);
        double iterLimit  = 20.0;
    
        double lastSigma  = 0.0;
        double twoSigmaM  = 0.0;
        double sinSigma   = 0.0;
        double cosSigma   = 0.0;
        double cos2SigmaM = 0.0;
        double deltaSigma = 0.0;

        do {
            lastSigma  = sigma;
            twoSigmaM  = 2.0 * sigma1 + sigma;
            sinSigma   = Math.sin(sigma);
            cosSigma   = Math.cos(sigma);
            cos2SigmaM = Math.cos(twoSigmaM);
            deltaSigma = B * sinSigma * (cos2SigmaM + B / 4.0 * (cosSigma * (-1.0 + 2.0 * Math.pow(cos2SigmaM, 2.0)) - B / 6.0 * cos2SigmaM * (-3.0 + 4.0 * Math.pow(sinSigma, 2.0)) * (-3.0 + 4.0 * Math.pow(cos2SigmaM, 2.0))));
            sigma      = distance / (b * A) + deltaSigma;
        } while ((--iterLimit > 0) && (Math.abs(sigma - lastSigma) >= 1e-12));

        if (iterLimit == 0) {
            return new LatLon(Double.NaN, Double.NaN); // Formula failed to converge
        }

        twoSigmaM  = 2.0 * sigma1 + sigma;
        sinSigma   = Math.sin(sigma);
        cosSigma   = Math.cos(sigma);
        cos2SigmaM = Math.cos(twoSigmaM);
    
        double lat = Math.atan2(sinU1 * cosSigma + cosU1 * sinSigma * Math.cos(radBearing), (1.0 - f) * Math.sqrt(Math.pow(sinAlpha, 2.0) + Math.pow(sinU1 * sinSigma - cosU1 * cosSigma * Math.cos(radBearing), 2.0)));
    
        double lambda = Math.atan2(sinSigma * Math.sin(radBearing), cosU1 * cosSigma - sinU1 * sinSigma * Math.cos(radBearing));
    
        double C = f / 16.0 * cosSqAlpha * (4.0 + f * (4.0 - 3.0 * cosSqAlpha));
    
        double lambdaP = lambda - (1.0 - C) * f * sinAlpha * (sigma + C * sinSigma * (cos2SigmaM + C * cosSigma * (-1.0 + 2.0 * cos2SigmaM * cos2SigmaM)));
        double lon = longitude + Math.toDegrees(lambdaP);
    
        return new LatLon(Math.toDegrees(lat), lon);
    }
	
    public final static double fix90(double num) {
        if (num < -90.0) {
            return -90.0;
        }
        
        if (num > 90.0) {
            return 90.0;
        }
        
        return num;
    }
	
    public final static double fix180(double num) {
        if (num < -180.0) {
            return -180.0;
        }
        
        if (num > 180.0) {
            return 180.0;
        }
        
        return num;
    }
	
    public final static double norm360(double num) {
        if (num < 0.0) {
            return num - Math.floor(num / 360.0) * 360.0;
//          return Math.IEEEremainder(num, 360.0);
        } else if (num > 360.0) {
            return num - Math.floor(num / 360.0) * 360.0;
//          return Math.IEEEremainder(num, 360.0);
        } else {
            return num;
        }
    }
	
    public final static double fromString(String txt) {
        int txtlen = txt.length();
        int idx    = 0;
        
        char ch = Character.toUpperCase(txt.charAt(0));
        
        double sgn = 1.0;
        
        if (ch == 'N' || ch =='S' || ch =='E' || ch =='W') {
            if (ch == 'S'|| ch == 'W') {
                sgn = -1.0;
            }
            
            idx++;
        } else {
            throw new NumberFormatException();
        }
        
        double numd = 0;
        
        while ((idx < txtlen) && (Character.isDigit(txt.charAt(idx)))) {
            numd = (numd * 10.0) + (txt.charAt(idx++) - '0');
        }
        
        if ((idx >= txt.length()) || (txt.charAt(idx++) != ' ')) {
            throw new NumberFormatException();
        }
        
        double numm = 0;
        
        while ((idx < txtlen) && (Character.isDigit(txt.charAt(idx)))) {
            numm = (numm * 10.0) + (txt.charAt(idx++) - '0');
        }

        if (numm > 59.0) {
            throw new NumberFormatException();
        }
        
        if ((idx >= txt.length()) || (txt.charAt(idx++) != ' ')) {
            throw new NumberFormatException();
        }
        
        double nums = 0;
        
        while ((idx < txtlen) && (Character.isDigit(txt.charAt(idx)))) {
            nums = (nums * 10.0) + (txt.charAt(idx++) - '0');
        }
        
        if (nums > 59.0) {
            throw new NumberFormatException();
        }
        
        double numss = 0;
        
        if (idx < txtlen) {
            if (txt.charAt(idx++) != '.') {
                throw new NumberFormatException();
            }
            
            if (idx < txtlen) {
                if (Character.isDigit(txt.charAt(idx))) {
                    numss = (txt.charAt(idx++) - '0');
                } else {
                    throw new NumberFormatException();
                }
            } else {
                throw new NumberFormatException();
            }
        }
        
        double num = sgn * (numd + (numm / 60.0) + ((nums + (numss / 10)) / 3600.0));
        
        return num;
    }
}
