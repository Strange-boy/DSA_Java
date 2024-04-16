import java.util.Scanner;

public class RoofTops {
    //function to find the max consecutive steps
    public static int findMaxConsecutiveSteps(int[] roofTops, int buildings){
        int maxSteps = 0;
        int currSteps = 0;

        for(int idx = 0; idx < buildings - 1; idx += 1){
            if(roofTops[idx] < roofTops[idx + 1]){
                currSteps += 1;
            } else {
                if(currSteps > maxSteps){
                    maxSteps = currSteps;
                }

                currSteps = 0;
            }
        }

        if (currSteps > maxSteps){
            maxSteps = currSteps;
        }

        return maxSteps;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int buildings = scn.nextInt();

        //we need to store the height of the roof tops
        int[] roofTops = new int[buildings];

        for(int idx = 0; idx < buildings; idx += 1){
            roofTops[idx] = scn.nextInt();
        }

        int maxSteps= findMaxConsecutiveSteps(roofTops, buildings);

        System.out.println("Max steps: " + maxSteps);
    }
}
