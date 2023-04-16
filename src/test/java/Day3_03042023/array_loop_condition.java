package Day3_03042023;

import java.util.ArrayList;

public class array_loop_condition {
    public static void main(String[] args) {
        //itterate through list of food using array list but only print out fruit id grape or apple

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("grape");
        fruits.add("strawberry");
        fruits.add("Orange");

        for (int i = 0; i < fruits.size(); i++) {
            //using the OR operator
            if(fruits.get(i) == "Apple" || fruits.get(i) == "Grape") {
                System.out.println("Fruits: " + fruits.get(i));
            }// end of condition

        }// end of loop


    }//end of main

}// end of class

