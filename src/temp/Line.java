package temp;
public class Line {
	public static final int MAX_NUM_OF_STATIONS = 3;
	private int lineNumber;
	private int frequency;
	private Station[] stations;
	private int numOfStations;
	
	public Line(int lineNumber, int frequency)
	{
		setLineNumber(lineNumber);
		setFrequency(frequency);
		this.stations = new Station[MAX_NUM_OF_STATIONS];
		numOfStations = 0;
	}

	// getters and setters
	public int getLineNumber() {
		return lineNumber;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public boolean setLineNumber(int lineNumber) {
		if(lineNumber < 0)
			return false;
		this.lineNumber = lineNumber;
		return true;
	}

	public boolean setFrequency(int frequency) {
		if(frequency <= 0)
			return false;
		this.frequency = frequency;
		return true;
	}
	
	public boolean addStation(Station s) {
		if (numOfStations == MAX_NUM_OF_STATIONS)
			return false;
		else if(isExist(s))
			return false;
		else
			stations[numOfStations++] = new Station(s);
		return true;
	}
	
	public boolean isExist(Station s) {
		for(int i=0; i < numOfStations ;++i)
			if(stations[i].equals(s))
				return true;
		return false;
	}
	
	public String toString() {
		String ret =  "Line: " + lineNumber + ", frequency: " + frequency + ", stations:\n";
		for(Station s : stations)
			ret += s + "\n";
		return ret;
	}
}