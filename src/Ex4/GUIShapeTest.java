package Ex4;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class GUIShapeTest {
	Circle2D c1=new Circle2D("11,22,1");
	Rect2D r5=new Rect2D("4,3,2,1");
	Segment2D s5=new Segment2D("1,3,-3,-3");
	Triangle2D t1=new Triangle2D("5,2,0,2,9,2");
	Point2D p1= new Point2D("1,2");
	GUIShape g1= new GUIShape(c1,true,Color.black,1);
	GUIShape g2= new GUIShape(r5,true,Color.blue,3);
	GUIShape g3= new GUIShape(s5,false,Color.green,0);
	GUIShape g4= new GUIShape(t1,true,Color.red,2);
	GUIShape g5= new GUIShape(p1,true,Color.red,4);

	@Test
	void testGUIShapeGeoShapeBooleanColorInt() {
		assertEquals(g1.toString(),"GUIShape,0,true,1,Circle2D,11.0,22.0, 1.0");
		assertEquals(g2.toString(),"GUIShape,255,true,3,Rect2D,2.0,1.0,4.0,3.0");
	}

	@Test
	void testGUIShapeGUIShape() {
		assertEquals(new GUIShape(g1).toString(),"GUIShape,0,true,1,Circle2D,11.0,22.0, 1.0");
		assertEquals(new GUIShape(g2).toString(),"GUIShape,255,true,3,Rect2D,2.0,1.0,4.0,3.0");
	}

	@Test
	void testGUIShape() {
		assertEquals(new GUIShape().toString(),"GUIShape,255,false,0,Circle2D,0.0,0.0, 1.0");
	}

	@Test
	void testGUIShapeString() {
		GUIShape g6= new GUIShape("GUIShape,255,true,3,Rect2D,2.0,1.0,4.0,3.0");
		assertEquals(g6.toString(),"GUIShape,255,true,3,Rect2D,2.0,1.0,4.0,3.0");
		assertThrows(IllegalArgumentException.class, () -> {new GUIShape("GUIShape,255,0,Rect2D,2.0,1.0,4.0,3.0");});
		assertThrows(IllegalArgumentException.class, () -> {new GUIShape("GUIShape,true,3,Rect2D,2.0,1.0,4.0,3.0");});
		assertThrows(IllegalArgumentException.class, () -> {new GUIShape("GUIShape,255,true,Rect2D,2.0,1.0,4.0,3.0");});
		assertThrows(IllegalArgumentException.class, () -> {new GUIShape("GUIShape,255,true,3,2.0,1.0,4.0,3.0");});
	}

	@Test
	void testGetShape() {
		assertEquals(g1.getShape().toString(),"11.0,22.0, 1.0");
		assertEquals(g2.getShape().toString(),"2.0,1.0,4.0,3.0");
	}

	@Test
	void testSetShape() {
		g1.setShape(t1);
		g2.setShape(c1);
		assertEquals(g1.toString(),"GUIShape,0,true,1,Triangle2D,5.0,2.0,0.0,2.0,9.0,2.0");
		assertEquals(g2.toString(),"GUIShape,255,true,3,Circle2D,11.0,22.0, 1.0");
	}

	@Test
	void testIsFilled() {
		assertTrue(g1.isFilled());
		assertFalse(g3.isFilled());
	}

	@Test
	void testSetFilled() {
		g1.setFilled(false);
		g3.setFilled(true);
		assertTrue(g3.isFilled());
		assertFalse(g1.isFilled());
	}

	@Test
	void testGetColor() {
		assertEquals(g4.getColor(),Color.red);
		assertEquals(g2.getColor(),Color.blue);
	}

	@Test
	void testSetColor() {
		g4.setColor(Color.green);
		g2.setColor(Color.red);
		assertEquals(g2.getColor(),Color.red);
		assertEquals(g4.getColor(),Color.green);
	}

	@Test
	void testGetTag() {
		assertEquals(g2.getTag(),3);
		assertEquals(g4.getTag(),2);
	}

	@Test
	void testSetTag() {
		g4.setTag(3);
		g2.setTag(2);
		assertEquals(g4.getTag(),3);
		assertEquals(g2.getTag(),2);
	}

	@Test
	void testCopy() {
		assertEquals(g3.copy().toString(),g3.toString());
		assertEquals(g2.copy().toString(),g2.toString());
	}

	@Test
	void testToString() {
		assertEquals(g1.toString(),"GUIShape,0,true,1,Circle2D,11.0,22.0, 1.0");
		assertEquals(g5.toString(),"GUIShape,16711680,true,4,Point2D,1.0,2.0");
	}

}
