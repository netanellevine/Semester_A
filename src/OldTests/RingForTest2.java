package OldTests;
	

	//Test 2 question 4
public class RingForTest2 {
	private PointForTest2 point;
	private double radius1;
	private double radius2;

	public RingForTest2(PointForTest2 p, double r1, double r2) {
		this.point = new PointForTest2(p);
		this.radius1 = r1;
		this.radius2 = r2;
	}

	public RingForTest2(RingForTest2 ring) {
		this.point = new PointForTest2(ring.point);
		this.radius1 = ring.radius1;
		this.radius2 = ring.radius2;
	}

	public int inArea(PointForTest2 p) {
		double dist = p.distance(this.point);
		if (dist < this.radius1) {
			return 1;
		} else if (dist <= this.radius2) {
			return 2;
		} else {
			return 3;
		}
	}

}
