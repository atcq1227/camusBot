/*
From Courtney Brown

Posts stati to twitter
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class PostTwitterStatus {


		PostTwitterStatus() {}
		
		public void updateTwitter(String update_str) {
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("c0hGLS1HRDNXEgYxcEaMJAeKk").setOAuthConsumerSecret("CyeIgFMhiIDyj7zkEsPkPHPa2ioNPryGzfW9eaI0WBBQrQNsfD").setOAuthAccessToken("912350203738558464-7NEKQmP1DM4bTo2qfje6IApmbAwlUoy").setOAuthAccessTokenSecret("akCklYY3XNmwZVwG5ilfhNUeSU8zb9m3LDUTXQDmmTWQf");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
		
			Status status = twitter.updateStatus(update_str);
			System.out.println("Successfully updated the status to [" + status.getText() + "].");
		} 
		
		catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get timeline: " + te.getMessage());
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to read the system input.");
		}
	}
}