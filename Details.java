package coding.exercise.model;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class Details {
    public String name;
    public Author authors[];

    
    @JsonbTransient
    public boolean legendary = true;

  
    public Details(
      @JsonbProperty("name") String name,
      @JsonbProperty("authors") Author authors[]) {

      this.name = name;
      this.authors = authors;
    }

    @Override
    public String toString() {
      return name + " wrote " + authors.length + " authors";
    }
}
