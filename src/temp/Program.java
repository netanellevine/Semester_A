package temp;
public class Program {

	public static void main(String[] args) {
		PointContainer pt = new PointContainer();
		System.out.println(pt.toString());
		System.out.println("Size: " + pt.getSize() + ", capacity: " + pt.getCapacity());
		pt.remove(new Point(1,1));
		pt.add(new Point(1,1));
		pt.add(new Point(2,1));
		pt.add(new Point(3,1));
		pt.add(new Point(1,2));
		pt.add(new Point(1,3));
		pt.add(new Point(1,4));
		pt.add(new Point(1,5));
		System.out.println(pt.toString());
		System.out.println("Size: " + pt.getSize() + ", capacity: " + pt.getCapacity());
		Point p = pt.get(1);
		System.out.println("At index 1, the point is: " + p);
		pt.set(new Point(-2,-2), 1);
		System.out.println(pt.toString());
		
		pt.remove(new Point(1,1));
		System.out.println(pt.toString());
		pt.remove(new Point(1,4));
		System.out.println(pt.toString());
		pt.remove(new Point(1,2));
		System.out.println(pt.toString());
		pt.remove(new Point(1,2));
		System.out.println(pt.toString());
		pt.remove(new Point(1,5));
		System.out.println(pt.toString());
		System.out.println("Size: " + pt.getSize() + ", capacity: " + pt.getCapacity());
	}
}




