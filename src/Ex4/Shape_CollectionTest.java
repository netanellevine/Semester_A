package Ex4;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.awt.Color;

import org.junit.jupiter.api.Test;


class Shape_CollectionTest {
	Circle2D c1=new Circle2D("8,-4,4");
	Rect2D r5 = new Rect2D("4,3,2,1");
	Segment2D s5=new Segment2D("4,-2,10,6");
	Triangle2D t1=new Triangle2D("6,2,10,8,12,2");
	Point2D p1 = new Point2D("1,2");
	GUIShape g1 = new GUIShape(new Circle2D("1,2,3"), true, Color.black, 1);
	GUIShape g2 = new GUIShape(r5, true, Color.blue, 3);
	GUIShape g3 = new GUIShape(s5, false, Color.green, 0);
	GUIShape g4 = new GUIShape(t1, true, Color.red, 2);
	GUIShape g5 = new GUIShape(p1, true, Color.red, 4);
	GUIShape g6 = new GUIShape(c1, false, Color.yellow, 5);
	Shape_Collection s1 = new Shape_Collection();

	@Test
	void testShape_Collection() {
		assertEquals(s1.toString(), "");
	}

	@Test
	void testShape_CollectionShape_Collection() {
		s1.add(g1);
		s1.add(g2);
		s1.add(g3);
		Shape_Collection s2 = new Shape_Collection(s1);
		Shape_Collection s3 = new Shape_Collection(s2);
		assertEquals(s2.toString(), s1.toString());
		assertEquals(s3.toString(), s1.toString());
	}

	@Test
	void testGet() {
		s1.add(g1);
		s1.add(g2);
		s1.add(g3);
		assertEquals(s1.get(2).toString(), g3.toString());
		assertEquals(s1.get(0).toString(), g1.toString());
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {s1.get(-1);});
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {s1.get(3);});
	}

	@Test
	void testSize() {
		s1.add(g1);
		s1.add(g2);
		s1.add(g3);
		assertEquals(s1.size(), 3);
		s1.add(g4);
		assertEquals(s1.size(), 4);
	}

	@Test
	void testRemoveElementAt() {
		s1.add(g1);
		s1.add(g2);
		s1.add(g3);
		String index0 = s1.get(0).toString();
		s1.removeElementAt(0);
		String newIndex0 = s1.get(0).toString();
		assertFalse(newIndex0 == index0);
		s1.add(g1);
		s1.add(g4);
		s1.add(g5);
		String index4 = s1.get(4).toString();
		s1.removeElementAt(3);
		String index3 = s1.get(3).toString();
		assertEquals(index4, index3);
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {s1.removeElementAt(-1);});
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {s1.removeElementAt(5);});
	}

	@Test
	void testAddAt() {
		s1.add(g1);
		s1.add(g2);
		s1.add(g3);
		s1.addAt(g4, 2);
		assertEquals(s1.get(2).toString(), g4.toString());
		s1.addAt(g5, 0);
		assertEquals(s1.get(0).toString(), g5.toString());
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {s1.addAt(g1, -1);});
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {s1.addAt(g2, 6);});
	}

	@Test
	void testAdd() {
		s1.add(g1);
		double size = s1.size();
		s1.add(g2);
		assertFalse(s1.size() == size);
		s1.add(g3);
		String lastIndex = s1.get(s1.size() - 1).toString();
		s1.add(g4);
		assertFalse(s1.get(s1.size() - 1).toString() == lastIndex);
	}

	@Test
	void testCopy() {
		Shape_Collection s2 = new Shape_Collection();
		s2.add(g4);
		s2.add(g5);
		s2.add(g6);
		assertEquals(s1.copy().toString(), s1.toString());
		assertEquals(s2.copy().toString(), s2.toString());
	}

	@Test
	void testSort() {
		s1.add(new GUIShape("GUIShape,255,false,0,Point2D,0.2,0.4"));
		s1.add(new GUIShape("GUIShape,16711680,true,1,Circle2D,0.1,0.2, 0.14"));
		s1.add(new GUIShape("GUIShape,65280,true,2,Rect2D,0.1,0.2,0.5,0.45"));
		s1.add(new GUIShape("GUIShape,65535,false,3,Rect2D,0.1,0.2,0.17,0.77"));
		s1.add(new GUIShape("GUIShape,16762880,false,4,Triangle2D,0.8,0.7,0.3,0.65,0.1,0.1"));
		s1.add(new GUIShape("GUIShape,16756655,false,5,Segment2D,0.2,0.6,0.7,0.2"));
		s1.add(new GUIShape("GUIShape,8421504,false,6,Rect2D,-0.04000000000000001,0.06,0.8,0.77"));

		String strSort_By_Tag = "GUIShape,255,false,0,Point2D,0.2,0.4\n"
				+ "GUIShape,16711680,true,1,Circle2D,0.1,0.2, 0.14\n"
				+ "GUIShape,65280,true,2,Rect2D,0.1,0.2,0.5,0.45\n"
				+ "GUIShape,65535,false,3,Rect2D,0.1,0.2,0.17,0.77\n"
				+ "GUIShape,16762880,false,4,Triangle2D,0.8,0.7,0.3,0.65,0.1,0.1\n"
				+ "GUIShape,16756655,false,5,Segment2D,0.2,0.6,0.7,0.2\n"
				+ "GUIShape,8421504,false,6,Rect2D,-0.04000000000000001,0.06,0.8,0.77\n";
		Shape_Comp comp = new Shape_Comp(0);
		s1.sort(comp);
		assertEquals(s1.toString(), strSort_By_Tag);

		String strSort_By_Anti_Tag = "GUIShape,8421504,false,6,Rect2D,-0.04000000000000001,0.06,0.8,0.77\n"
				+ "GUIShape,16756655,false,5,Segment2D,0.2,0.6,0.7,0.2\n"
				+ "GUIShape,16762880,false,4,Triangle2D,0.8,0.7,0.3,0.65,0.1,0.1\n"
				+ "GUIShape,65535,false,3,Rect2D,0.1,0.2,0.17,0.77\n"
				+ "GUIShape,65280,true,2,Rect2D,0.1,0.2,0.5,0.45\n"
				+ "GUIShape,16711680,true,1,Circle2D,0.1,0.2, 0.14\n" + "GUIShape,255,false,0,Point2D,0.2,0.4\n";
		comp = new Shape_Comp(1);
		s1.sort(comp);
		assertEquals(s1.toString(), strSort_By_Anti_Tag);

		String strSort_By_Area = "GUIShape,16756655,false,5,Segment2D,0.2,0.6,0.7,0.2\n"
				+ "GUIShape,255,false,0,Point2D,0.2,0.4\n" + "GUIShape,65535,false,3,Rect2D,0.1,0.2,0.17,0.77\n"
				+ "GUIShape,16711680,true,1,Circle2D,0.1,0.2, 0.14\n"
				+ "GUIShape,65280,true,2,Rect2D,0.1,0.2,0.5,0.45\n"
				+ "GUIShape,16762880,false,4,Triangle2D,0.8,0.7,0.3,0.65,0.1,0.1\n"
				+ "GUIShape,8421504,false,6,Rect2D,-0.04000000000000001,0.06,0.8,0.77\n";
		comp = new Shape_Comp(2);
		s1.sort(comp);
		assertEquals(s1.toString(), strSort_By_Area);

		String strSort_By_Anti_Area = "GUIShape,8421504,false,6,Rect2D,-0.04000000000000001,0.06,0.8,0.77\n"
				+ "GUIShape,16762880,false,4,Triangle2D,0.8,0.7,0.3,0.65,0.1,0.1\n"
				+ "GUIShape,65280,true,2,Rect2D,0.1,0.2,0.5,0.45\n"
				+ "GUIShape,16711680,true,1,Circle2D,0.1,0.2, 0.14\n"
				+ "GUIShape,65535,false,3,Rect2D,0.1,0.2,0.17,0.77\n"
				+ "GUIShape,16756655,false,5,Segment2D,0.2,0.6,0.7,0.2\n" + "GUIShape,255,false,0,Point2D,0.2,0.4\n";
		comp = new Shape_Comp(3);
		s1.sort(comp);
		assertEquals(s1.toString(), strSort_By_Anti_Area);

		String strSort_By_Perimeter = "GUIShape,255,false,0,Point2D,0.2,0.4\n"
				+ "GUIShape,16711680,true,1,Circle2D,0.1,0.2, 0.14\n"
				+ "GUIShape,65535,false,3,Rect2D,0.1,0.2,0.17,0.77\n"
				+ "GUIShape,16756655,false,5,Segment2D,0.2,0.6,0.7,0.2\n"
				+ "GUIShape,65280,true,2,Rect2D,0.1,0.2,0.5,0.45\n"
				+ "GUIShape,16762880,false,4,Triangle2D,0.8,0.7,0.3,0.65,0.1,0.1\n"
				+ "GUIShape,8421504,false,6,Rect2D,-0.04000000000000001,0.06,0.8,0.77\n";
		comp = new Shape_Comp(4);
		s1.sort(comp);
		assertEquals(s1.toString(), strSort_By_Perimeter);

		String strSort_By_Anti_Perimeter = "GUIShape,8421504,false,6,Rect2D,-0.04000000000000001,0.06,0.8,0.77\n"
				+ "GUIShape,16762880,false,4,Triangle2D,0.8,0.7,0.3,0.65,0.1,0.1\n"
				+ "GUIShape,65280,true,2,Rect2D,0.1,0.2,0.5,0.45\n"
				+ "GUIShape,16756655,false,5,Segment2D,0.2,0.6,0.7,0.2\n"
				+ "GUIShape,65535,false,3,Rect2D,0.1,0.2,0.17,0.77\n"
				+ "GUIShape,16711680,true,1,Circle2D,0.1,0.2, 0.14\n" + "GUIShape,255,false,0,Point2D,0.2,0.4\n";
		comp = new Shape_Comp(5);
		s1.sort(comp);
		assertEquals(s1.toString(), strSort_By_Anti_Perimeter);

		String strSort_By_toString = "GUIShape,16711680,true,1,Circle2D,0.1,0.2, 0.14\n"
				+ "GUIShape,16756655,false,5,Segment2D,0.2,0.6,0.7,0.2\n"
				+ "GUIShape,16762880,false,4,Triangle2D,0.8,0.7,0.3,0.65,0.1,0.1\n"
				+ "GUIShape,255,false,0,Point2D,0.2,0.4\n" + "GUIShape,65280,true,2,Rect2D,0.1,0.2,0.5,0.45\n"
				+ "GUIShape,65535,false,3,Rect2D,0.1,0.2,0.17,0.77\n"
				+ "GUIShape,8421504,false,6,Rect2D,-0.04000000000000001,0.06,0.8,0.77\n";
		comp = new Shape_Comp(6);
		s1.sort(comp);
		assertEquals(s1.toString(), strSort_By_toString);
	}

	@Test
	void testRemoveAll() {
		s1.add(g1);
		s1.add(g2);
		s1.add(g3);
		Shape_Collection s2 = new Shape_Collection();
		s2.add(g4);
		s2.add(g5);
		s2.add(g6);
		s1.removeAll();
		s2.removeAll();
		assertEquals(s1.toString(), "");
		assertEquals(s2.toString(), "");
	}

	@Test
	void testSave() {
		Shape_Collection s2 = new Shape_Collection();
		s1.add(g1);
		s1.save("Shape_Collection_TestSave_File1.txt");
		s2.load("Shape_Collection_TestSave_File1.txt");
		assertEquals(s1.toString(), s2.toString());
		s1.add(g2);
		s1.save("Shape_Collection_TestSave_File2.txt");
		s2.removeAll();
		s2.load("Shape_Collection_TestSave_File2.txt");
		assertEquals(s1.toString(), s2.toString());
		s1.add(g3);
		s1.save("Shape_Collection_TestSave_File3.txt");
		s2.removeAll();
		s2.load("Shape_Collection_TestSave_File3.txt");
		assertEquals(s1.toString(), s2.toString());
	}

	@Test
	void testLoad() {
		s1.removeAll();
		s1.load("Shape_Collection_TestLoad_File1.txt");
		assertEquals(s1.toString(), "GUIShape,0,true,1,Circle2D,1.0,2.0, 3.0\n");
		s1.removeAll();
		s1.load("Shape_Collection_TestLoad_File2.txt");
		assertEquals(s1.toString(),
				"GUIShape,0,true,1,Circle2D,1.0,2.0, 3.0\n" + "GUIShape,255,true,3,Rect2D,2.0,1.0,4.0,3.0\n");
		s1.removeAll();
		s1.load("Shape_Collection_TestLoad_File3.txt");
		assertEquals(s1.toString(),
				"GUIShape,0,true,1,Circle2D,1.0,2.0, 3.0\n" + "GUIShape,255,true,3,Rect2D,2.0,1.0,4.0,3.0\n"
						+ "GUIShape,65280,false,0,Segment2D,1.0,3.0,-1.0,-3.0\n");

	}

	@Test
	void testGetBoundingBox() {
		s1.removeAll();
		s1.add(g3);
		s1.add(g4);
		s1.add(g6);
		assertEquals(s1.getBoundingBox().toString(), "4.0,-8.0,12.0,8.0");
		s1.removeAll();
		s1.add(new GUIShape("GUIShape,255,true,0,Circle2D,-10,-5,10"));
		s1.add(new GUIShape("GUIShape,65535,true,1,Circle2D,5,-2.5,7.5"));
		s1.add(new GUIShape("GUIShape,16711680,false,2,Triangle2D,-15,0,-5,10,-5,-15"));
		s1.add(new GUIShape("GUIShape,0,false,3,Point2D,-1.7,1.8"));
		s1.add(new GUIShape("GUIShape,8421504,false,4,Rect2D,-9.918,-7.465,10,2.95"));
		s1.add(new GUIShape("GUIShape,255,true,5,Segment2D,0,-5,-10,10"));
		assertEquals(s1.getBoundingBox().toString(), "-20.0,-15.0,12.5,10.0");
		s1.removeAll();
		s1.add(new GUIShape("GUIShape,16756655,true,0,Circle2D,-7.45,-27.28,12.32"));
		s1.add(new GUIShape("GUIShape,255,true,1,Segment2D,-13,-21,10,-20"));
		s1.add(new GUIShape("GUIShape,0,false,2,Point2D,-28.17,-12"));
		assertEquals(s1.getBoundingBox().toString(), "-28.17,-39.6,10.0,-12.0");

	}

	@Test
	void testToString() {
		s1.add(g1);
		s1.add(g2);
		s1.add(g3);
		String strS1 = g1.toString() + "\n" + g2.toString() + "\n" + g3.toString() + "\n";
		Shape_Collection s2 = new Shape_Collection();
		s2.add(g4);
		s2.add(g5);
		s2.add(g6);
		String strS2 = g4.toString() + "\n" + g5.toString() + "\n" + g6.toString() + "\n";
		assertEquals(s1.toString(), strS1);
		assertEquals(s2.toString(), strS2);
	}

}
