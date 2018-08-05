package mavenProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.model.Review;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ReviewServiceImpl {

    public List<Review> getReviews() throws IOException {
        List<Review> reviews = new ArrayList();
        Review review = new Review();

        review.setCount(10);
        review.setName("test");
        review.setAuthor("MyBook");

        reviews.add(review);

        return reviews;

//        return readYaml(reviews, new File("/Users/yh05319/Downloads/spring-boot-file-upload-ajax-rest/src/main" +
//                "/resources/reviews.yaml"));
    }

    private List<Review> readYaml(List<Review> reviews,  File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory()); // jackson databind
        Review review = mapper.readValue(file, Review.class);
        reviews.add(review);

        return reviews;
    }

}
