package mavenProject;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Reviews {

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @JsonProperty("reviews")
    private List<Review> reviews = null;



}
