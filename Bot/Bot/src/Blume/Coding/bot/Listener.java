package Blume.Coding.bot;

import java.util.Date;
import java.util.Random;
import java.util.Timer;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Listener{
	
	private Twitter twitter;
	
	private String ckey = "";
	private String ckeysecret = "";
	private String atoken = "";
	private String atokensecret = "";
	
	
	
	// every night at 2am you run your task
	private Random r = new Random();
	
	public void init() throws TwitterException {
		
		  while (true) {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(ckey)
		.setOAuthConsumerSecret(ckeysecret)
		.setOAuthAccessToken(atoken)
		.setOAuthAccessTokenSecret(atokensecret);
		TwitterFactory tf = new TwitterFactory();
			twitter.updateStatus(r.nextInt() + "TEST");
		 try {
			Thread.sleep(60*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		 }
	}
	
	

}
*/