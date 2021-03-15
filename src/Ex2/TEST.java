package Ex2;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Ex2Test {
	static double[] po1={2,0,3, -1,0}, 
			po2 = {0.1,0,1, 0.1,3};
	static final double EPS = 0.0001;

	@Test
	void testF() {
		double fx0 = Ex2.f(po1, 0);
		double fx1 = Ex2.f(po1, 1);
		double fx2 = Ex2.f(po1, 2);
		assertEquals(fx0,2);
		assertEquals(fx1,4);
		assertEquals(fx2,6);
	}

//	@Test
//	void testRoot() {
//		double x12 = Ex2.root_itertive(po1, 0, 10, EPS);
//		assertEquals(x12, 3.1958, 0.001);
//	}

	@Test
	void testDerivativeArrayDoubleArray() {
		double[] p = {1,2,3}; // 3X^2+2x+1
		double[] dp1 = {2,6}; // 6x+2
		double[] dp2 = Ex2.derivative(p);
		assertEquals(dp1[0], dp2[0],EPS);
		assertEquals(dp1[1], dp2[1],EPS);
		assertEquals(dp1.length, dp2.length);
	}
}
