package Action_item;

import java.util.ArrayList;

public class actionitem1 {
    public static void main(String[] args) {
        //create an ArrayList of countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("South Africa");
        countries.add("Bangladesh");
        countries.add("Spain");
        countries.add("Morocco");
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(27);
        countryCode.add(880);
        countryCode.add(34);
        countryCode.add(506);
        for (int i = 0; i < countries.size(); i++){
            System.out.println("Country is " + countries.get(i) + " country code is " + countryCode.get(i));
        }//end of loop

    }//end of main
}// end of java class
