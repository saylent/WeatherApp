package coding.exercise.consumer;

import java.util.List;
import java.util.stream.Collectors;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import coding.exercise.model.Author;
import coding.exercise.model.Details;

public class Consumer {
    public static Details[] consumeWithJsonb(String targetUrl) {
      Client client = ClientBuilder.newClient();

      Response response = client.target(targetUrl).request().get();
      Details[] artists = response.readEntity(Details[].class);

      response.close();
      client.close();

      return artists;
    }
    
    public static Details[] consumeWithJsonp(String targetUrl) {
      Client client = ClientBuilder.newClient();

      Response response = client.target(targetUrl).request().get();
      JsonArray arr = response.readEntity(JsonArray.class);

      response.close();
      client.close();

      return Consumer.collectDetails(arr);
    }
    
    private static Details[] collectDetails(JsonArray authorArr) {
      List<Object> authors = authorArr.stream().map(artistJson -> {
        JsonArray albumArr = ((JsonObject) artistJson).getJsonArray("authors");
        Details details = new Details(
          ((JsonObject) artistJson).getString("name"),
          Consumer.collectAlbums(albumArr));
        return details;
      }).collect(Collectors.toList());

      return authors.toArray(new Details[authors.size()]);
    }
    
    private static Author[] collectAlbums(JsonArray albumArr) {
      List<Author> albums = albumArr.stream().map(albumJson -> {
    	  Author album = new Author(
          ((JsonObject) albumJson).getString("title"),
          ((JsonObject) albumJson).getString("artist"),
          ((JsonObject) albumJson).getInt("ntracks") );
        return album;
      }).collect(Collectors.toList());

      return albums.toArray(new Author[albums.size()]);
    }
}
