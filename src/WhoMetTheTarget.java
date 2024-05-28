import java.util.Scanner;

public class WhoMetTheTarget {
    
    //in order to find the number of employees who met the target
    public static int numberOfEmployeesWhoMetTheTarget(int[] hours, int target){
        int targetCompleted = 0;
        
        for(int employee = 0; employee < hours.length; employee += 1){
            if(hours[employee] >= target){
                targetCompleted += 1;
            }
        }
        
        return targetCompleted;
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int totalEmployees = scn.nextInt();
        int[] hours = new int[totalEmployees];

        //input the hours worked by each employee
        for(int employee = 0; employee < totalEmployees; employee += 1){
            hours[employee] = scn.nextInt();
        }
        
        //the target time for each employee to do the job
        int target = scn.nextInt();

        int targetEmp = numberOfEmployeesWhoMetTheTarget(hours, target);
        System.out.println(targetEmp);
    }
}
