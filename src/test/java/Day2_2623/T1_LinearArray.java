package Day2_2623;

import java.sql.SQLOutput;

public class T1_LinearArray {
    public static void main(String[] args) {

        //create list of cities in linear array
        //array count starts from 0 index
        String[] cities = new String[]{"Brooklyn","Queens","Manhattan","Bronx","Staten Island"};
        //get the count of the list of the cities
        System.out.println("Cities count "+ cities.length);
        //print out Bronx and Brooklyn from the list
        System.out.println("My cities are " + cities[0] + "," + cities[3]);

        //create a list of zipcode
        int[]zipcode = new int[]{11219,11220,33333,55555,};
        //get the count of the list of the zipcode
        System.out.println("zipcode count "+ zipcode.length);
        //print out Bronx and 11219 and 3333 from the list
        System.out.println(" My zipcodes are " + zipcode[0]+ ", " + zipcode[2]);



    }//end of java




}//end of java class
