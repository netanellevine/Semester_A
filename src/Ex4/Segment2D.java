package Ex4;

/**
 * This class represents a 2D segment on the plane, Ex4: you should implement
 * this class!
 * 
 * @author I2CS
 *
 */
public class Segment2D implements GeoShape {
	//Fields:
	private Point2D _p1, _p2;

	//Constructors:
	
	// Constructor that get's 2 Points2D and builds this Segment2D.
	public Segment2D(Point2D p1, Point2D p2) {
		this._p1 = new Point2D(p1);
		this._p2 = new Point2D(p2);
	}

	// Constructor that get's (x,y,x,y) double nums and builds this Segment2D.
	public Segment2D(double x1, double y1, double x2, double y2) {
		this._p1 = new Point2D(x1, y1);
		this._p2 = new Point2D(x2, y2);
	}

	// Constructor that get's a Segment2D values and builds this Segment2D.
	public Segment2D(Segment2D seg) {
		this._p1 = new Point2D(seg._p1);
		this._p2 = new Point2D(seg._p2);
	}

	// Constructor that get's a string that represents the Segment2D.
	public Segment2D(String seg) {
		int count = seg.length() - seg.replaceAll(",", "").length();// how many ',' is in the string.
			try { // try to convert the string to x,y,x,y.
				if (count != 3) { // if count is not 3 the format of the string is not suit for Segment2D.
					throw (new IllegalArgumentException()); // throw Exception.
				}
				else {
				String[] str = seg.split(",", 4); // split to 4 substrings.
				this._p1 = new Point2D(str[0] + "," + str[1]);
				this._p2 = new Point2D(str[2] + "," + str[3]);
			}
		}
			catch (IllegalArgumentException e) {
				System.err.println("ERR: got wrong format string for Segment2D init, got:" + seg
						+ "  should be of format: x,y,x,y");
				throw (e);
			}
	}
	
	//Constructor that get's an array of Point2D (2 Points), and creates this Segment2D.
	public Segment2D(Point2D[] arrp) {
		this._p1 = new Point2D(arrp[0]);
		this._p2 = new Point2D(arrp[1]);
	}

	//This method checks if a point given in inside this Segment2D, return true if so.
	@Override
	public boolean contains(Point2D ot) {
		return ((this._p1.distance(ot)) + (this._p2.distance(ot)) == (_p1.distance(_p2)));
	}

	// This method returns the center of mass of this Segment2D.
	@Override
	public Point2D centerOfMass() {
		double cx = (this._p1.x() + this._p2.x()) / 2;
		double cy = (this._p1.y() + this._p2.y()) / 2;
		return new Point2D(cx, cy);
	}

	// This method returns the area of this Segment2D (always 0).
	@Override
	public double area() {
		return 0;
	}

	// This method returns the perimeter of this Segment2D.
	@Override
	public double perimeter() {
		return (this._p1.distance(this._p2)) * 2;
	}

	/* This method moves this Segment2D location according to a Point2D given.
	 * same as Point2D.move just do it for the two points of this Segment2D.
	 */
	@Override
	public void move(Point2D vec) {
		this._p1.move(vec);
		this._p2.move(vec);
	}

	// copy return a new (deep) copy of this Segment2D.
	@Override
	public GeoShape copy() {
		return new Segment2D(this);
	}

	// getPoints returns an array of Points2D that represents this Segment2D points.
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] = new Point2D(this._p1);
		ans[1] = new Point2D(this._p2);
		return ans;
	}
	// This method returns a String that represents the values of this Segment2D.
	@Override
	public String toString() {
		return this._p1.toString() + "," + this._p2.toString();
	}

	// This method returns the(_p1) Point2D of this Segment2D.
	public Point2D get_p1() {
		return this._p1;
	}

	// This method changes the value of _p1 into a new Point2D given.
	public void set_p1(Point2D _p1) {
		this._p1 = new Point2D(_p1);
	}

	// This method returns the(_p2) Point2D of this Segment2D.
	public Point2D get_p2() {
		return this._p2;
	}

	// This method changes the value of _p2 into a new Point2D given.
	public void set_p2(Point2D _p2) {
		this._p2 = new Point2D(_p2);
	}
}