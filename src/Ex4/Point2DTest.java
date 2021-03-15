package Ex4;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Point2DTest {
	Point2D p1=new Point2D(1,2);
	Point2D p2=new Point2D(7,9.26);
	Point2D p3=new Point2D(new Point2D(0.28,3.57));
	Point2D p4=new Point2D("5.12,5");
	Point2D p5=new Point2D(-12,-2.7);
	@Test
	void testPoint2DDoubleDouble() {
		assertEquals(p1.toString(), "1.0,2.0");
	}

	@Test
	void testPoint2DPoint2D() {
		assertEquals(p3.toString(), "0.28,3.57");
	}

	@Test
	void testPoint2DString() {
		assertEquals(p4.toString(), "5.12,5.0");
		assertThrows(IllegalArgumentException.class, () -> {new Point2D("1^,3");;});
	}

	@Test
	void testX() {
		assertEquals(p4.x(),5.12);
	}

	@Test
	void testY() {
		assertEquals(p2.y(),9.26);
	}

	@Test
	void testIx() {
		assertEquals(p4.ix(),5);
	}

	@Test
	void testIy() {
		assertEquals(p2.iy(),9);
	}

	@Test
	void testAdd() {
		assertEquals(p3.add(p1).toString(),"1.28,5.57");
		assertEquals(p2.add(p5).toString(),"-5.0,6.56");
	}

	@Test
	void testToString() {
		assertEquals(p3.toString(),"0.28,3.57");
		assertEquals(p2.toString(),"7.0,9.26");
	}

	@Test
	void testDistance() {
		assertEquals(p3.distance(),3.5809635574800254);
		assertEquals(p1.distance(),2.23606797749979);
	}

	@Test
	void testDistancePoint2D() {
		assertEquals(p3.distance(p5),13.788085436346845);
		assertEquals(p1.distance(p4),5.09650860884194);
	}

	@Test
	void testEqualsObject() {
		assertFalse(p3.equals(p5));
		assertFalse(p3.equals(null));
		assertFalse(p3.equals(new Rect2D (1,2,3,4)));
		assertTrue(p1.equals(p1));
	}

	@Test
	void testClose2equalsPoint2DDouble() {
		assertFalse(p3.close2equals(p5,0.0001));
		assertTrue(p2.close2equals(p2));
	}

	@Test
	void testClose2equalsPoint2D() {
		assertFalse(p1.close2equals(p4));
		assertTrue(p2.close2equals(p2));
	}

	@Test
	void testVector() {
		assertEquals(p3.vector(p1).toString(),"0.72,-1.5699999999999998");
		assertEquals(p5.vector(p4).toString(),"17.12,7.7");
	}

	@Test
	void testContains() {
		assertFalse(p1.contains(p4));
		assertTrue(p2.contains(new Point2D(7,9.26)));
	}

	@Test
	void testCenterOfMass() {
		assertEquals(p4.centerOfMass().toString(),p4.toString());
		assertEquals(p1.centerOfMass().toString(),p1.toString());
	}

	@Test
	void testArea() {
		assertEquals(p4.area(),0);
		assertEquals(p1.area(),0);
	}

	@Test
	void testPerimeter() {
		assertEquals(p2.perimeter(),0);
		assertEquals(p5.perimeter(),0);
	}

	@Test
	void testMove() {
		p4.move(p1);
		p5.move(p5);
		assertEquals(p4.toString(),"6.12,7.0");
		assertEquals(p5.toString(),"-24.0,-5.4");
	}

	@Test
	void testCopy() {
		assertEquals(p1.copy().toString(), p1.toString());
		assertEquals(p3.copy().toString(), p3.toString());
		assertEquals(p4.copy().toString(), p4.toString());
	}

	@Test
	void testGetPoints() {
		Point2D[] pa = p3.getPoints();
		Point2D[] pa1 = p5.getPoints();
		assertEquals(pa[0].x(),p3.x());
		assertEquals(pa[0].y(),p3.y());
		assertEquals(pa1[0].x(),p5.x());
		assertEquals(pa1[0].y(),p5.y());
	}

}
