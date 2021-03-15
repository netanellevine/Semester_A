package Ex4;
import java.awt.Color;

// Netanel Levine.
// ID: 312512619. 
/**
 * This class is the "main" class which will be constructed and run as in (Test_Ex4).
 * Ex4: you should implement this class!
 * @author boaz.benmoshe
 *
 */

public class Ex4 implements Ex4_GUI{
	//Field:
	private Shape_Collection collection;
	
	//Constructor:
	public Ex4() {
		this.collection=new Shape_Collection();
	}
	
	// This method inits the GUI_Shape_Collection - which will be presented at Ex4
	@Override
	public void init(GUI_Shape_Collection g) {;
	this.collection= (Shape_Collection) g;
	}
	
	// This method returns a link to the GUI_Shape_Collection
	@Override
	public GUI_Shape_Collection getShape_Collection() {
		return this.collection;
	}

	/* This method presents the GUI shapes in this collection in a GUI window.
	 * First(assuming that this collection is without a boundingBox already), it creates a boundingBox
	 * and sets the scale of the draw.
	 * Second, it goes from the first GUiShape to the last, and draws each one according to it's shape.
	 * This method determine the shape type by checking if the [i]'th GUIShape contains the shape name(String).
	 * Third, it draws the shape according to each shape parameters (also refers to the case of that the shape is filled or not).
	 */
	@Override
	public void show() {
		// Creates boundingBox and sets the scale and settings for the draw.
		StdDraw.setCanvasSize(Ex4_Const.Width, Ex4_Const.Height);
		StdDraw.setScale(0, 0.9);
		Rect2D bounding = this.collection.getBoundingBox();
		Point2D min = bounding.getPoints()[0];
		Point2D max = bounding.getPoints()[1];
		GUI_Shape s7 = new GUIShape(bounding, false, Color.gray, this.collection.size() - 1);
		this.collection.add(s7);
		double m0 = Math.min(min.x(), min.y());
		double m1 = Math.max(max.x(), max.y());
		StdDraw.setScale(m0 - 0.1, m1 + 0.1);
		StdDraw.setPenRadius(0.005);
		/*Going through every [i]=GUIShape of this collection.
		 * 1) Sets the color of the GUIshape.
		 * 2) Determine the GUIShape shape.
		 * 3) Checks if the shape is filled or not.
		 * 4) Draws the shape.
		 */
		for (int i = 0; i < this.collection.size(); i++) {
			StdDraw.setPenColor(this.collection.get(i).getColor()); // Color
			String str = this.collection.get(i).getShape().toString(); // Shape at[i] values.
			switch (this.collection.get(i).getShape().getClass().getSimpleName()) { // Shape name.
			case "Point2D": // if it's Point2D.
				Point2D p1 = new Point2D(str);
				StdDraw.point(p1.x(), p1.y());
				break;
			case "Segment2D": // if it's Segment2D.
				Segment2D s1 = new Segment2D(str);
				StdDraw.line(s1.get_p1().x(), s1.get_p1().y(), s1.get_p2().x(), s1.get_p2().y());
				break;
			case "Rect2D": // if it's Rect2D.
				Rect2D r1 = new Rect2D(str);
				double halfHeight = Math.abs((r1.getTopRight().y() - r1.getDownLeft().y()) / 2);
				double halfWidth = Math.abs((r1.getTopRight().x() - r1.getDownLeft().x()) / 2);
				if (this.collection.get(i).isFilled()) {
					StdDraw.filledRectangle(r1.centerOfMass().x(), r1.centerOfMass().y(), halfWidth, halfHeight);
				} 
				else {
					StdDraw.rectangle(r1.centerOfMass().x(), r1.centerOfMass().y(), halfWidth, halfHeight);
				}
				break;
			case "Circle2D": // if it's Circle2D.
				Circle2D c1 = new Circle2D(str);
				if (this.collection.get(i).isFilled()) {
					StdDraw.filledCircle(c1.getCenter().x(), c1.getCenter().y(), c1.getRadius());
				} 
				else {
					StdDraw.circle(c1.getCenter().x(), c1.getCenter().y(), c1.getRadius());
				}
				break;
			case "Triangle2D": // if it's Triangle2D.
				Triangle2D t1 = new Triangle2D(str);
				double[] x = { t1.getA().x(), t1.getB().x(), t1.getC().x() };
				double[] y = { t1.getA().y(), t1.getB().y(), t1.getC().y() };
				if (this.collection.get(i).isFilled()) {
					StdDraw.filledPolygon(x, y);
				} 
				else {
					StdDraw.polygon(x, y);
				}
				break;
			}
		}
		/*Removes the boundingBox that was created at the beginning of this method,
		 * because it wasn't part of the original collection.
		 */
		this.collection.removeElementAt(this.collection.size() - 1);
	}

	//This method returns a String containing all the "toString" of each GUI_shape in this collection.
	@Override
	public String getInfo() {
		return this.collection.toString();
	}
}

