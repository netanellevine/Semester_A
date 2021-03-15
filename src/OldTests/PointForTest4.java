package OldTests;



	/*****************************************************************
	*  @author Eyal Levi
	*  קורס מבו�? לחישוב - �?וניברסיטת �?רי�?ל
	*  https://github.com/LeviEyal
	******************************************************************/

	public class PointForTest4 {
	    private double xVal;
	    private double yVal;

	    public PointForTest4(double x, double y) {
	        xVal = x;
	        yVal = y;
	    }
	    public PointForTest4(PointForTest4 p) {
	        xVal = p.xVal;
	        yVal = p.yVal;
	    }
	    public double distance(PointForTest4 p) {
	        double xDis = xVal - p.xVal;
	        double yDis = yVal - p.yVal;
	        return Math.sqrt(xDis * xDis + yDis * yDis);
	    }
	    public boolean equals(PointForTest4 p) {
	        return xVal == p.xVal && yVal == p.yVal;
	    }
	}
