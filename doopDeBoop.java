/*
Matt Shaw 2017

Takes dialogue from Jonas in Camus' "Jonas (Or An Artist At Work)" and makes new strings
based on what a Markov chain spits out after reading it.
*/

import java.util.ArrayList;

import processing.core.*;
import twitter4j.*;

import com.jaunt.*;

public class doopDeBoop<E> extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PApplet.main("doopDeBoop");
		
	}
	
	Twitter twitter;
	
	PostTwitterStatus status = new PostTwitterStatus();
	
	TextTokenizer tokenizer = new TextTokenizer();
	MarkovChain<E> markov = new MarkovChain<E>();
	
	StringBuilder post = new StringBuilder();
	String postString;
	
	public void setup() {
		//read/prepare file for Markov chain then train and generate chain
		tokenizer.readFile();
		markov.train((ArrayList<E>)tokenizer.getStringArray());
		markov.generate((ArrayList<E>)tokenizer.getStringArray());
		
		generatePost();
	}
	
	public void draw() {
		
		//generate a post every hour
		while(System.currentTimeMillis() % 360000 == 0) {
			postString = post.toString();
			status.updateTwitter(postString);
		}
	}
	
	public void generatePost() {
		
		//add elements to a stringBuilder
		for(int i = 0; i < markov.getGeneratedElements().size(); i++) {
			post.append(markov.getGeneratedElements().get(i));
		}
	}
}
