import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentObservationDTO {
	@JsonProperty("display_location")
	public DisplayLocationDTO displayLocation;

	@JsonProperty("temp_f")
	public Double fTemp;

	@JsonProperty("temp_c")
	public Double cTemp;
}
