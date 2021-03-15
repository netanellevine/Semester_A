package OldTests;

import java.util.Arrays;

public class Mainfor1 {

	public static void main(String[] args) {
//		PointForTest1 p1 = new PointForTest1();
//		PointForTest1 p2 = new PointForTest1(1, 2);
//		PointForTest1 p5 = new PointForTest1(0.3, 2);
//		PointForTest1 p6 = new PointForTest1(1, 2);
//		PointForTest1 p3 = new PointForTest1(1, 54);
//		PointForTest1 p4 = new PointForTest1(7.5, 8);
//		PointForTest1[] p = {p3,p3,p3,p1,p2,p4,p5,p6};
//		PointForTest1.Psort(p);
//        System.out.println(Arrays.toString(p));
		PointForTest1 p1= new PointForTest1(1,0);
		PointForTest1 p2= new PointForTest1(-2,-3.5);
		PointForTest1 p3= new PointForTest1();
		PointForTest1 p4= new PointForTest1(-3,0);
		PointForTest1 p5= new PointForTest1(5,0);
		PointForTest1 p6 = new PointForTest1();
		PointForTest1 p7 = new PointForTest1(1, 2);
		PointForTest1 p8 = new PointForTest1(0.3, 2);
		PointForTest1 p9 = new PointForTest1(1, 2);
		PointForTest1 p10 = new PointForTest1(1, 54);
		PointForTest1 p11 = new PointForTest1(7.5, 8);
		PointForTest1[] p = {p1,p2,p3,p4};
//		PointForTest1.Psort(p);
//        System.out.println(Arrays.toString(p));
		LinkedListPoint ll= new LinkedListPoint();
		ll.add(p1);
		ll.add(p2);
		ll.add(p3);
		ll.add(p4);
		ll.add(p2);
		ll.add(p5);
		ll.add(p2);
//		System.out.println(ll);
		System.out.println(ll +" list size:" +ll.size());
		ll.remove(p2);
		System.out.println(ll +" list size:" +ll.size());
//		ll.add(p1); 
//		System.out.println(ll +" list size:" +ll.size());
//		ll.add(p2); 
//		System.out.println(ll +" list size:" +ll.size());
//		ll.add(p3); 
//		System.out.println(ll +" list size:" +ll.size());
//		ll.add(p4); 
//		System.out.println(ll +" list size:" +ll.size());
		// ll.add(p1); 
		// ll.add(p1); 
		// ll.add(p1);
		// ll.add(p1);
		// ll.add(p1);
		// ll.add(p1);
		// ll.add(p1);
		// ll.add(p1);
		System.out.println("does the list contains p1? "+ ll.contains(p10));
//		ll.remove(p2);
//		ll.remove(null);
//		// ll.remove(p4);
//		// ll.remove(p3);
//		// ll.remove(p2);
//		System.out.println("after removing  2 points: "+ ll);
//		System.out.println("list size:" +ll.size());

	}

}
