
package Ex4;

/**
 * This class represents a 2D point in the plane. Do NOT change this class! It
 * would be used as is for testing. Ex4: you should NOT change this class!
 * 
 * @author boaz.benmoshe
 */

public class Point2D implements GeoShape {
	//Fields:
	public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1, 2), EPS = EPS2;
	public static final Point2D ORIGIN = new Point2D(0, 0);
	private double _x, _y;
	
	//Constructors:
	
	// Constructor that creates a Point2D with a given x,y(double).
	public Point2D(double x, double y) {
		this._x = x;
		this._y = y;
	}
	
	// Constructor that creates a Point2D with a given Point2D
	public Point2D(Point2D p) {
		this._x = p.x();
		this._y = p.y();
	}
	
	// Constructor that creates a Point2D with a given string that represents a Point2D values.
	public Point2D(String s) {
		try { // try to convert the string to x and y num.
			String[] a = s.split(","); // split to 2 substrings.
			_x = Double.parseDouble(a[0]);
			_y = Double.parseDouble(a[1]);
		} 
		catch (IllegalArgumentException e) { // catch and throw IllegalArgumentException.
			System.err
					.println("ERR: got wrong format string for Point2D init, got:" + s + "  should be of format: x,y");
			throw (e);
		}
	}
	
	// This function returns the values of the x in the Point2D.
	public double x() {
		return this._x;
	}

	// This function returns the values of the y in the Point2D.
	public double y() {
		return this._y;
	}

	// This function returns the values of the x in the Point2D (but as int).
	public int ix() {
		return (int) _x;
	}

	// This function returns the values of the y in the Point2D (but as int).
	public int iy() {
		return (int) _y;
	}

	/* This function adds the values of a Point2D given the this Point2D
	 * by adding the x given + this x ,and the y given + this y.
	 */
	public Point2D add(Point2D p) {
		Point2D a = new Point2D(p.x() + x(), p.y() + y());
		return a;
	}

	// This function returns a String that represents the values of this Point2D.
	@Override
	public String toString() {
		return _x + "," + _y;
	}
	/* This function returns the distance(double num) of this Point2D 
	 * from the ORIGIN point(0,0).
	 */
	public double distance() {
		return this.distance(ORIGIN);
	}

	/* This function returns the distance(double num) of this Point2D 
	 * from a Point2D given.
	 */
	public double distance(Point2D p2) {
		double dx = this.x() - p2.x();
		double dy = this.y() - p2.y();
		double t = (dx * dx + dy * dy);
		return Math.sqrt(t);
	}

	/* This function checks if an Object given is a Point2D and compares it
	 *  with this Point2D, if they are equals return true.
	 */
	public boolean equals(Object p) {
		if (p == null || !(p instanceof Point2D)) {
			return false;
		}
		Point2D p2 = (Point2D) p;
		return ((_x == p2._x) && (_y == p2._y));
	}

	/* This function checks if a Point2D given is close to equals with
	 *  this Point2D (with deviation of eps(given)).
	 */
	public boolean close2equals(Point2D p2, double eps) {
		return (this.distance(p2) < eps);
	}

	/* This function checks if a Point2D given is close to equals with
	 *  this Point2D (with deviation of eps).
	 */
	public boolean close2equals(Point2D p2) {
		return close2equals(p2, EPS);
	}

	/**
	 * This method returns the vector between this point and the target point. The
	 * vector is represented as a Point2D.
	 * 
	 * @param target
	 * @return
	 */
	public Point2D vector(Point2D target) {
		double dx = target.x() - this.x();
		double dy = target.y() - this.y();
		return new Point2D(dx, dy);
	}

	/* This function checks if this Point2D contains a Point2D given
	 * (because its point so checks if equals).
	 */
	@Override
	public boolean contains(Point2D ot) {
		return this.equals(ot);
	}

	// irrelevent for Point2D.
	@Override
	public Point2D centerOfMass() {
		// TODO Auto-generated method stub
		return new Point2D(this);
	}
	
	// This Function returns the area of this Point2D (always 0).
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	// This Function returns the perimeter of this Point2D (always 0).
	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* This function moves this Point2D location according to a Point2D given.
	 * For example this Point2D is (1,5) and the point given is (3,2),
	 * the new Point2D will be (4,7).
	 */
	@Override
	public void move(Point2D vec) {
		this._x += vec.x();
		this._y += vec.y();
	}

	// copy return a new (deep) copy of the point.
	@Override
	public GeoShape copy() {
		return new Point2D(this);
	}

	/* getPoints returns an array of Points2D that represents this Point2D.
	 * ans[0] = this Point2D.
	 */
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[1];
		ans[0] = new Point2D(this);
		return ans;
	}
}
