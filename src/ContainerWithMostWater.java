import java.util.Scanner;

public class ContainerWithMostWater {
    //in order to find the maximum area in the container
    //time complexity: O(N)
    public static int findMaxArea(int[] height){
        int maximumArea = 0;

        int left = 0;
        int right = height.length - 1;

        while(left < right){
            int width = right - left;
            int currHeight = Math.min(height[left], height[right]);
            int currArea = width * currHeight;

            maximumArea = Math.max(currArea, maximumArea);

            if(height[left] < height[right]) left += 1;
            else right -= 1;
        }

        return maximumArea;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int totalLines = scn.nextInt();

        //we need an array to store the height
        int[] height = new int[totalLines];

        //in order to input the heights of the container
        for(int idx = 0; idx < totalLines; idx += 1){
            height[idx] = scn.nextInt();
        }

        int maxArea = findMaxArea(height);
        System.out.println(maxArea);
    }
}
