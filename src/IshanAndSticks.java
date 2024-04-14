
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class IshanAndSticks {
    //function to find the largest square
    public static ArrayList<Integer> findLargestSquare(int[] nums){
        HashMap<Integer, Integer> freqSticks = new HashMap<>();

        //we need to find the frequency of each sticks
        for(int element: nums){
            if(freqSticks.containsKey(element)){
                int newFreq = freqSticks.get(element) + 1;
                freqSticks.put(element, newFreq);
            } else {
                freqSticks.put(element, 1);
            }
        }

        //once we find the frequency , now we have to pick the largest stick (min 4)
        int maxArea = 0;
        int maxSquare = 0;

        ArrayList<Integer> largestSquare = new ArrayList<>();
        for(int stickSize: freqSticks.keySet()){
            int totalSticks = freqSticks.get(stickSize);
            int area = stickSize * stickSize;

            if(totalSticks >= 4 && area > maxArea){
                maxArea = area;
                maxSquare = totalSticks / 4;
            }
        }

        //now if there are no square which suffice the condition
        if(maxArea == 0){
            largestSquare.add(-1);
        } else {
            largestSquare.add(maxArea);
            largestSquare.add(maxSquare);
        }

        return largestSquare;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int length = scn.nextInt();

        //now we need to initialise an array
        int[] nums = new int[length];

        //input the elements in the array
        for(int idx = 0; idx < length; idx += 1){
            nums[idx] = scn.nextInt();
        }

        ArrayList<Integer> largestSquare = findLargestSquare(nums);

        for(int value: largestSquare){
            System.out.print(value + " ");
        }
    }
}
