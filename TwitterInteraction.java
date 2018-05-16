import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.util.*;

public class TwitterInteraction {

	Twitter twitter;

	TwitterInteraction() {

		try {

			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("c0hGLS1HRDNXEgYxcEaMJAeKk")
					.setOAuthConsumerSecret("")
					.setOAuthAccessToken("912350203738558464-7NEKQmP1DM4bTo2qfje6IApmbAwlUoy")
					.setOAuthAccessTokenSecret("");
			TwitterFactory tf = new TwitterFactory(cb.build());
			twitter = tf.getInstance();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to get timeline: " + e.getMessage());
		}

	}

	public void updateTwitter(String update_str) {
		try {

			Status status = twitter.updateStatus(update_str);
			System.out.println("Successfully updated the status to [" + status.getText() + "].");
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get timeline: " + te.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to read the system input.");
		}
	}

	public ArrayList searchForTweets(String searchTerm) {
		ArrayList res = new ArrayList();
		try {
			Query query = new Query(searchTerm);
			query.count(100);
			QueryResult result = twitter.search(query);
			for (Status status : result.getTweets()) {
				// System.out.println("@" + status.getUser().getScreenName() + ":" +
				// status.getText());
				res.add(status.getText());
			}
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get timeline: " + te.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to read the system input.");
		}
		return res;
	}

}
