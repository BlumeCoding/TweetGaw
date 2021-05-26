package Blume.Coding.bot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Main {

	
	//////////////////////////
	//  Credits:            //
	//   BlumeCoding        //
	//                      //
	//   ImFrozen für       //
	//   TXT read code      //
	//                      //
	//////////////////////////
	
	//  Du kannst beim status keine ascii zeichen benutzen nur UTF-8
	// bei Problemen und Fragen stehe ich gerne zu verfügung 
	
	//  ihr müsst eine App erstellen für twitter unter https://apps.twitter.com/
	//  ihr müsst einen acc haben der eine Nummer verifieziert hat 
	//  Die keys unten bekommt ihr nach dem erstellen der twitter app
	// ihr könnt die tweets designen wie ihr wollt aber datum muss drin bleiben
	// weil ich leider einen  bug habe den ich nicht gefixt bekomme sonst postet
	// er nur das datum und nicht den acc
	//  ihr erstellt entweder mehrere bots und lässt sie laufen oder ihr packt in
	// die txt file vor dem acc den sogennanten provider davon vor besser bekomm ichs net hin
	//Mittlerweile muss man jetzt bei Twitter eine Anfrage erstellen um Jetzt eine Twitter Application erstellen zu können

	
	public static Random r = new Random();

	public static void main(String[] args) throws InterruptedException, IOException {
		Date date = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy");

		String ckey = "";
		String ckeysecret = "";
		String atoken = "";
		String atokensecret = "";
		
		int i = 1;
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(ckey)
				.setOAuthConsumerSecret(ckeysecret)
				.setOAuthAccessToken(atoken)
				.setOAuthAccessTokenSecret(atokensecret);

		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
while(true) {
		try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				try {
					String status = String.format(
							"OUTPUT: [%s]\r\n\r\nDATUM: %s\r\n acc : %s \r\n", i,
							s.format(date), line);
					System.out.println("Status wurde geändert zu " + status);

					twitter.updateStatus(status);
					i++;
				} catch (TwitterException e) {
					e.printStackTrace();
				}
              
				//ZEIT in Minuten
				//5 Minuten einfach so 5 * 60* 1000 etc..
				Thread.sleep(5 *60 * 1000);
			}
		}
	}
  }
}
