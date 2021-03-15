package OldTests;

public class EllipseForTest4 {
	private PointForTest4 p;
	private PointForTest4 q;
	private double n;

	public EllipseForTest4(double xp, double yp, double xq, double yq, double n) {
		this.p = new PointForTest4(xp, yp);
		this.q = new PointForTest4(xq, yq);
		this.n = n;
	}

	public EllipseForTest4(EllipseForTest4 e1) {
		this.p = new PointForTest4(e1.p);
		this.q = new PointForTest4(e1.q);
		this.n = e1.n;
	}

	public int where(PointForTest4 p1) {
		double dist1 = p1.distance(this.p);
		double dist2 = p1.distance(this.q);
		if (dist1 + dist2 == this.n) {
			return 0;
		}
		if (dist1 + dist2 < this.n) {
			return -1;
		} else {
			return 1;
		}
	}

	public boolean equals(EllipseForTest4 e) {
		return (((this.p.equals(e.p) && this.q.equals(e.q)) || 
				(this.p.equals(e.q) && this.q.equals(e.p))) && this.n == e.n);
	}

}
