import lombok.extern.slf4j.Slf4j;
import twitter4j.RateLimitStatus;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.Map;

/**
 * Created by Cesar Koot on 23-1-2016.
 */
@Slf4j
public class MyFirstTwitterApp {

    public static void main(String[] args) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();

        Map<String, RateLimitStatus> rateLimitStatuses = twitter.getRateLimitStatus(); // /application/rate_limit_status
        for (Map.Entry<String, RateLimitStatus> rateLimitStatus : rateLimitStatuses.entrySet()) {
            log.info(rateLimitStatus.getKey() + " " + rateLimitStatus.getValue());
        }
        twitter.search("");

        
//        List<Status> statuses = twitter.getHomeTimeline();
//        System.out.println("Showing home timeline.");
//        for (Status status : statuses) {
//            System.out.println(status.getUser().getName() + ":" +
//                    status.getText());
//        }
    }

}
