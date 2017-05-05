
public class Weather {
	private String city;
	private String state;
	private Double fTemp;
	private Double cTemp;

	public Weather(String city, String state, Double fTemp, Double cTemp) {

		this.city = city;
		this.state = state;
		this.fTemp = fTemp;
		this.cTemp = cTemp;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getfTemp() {
		return fTemp;
	}

	public void setfTemp(Double fTemp) {
		this.fTemp = fTemp;
	}

	public Double getcTemp() {
		return cTemp;
	}

	public void setcTemp(Double cTemp) {
		this.cTemp = cTemp;
	}
	
	@Override
	public String toString() {
		return city + ":" + fTemp + ":" + cTemp;
	}

}
