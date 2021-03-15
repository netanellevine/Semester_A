package temp;
public class Station {
	private String cityName;
	private String streetName;
	
	public Station(String cityName, String streetName)
	{
		setCityName(cityName);
		setStreetName(streetName);
	}
	
	public Station(Station other)
	{
		this(other.cityName, other.streetName);
	}

	// getters and setters
	public String getCityName() {
		return cityName;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public boolean setCityName(String cityName) {
		if(cityName.equals(""))
			return false;
		this.cityName = cityName;
		return true;
	}

	public boolean setStreetName(String streetName) {
		if(streetName.equals(""))
			return false;
		this.streetName = streetName;
		return true;
	}

	public boolean equals(Station other){
		return (this.cityName.equals(other.cityName) && this.streetName.equals(other.streetName));
	}
	
	public String toString() {
		return cityName + ", " + streetName;
	}
}