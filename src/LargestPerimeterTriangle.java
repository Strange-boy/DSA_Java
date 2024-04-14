
import java.util.Arrays;
import java.util.Scanner;

//time complexity: O(N)
public class LargestPerimeterTriangle {
    public static int findLargestPerimeter(int[] triangle){
        int largestPerimeter = 0;

        //first we need to sort the array
        Arrays.sort(triangle);

        //logic : simply iterate from back of the array
        for(int idx = triangle.length - 1; idx >= 2; idx -= 1){
            if(triangle[idx - 2] + triangle[idx - 1] > triangle[idx]){
                largestPerimeter = triangle[idx - 2] + triangle[idx - 1] + triangle[idx];
                break;
            }
        }

        return largestPerimeter;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int totalSides = scn.nextInt();

        //now we need an array to store the sides
        int[] triangle = new int[totalSides];

        //enter the values inside the triangle
        for(int idx = 0; idx < totalSides; idx += 1){
            triangle[idx] = scn.nextInt();
        }

        int largestPerimeter = findLargestPerimeter(triangle);

        //the final answer with largest perimeter triangle
        System.out.println(largestPerimeter);
    }
}
