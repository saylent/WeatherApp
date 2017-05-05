
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherClient {
	private HttpClient client = HttpClientBuilder.create().build();
	private static final String API_KEY = "6135f78e52c9e3ca";
	public static final Charset UTF8 = Charset.forName("UTF-8");
	private static final String BASE_URL = "http://api.wunderground.com/api/" + API_KEY + "/conditions/q/";

	public Weather getWeatherForCity(String city, String state) {
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponseDTO responseDTO = null;
		String uri = BASE_URL + state + "/" + city + ".json";
		Weather weather = null;

		try {
			HttpGet request = new HttpGet(uri);
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			String retSrc = null;
			if (entity != null) {
				retSrc = EntityUtils.toString(entity);
				System.out.println(retSrc);
				responseDTO = mapper.readValue(retSrc, WeatherResponseDTO.class);
				weather = new Weather(responseDTO.currentObservation.displayLocation.city,
						responseDTO.currentObservation.displayLocation.state, responseDTO.currentObservation.fTemp,
						responseDTO.currentObservation.cTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return weather;
	}
	
	public List<Weather> getSortedWeatherByCities(List<Location> cityList ) {
		List<Weather> weatherByCities = new ArrayList<Weather> ();
		for (Location location : cityList) {
			Weather weather = getWeatherForCity(location.getCity(), location.getState());
			weatherByCities.add(weather);
		}
		
		Collections.sort(weatherByCities, new Comparator<Weather>(){
		    public int compare(Weather w1, Weather w2) {
		        return w2.getcTemp().compareTo(w1.getcTemp());
		    }
		});
		return weatherByCities;
		
	}
	
	

}
