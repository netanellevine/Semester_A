package OldTests;

public class PointForTest6 {

	private int x, y;
	private String name;

	public PointForTest6(int x, int y, String name) {
		setX(x);
		setY(y);
		setName(name);
	}

	public PointForTest6(PointForTest6 other) {
		this(other.x, other.y, other.name);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(PointForTest6 p) {
	return(this.x==p.x && this.y==p.y && this.name==p.name);	
	}
	
	
	
	
	
	
}
