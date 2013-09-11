/**
 * Created with IntelliJ IDEA.
 * User: Stephen
 * Date: 9/10/13
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.*;
public class AiSearch {



    public static void main (String[]args){

        int count = 0;


        char[] chars = "BCDFHJK".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);




        }
        String output = sb.toString();
        System.out.println(output);
        check(output);



    }
    public static void check(CharSequence output){


        for(int i =0; i < output.length(); i++)
            if(output.charAt(i) == 'B'){
                System.out.print("I have a b ");
            }

    }
}

