package Ex4;

/**
 * This class represents a 2D circle in the plane. Please make sure you update
 * it according to the GeoShape interface. Ex4: you can update this class
 * (additional documentation is needed)!
 * @author boaz.benmoshe
 *
 */
public class Circle2D implements GeoShape {
	//Fields:
	private Point2D _center;
	private double _radius;
	
	//Constructors:
	
	// Constructor that get's Point2D of the Center and a Double for the Radius.
	public Circle2D(Point2D cen, double rad) {
		this._center = new Point2D(cen);
		isRadiusOk(rad);	//check if the Radius is positive.
	}
	
	// Constructor that get's Double x and Double y that represents the Center and a Double for the Radius.
	public Circle2D(double x, double y, double rad) {
		this._center = new Point2D(x, y);
		isRadiusOk(rad);	//check if the Radius is positive.
	}
	
	// Constructor that get's a String that represents the Circle values (Center Point and Radius).
	public Circle2D(String cir) {
		int count = cir.length() - cir.replaceAll(",", "").length();// how many ',' is in the string.
			try { // try to convert the string to x,y,r.
				if (count != 2) { // if count is not 2 the format of the string is not suit for Circle2D.
					throw (new IllegalArgumentException()); // throw Exception.
				}
				else { 
				String[] str = cir.split(",", 3); // split to 3 substrings.
				this._center = new Point2D(str[0] + "," + str[1]);
				double tempr = Double.parseDouble(str[2]);
				isRadiusOk(tempr); //check if the Radius is positive.
			} 
			}
			catch (IllegalArgumentException e) {
				System.err.println("ERR: got wrong format string for Circle2D init, got:" + cir
						+ "  should be of format: x,y,radius");
				throw (e);
			}
	}

	// Constructor that get's a Circle2D values.
	public Circle2D(Circle2D c) {
		this._center = new Point2D(c._center);
		isRadiusOk(c._radius); //check if the Radius is positive.
	}
	
	/* Constructor that get's an array of Points2D, the first point is the center
	 * the second point is on the boundry of this circle.
	 */
	public Circle2D(Point2D[] arrp) { 
		this._center = new Point2D(arrp[0]);
		this._radius = arrp[1].distance(arrp[0]);
	}

	/* isRadiusOk checks if the Radius is legit(positive num),
	 * and if not it changes the value of the radius to 1 and throw an Exception.
	*/ 
	private void isRadiusOk(double rad) { 
		if (rad >= 0) {
			this._radius = rad;
		}
		else {
			System.err.println(new IllegalArgumentException()
					+ " EROR! Radius can be a positive number only.\nThe default Radius is 1\n");
			this._radius = 1;
			throw (new IllegalArgumentException());
		}
	}
	
	// getRadius returns the radius of this circle.
	public double getRadius() {
		return this._radius;
	}
	
	// getCenter returns the center point of this circle.
	public Point2D getCenter() {
		return this._center;
	}
	
	// setRadius changes the value of the current radius to the number given.
	public void setRadius(double r) {
		isRadiusOk(r); //check if the Radius is positive.
	}
	
	// setCenter changes the values of the center point of this circle to a new point given.
	public void setCenter(Point2D cent) {
		this._center = new Point2D(cent);
	}

	// toString returns a string that represent this Circle2D parameters.
	@Override 
	public String toString() {
		return _center + ", " + _radius;
	}

	/* contains checks if the Point2D given is inside this circle
	 * (the boundry also counts in), if not returns False.
	 */
	@Override
	public boolean contains(Point2D ot) {
		double dist = ot.distance(this._center);
		return dist <= this._radius + Point2D.EPS;
	}

	// centerOfMass return the center of this circle which is the center point.
	@Override
	public Point2D centerOfMass() {
		return new Point2D(this._center);
	}

	// area returns the area of this circle (double num).
	@Override
	public double area() {
		double ans = Math.PI * Math.pow(this._radius, 2);
		return ans;
	}

	// perimeter returns the perimeter of this circle(double num).
	@Override
	public double perimeter() {
		double ans = Math.PI * 2 * this._radius;
		return ans;
	}

	/*move changes the location of the circle by moving the center point 
	 * according to the point given. 
	 * For example the center of this circle is (1,5) and the point given is (3,2),
	 * the new center of this circle will be (4,7).
	 */
	@Override
	public void move(Point2D vec) {
		_center.move(vec);
	}

	// copy return a new (deep) copy of this circle.
	@Override
	public GeoShape copy() {
		return new Circle2D(_center, _radius);
	}

	/* getPoints returns an array of Points2D that represents this Circle2D parameters.
	 * The first point in the array(ans[0]) is the center of the circle.
	 * The second point in the array(ans[1]) is a point on the boundry of the circle.
	 */
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] = new Point2D(this._center);
		ans[1] = new Point2D(ans[0].x(), ans[0].y() + this._radius);
		return ans;
	}

}
