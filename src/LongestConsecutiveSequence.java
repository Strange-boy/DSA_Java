import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestConsecutiveSequence {

    //time complexity : O(N)
    private static ArrayList<Integer> findLongestConsecutiveSequence(int[] nums){
        Map<Integer, Boolean> startPointMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        //map all values as true at first
        for(int value : nums) {
            startPointMap.put(value, true);
        }

        //map all the starting values taking above values as reference
        for(int value: nums){
            if(startPointMap.containsKey(value - 1))
                startPointMap.put(value, false);
        }

        //now we have to find the largest consecutive sequence
        int maxLength = 0;
        int maxStartPoint = 0;

        for(int value : nums){
            if(startPointMap.get(value)){
                int currStartPoint = value;
                int currLength = 1;

                while(startPointMap.containsKey(currStartPoint + currLength)){
                    currLength += 1;
                }

                if(currLength > maxLength){
                    maxLength = currLength;
                    maxStartPoint = currStartPoint;
                }
            }
        }

        //finally we have to push the two results
        result.add(maxLength);
        result.add(maxStartPoint);

        return result;
    }

    //main function
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int length = scn.nextInt();
        int[] nums = new int[length];

        //input the elements in array
        for(int idx = 0; idx < length; idx += 1){
            nums[idx] = scn.nextInt();
        }

        ArrayList<Integer> result = findLongestConsecutiveSequence(nums);

        int maxLength = result.get(0);
        int startPoint = result.get(1);

        //in order to print the consecutive sequence
        for(int num = startPoint; num < startPoint + maxLength; num += 1){
            System.out.print(num + " ");
        }

        System.out.println();
    }
}
