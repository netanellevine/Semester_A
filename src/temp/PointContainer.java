package temp;
public class PointContainer {
	private final static int INIT_SIZE = 3;
	private final static float GROWTH_FACTOR=1.5f;
	private Point data[];
	private int size;
	
	public PointContainer() {
		data = new Point[INIT_SIZE];
		size = 0;
	}
	
	public void add(Point p) {
		if (size == data.length)
			resize((int)(size*GROWTH_FACTOR));
		data[size++] = p;
	}
	
	private void resize(int newSize) {
		Point t[] = new Point[newSize];
		for (int i = 0; i < data.length; i++)
			t[i] = data[i];
		data = t;
	}
	
	public String toString() {
		String ans = "[";
		for (int i = 0; i < size; i++)
			ans = ans + data[i].toString() +"; ";
		return ans + "]";
	}
	
	public int getSize() {
		return size;
	}
	
	public int getCapacity()
	{
		return data.length;
	}
	
	public int contains(Point p) {
		int ans = -1;// not found
		for (int i=0; ans==-1 && i<size; i++)
		{
			if (data[i].equals(p))
				ans = i;
		}
		return ans;
	}
	
	public boolean remove(Point p) {
		boolean ans = false;
		int ind = contains(p);
		if (ind != -1)
		{
			for (int i=ind; i<size-1; i++)
				data[i] = data[i+1];
			size--;
			ans = true;
		}
		return ans;
	}
	
	public Point get(int index) {
		if(index < 0 || index > size-1)
			return null;
		return data[index];
	}
	
	public boolean set(Point p, int index) {
		if (index < 0 || index > size-1)
			return false;
		data[index] = p;
		return true;
	}
}
