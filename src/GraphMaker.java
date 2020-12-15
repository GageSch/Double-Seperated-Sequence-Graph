import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.geom.Ellipse2D;
import java.util.*;

class Surface extends JPanel {
	
	public static final int HEIGHT = 1000;
	public static final int WIDTH = 1920;
	public static final int X_MIN = 1;
	public static final long X_MAX = 10000;
	public static final int Y_MIN = -50;
	public static final long Y_MAX = 18310;
	public static final double XRATIO = (double) WIDTH/(X_MAX - X_MIN);
	public static final double YRATIO = (double) HEIGHT/(Y_MAX - Y_MIN);
	public static final int RADIUS = 1;
	
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        
        for(int x = X_MIN; x < X_MAX; x++) {
        	int y = function(x);
        	System.out.println(y);
        	int yCord = HEIGHT - (int) Math.round((y -Y_MIN) * YRATIO);
        	int xCord = (int) Math.round((x - X_MIN)* XRATIO);
        	Ellipse2D theCircle = new Ellipse2D.Double(xCord - RADIUS, yCord - RADIUS, 2 * RADIUS, 2 * RADIUS);
        	g2d.setPaint(Color.BLACK);
        	g2d.fill(theCircle);
        }
    }
    
    public static int function(int n) {
    	String finalString = "";
    	String decimalString = Integer.toString(n);
    	String[] decimal = decimalString.split("");
    	Arrays.sort(decimal, Collections.reverseOrder());
    	String finalDecimalString = "";
    	for (int i = 0; i < decimal.length; i++) {
    		finalDecimalString += decimal[i];
        }
    	int finalDecimal = Integer.parseInt(finalDecimalString);
    	String binaryString = Integer.toBinaryString(finalDecimal);
    	String[] binary = binaryString.split("");
    	int ones = 0;
    	int zeroes = 0;
    	for (int i = 0; i < binary.length; i++) {
        	if (Integer.parseInt(binary[i]) == 1) {
        		ones++;
        	}
        	else {
        		zeroes++;
        	}
        }
    	for (int i = 0; i < ones; i++) {
        	finalString += "1";
        }
    	for (int i = 0; i < zeroes; i++) {
        	finalString += "0";
        }
    	return Integer.parseInt(finalString,2);
    }

    @Override
    public void paintComponent(Graphics g) {

        
        doDrawing(g);
    }
}

