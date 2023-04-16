package Action_item;

public class Grade_ActionItem {
    public static void main(String[] args) {
        int score = 90; //the highest score
        int a = 85;
        int b = 80;
        int c = 75;
        int d = 70;
        int f = 60;
        if (score >= a) {
            System.out.println("Student has received an A f");
        } else if (score >= b) {
            System.out.println("Student received b grade");
        } else if (score >= c) {
            System.out.println("Student received an c grade");
        } else if (score >= d)
            System.out.println("Student received score of d");
        else{
            System.out.println("Student received a F and failed the class");
        }// end of multiple condition

    }// end of main
}// emd of java class
