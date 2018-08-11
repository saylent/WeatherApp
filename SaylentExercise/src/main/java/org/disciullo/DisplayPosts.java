package org.disciullo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.api.ApiResponseMessage;
import io.swagger.model.Comment;
import io.swagger.model.Post;
import io.swagger.model.User;

/**
 * Will call into web services to get data, group into the format we want to see and
 * forward the results to a JSP to be rendered in the broswer
 * @author Anne
 *
 */
public class DisplayPosts extends HttpServlet {

	private static final long serialVersionUID = 3511297923151678325L;

	private static final String OKAY = "ok";
	private List<User> users;
	private List<Post> posts;
	private List<Comment> comments;
	private List<DisplayObject> displayObjects;

	@Override
	public void init() throws ServletException {
		// call the web services to get the data
		users = getUsers(getData("http://localhost:8080/SaylentExercise/rest/users"));
		posts = getPosts(getData("http://localhost:8080/SaylentExercise/rest/posts"));
		comments = getComments(getData("http://localhost:8080/SaylentExercise/rest/comments"));
		displayObjects = buildDisplayObjectList();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set response content type
		response.setContentType("text/html");

		if (displayObjects.isEmpty()) {
			request.setAttribute("somethingWentWrong", true);
		}
		request.setAttribute("displayObjects", displayObjects);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	@Override
	public void destroy() {
		// do nothing.
	}

	/**
	 * Build up the data we want to see on the page.
	 * @return the list of user names, titles of posts and count of comments on those posts. If anything
	 * goes wrong with any web service call, return an emtpy list.
	 */
	private List<DisplayObject> buildDisplayObjectList() {
		List<DisplayObject> displayObjects = new ArrayList<>();
		if (posts.isEmpty() || users.isEmpty() || comments.isEmpty()) {
			return displayObjects;
		}
		for (Post post : posts) {
			Integer userId = post.getUserId();
			DisplayObject displayObject = new DisplayObject();
			displayObject.setPostId(post.getId());
			displayObject.setUserId(userId);
			displayObject.setTitle(post.getTitle());
			User user = users.stream()
					.filter(u -> userId == u.getId())
					.findAny()
					.orElse(null);
			displayObject.setPersonName(user.getName());
			displayObjects.add(displayObject);
		}
		// count the comments by postId
		Map<Integer, Integer> commentCountMap = new HashMap<>();
		for (Comment comment : comments) {
			Integer postId = comment.getPostId();
			commentCountMap.put(postId, commentCountMap.getOrDefault(postId, 0)+1);
		}
		// set the counts in the DisplayObjects
		for (DisplayObject ds : displayObjects) {
			ds.setCommentCount(commentCountMap.get(ds.getPostId()));
		}
		// sort by name and then comment count (high to low)
		displayObjects.sort(Comparator.comparing(DisplayObject::getPersonName)
				.thenComparing(Comparator.comparing(DisplayObject::getCommentCount)
						.reversed()));
		return displayObjects;
	}
	/**
	 * Get the response from the web service. Check if ok or not.
	 * @param url the webservice url
	 * @return the string containing the array with the data or null if something went wrong.
	 */
	private String getData(String url) {
		String jsonString = null;
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(url);
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		response.close();  // You should close connections!
		ObjectMapper mapper = new ObjectMapper();
		ApiResponseMessage apiResponseMessage = null;
		try {
			apiResponseMessage = mapper.readValue(value, ApiResponseMessage.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
			return jsonString;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return jsonString;
		} catch (IOException e) {
			e.printStackTrace();
			return jsonString;
		}
		if (apiResponseMessage != null && apiResponseMessage.getType().equals(OKAY)) {
			jsonString = apiResponseMessage.getMessage();
		}
		return jsonString;
	}

	/**
	 * Parse the string containing the JsonArray into a list of {@link User}s.
	 * @param jsonArray
	 * @return a list of the users, empty list if something went wrong
	 */
	private List<User> getUsers(String jsonArray) {
		List<User> users = new ArrayList<>();
		if (jsonArray != null) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				users = mapper.readValue(jsonArray, new TypeReference<List<User>>(){});
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	/**
	 * Parse the string containing the JsonArray into a list of {@link Post}s.
	 * @param jsonArray
	 * @return a list of the posts, empty list if something went wrong
	 */
	private List<Post> getPosts(String jsonArray) {
		List<Post> posts = new ArrayList<>();
		if (jsonArray != null) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				posts = mapper.readValue(jsonArray, new TypeReference<List<Post>>(){});
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return posts;
	}


	/**
	 * Parse the string containing the JsonArray into a list of {@link Comments}s.
	 * @param jsonArray
	 * @return a list of the comments, empty list if something went wrong
	 */
	private List<Comment> getComments(String jsonArray) {
		List<Comment> comments = new ArrayList<>();
		if (jsonArray != null) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				comments = mapper.readValue(jsonArray, new TypeReference<List<Comment>>(){});
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return comments;
	}

}
