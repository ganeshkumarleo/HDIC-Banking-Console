
import java.util.Scanner;

public class Input {//class name
    private static Scanner sc = new Scanner(System.in);//obj creation -reference variable 
    public static String getString(){
        String str = sc.nextLine();    
        return str;
    }
    public static int getInt(){//getting input int
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }
    
}