package Ex4;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Rect2DTest {
	Point2D p1 = new Point2D("0,0");
	Point2D p2 = new Point2D("1,1");
	Point2D p3 = new Point2D("2,6");
	Point2D p4 = new Point2D("-8,0.62");
	Point2D p5 = new Point2D("0.23,-0.87");
	Point2D[] pa = { p3, p4 };
	Rect2D r1 = new Rect2D(p1, p2);
	Rect2D r2 = new Rect2D(1, 2, 3, 4);
	Rect2D r3 = new Rect2D(new Segment2D(p1, p2));
	Rect2D r4 = new Rect2D("9,8,7,6");
	Rect2D r5 = new Rect2D(new Rect2D("0.1,8,0.4,2"));
	Rect2D r6 = new Rect2D(pa);
	Rect2D r7 = new Rect2D(1, 2, 1, 2);
	Rect2D r8 = new Rect2D(3, 4, 9, 4);

	@Test
	void testRect2DPoint2DPoint2D() {
		assertEquals(r1.toString(), "0.0,0.0,1.0,1.0");
	}

	@Test
	void testRect2DDoubleDoubleDoubleDouble() {
		assertEquals(r2.toString(), "1.0,2.0,3.0,4.0");
	}

	@Test
	void testRect2DSegment2D() {
		assertEquals(r3.toString(), "0.0,0.0,1.0,1.0");
	}

	@Test
	void testRect2DString() {
		assertEquals(r4.toString(), "7.0,6.0,9.0,8.0");
		assertThrows(IllegalArgumentException.class, () -> {new Rect2D("1,2,3,4,5");});
		assertThrows(IllegalArgumentException.class, () -> {new Rect2D("1,2,3&,4");});
	}

	@Test
	void testRect2DRect2D() {
		assertEquals(r5.toString(), "0.1,8.0,0.4,2.0");
	}

	@Test
	void testRect2DPoint2DArray() {
		assertEquals(r6.toString(), "-8.0,0.62,2.0,6.0");
	}

	@Test
	void testGetDownLeft() {
		assertEquals(r2.getDownLeft().toString(), "1.0,2.0");
	}

	@Test
	void testSetDownLeft() {
		r2.setDownLeft(p5);
		assertEquals(r2.toString(), "0.23,-0.87,3.0,4.0");
	}

	@Test
	void testGetTopRight() {
		assertEquals(r2.getTopRight().toString(), "3.0,4.0");
	}

	@Test
	void testSetTopRight() {
		r2.setTopRight(p5);
		assertEquals(r2.toString(), "0.23,-0.87,1.0,2.0");
	}

	@Test
	void testContains() {
		assertFalse(r1.contains(new Point2D(1.000001, 1.000001)));
		assertTrue(r1.contains(new Point2D(0.2, 0.7)));
		assertTrue(r1.contains(new Point2D(1, 1)));
		assertFalse(r7.contains(new Point2D(-0.5, -2)));
		assertTrue(r7.contains(new Point2D(1, 2)));
		assertFalse(r8.contains(new Point2D(0, -1.12)));
		assertTrue(r8.contains(new Point2D(6.22, 4)));
	}

	@Test
	void testCenterOfMass() {
		assertEquals(r1.centerOfMass(), new Point2D(0.5, 0.5));
		assertEquals(r5.centerOfMass(), new Point2D(0.25, 5));
		assertEquals(r6.centerOfMass(), new Point2D(-3, 3.31));
		assertEquals(r7.centerOfMass(), new Point2D(1, 2));
	}

	@Test
	void testArea() {
		assertEquals(r1.area(), 1);
		assertEquals(r6.area(), 53.8);
		assertEquals(r7.area(), 0);
		assertEquals(r8.area(), 0);
	}

	@Test
	void testPerimeter() {
		assertEquals(r1.perimeter(), 4);
		assertEquals(r6.perimeter(), 30.759999999999998);
		assertEquals(r7.perimeter(), 0);
		assertEquals(r8.perimeter(), 12);
	}

	@Test
	void testMove() {
		r1.move(new Point2D(2, 2));
		assertEquals(r1.toString(), "2.0,2.0,3.0,3.0");
		r6.move(new Point2D(0, 0));
		assertEquals(r6.toString(), "-8.0,0.62,2.0,6.0");
		r5.move(new Point2D(-3, -6));
		assertEquals(r5.toString(), "-2.9,2.0,-2.6,-4.0");
	}

	@Test
	void testCopy() {
		assertEquals(r1.copy().toString(), r1.toString());
		assertEquals(r3.copy().toString(), r3.toString());
		assertEquals(r6.copy().toString(), r6.toString());
	}

	@Test
	void testGetPoints() {
		Point2D[] ra = r3.getPoints();
		Point2D[] ra1 = r5.getPoints();
		assertEquals(new Segment2D(ra).toString(), r3.toString());
		assertEquals(new Segment2D(ra1).toString(), r5.toString());
	}

	@Test
	void testToString() {
		assertEquals(r2.toString(), "1.0,2.0,3.0,4.0");
		assertEquals(r1.toString(), "0.0,0.0,1.0,1.0");
	}

}
