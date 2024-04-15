import java.util.Scanner;

public class PunishTheStudents {
    //in order to find the total swaps to required to sort the paper
    public static int findTotalSwaps(int[] roll){
        //in order to find the total swaps required
        int totalSwaps = 0;

        int students = roll.length;
        for(int first = 1; first <= students - 1; first += 1){
            for(int second = 0; second < students - first; second += 1){
                if(roll[second] > roll[second + 1]){
                    totalSwaps += 2;
                    int temp = roll[second];
                    roll[second] = roll[second + 1];
                    roll[second + 1] = temp;
                }
            }
        }

        return totalSwaps;
    }

    //in order to check whether the student should be punished or not
    public static int shouldBePunished(int[] roll, int[] marks, double reqAvg){
        int totalSwaps = findTotalSwaps(roll);

        int students = marks.length;
        int totalMarks = 0;

        //now we need to find the total marks
        for(int idx = 0; idx < students; idx += 1){
            totalMarks += marks[idx];
        }

        int newMarks = totalMarks - totalSwaps;
        double newAvg = (newMarks * 1.0) / students;

        if(newAvg >= reqAvg) return 1;
        else return 0;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int students = scn.nextInt();

        //declare a roll no array with length students
        int[] roll = new int[students];

        //input the roll no value
        for(int idx = 0; idx < students; idx += 1){
            roll[idx] = scn.nextInt();
        }

        //array to store the marks of all the students
        int[] marks = new int[students];

        //in order to input the marks of the all students
        for(int idx = 0; idx < students; idx += 1){
            marks[idx] = scn.nextInt();
        }

        //average allowed
        double reqAvg = scn.nextDouble();
        int punished = shouldBePunished(roll, marks, reqAvg);

        System.out.println("Punished:" + punished);
    }
}
