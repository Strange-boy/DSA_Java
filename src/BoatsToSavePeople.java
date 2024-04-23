import java.util.Arrays;
import java.util.Scanner;

public class BoatsToSavePeople {

    //minimum number of boats required to save people
    //Time complexity: O(Nlog(N))
    public static int findMinBoats(int[] wtPeople, int limit){
        int minBoats = 0;

        //first we need to sort the array
        Arrays.sort(wtPeople);

        int left = 0;
        int right = wtPeople.length - 1;

        while(left <= right){
            int weightSum = wtPeople[left] + wtPeople[right];

            if(weightSum <= limit){
                left += 1;
                right -= 1;
            } else {
                //if not we would take heavy => one boat
                right -= 1;
            }

            minBoats += 1;
        }

        return minBoats;
    }

    //main function to execute the code
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int totalPeople = scn.nextInt();

        //enter the weight of every one
        int[] wtPeople = new int[totalPeople];

        //enter the elements in the array
        for(int people = 0; people < totalPeople; people += 1){
            wtPeople[people] = scn.nextInt();
        }

        //enter the limit allowed in the boat
        int limit = scn.nextInt();

        int minBoats = findMinBoats(wtPeople, limit);

        System.out.println("Minimum boats: " + minBoats);
    }
}
