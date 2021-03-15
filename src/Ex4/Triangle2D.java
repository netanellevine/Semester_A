package Ex4;
/**
 * This class represents a 2D Triangle in the plane. Ex4: you should implement
 * this class!
 * 
 * @author I2CS
 *
 */
public class Triangle2D implements GeoShape {
	//Fields:
	private Point2D A, B, C;

 	//Constructors:

	// Constructor that get's 3 Points2D and builds this Triangle2D.
	public Triangle2D(Point2D a, Point2D b, Point2D c) {
		this.A = new Point2D(a);
		this.B = new Point2D(b);
		this.C = new Point2D(c);
	}

	// Constructor that get's (x,y,x,y,x,y) double nums and builds this Triangle2D.
	public Triangle2D(double x1, double y1, double x2, double y2, double x3, double y3) {
		this.A = new Point2D(x1, y1);
		this.B = new Point2D(x2, y2);
		this.C = new Point2D(x3, y3);
	}

	// Constructor that get's a string that represents the Triangle2D.
	public Triangle2D(String tri) {
		int count = tri.length() - tri.replaceAll(",", "").length(); // how many ',' is in the string.
			try { // try to convert the string to x,y,x,y,x,y.
				if (count != 5) { // if count is not 5 the format of the string is not suit for Triangle2D.
					throw (new IllegalArgumentException()); // throw Exception.
				}
				else {
				String[] str = tri.split(",", 6); // split to 6 substrings.
				this.A = new Point2D(str[0] + "," + str[1]);
				this.B = new Point2D(str[2] + "," + str[3]);
				this.C = new Point2D(str[4] + "," + str[5]);
			}
		}	catch (IllegalArgumentException e) {
				System.err.println("ERR: got wrong format string for Triangle2D init, got:" + tri
						+ "  should be of format: x,y,x,y,x,y");
				throw (e);
			}
		} 
	
	//Constructor that get's an array of Point2D (3 Points), and creates this Triangle2D.
	public Triangle2D(Point2D[] arrp) {
		this.A = new Point2D(arrp[0]);
		this.B = new Point2D(arrp[1]);
		this.C = new Point2D(arrp[2]);
	}

	// Constructor that get's a Triangle2D values and builds this Triangle2D.
	public Triangle2D(Triangle2D t) {
		this.A = new Point2D(t.A);
		this.B = new Point2D(t.B);
		this.C = new Point2D(t.C);
	}

	/* contains checks if the Point2D given is inside this Triangle2D
	 * (the boundry also counts in), if not returns False.
	 */
	@Override
	public boolean contains(Point2D F) {
		if (this.A.equals(this.B) && this.B.equals(this.C) && this.A.equals(F)) {
			return true; // if A=B=C=F(point2D given) return true.
		} 
			// if the x of A,B,C,F are equals.
		else if ((this.A.x() == this.B.x() && this.B.x() == this.C.x() && this.C.x() == F.x())) {
//return true if the y of the Point2D given(F) is between the min y and the max y of the triangle.
			return (Math.min(this.A.y(), Math.min(this.B.y(), this.C.y())) <= F.y())
					&& (Math.max(this.A.y(), Math.max(this.B.y(), this.C.y())) >= F.y());
		} 	// if the y of A,B,C,F are equals.
		else if ((this.A.y() == this.B.y() && this.B.y() == this.C.y() && this.C.y() == F.y())) {
//return true if the x of the Point2D given(F) is between the min x and the max x of the triangle.
			return (Math.min(this.A.x(), Math.min(this.B.x(), this.C.x())) <= F.x())
					&& (Math.max(this.A.x(), Math.max(this.B.x(), this.C.x())) >= F.x());
		} 
		else {
			/*Check if the summ of the area,of all 3 options to create traignle, combining the 
			 *point given and the original points is equal to the area of this Triangle2D.
			 */
			double areaABF = new Triangle2D(this.A, this.B, F).area();
			double areaAFC = new Triangle2D(this.A, F, this.C).area();
			double areaFBC = new Triangle2D(F, this.B, this.C).area();
			return (((areaABF + areaAFC + areaFBC) < this.area()));
		}
	}
	
	/* This method returns the center of mass of this Triangle2D 
	 * using the avarage of the values of x and the y.
	 */
	@Override
	public Point2D centerOfMass() {
		//Another way to calculate it.
//		Point2D P = new Point2D(new Segment2D(this.B, this.C).centerOfMass());
//		double px = (2 * P.x() + A.x()) / 3;
//		double py = (2 * P.y() + A.y()) / 3;
//		return new Point2D(px, py);
		double cx = (A.x() + B.x() + C.x()) / 3;
		double cy = (A.y() + B.y() + C.y()) / 3;
		return new Point2D(cx, cy);
	}

	// This method returns the area of this Triangle2D.
	@Override
	public double area() {
		return Math.abs((this.A.x() * (this.B.y() - this.C.y()) + this.B.x() * (this.C.y() - this.A.y())
				+ this.C.x() * (this.A.y() - this.B.y())) / 2.0);
	}
	
	// This method returns the(A) Point2D of this Triangle2D.
	public Point2D getA() {
		return this.A;
	}
	
	// This method sets the (A) Point2D of this Triangle2D, to a point given.
	public void setA(Point2D a) {
		this.A = new Point2D(a);
	}

	// This method returns the(B) Point2D of this Triangle2D.
	public Point2D getB() {
		return this.B;
	}

	// This method sets the (B) Point2D of this Triangle2D, to a point given.
	public void setB(Point2D b) {
		this.B = new Point2D(b);
	}

	// This method returns the(C) Point2D of this Triangle2D.
	public Point2D getC() {
		return this.C;
	}

	// This method sets the (C) Point2D of this Triangle2D, to a point given.
	public void setC(Point2D c) {
		this.C = new Point2D(c);
	}

	// This method returns the perimeter of this Triangle2D.
	@Override
	public double perimeter() {
		return this.A.distance(this.B) + this.B.distance(this.C) + this.C.distance(this.A);
	}

	/* This method moves this Triangle2D location according to a Point2D given.
	 * same as Point2D.move just do it for the three points of this Triangle2D.
	 */
	@Override
	public void move(Point2D vec) {
		A.move(vec);
		B.move(vec);
		C.move(vec);
	}

	// copy return a new (deep) copy of this Triangle2D.
	@Override
	public GeoShape copy() {
		return new Triangle2D(this.A, this.B, this.C);
	}

	// getPoints returns an array of Points2D that represents this Triangle2D points.
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[3];
		ans[0] = new Point2D(this.A);
		ans[1] = new Point2D(this.B);
		ans[2] = new Point2D(this.C);
		return ans;
	}

	// This method returns a String that represents the values of this Triangle2D.
	@Override
	public String toString() {
		return this.A + "," + this.B + "," + this.C;
	}
}
