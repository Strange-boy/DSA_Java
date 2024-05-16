import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String expression = scn.nextLine();

        Stack<Character> st = new Stack<>();

        //now we need to iterate through the expression
        for(int idx = 0; idx < expression.length(); idx += 1){
            char currCh = expression.charAt(idx);
            if(currCh == ')'){
                //we need to check if it is a duplicate bracket
                if(st.peek() == '('){
                    System.out.println("Duplicate bracket found");
                    return;
                } else {
                    //while the opening bracket is found
                    while(st.peek() != '('){
                        st.pop();
                    }

                    //after finding the opening bracket , we have to throw that too
                    st.pop();
                }
            } else {
                st.push(currCh);
            }
        }

        //in case we came out, no duplicate brackets
        System.out.println("No Duplicate Brackets");
    }
}
