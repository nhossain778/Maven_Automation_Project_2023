package Day2_2623;

import java.util.ArrayList;

public class T2_Arraylist {
    public static void main(String[] args) {
        ArrayList <String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("India");
        countries.add("Bangladesh");
        countries.add("Pakistan");
        //get the count of the list
        System.out.println("Countires list: " + countries.size());
        //Print only Bangladesh usa and india
        System.out.println("Countries are " + countries.get(0) + "," + countries.get(1) +", " + countries.get(2));

        countries.add("Russia");
        //get count of the list
        System.out.println("Countires list: " + countries.size());
        System.out.println(countries.get(4));
        //to ge the lsit value dynamically do the follwong
        //System.out.println("countries.get(countries.size()-1))

        //create an Integer arrayList of area code
        ArrayList <Integer> areaCode = new ArrayList<>();
        areaCode.add(777);
        areaCode.add(222);
        areaCode.add(333);
//get the count of the list
        System.out.println("Area code list: " + areaCode.size());
//Print the first and third area code
        System.out.println("Area codes are " + areaCode.get(0) + ", " + areaCode.get(2));





    }//end of main
}//end of java class
