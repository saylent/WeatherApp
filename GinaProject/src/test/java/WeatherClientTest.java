


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class WeatherClientTest {

	
	@Test
	public void testGetSortedWeatherByCities() throws ClientProtocolException, IOException {
		WeatherClient client = new WeatherClient();
		List<Location> cityList = new ArrayList<Location> ();
		cityList.add(new Location("Austin", "TX"));
		cityList.add(new Location("Denver", "CO"));
		cityList.add(new Location("San Jose", "CA"));
		cityList.add(new Location("Washington", "DC"));
		cityList.add(new Location("Fayetteville", "AR"));
		cityList.add(new Location("Seattle", "WA"));
		cityList.add(new Location("Raleigh", "NC"));
		cityList.add(new Location("Boston", "MA"));
		cityList.add(new Location("Des Moines", "IA"));
		cityList.add(new Location("Salt Lake City", "UT"));
		List<Weather> weatherByCities = client.getSortedWeatherByCities(cityList);
		for(Weather w : weatherByCities) {
			System.out.println(w);
		}
		
	}

}
