package coding.exercise.service;

import javax.json.JsonArray;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import coding.exercise.model.Details;
import coding.exercise.consumer.Consumer;

@Path("artists")
public class ArtistResource {

    @Context
    UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray getArtists() {
    	return Reader.getArtists();
    }

    // tag::getJsonString[]
    @GET
    @Path("jsonString")
    @Produces(MediaType.TEXT_PLAIN)
    public String getJsonString() {
      Jsonb jsonb = JsonbBuilder.create();

      Details[] artists = Consumer.consumeWithJsonb(uriInfo.getBaseUri().toString() +
        "artists");
      String result = jsonb.toJson(artists);

      return result;
    }

    @GET
    @Path("total/{artist}")
    @Produces(MediaType.TEXT_PLAIN)
    public int getTotalAlbums(@PathParam("artist") String artist) {
      Details[] artists = Consumer.consumeWithJsonb(uriInfo.getBaseUri().toString()
        + "artists");

      for (int i = 0; i < artists.length; i++) {
        if (artists[i].name.equals(artist)) {
          return artists[i].authors.length;
        }
      }
      return -1;
    }

    @GET
    @Path("total")
    @Produces(MediaType.TEXT_PLAIN)
    public int getTotalArtists() {
      return Consumer.consumeWithJsonp(uriInfo.getBaseUri().toString() +
        "artists").length;
    }

}
