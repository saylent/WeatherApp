package mavenProject;


import com.model.Review;
import com.service.ReviewServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class RestUploadController {

    @Autowired
    private ReviewServiceImpl reviewService;

    private final Logger logger = LoggerFactory.getLogger(RestUploadController.class);

    @RequestMapping(value = "/getreviews", method = RequestMethod.GET)
    public List<Review> uploadFileMulti() throws IOException {

        logger.debug("Multiple file upload!");

        return reviewService.getReviews();

    }

}
