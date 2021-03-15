package OldTests;

public class PointArrayForTest6 {
	private PointForTest6[] array;

	public PointArrayForTest6(PointForTest6[] a) {
		this.array = new PointForTest6[a.length];
		for (int i = 0; i < a.length; i++) {
			this.array[i] = new PointForTest6(a[i]);
		}
	}

	public boolean theSame(PointForTest6[] a) {
		if (a.length != this.array.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (!(a[i].equals(this.array[i]))) {
				return false;
			}
		}
		return true;
	}

	public PointForTest6[] copyArrayFromXToY(int x, int y) {
		if (x>y || x < 0 || y < 0 || y > this.array.length) {
			return null;
		}
		PointForTest6[] copy = new PointForTest6[y-x+1];
		for(int i=0;i<copy.length;i++) {
			copy[i]=this.array[x+i];
		}
		return copy;
	}
	
	
	
	
	
	
	
	
}
