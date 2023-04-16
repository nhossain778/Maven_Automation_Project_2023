package Day3_03042023;

public class T2_Multiple_Conditions {
    public static void main(String[] args) {
        // using multiple condition staments verify when a+b >c and a+b is <c and a+b == c
        int a = 2;
        int b =3;
        int c = 5;
        if (a+b > c){
            System.out.println("a and b are greater than c");
        } else if (a+b < c){
            System.out.println("a and b are less than c");
            // when tou compare two values it will always be == double equal signs
        } else if (a+b == c){
            System.out.println("a and b is equal to c");
        }// end of multiple condition

    }// end of main
}// emd of java class