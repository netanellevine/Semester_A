package Ex4;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Circle2DTest {
	Point2D p1=new Point2D(0,0);
	Point2D p2=new Point2D(-8,9);
	Point2D p3=new Point2D(0.23,1.7);
	Point2D p4=new Point2D(2,2);
	Point2D[] pa= {p2,p3};
	Circle2D c1= new Circle2D(p1,1);
	Circle2D c2=new Circle2D(0,3,3);
	Circle2D c3=new Circle2D("5,6,9");
	Circle2D c4=new Circle2D(pa);
	Circle2D c5=new Circle2D(c3);
	
	@Test
	void testCircle2DPoint2DDouble() {
		assertEquals(c1.toString(), "0.0,0.0, 1.0");
		assertThrows(IllegalArgumentException.class, () -> {new Circle2D(p1,-3);;});
	}

	@Test
	void testCircle2DDoubleDoubleDouble() {
		assertEquals(c1.toString(), "0.0,0.0, 1.0");
		assertThrows(IllegalArgumentException.class, () -> {new Circle2D(1,2,-1);;});
	}

	@Test
	void testCircle2DString() {
		assertEquals(c3.toString(), "5.0,6.0, 9.0");
		assertThrows(IllegalArgumentException.class, () -> {new Circle2D("1,2,3,4");});
		assertThrows(IllegalArgumentException.class, () -> {new Circle2D("1,2$,3");});
		assertThrows(IllegalArgumentException.class, () -> {new Circle2D("1,2,-8");});
	}

	@Test
	void testCircle2DCircle2D() {
		assertEquals(c5.toString(), "5.0,6.0, 9.0");
		assertThrows(IllegalArgumentException.class, () -> {new Circle2D(c5).setRadius(-2);;;});
	}

	@Test
	void testCircle2DPoint2DArray() {
		assertEquals(c4.toString(), "-8.0,9.0, 11.001040859845943");
	}
	
	@Test
	void isRadiusOkDouble() {
		assertEquals(c5.getRadius(), 9);
		assertEquals(c4.getRadius(), 11.001040859845943);
		assertThrows(IllegalArgumentException.class, () -> {new Circle2D("1,2,-3");});
		assertThrows(IllegalArgumentException.class, () -> {new Circle2D("1,2,-27");});
	}
	@Test
	void testGetRadius() {
		assertEquals(c1.getRadius(), 1);
		assertEquals(c3.getRadius(), 9);
	}

	@Test
	void testGetCenter() {
		assertEquals(c1.getCenter().toString(), "0.0,0.0");
		assertEquals(c5.getCenter().toString(), "5.0,6.0");
	}
	
	@Test
	void testSetRadius() {
		c1.setRadius(5);
		c3.setRadius(0);
		assertEquals(c1.getRadius(),5);
		assertEquals(c3.getRadius(),0);
		assertThrows(IllegalArgumentException.class, () -> {c2.setRadius(-5);});
	}

	@Test
	void testSetCenter() {
		c1.setCenter(p3);
		c3.setCenter(p2);
		assertEquals(c1.getCenter().toString(), "0.23,1.7");
		assertEquals(c3.getCenter().toString(), "-8.0,9.0");
	}
	@Test
	void testToString() {
		assertEquals(c4.toString(), "-8.0,9.0, 11.001040859845943");
		assertEquals(c2.toString(), "0.0,3.0, 3.0");
	}

	@Test
	void testContains() {
		assertFalse(c1.contains(new Point2D(1.000001, 1.000001)));
		assertTrue(c1.contains(new Point2D(0.0001, 0.0001)));
		assertTrue(c2.contains(new Point2D(2.89013, 2.19555)));
		assertFalse(c2.contains(new Point2D(2.88989898, 2.19452312)));
		assertTrue(c3.contains(new Point2D(-0.950205, -0.75241)));
		assertFalse(c3.contains(new Point2D(-0.950215, -0.752405)));
	}

	@Test
	void testCenterOfMass() {
		assertEquals(c1.centerOfMass(), c1.getCenter());
		assertEquals(c5.centerOfMass(), c5.getCenter());
	}

	@Test
	void testArea() {
		assertEquals(c1.area(), Math.PI);
		assertEquals(c2.area(),28.274333882308138);
		assertEquals(c3.area(), 254.46900494077323);
	}

	@Test
	void testPerimeter() {
		assertEquals(c1.perimeter(),Math.PI*2);
		assertEquals(c2.perimeter(), 18.84955592153876);
		assertEquals(c3.perimeter(), 56.548667764616276);
	}

	@Test
	void testMove() {
		c3.move(new Point2D(2, 2));
		assertEquals(c3.toString(),"7.0,8.0, 9.0");
		c5.move(new Point2D(0, 0));
		assertEquals(c5.toString(),"5.0,6.0, 9.0");
		c1.move(new Point2D(-3, -6));
		assertEquals(c1.toString(),"-3.0,-6.0, 1.0");
	}

	@Test
	void testCopy() {
		assertEquals(c1.copy().toString(), c1.toString());
		assertEquals(c3.copy().toString(), c3.toString());
		assertEquals(c4.copy().toString(), c4.toString());
	}

	@Test
	void testGetPoints() {
		Point2D[] sa = c3.getPoints();
		Point2D[] sa1 = c1.getPoints();
		assertEquals(new Segment2D(sa).toString(),"5.0,6.0,5.0,15.0");
		assertEquals(new Segment2D(sa1).toString(),"0.0,0.0,0.0,1.0");
	}

}
