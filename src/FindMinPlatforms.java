import java.util.Arrays;
import java.util.Scanner;

public class FindMinPlatforms {

    //in order to find the minimum platforms
    //greedy approach to solve the problem
    //Time complexity: O(N * LogN)
    public static int findMinPlatforms(int[] arrival, int[] depart){
        int currTrains = 0;
        int minPlatforms = 0;

        //we need to sort the elements in both the array
        Arrays.sort(arrival);
        Arrays.sort(depart);


        int first = 0;
        int second = 0;

        while(first < arrival.length && second < depart.length){
            if(arrival[first] <= depart[second]){
                currTrains += 1;
                first += 1;
            } else {
                currTrains -= 1;
                second += 1;
            }

            minPlatforms = Math.max(currTrains, minPlatforms);
        }

        return minPlatforms;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int totalTrains = scn.nextInt();

        //we have to input the arrival time of all the trains
        int[] arrival = new int[totalTrains];

        for(int idx = 0; idx < totalTrains; idx += 1){
            arrival[idx] = scn.nextInt();
        }

        //we have to input the departure time
        int[] depart = new int[totalTrains];

        for(int idx = 0; idx < totalTrains; idx += 1){
            depart[idx] = scn.nextInt();
        }

        int minPlatforms = findMinPlatforms(arrival, depart);
        System.out.println("Min Platforms: " + minPlatforms);
    }
}
