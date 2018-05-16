/*
Matt Shaw 2017

Takes an input string and divides it into tokens based on delimiters
*/

import java.util.ArrayList;
import java.util.StringTokenizer;

public class TextTokenizer
{
  TextTokenizer() {}
  
  TextTokenizer(String input)
  {
    this.input = input;
  }
  
  private StringBuilder inputBuilder = new InputBuilder();
  private String input;
  private String delims = "[ ]";
  private String[] output;
  StringTokenizer outputString = new StringTokenizer(this.input, " /?.!", true);
  ArrayList<String> stringArray = new ArrayList();
  
  public void readFile()
  {
	  //read file line by line
	  try(BufferedReader br = new BufferedReader(new FileReader("EXILE.txt"))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        inputBuilder.append(br.read());
		    }
		    String everything = sb.toString();
		}
	  
	  //convert stringBuiler to string
	  this.input = inputBuilder.toString();
  }
  
  public String[] getOutput()
  {
    return this.output;
  }
  
  public void setOutput(String[] output)
  {
    this.output = output;
  }
  
  public ArrayList<String> getStringArray()
  {
    return this.stringArray;
  }
  
  public void setStringArray(ArrayList<String> stringArray)
  {
    this.stringArray = stringArray;
  }
}
