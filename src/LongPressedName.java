import java.util.Scanner;

public class LongPressedName {
    //in order to find whether the typed name is long pressed or not
    public static boolean longPressed(String name, String typed){
        //corner case
        if(name.length() > typed.length()) return false;

        //kind of like a two pointer approach to solve the problem
        int namePtr = 0;
        int typedPtr = 0;

        while(namePtr < name.length() && typedPtr < typed.length() ){
            if(name.charAt(namePtr) == typed.charAt(typedPtr)){
                namePtr += 1;
                typedPtr += 1;
            } else if(namePtr > 0 && name.charAt(namePtr - 1) == typed.charAt(typedPtr)){
                typedPtr += 1;
            } else {
                return false;
            }
        }

        //if the typed string is still remaining
        while(typedPtr < typed.length()){
            if(typed.charAt(typedPtr) == name.charAt(namePtr - 1)){
                typedPtr += 1;
            } else {
                return false;
            }
        }

        //if after the iterations, if still the name is not fully iterated
        //if all the conditions are satisfied then return true

        if(namePtr < name.length()) return false;
        else return true;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        String name = scn.next();
        String typed = scn.next();

        Boolean isLongPressed = longPressed(name, typed);
        System.out.println(isLongPressed);
    }
}
