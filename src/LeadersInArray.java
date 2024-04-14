import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
* Brute: here simply take an element and compare with all the elements to the right to find whether it is max
*  and push it to array list
* Time complexity: O(n^2)
*
* Optimal: just try to iterate from the right and find whether the current element is max or not
* Time complexity: O(2N)
* */
public class LeadersInArray {
    //Optimal approach to find the leaders
    public static ArrayList<Integer> arrayLeaders(int[] nums, int length){
        ArrayList<Integer> leaders = new ArrayList<>();

        int currLeader = Integer.MIN_VALUE;

        //iterate and find all the leaders
        for(int idx = nums.length - 1; idx >= 0; idx -= 1){
            if(nums[idx] >= currLeader){
                leaders.add(nums[idx]);
                currLeader = nums[idx];
            }
        }

        //finally we have to reverse the elements in the array
        Collections.reverse(leaders);

        return leaders;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int length = scn.nextInt();

        //we need an array to store the number
        int[] nums = new int[length];

        for(int idx = 0; idx < length; idx += 1){
            nums[idx] = scn.nextInt();
        }

        //in order to find the leaders in the array
        ArrayList<Integer> leaders = arrayLeaders(nums, length);

        //now we have to print all the leaders in the array
        for(int leader: leaders){
            System.out.print(leader + " ");
        }
    }
}
