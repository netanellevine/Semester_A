package Ex4;

/**
 * This class represents a 2D axis parallel rectangle. Ex4: you should implement
 * this class!
 * 
 * @author I2CS
 *
 */
public class Rect2D implements GeoShape {
	//Fields:
	private Point2D downLeft, topRight;

	//Constructors:
	
	// Constructor that get's 2 Points2D and builds this Rect2D.
	public Rect2D(Point2D p1, Point2D p2) {
		this.downLeft = new Point2D(p1);
		this.topRight = new Point2D(p2);
		if (!isBigger(p1, p2)) {
			this.downLeft = new Point2D(p2);
			this.topRight = new Point2D(p1);
		}
	}

	// Constructor that get's (x,y,x,y) double nums and builds this Rect2D.
	public Rect2D(double x1, double y1, double x2, double y2) {
		this.downLeft = new Point2D(x1, y1);
		this.topRight = new Point2D(x2, y2);
		if (!isBigger(this.downLeft, this.topRight)) {
			this.downLeft = new Point2D(x2, y2);
			this.topRight = new Point2D(x1, y1);
		}
	}

	// Constructor that get's a Segment2D values and builds this Rect2D.
	public Rect2D(Segment2D seg) {
		this.downLeft = new Point2D(seg.get_p1());
		this.topRight = new Point2D(seg.get_p2());
		if (!isBigger(this.downLeft, this.topRight)) {
			this.downLeft = new Point2D(seg.get_p2());
			this.topRight = new Point2D(seg.get_p1());
		}
	}

	// Constructor that get's a string that represents the Rect2D.
	public Rect2D(String rec) {
		int count = rec.length() - rec.replaceAll(",", "").length(); // how many ',' is in the string.
			try { // try to convert the string to x,y,x,y.
				if (count != 3) { // if count is not 3 the format of the string is not suit for Rect2D.
					throw (new IllegalArgumentException()); // throw Exception.
					}
				else {
				String[] str = rec.split(",", 4); // split to 4 substrings.
				this.downLeft = new Point2D(str[0] + "," + str[1]);
				this.topRight = new Point2D(str[2] + "," + str[3]);
				if (!isBigger(this.downLeft, this.topRight)) {
					this.downLeft = new Point2D(str[2] + "," + str[3]);
					this.topRight = new Point2D(str[0] + "," + str[1]);
				}
			}
		}
			catch (IllegalArgumentException e) {
				System.err.println(
						"ERR: got wrong format string for Rect2D init, got:" + rec + "  should be of format: x,y,x,y");
				throw (e);
			}
		} 
	

	// Constructor that get's a Rect2D values and builds this Rect2D.
	public Rect2D(Rect2D rec) {
		this.downLeft = new Point2D(rec.downLeft);
		this.topRight = new Point2D(rec.topRight);
		if (!isBigger(this.downLeft, this.topRight)) {
			this.downLeft = new Point2D(rec.topRight);
			this.topRight = new Point2D(rec.downLeft);
		}
	}

	//Constructor that get's an array of Point2D (2 Points), and creates this Rect2D.
	public Rect2D(Point2D[] arrp) {
		this.downLeft = new Point2D(arrp[0]);
		this.topRight = new Point2D(arrp[1]);
		if (!isBigger(this.downLeft, this.topRight)) {
			this.downLeft = new Point2D(arrp[1]);
			this.topRight = new Point2D(arrp[0]);
		}
	}

	/* This method checks which one of the Point2D given is bigger,
	 * to determine which point will be the DownLeft and which
	 * point will be the TopRight  of this Rect2D.
	 */
	private boolean isBigger(Point2D p1, Point2D p2) {
		if (p1.x() <= p2.x() && p1.y() <= p2.y()) {
			return true;
		} 
		else {
			return false;
		}
	}

	// This method returns the(downLeft) Point2D of this Rect2D.
	public Point2D getDownLeft() {
		return this.downLeft;
	}

	/* This method changes the value of downLeft into a new Point2D given.
	 * Using isBigger to determine if the set of the point should change the name of the points.
	 */
	public void setDownLeft(Point2D dl) {
		this.downLeft = new Point2D(dl);
		if (!isBigger(this.downLeft, this.topRight)) {
			this.downLeft = new Point2D(this.topRight);
			this.topRight = new Point2D(dl);
		}
	}

	// This method returns the(topRight) Point2D of this Rect2D.
	public Point2D getTopRight() {
		return this.topRight;
	}

	/* This method changes the value of topRight into a new Point2D given.
	 * Using isBigger to determine if the set of the point should change the name of the points.
	 */
	public void setTopRight(Point2D tp) {
		this.topRight = new Point2D(tp);
		if (!isBigger(this.downLeft, this.topRight)) {
			this.topRight = new Point2D(this.downLeft);
			this.downLeft = new Point2D(tp);
		}
	}

	/* contains checks if the Point2D given is inside this rectangle
	 * (the boundry also counts in), if not returns False.
	 */
	@Override
	public boolean contains(Point2D ot) {
		return (ot.x() >= this.downLeft.x() && ot.x() <= this.topRight.x() && ot.y() >= this.downLeft.y()
				&& ot.y() <= this.topRight.y());
	}

	// This method returns the center of mass of this Rect2D.
	@Override
	public Point2D centerOfMass() {
		return new Segment2D(downLeft, topRight).centerOfMass();
	}

	// This method returns the area of this Rect2D.
	@Override
	public double area() {
		double AB = downLeft.distance(new Point2D(topRight.x(), downLeft.y()));
		double BC = topRight.distance(new Point2D(topRight.x(), downLeft.y()));
		return AB * BC;
	}

	// This method returns the perimeter of this Rect2D.
	@Override
	public double perimeter() {
		double AB = downLeft.distance(new Point2D(topRight.x(), downLeft.y()));
		double BC = topRight.distance(new Point2D(topRight.x(), downLeft.y()));
		return (AB + BC) * 2;
	}

	/* This method moves this Rect2D location according to a Point2D given.
	 * same as Point2D.move just do it for the two points of this Rect2D.
	 */
	@Override
	public void move(Point2D vec) {
		downLeft.move(vec);
		topRight.move(vec);
	}

	// copy return a new (deep) copy of this Rect2D.
	@Override
	public GeoShape copy() {
		return new Rect2D(this);
	}

	// getPoints returns an array of Points2D that represents this Rect2D points.
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] = new Point2D(this.downLeft);
		ans[1] = new Point2D(this.topRight);
		return ans;
	}

	// This method returns a String that represents the values of this Rect2D.
	@Override
	public String toString() {
		return this.downLeft + "," + this.topRight;
	}

}
