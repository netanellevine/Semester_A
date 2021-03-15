package Ex3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Ex3Test {
	// @author Netanel Levine
	// ID 312512619
	
	public static String myID() {
		return "312512619";
	}
	
	
	@Test
	void testMoveCharToLast() {
		String in = "hello world, let's go!";
		String out = "heo word, et's go!llll";
		assertTrue(out.equals(Ex3.moveCharToLast(in,'l')));
		in = "&hi&hi&";
		out = "hihi&&&";
		assertTrue(out.equals(Ex3.moveCharToLast(in,'&')));
		in = "abababaaaababa  ababaa";
		out = "aaaaaaaaa  aaaabbbbbbb";
		assertTrue(out.equals(Ex3.moveCharToLast(in,'b')));
		in = "&hello&";
		out = "&hello&";
		assertTrue(out.equals(Ex3.moveCharToLast(in,'a')));
		in = "";
		out = "";
		assertTrue(out.equals(Ex3.moveCharToLast(in,'l')));
		in = "hello        world";
		out = "helloworld        ";
		assertTrue(out.equals(Ex3.moveCharToLast(in,' ')));
	}
	
	@Test
	void testReduce() {
		String in = "aaabbccccxxxyzz";
		String out = "abcxyz";
		assertTrue(out.equals(Ex3.reduce(in)));
		in = "lkfgjkdgafsdfgbdgj";
		out = in;
		assertTrue(out.equals(Ex3.reduce(in)));
		in = "";
		out = "";
		assertTrue(out.equals(Ex3.reduce(in)));
		in = "aaaaaa bbab abccaa";
		out = "a bab abca";
		assertTrue(out.equals(Ex3.reduce(in)));
		in = "h";
		out = in;
		assertTrue(out.equals(Ex3.reduce(in)));
		in = "hello        world";
		out = "helo world";
		assertTrue(out.equals(Ex3.reduce(in)));
	}
	
	@Test
	void testMySplit() {
		assertEquals(Ex3.mySplit(new int[] {1,2,3,4,5,6,7,8,9}),false);
		assertEquals(Ex3.mySplit(new int[] {0,0,0,0,0,0,0}),true);
		assertEquals(Ex3.mySplit(new int[] {0,0,0,0,0,0,1}),false);
		assertEquals(Ex3.mySplit(new int[] {2,4,2,6,-14}),true);
		assertEquals(Ex3.mySplit(new int[] {5,21,8,15,7}),true);
		assertEquals(Ex3.mySplit(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}),true);
		assertEquals(Ex3.mySplit(new int[] {15,10,5,25,10}),false);
		assertEquals(Ex3.mySplit(new int[] {15,8,7,3,9,10,2}),true);
		assertEquals(Ex3.mySplit(new int[] {3,5,15,3,30,20,21,27,12}),false);
		assertEquals(Ex3.mySplit(new int[] {5,10,15,20,25,30,50,100,27,99,27009,25000,555,444,3,978,335,2000,2,460,43}),true);
	}
	
	@Test
	void testSumOfNeighbours() {
		int[][] mat1 = {{3,5,7,5},{-4,2,10,11},{9,-50,3,60}};
		int[][] matOut1 = {{3,18,33,28},{-31,-17,43,85},{-52,20,33,24}};
		assertTrue(Arrays.deepEquals(Ex3.sumOfNeighbours(mat1), matOut1));;		
		int[][] mat2 = {{14,-2,0,14,-4},{-1,3,13,-7,2},{-3,3,5,12,0},{10,-4,8,1,-5},{0,13,-4,6,-6}};
		int[][] matOut2 = {{0,29,21,4,9},{15,29,28,42,15},{11,31,29,17,3},{9,32,32,16,13},{19,10,24,-6,2}};
		assertTrue(Arrays.deepEquals(Ex3.sumOfNeighbours(mat2), matOut2));;
		int[][] mat3 = {{25,0,-5,13,-8,1,24,9,21,12},{6,14,22,5,-6,17,13,4,29,1},{15,-7,-6,2,-9,-1,23,-5,19,27},
				{2,-8,8,29,23,22,15,15,20,16},{3,-8,-7,14,29,26,1,11,2,2},{15,2,12,11,12,29,8,6,2,9},{5,3,28,23,9,22,12,3,20,-6},
				{8,15,-8,9,16,7,-8,11,14,1},{-8,-8,14,-10,28,-9,2,0,22,9},{10,19,24,-6,13,0,12,5,10,20}};
		int[][] matOut3 = {{20,62,54,8,30,40,44,91,55,51},{47,50,16,3,20,37,72,133,88,108},{7,53,65,66,91,98,80,138,107,85},
				{-5,0,9,54,112,107,92,86,87,70},{3,27,60,117,166,139,132,69,81,49},{5,51,66,120,163,119,110,59,47,20},
				{43,77,67,89,129,85,78,65,40,46},{7,34,74,100,79,72,48,65,60,59},{44,74,35,90,20,70,18,68,70,67},{3,32,9,69,3,46,-2,46,56,41}};
		assertTrue(Arrays.deepEquals(Ex3.sumOfNeighbours(mat3), matOut3));;		
		int[][] mat4 = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		int[][] matOut4 = {{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		assertTrue(Arrays.deepEquals(Ex3.sumOfNeighbours(mat4), matOut4));;		
		int[][] mat5 = {{0,0,0,0},{1,0,0,0},{0,0,0,0},{0,0,0,1}};
		int[][] matOut5 = {{1,1,0,0},{0,1,0,0},{1,1,1,1},{0,0,1,0}};
		assertTrue(Arrays.deepEquals(Ex3.sumOfNeighbours(mat5), matOut5));;	
		int[][] mat6 = {{0,0,0,0},{0,0,0,0},{0,0,0,1}};
		int[][] matOut6 = {{0,0,0,0},{0,0,1,1},{0,0,1,0}};
		assertTrue(Arrays.deepEquals(Ex3.sumOfNeighbours(mat6), matOut6));;

	}
	
	@Test
	void testCaesarCipherText() {
		String in = "abcdefghijklmnopqrstuvwxyz";
		String out = "efghijklmnopqrstuvwxyzabcd";
		assertTrue(out.equals(Ex3.caesarCipherText(in, 4)));
		assertTrue(in.equals(Ex3.caesarCipherText(Ex3.caesarCipherText(in, 4),-4)));
		in = "defend the east wall of the castle";
		out = "efgfoe uif fbtu xbmm pg uif dbtumf";
		assertTrue(out.equals(Ex3.caesarCipherText(in, 1)));
		assertTrue(in.equals(Ex3.caesarCipherText(Ex3.caesarCipherText(in, 1),-1)));
		in = "defend the east wall of the castle";
		out = "cdedmc sgd dzrs vzkk ne sgd bzrskd";
		assertTrue(out.equals(Ex3.caesarCipherText(in, -1)));
		assertTrue(in.equals(Ex3.caesarCipherText(Ex3.caesarCipherText(in, -1),1)));
		in = "defend the east wall of the castle";
		out = in;
		assertTrue(out.equals(Ex3.caesarCipherText(in, 26)));
		assertTrue(in.equals(Ex3.caesarCipherText(Ex3.caesarCipherText(in, 26),-26)));
		in = "abcdefghijklmnopqrstuvwxyz";
		out = "uvwxyzabcdefghijklmnopqrst";
		assertTrue(out.equals(Ex3.caesarCipherText(in, 20)));
		assertTrue(in.equals(Ex3.caesarCipherText(Ex3.caesarCipherText(in, 20),-20))); //reverse in -20
		in = "abcdefghijklmnopqrstuvwxyz";
		out = "uvwxyzabcdefghijklmnopqrst";
		assertTrue(out.equals(Ex3.caesarCipherText(in, 20)));
		assertTrue(in.equals(Ex3.caesarCipherText(Ex3.caesarCipherText(in, 20),6))); //reverse in 6 gives the same as -20
	}
	
	@Test
	void testVigenereCipherText() {
		String in = "a simple example";
		String out = "a zqqkpq rqaowti";
		assertTrue(out.equals(Ex3.vigenereCipherText(in, "achievement")));
		in = "impressive student from ariel university";
		out = "pacfvzgvjv ggiulbg wycz rywrz bbvjvygvhp";
		assertTrue(out.equals(Ex3.vigenereCipherText(in, "honor")));
		in = "test";
		out = "test";
		assertTrue(out.equals(Ex3.vigenereCipherText(in, "a")));
		in = "defend the east wall of the castle";
		out = "vkuwts zww tsyi cpdr gl lnt ipkzaw";
		assertTrue(out.equals(Ex3.vigenereCipherText(in, "sgp")));
		in = "defend the east wall of the castle";
		out = "vyuief epj egae ottn lu tsm qcahfw";
		assertTrue(out.equals(Ex3.vigenereCipherText(in, "supercalifragilisticexpialidocious")));
		in = "impressive student from ariel university";
		out = "";
		assertTrue(out.equals(Ex3.vigenereCipherText(in, "A *")));
	}
	
	@Test
	void testVigenereDecipherText() {
		String in = "a simple example";
		String key = "achievement";
		assertTrue(in.equals(Ex3.vigenereDecipherText(Ex3.vigenereCipherText(in,key),key)));	
		in = "defend the east wall of the castle";
		key = "sgp";
		assertTrue(in.equals(Ex3.vigenereDecipherText(Ex3.vigenereCipherText(in,key),key)));	
		in = "defend the east wall of the castle";
		key = "supercalifragilisticexpialidocious";
		assertTrue(in.equals(Ex3.vigenereDecipherText(Ex3.vigenereCipherText(in,key),key)));	
		in = "impressive student from ariel university";
		key = "honor";
		assertTrue(in.equals(Ex3.vigenereDecipherText(Ex3.vigenereCipherText(in,key),key)));	
		in = "test";
		key = "a";
		assertTrue(in.equals(Ex3.vigenereDecipherText(Ex3.vigenereCipherText(in,key),key)));	

	}

}
