/*String cleaning
===============

Your spy, Beta Rabbit, has managed to infiltrate a lab of mad scientists who are turning rabbits into zombies. He sends a text transmission to you, but it is intercepted by a pirate, who jumbles the message by repeatedly inserting the same word into the text some number of times. At each step, he might have inserted the word anywhere, including at the beginning or end, or even into a copy of the word he inserted in a previous step. By offering the pirate a dubloon, you get him to tell you what that word was. A few bottles of rum later, he also tells you that the original text was the shortest possible string formed by repeated removals of that word, and that the text was actually the lexicographically earliest string from all the possible shortest candidates. Using this information, can you work out what message your spy originally sent?

For example, if the final chunk of text was "lolol," and the inserted word was "lol," the shortest possible strings are "ol" (remove "lol" from the beginning) and "lo" (remove "lol" from the end). The original text therefore must have been "lo," the lexicographically earliest string.

Write a function called answer(chunk, word) that returns the shortest, lexicographically earliest string that can be formed by removing occurrences of word from chunk. Keep in mind that the occurrences may be nested, and that removing one occurrence might result in another. For example, removing "ab" from "aabb" results in another "ab" that was not originally present. Also keep in mind that your spy's original message might have been an empty string.

chunk and word will only consist of lowercase letters [a-z].
chunk will have no more than 20 characters.
word will have at least one character, and no more than the number of characters in chunk.

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:
    (string) chunk = "lololololo"
    (string) word = "lol"
Output:
    (string) "looo"

Inputs:
    (string) chunk = "goodgooogoogfogoood"
    (string) word = "goo"
Output:
    (string) "dogfood"*/

package professorBoolean;

import java.util.ArrayList;

public class StringCleaning {

	public static void main(String args[]){
		
		String chunk = "goodgooogoogfogoood";
		String word = "goo";
		
		System.out.println(Answer(chunk,word));
	}
	
	public static String Answer(String chunk, String word){
		
		while (findAll(chunk,word).length>0) { //Keep on removing words while the word still exists in the chunk
		
			//get all word locations
			int[] wordLocations = findAll(chunk,word);
			
			//for each word location see how many word locations are left if we remove that one and find word locations again
			int[] wordsLeft = new int[wordLocations.length];
					
			for (int x=0;x< wordLocations.length; x++){
				wordsLeft[x]=findAll(removeWord(chunk,word,wordLocations[x]),word).length;
			}
			//Now wordsLeft contains how many times the word would be left for each removal option in wordLocations.
			//We need to find the highest number of words left, and then choose the latest option with that number.
			//That way we get the shortest result in the end, and then the lexicographically earliest string possible.
			int highestNumberLeft=0;
			for (int x=0; x<wordsLeft.length; x++){
				if (wordsLeft[x]>highestNumberLeft){
					highestNumberLeft=wordsLeft[x];
				}
			}
			
			//Choose the option where most word locations are left, 
			//and where we remove the word as far to the end as possible
			int removalOption=0;
			for (int x=0; x<wordsLeft.length; x++){
				if (wordsLeft[x]==highestNumberLeft) {
					removalOption=x;
				}
			}
			
			//Remove the word from chunk
			chunk=removeWord(chunk,word,wordLocations[removalOption]);
					
			//repeat until no more word locations
		}
		return chunk;
	}
	
	public static int[] findAll(String chunk, String word){
		//This returns and array containing all locations of word in chunk.
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for (int i = -1; (i = chunk.indexOf(word, i + 1)) != -1; ) {;
		  answer.add(i);
		}
		
		int[] answerArr = new int[answer.size()];
		for (int x=0; x<answer.size(); x++){
			answerArr[x]=answer.get(x);
		}
		
		return answerArr;
	}
	
	public static String removeWord(String chunk, String word, int pos) {
		//This returns chunk with the word as pos removed.
		return chunk.substring(0,pos)+chunk.substring(pos+word.length(),chunk.length());
	}	
}


