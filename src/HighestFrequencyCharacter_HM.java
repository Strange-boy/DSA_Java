import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HighestFrequencyCharacter_HM {

    //Time complexity : O(length of the string)
    //we have to find the highest frequency character in the given string
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String inputString = scn.next();

        //we need a hashmap to store the frequency of the character
        HashMap<Character, Integer> charFrequency = new HashMap<>();

        //adding each character along with the count
        for(int idx = 0; idx < inputString.length(); idx += 1){
            char currChar = inputString.charAt(idx);

            if(charFrequency.containsKey(currChar)){
                int oldFreq = charFrequency.get(currChar);
                int newFreq = oldFreq + 1;

                charFrequency.put(currChar, newFreq);
            } else {
                charFrequency.put(currChar, 1);
            }
        }

        System.out.println(charFrequency);

        //we need to find the character with the highest frequency
        char maxFreqCharacter = inputString.charAt(0);
        int highestOccurence = charFrequency.get(maxFreqCharacter);

        for(Character key : charFrequency.keySet()){
            if(charFrequency.get(key) > charFrequency.get(maxFreqCharacter)){
                maxFreqCharacter = key;
                highestOccurence = charFrequency.get(key);
            }
        }

        // EDGE CASE : suppose there are multiple characters with max frequency
        //we would simply iterate and find the max value
        ArrayList<Character> maxFreqCharacters = new ArrayList<>();


        //logic to add all the characters with highest occurence
        for(Character key : charFrequency.keySet()){
            if(charFrequency.get(key) == highestOccurence){
                maxFreqCharacters.add(key);
            }
        }

        System.out.println("The Max occuring character / characters : " + maxFreqCharacters);
    }
}
