package Ex4;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Triangle2DTest {
	Point2D a1 = new Point2D(1, 2);
	Point2D b1 = new Point2D(4, 7);
	Point2D c1 = new Point2D(0, 0);
	Point2D a2 = new Point2D(-0.2, 0.1);
	Point2D b2 = new Point2D(-8.76, 9);
	Point2D c2 = new Point2D(-6, -6);
	Point2D[] arrp = { a1, a2, c1 };
	Triangle2D t1 = new Triangle2D(a1, b1, c1);
	Triangle2D t2 = new Triangle2D(0, 0, 6, 6, -6, 6);
	Triangle2D t3 = new Triangle2D("3,6,3,2,3,9");
	Triangle2D t4 = new Triangle2D(a2, b2, c2);
	Triangle2D t5 = new Triangle2D("0.01,2.32,5.21,0,7,8.29");
	Triangle2D t6 = new Triangle2D(arrp);
	Triangle2D t7 = new Triangle2D(1, 2, 1, 2, 1, 2);

	@Test
	void testTriangle2DPoint2DPoint2DPoint2D() {
		assertEquals(t1.toString(), "1.0,2.0,4.0,7.0,0.0,0.0");
	}

	@Test
	void testTriangle2DDoubleDoubleDoubleDoubleDoubleDouble() {
		assertEquals(t2.toString(), "0.0,0.0,6.0,6.0,-6.0,6.0");
	}

	@Test
	void testTriangle2DString() {
		assertEquals(t3.toString(), "3.0,6.0,3.0,2.0,3.0,9.0");
		assertThrows(IllegalArgumentException.class, () -> {new Triangle2D("3,6,3,2,3,9,7");});
		assertThrows(IllegalArgumentException.class, () -> {new Triangle2D("3,6,@3,2,3,9");});
	}

	@Test
	void testTriangle2DPoint2DArray() {
		assertEquals(t6.toString(), "1.0,2.0,-0.2,0.1,0.0,0.0");
	}
	@Test
	void testTriangle2DTriangle2D() {
		assertEquals(new Triangle2D(t6).toString(), t6.toString());
	}
	@Test
	void testContains() {
		assertFalse(t1.contains(new Point2D(0.9332853559609, 1.8667494580455)));
		assertTrue(t1.contains(new Point2D(1, 1.8)));
		assertFalse(t7.contains(new Point2D(1.000001, 2)));
		assertTrue(t7.contains(new Point2D(1, 2)));
		assertFalse(t3.contains(new Point2D(3.000000001, 2.000000001)));
		assertTrue(t3.contains(new Point2D(3, 5)));
	}

	@Test
	void testCenterOfMass() {
		assertEquals(t1.centerOfMass(), new Point2D(1.6666666666666667, 3));
		assertEquals(t3.centerOfMass(), new Point2D(3, 5.666666666666667));
		assertEquals(t5.centerOfMass(), new Point2D(4.07333333333333333, 3.5366666666666666));
		assertEquals(t7.centerOfMass(), new Point2D(1, 2));
	}

	@Test
	void testArea() {
		assertEquals(t1.area(), 0.5);
		assertEquals(t6.area(), 0.25);
		assertEquals(t3.area(), 0);
		assertEquals(t5.area(), 23.630399999999995);
	}

	@Test
	void testGetA() {
		assertEquals(t6.getA().toString(), "1.0,2.0");
	}

	@Test
	void testSetA() {
		t1.setA(a2);
		assertEquals(t1.getA().toString(), "-0.2,0.1");
	}

	@Test
	void testGetB() {
		assertEquals(t6.getB().toString(), "-0.2,0.1");
	}

	@Test
	void testSetB() {
		t1.setB(c2);
		assertEquals(t1.getB().toString(), "-6.0,-6.0");

	}

	@Test
	void testGetC() {
		assertEquals(t6.getC().toString(), "0.0,0.0");
	}

	@Test
	void testSetC() {
		t1.setC(b2);
		assertEquals(t1.getC().toString(), "-8.76,9.0");
	}

	@Test
	void testPerimeter() {
		assertEquals(t1.perimeter(), 16.12927762064364);
		assertEquals(t6.perimeter(), 4.706895280674193);
		assertEquals(t3.perimeter(), 14);
		assertEquals(t5.perimeter(), 23.36755909922369);
	}

	@Test
	void testMove() {
		t1.move(c1);
		assertEquals(t1.toString(), "1.0,2.0,4.0,7.0,0.0,0.0");
		t6.move(b2);
		assertEquals(t6.toString(), "-7.76,11.0,-8.959999999999999,9.1,-8.76,9.0");
		t5.move(a1);
		assertEquals(t5.toString(), "1.01,4.32,6.21,2.0,8.0,10.29");
	}

	@Test
	void testCopy() {
		assertEquals(t1.copy().toString(), t1.toString());
		assertEquals(t3.copy().toString(), t3.toString());
		assertEquals(t6.copy().toString(), t6.toString());
	}

	@Test
	void testGetPoints() {
		Point2D[] ta = t3.getPoints();
		Point2D[] ta1 = t5.getPoints();
		assertEquals(new Triangle2D(ta).toString(), t3.toString());
		assertEquals(new Triangle2D(ta1).toString(), t5.toString());
	}

	@Test
	void testToString() {
		assertEquals(t2.toString(), "0.0,0.0,6.0,6.0,-6.0,6.0");
		assertEquals(t1.toString(), "1.0,2.0,4.0,7.0,0.0,0.0");
	}

}
