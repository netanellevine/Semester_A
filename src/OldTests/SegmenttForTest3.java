package OldTests;

public class SegmenttForTest3 {
	private PointForTest3 point1;
	private PointForTest3 point2;

	public SegmenttForTest3(PointForTest3 p1, PointForTest3 p2) {
		this.point1 = new PointForTest3(p1.getX(), p1.getY());
		this.point2 = new PointForTest3(p2.getX(), p2.getY());
	}

	public SegmenttForTest3(SegmenttForTest3 s1) {
		this.point1 = new PointForTest3(s1.point1.getX(), s1.point1.getY());
		this.point2 = new PointForTest3(s1.point2.getX(), s1.point2.getY());
	}

	public double length() {
		double temp = (this.point1.getX() - this.point2.getX()) * (this.point1.getX() - this.point2.getX())
		+ (this.point1.getY() - this.point2.getY()) * (this.point1.getY() - this.point2.getY());
		return Math.sqrt(temp);
	}
	
	public boolean contains(PointForTest3 p1) {
		SegmenttForTest3 s1= new SegmenttForTest3(this.point1,p1);
		SegmenttForTest3 s2= new SegmenttForTest3(this.point2,p1);
		return (s1.length()+s2.length()==this.length());
	}
}
