package io.swagger.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class RestApplication extends Application {

	private Set<Object> singletons = new HashSet<>();

	public RestApplication() {
		singletons.add(new UsersApi());
		singletons.add(new PostsApi());
		singletons.add(new CommentsApi());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}