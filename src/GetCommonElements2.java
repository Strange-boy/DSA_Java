import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GetCommonElements2 {

    //in order to find the common elements in both the arrays
    private static ArrayList<Integer> findCommonElements(int[] first, int[] second){
        ArrayList<Integer> commonElements = new ArrayList<>();

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        //map elements to it's frequency
        for(int value: first){
            if(freqMap.containsKey(value)){
                int oldFreq = freqMap.get(value);
                int newFreq = oldFreq + 1;

                freqMap.put(value, newFreq);
            } else {
                freqMap.put(value, 1);
            }
        }

        //now we need to check with the second array for duplicated elements
        for(int value : second){
            if(freqMap.containsKey(value) && freqMap.get(value) > 0 ){
                commonElements.add(value);
                int currFreq = freqMap.get(value);
                int newFreq = currFreq - 1;

                freqMap.put(value, newFreq);
            }
        }

        return commonElements;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //input the first array input
        int firstLength = scanner.nextInt();
        int[] first = new int[firstLength];

        for(int idx = 0; idx < first.length; idx += 1){
            first[idx] = scanner.nextInt();
        }

        //input the second array input
        int secondLength = scanner.nextInt();
        int[] second = new int[secondLength];

        for(int idx = 0; idx < second.length; idx += 1){
            second[idx] = scanner.nextInt();
        }

        ArrayList<Integer> commonElements = findCommonElements(first, second);

        //in case there are no common elements
        if(commonElements.isEmpty()) System.out.println("There are no common Elements");

        //in order to print the common elements
        for(int element: commonElements){
            System.out.print(element + " ");
        }

        System.out.println();
    }
}
