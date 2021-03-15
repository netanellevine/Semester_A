package Ex4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * This class represents a collection of GUI_Shape. Ex4: you should implement
 * this class!
 * @author I2CS
 */
public class Shape_Collection implements GUI_Shape_Collection {
	//Field:
	private ArrayList<GUI_Shape> arrGEO;

	//Constructors:

	// Default constructor.
	public Shape_Collection() {
		this.arrGEO = new ArrayList<GUI_Shape>();
	}

	// Constructor that get's a Shape_Collection and build this Shape_Collection with the values of the given.
	public Shape_Collection(Shape_Collection collection) {
		this.arrGEO = collection.arrGEO;
	}

	/*This method return a reference to the i'th element in this collection.
	 * If the index given is not within the range of this collection it's
	 * throws an Exception.
	 */
	@Override
	public GUI_Shape get(int i) {
		if (this.arrGEO.size() > i && i >= 0) {
			return this.arrGEO.get(i);
		}
		else {
			System.err.println("EROR! the index of the array is between 0 and " + (this.arrGEO.size() - 1));
			throw (new ArrayIndexOutOfBoundsException(i));
		}
	}

	//This method return the size of this collection (if empty return 0).
	@Override
	public int size() {
		return this.arrGEO.size();
	}

	/*This method remove (and return) the gui_shape at the i'th location.
	 * After removing the size of this collection decreases (by 1) and the order 
	 * (of the elements) remains the same - just with out the removed element.
	 * If the index given is not within the range of this collection it's
	 * throws an Exception.
	 */
	@Override
	public GUI_Shape removeElementAt(int i) {
		if (this.arrGEO.size() > i && i >= 0) {
			return this.arrGEO.remove(i);
		}
		else {
			System.err.println("EROR! the index of the array is between 0 and " + (this.arrGEO.size() - 1));
			throw (new ArrayIndexOutOfBoundsException(i));
		}
	}

	/**
	 * This method adds the gui_element s to this collection in the i'th position.
	 * Note: the method adds the GUIshape given "as is" (NOT a new copy of s).
	 * If the index given is not within the range of this collection it's
	 * throws an Exception.
	 */
	@Override
	public void addAt(GUI_Shape s, int i) {
		if (this.arrGEO.size() > i && i >= 0) {
			this.arrGEO.add(i, s);
		}
		else {
			System.err.println("EROR! the index of the array is between 0 and " + (this.arrGEO.size() - 1));
			throw (new ArrayIndexOutOfBoundsException(i));
		}
	}

	/**
	 * This method adds the gui_element s to this collection in the last position.
	 * Note: the method adds the GUIshape given "as is" (NOT a new copy of s).
	 */
	@Override
	public void add(GUI_Shape s) {
		this.arrGEO.add(s);
	}

	// This method constructs a deep copy of this collection.
	@Override
	public GUI_Shape_Collection copy() {
		return new Shape_Collection(this);
	}

	/** This method sorts this collection according to the comp Comparator(given) - in increasing order.
	 * @param comp a linear order over gui_sahpes as defined in java.util.Comparator
	 */
	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		Collections.sort(this.arrGEO, comp);
	}

	//This method simple removes all the elements from this collection (not null).
	@Override
	public void removeAll() {
		arrGEO.removeAll(this.arrGEO);
	}

	/*This method saves this collection to a text file(with a given file_name).
	 * If FileWriter fails to write it to a text file it throws an IOException.
	 */
	@Override
	public void save(String file_name) {
		try {
			FileWriter myWriter = new FileWriter(file_name);
			myWriter.write(this.toString());
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* This method restore a gui_shape collection from text file 
	 * (with a given file path or file name).
	 * If Scanner fails to load the text it throws an FileNotFoundException.
	 */
	@Override
	public void load(String file) {
		try {
			File txtCollection = new File(file);
			Scanner myReader = new Scanner(txtCollection);
			while (myReader.hasNextLine()) {
				String temp = myReader.nextLine();
				GUI_Shape gui = new GUIShape(temp);
				this.add(gui);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*This methods returns the minimal bounding box containing all the shapes in this collection.
	 *getBoundingBox calculate by arranging all the X'es and all the Y'es of 
	 *all the shapes in this collection by increasing order (array of X, array of Y).
	 *Then it takes the Min(x,y) and the Max(x,y) from the arrays,
	 *and creates a Rect2D with those values.
	 *NOTE- for Circle2D it creates a square that contains the Circle2D and adds
	 *the X'es and Y'es of the square to the arrays of X and Y(because circle is a tricky shape).
	 *Returns a new Rect2D.
	 */
	@Override
	public Rect2D getBoundingBox() {
		ArrayList<Double> arrx = new ArrayList<Double>(); // ArrayList of all the X'es.
		ArrayList<Double> arry = new ArrayList<Double>(); // ArrayList of all the Y'es.
		for (int i = 0; i < this.arrGEO.size(); i++) {
			String str = this.arrGEO.get(i).getShape().toString();//string of the values of the shape.
			switch (this.arrGEO.get(i).getShape().getClass().getSimpleName()) {
			case "Point2D": // if it's Point2D.
				Point2D p1 = new Point2D(str);
				arrx.add(p1.x());
				arry.add(p1.y());
				break;
			case "Segment2D": // if it's Segment2D.
				Segment2D s1 = new Segment2D(str);
				arrx.add(s1.get_p1().x());
				arry.add(s1.get_p1().y());
				arrx.add(s1.get_p2().x());
				arry.add(s1.get_p2().y());
				break;
			case "Rect2D": // if it's Rect2D.
				Rect2D r1 = new Rect2D(str);
				arrx.add(r1.getDownLeft().x());
				arry.add(r1.getDownLeft().y());
				arrx.add(r1.getTopRight().x());
				arry.add(r1.getTopRight().y());
				break;
			case "Circle2D": // if it's Circle2D.
				Circle2D c1 = new Circle2D(str);
				arrx.add((c1.getCenter().x()) + c1.getRadius());
				arry.add((c1.getCenter().y()) + c1.getRadius());
				arrx.add((c1.getCenter().x()) - c1.getRadius());
				arry.add((c1.getCenter().y()) - c1.getRadius());
				break;
			case "Triangle2D": // if it's Triangle2D.
				Triangle2D t1 = new Triangle2D(str);
				arrx.add(t1.getA().x());
				arry.add(t1.getA().y());
				arrx.add(t1.getB().x());
				arry.add(t1.getB().y());
				arrx.add(t1.getC().x());
				arry.add(t1.getC().y());
				break;
			}
		}
		Collections.sort(arrx);
		Collections.sort(arry);
		Point2D min = new Point2D(arrx.get(0), arry.get(0));
		Point2D max = new Point2D(arrx.get(arrx.size() - 1), arry.get(arry.size() - 1));
		return new Rect2D(min, max);
	}

	/*This method returns a string that represent this Shape_Collection parameters.
	*The format of the string for each GUIShape is:
	*"GUIShape,RGB(color)int,true/false,tag(int),GeoShape name,fields of shape(points/radius,double)".
	*Note- after every GUIShape it's moves to next line.
	*/
	@Override
	public String toString() {
		String strCollection = "";
		for (int i = 0; i < this.arrGEO.size(); i++) {
			strCollection += this.arrGEO.get(i).toString() + "\n";
		}
		return strCollection;
	}
}