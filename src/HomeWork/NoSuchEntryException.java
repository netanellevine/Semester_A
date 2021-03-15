package HomeWork;

public class NoSuchEntryException extends Exception {

	private int entry;

	public NoSuchEntryException(int e) {
		this.entry = e;
	}
	
	public int getEntry() {
	return this.entry;	
	}
	
	
	
	
	
	
}
