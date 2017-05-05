import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponseDTO {

	@JsonProperty("current_observation")
	public CurrentObservationDTO currentObservation;
}
