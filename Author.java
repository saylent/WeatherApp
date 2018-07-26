package coding.exercise.model;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class Author {
    public String name;

    @JsonbProperty("user")
    public String userName;

    @JsonbProperty("posts")
    public int posts;

    
    public Author() {
    }

    @JsonbCreator

    public Author(
      @JsonbProperty("name") String name,
      @JsonbProperty("user") String userName,
      @JsonbProperty("posts") int posts) {
        
      this.name = name;
      this.userName = userName;
      this.posts = posts;
    }

    @Override
    public String toString() {
      return "Album named " + name + " by " + userName +
        " contains " + posts + " posts";
    }
}
