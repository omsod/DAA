import java.util.Scanner;
public class Fibonacci{

    public static void nonRecurssive(int n) {
        int first=0,second=1;
        if (n<0) {
            System.out.println("enter valid positive no.");
            return;
        }
        System.out.println("fibonacci sequence upto "+n+" is :");
        if (n>=0) {
            System.out.println(first);
            
        }
        if (n>=1) {
            System.out.println(second);
        }
        for(int i=2;i<=n;i++){
            
            int third=first+second;
            System.out.println(third);
            first=second;
            second=third;
        }
    }

    public static int recursive(int n){
        
        if (n<=1) {
            return n;
        }
        else{
            
            return recursive(n-1)+recursive(n-2);
            
        }
    }

    public static void main(String[] args) {
        System.out.println("enter no. to find fibonacci sequence of :");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        nonRecurssive(n);
        System.out.println("****************************************************************************");
        for(int i=0;i<=n;i++){
            System.out.println(recursive(i));
        }
        
        
    }
}