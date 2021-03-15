package Ex4;

/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */
import java.awt.Color;

public class GUIShape implements GUI_Shape {
	//Fields:
	private GeoShape shape;
	private Color color;
	private boolean isFilled;
	private int tag;

	//Constructors:
	
	// Constructor that get's all the fields require to build a GUIShape.
	public GUIShape(GeoShape s, boolean f, Color c, int t) {
		this.shape = s;
		this.color = c;
		this.isFilled = f;
		this.tag = t;
	}

	// Constructor that get's a GUIShape and build this GUIShape with the values of the given.
	public GUIShape(GUIShape s) {
		this.shape = s.shape;
		this.color = s.color;
		this.isFilled = s.isFilled;
		this.tag = s.tag;
	}

	// Default constructor.
	public GUIShape() {
		this.shape = new Circle2D(new Point2D(0, 0), 1);
		this.color = Color.blue;
		this.isFilled = false;
		this.tag = 0;
	}

	/* Constructor that get's a string that represents the GUIShape.
	 * The format of the string given should be:
	 * "GUIShape,RGB(color)int,true/false,tag(int),GeoShape name,fields of shape(points/radius,double)".
	 */
	public GUIShape(String gui) {
		try {
			int count = gui.length() - gui.replaceAll(",", "").length();//How many ',' is in the string.
			if (count < 6) { // If count is below 6 the format of the string given is not suit for GUIShape.
				System.err.println("not enough values for GUIShape!!");
				throw (new IllegalArgumentException()); // Throw Exception.
			}
			String[] str = gui.split(",", 6); // Split to 6 substrings.
			// str[0] skip because it's "GUIShape and has no value.
			this.color = new Color(Integer.parseInt(str[1])); 
			this.isFilled = Boolean.parseBoolean(str[2]);
			this.tag = Integer.parseInt(str[3]);
			switch (str[4]) { // Check what is the shape in str[4].
			case "Circle2D":
				this.shape = new Circle2D(str[5]);// Create Circle2D.
				break;
			case "Rect2D":
				this.shape = new Rect2D(str[5]);// Create Rect2D.
				break;
			case "Segment2D":
				this.shape = new Segment2D(str[5]);// Create Segment2D.
				break;
			case "Triangle2D":
				this.shape = new Triangle2D(str[5]);// Create Triangle2D.
				break;
			case "Point2D":
				this.shape = new Point2D(str[5]);// Create Point2D.
				break;
			default:
				throw (new IllegalArgumentException());// Throw Exception.
			}
		} 
		catch (IllegalArgumentException e) {
			System.err.println("ERR: got wrong format string for GUIShape init, got:" + gui
					+ "\nshould be of format: GUIShape,RGB num,true/false,tag,GeoShape name,points of shape(x,y)");
			throw (new IllegalArgumentException());// Throw Exception.
		}
	}

	// This method returns the shape fields of this GUIShape shape.
	@Override
	public GeoShape getShape() {
		return this.shape;
	}

	// This method changes this shape to a shape given.
	@Override
	public void setShape(GeoShape g) {
		;
		this.shape = g;
	}
	
	// This method returns is filled value(true/false) of this GUIShape.
	@Override
	public boolean isFilled() {
		return this.isFilled;
	}

	/* This method changes the is filled value(true/false)
	 * of this GUIShape to a boolean value given.
	 */
	@Override
	public void setFilled(boolean filled) {
		this.isFilled = filled;
	}

	// This method returns the color of this GUIShape.
	@Override
	public Color getColor() {
		return this.color;
	}

	// This method changes the color of this GUIShape to a color given.
	@Override
	public void setColor(Color cl) {
		this.color = cl;
	}

	// This method returns the tag num of this GUIShape.
	@Override
	public int getTag() {
		return this.tag;
	}

	// This method changes the tag num of this GUIShape to a tag num given.
	@Override
	public void setTag(int tag) {
		this.tag = tag;
	}

	// copy return a new (deep) copy of this GUIShape.
	@Override
	public GUI_Shape copy() {
		return new GUIShape(this);
	}

/*This method returns a string that represent this GUIShape parameters.
*The format of the string is:
*"GUIShape,RGB(color)int,true/false,tag(int),GeoShape name,fields of shape(points/radius,double)".
*/
	@Override
	public String toString() {
		return "GUIShape," + (this.color.getRGB() & 0xffffff) + "," + this.isFilled + "," + this.tag + ","
				+ this.shape.getClass().getSimpleName() + "," + this.shape;
	}
}
