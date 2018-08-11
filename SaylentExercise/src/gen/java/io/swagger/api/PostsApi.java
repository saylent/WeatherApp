package io.swagger.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.api.impl.PostsApiServiceImpl;
import io.swagger.model.Post;

@Path("/posts")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the posts API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-08-06T19:44:40.063-04:00")
public class PostsApi  {

	private PostsApiService postsApiService = new PostsApiServiceImpl();

	@GET

	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "", notes = "", response = Post.class, responseContainer = "List", tags={  })
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Successful Operation", response = Post.class, responseContainer = "List") })
	public Response postsGet(@Context SecurityContext securityContext)
			throws NotFoundException {
		return postsApiService.postsGet(securityContext);
	}
}
