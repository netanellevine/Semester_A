package Bohan;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
* This class represents a skeleton for the mid-term JUnit (Intro2CS course - Ariel U. CS).
* Please implement a "test" for each functions in the Bohan class. */
class BohanTest {

	@Test
	void testStringArr2Set() {
		String[] s= {"aa","bb","ccc","bb"};
		String[] newS=Bohan.stringArr2Set(s);
		String[] expectedS={"aa","bb","ccc"};
		assertArrayEquals(expectedS, newS);

	}

//	@Test
//	void testMaxMonotoneIncArr() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSumOf2() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testEvenSumProb() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testIntersectionSetSize() {
//		fail("Not yet implemented");
//	}

}
