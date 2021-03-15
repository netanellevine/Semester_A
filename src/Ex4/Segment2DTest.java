package Ex4;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Segment2DTest {
	double eps = 0.000001;
	Point2D p1 = new Point2D(1, 2);
	Point2D p2 = new Point2D(3, 4);
	Segment2D s0 = new Segment2D(p1, p2);
	Segment2D s1 = new Segment2D(1, 2, 3, 4);
	Segment2D s2 = new Segment2D(s0);
	Segment2D s3 = new Segment2D(7, 5, 7, 5);
	Segment2D s4 = new Segment2D(2, 4, -6, -8);
	Segment2D s5 = new Segment2D(5, -2, -9, 0);
	Segment2D s6 = new Segment2D(12.393, 1.279, 3, -8.272);

	@Test
	void testSegment2DPoint2DPoint2D() {
		assertEquals(s0.toString(), new Segment2D(p1, p2).toString());
	}

	@Test
	void testSegment2DDoubleDoubleDoubleDouble() {
		assertEquals(s1.toString(), new Segment2D(p1, p2).toString());
	}

	@Test
	void testSegment2DSegment2D() {
		assertEquals(s2.toString(), new Segment2D(p1, p2).toString());
	}

	@Test
	void testSegment2DString() {
		assertEquals(new Segment2D("1,2,3,4").toString(), "1.0,2.0,3.0,4.0");
		assertThrows(IllegalArgumentException.class, () -> {new Segment2D("1,2,3,4,5");});
		assertThrows(IllegalArgumentException.class, () -> {new Segment2D("1,2,3&,4");});
	}

	void testSegment2DPoint2DArray() {
		Point2D[] sp1 = s4.getPoints();
		assertEquals(new Segment2D(sp1).toString(), "2.0,4.0,-6.0,-8.0");
	}

	@Test
	void testContains() {
		assertFalse(s1.contains(new Point2D(2, 6)));
		assertTrue(s3.contains(new Point2D(7, 5)));
		assertFalse(s2.contains(new Point2D(-0.5, -2)));
		assertTrue(s2.contains(new Point2D(2, 3)));
		assertFalse(s3.contains(new Point2D(0, -1.12)));
		assertTrue(s5.contains(new Point2D(-9, 0)));
	}

	@Test
	void testCenterOfMass() {
		assertEquals(s0.centerOfMass(), new Point2D(2, 3));
		assertEquals(s3.centerOfMass(), new Point2D(7, 5));
		assertEquals(s5.centerOfMass(), new Point2D(-2, -1));
		assertEquals(s4.centerOfMass(), new Point2D(-2, -2));
	}

	@Test
	void testArea() {
		assertEquals(s1.area(), 0);
		assertEquals(s2.area(), 0);
	}

	@Test
	void testPerimeter() {
		assertEquals(s3.perimeter(), 0);
		assertEquals(s1.perimeter(), 5.6568542494924, eps);
		assertEquals(s4.perimeter(), 28.844410203711913, eps);
		assertEquals(s5.perimeter(), 28.284271247462, eps);

	}

	@Test
	void testMove() {

		s3.move(new Point2D(2, 2));
		assertEquals(s3.toString(), new Segment2D(9, 7, 9, 7).toString());
		s4.move(new Point2D(0, 0));
		assertEquals(s4.toString(), new Segment2D(2, 4, -6, -8).toString());
		s6.move(new Point2D(-3, -6));
		assertEquals(s6.toString(), new Segment2D(9.393, -4.721, 0, -14.272).toString());
	}

	@Test
	void testCopy() {
		assertEquals(s1.copy().toString(), s1.toString());
		assertEquals(s3.copy().toString(), s3.toString());
		assertEquals(s6.copy().toString(), s6.toString());
	}

	@Test
	void testGetPoints() {
		Point2D[] sa = s3.getPoints();
		Point2D[] sa1 = s5.getPoints();
		assertEquals(new Segment2D(sa).toString(), s3.toString());
		assertEquals(new Segment2D(sa1).toString(), s5.toString());
	}

	@Test
	void testToString() {
		assertEquals(s1.toString(), "1.0,2.0,3.0,4.0");
		assertEquals(s5.toString(), "5.0,-2.0,-9.0,0.0");
	}

	@Test
	void testGet_p1() {
		assertEquals(s1.get_p1().toString(), "1.0,2.0");
		assertEquals(s5.get_p1().toString(), "5.0,-2.0");
	}

	@Test
	void testSet_p1() {
		s1.set_p1(p2);
		s5.set_p1(p1);
		assertEquals(s1.toString(), "3.0,4.0,3.0,4.0");
		assertEquals(s5.toString(), "1.0,2.0,-9.0,0.0");
	}

	@Test
	void testGet_p2() {
		assertEquals(s1.get_p2().toString(), "3.0,4.0");
		assertEquals(s5.get_p2().toString(), "-9.0,0.0");
	}

	@Test
	void testSet_p2() {
		s1.set_p2(p1);
		s5.set_p2(p2);
		assertEquals(s1.toString(), "1.0,2.0,1.0,2.0");
		assertEquals(s5.toString(), "5.0,-2.0,3.0,4.0");
	}

}
