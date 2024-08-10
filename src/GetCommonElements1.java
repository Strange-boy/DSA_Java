import java.util.HashMap;
import java.util.Scanner;

public class GetCommonElements1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        //initialise the first arrays
        int firstLength = scn.nextInt();
        int[] first = new int[firstLength];

        //input the values of first array
        for(int idx = 0; idx < first.length; idx += 1){
            first[idx] = scn.nextInt();
        }

        //initialise the second array
        int secondLength = scn.nextInt();
        int[] second = new int[secondLength];

        //input the values of second array
        for(int idx = 0; idx < second.length; idx += 1){
            second[idx] = scn.nextInt();
        }

        //main logic to solve the problem
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int value : first){
            if(freqMap.containsKey(value)){
                int oldFreq = freqMap.get(value);
                int newFreq = oldFreq + 1;

                //add the new value
                freqMap.put(value, newFreq);
            } else {
                freqMap.put(value, 1);
            }
        }

        //now we would iterate through the second array and find the common elements
        for(int value : second){
            if(freqMap.containsKey(value)){
                System.out.print(value + " ");
                freqMap.remove(value);
            }
        }
    }
}
