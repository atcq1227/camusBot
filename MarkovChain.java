/*
Does a Markov chain
 */

import java.util.ArrayList;
import java.util.Random;

public class MarkovChain <E> {
	
	ArrayList<E> elementsInFile = new ArrayList<E>();
	ArrayList<float[]> counts = new ArrayList<float[]>();
	ArrayList<float[]> percentages = new ArrayList<float[]>();
	ArrayList<E> generatedElements = new ArrayList<E>();
	
	MarkovChain() {}
	
	void train(ArrayList<E> elements) {
	
		for(int i = 0; i < elements.size(); i++) {
			if(!elementsInFile.contains(elements.get(i))) {
				elementsInFile.add(elements.get(i));
			}
		}
		
		for(int i = 0; i < elementsInFile.size(); i++) {
			counts.add(new float[elementsInFile.size()]);
			percentages.add(new float[elementsInFile.size()]);
			//System.out.println("Counts: " + counts.get(i)[i]);
		}
		
		
		for(int i = 1; i < elements.size(); i++) {
			if(elementsInFile.contains(elements.get(i))) {
				counts.get(elementsInFile.indexOf(elements.get(i-1)))[elementsInFile.indexOf(elements.get(i))] += 1;
			}
		}
		
		float sum;
		float percentageSum;
		
		for(int i = 0; i < elementsInFile.size(); i++) {
			//System.out.println("notesInFile: " + notesInFile.get(i));
			percentageSum = 0;
			for(int j = 0; j < counts.size(); j++) {
				sum = 0;
				for(int k = 0; k < counts.size(); k++) {
					sum += counts.get(i)[k];
				}
				percentages.get(i)[j] = counts.get(i)[j]/sum;
				
				percentageSum += percentages.get(i)[j];
//				System.out.println("percentages: " + percentages.get(i)[j]);
//				System.out.println("percentageSum: " + percentageSum);
			}
		}
		
	}
	
	void generate (ArrayList <E> elements) {
		Random rand = new Random();
		Random seed = new Random();
		float x;
		float percentageSum;
		
		x = seed.nextFloat()*elements.size();
		
		generatedElements.add(elements.get((int)x));
		
		for	(int i = 1; i < 100; i++) {
			x = rand.nextFloat();
			percentageSum = 0;
			
			for(int j = 0; j < elementsInFile.size(); j++) {
				if(x <= percentages.get(elementsInFile.indexOf(generatedElements.get(i - 1)))[j] + percentageSum)
				{
					generatedElements.add((E)elementsInFile.get(j));
					break;
				}
				
				else if(j >= elementsInFile.size()) {
					generatedElements.add((E)elementsInFile.get(j));
					break;
				}
				
				else {
					percentageSum += percentages.get(elementsInFile.indexOf(generatedElements.get(i-1)))[j];
				}
					
				System.out.println("j: " + j);
				
				System.out.println("percentageSum: " + percentageSum);	
			}
			
			//System.out.println("X: " + x);
		}
		//System.out.println("generatedElements: " + generatedElements.size());
	}
	
	public ArrayList<E> getGeneratedElements() {
		return generatedElements;
	}
}
