/*
 * INSTRUCTION:
 *     This is a Java starting code for hw4_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw4_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw4_1.java
 * Abstract: This program takes multiple numbers inputed by a user sorts them in ascending order and orders consecutive numbers in the input into a range like in the following set in the format below.
    1 2 3 7 9 13 -> 1-3 7 9 13. 
 * ID: 5323
 * Name: Vera Boukhonine
 * Date: 02/22/2023
 * References: https://stackoverflow.com/questions/26570184/find-groups-of-continuous-integers-in-a-list-in-java
   https://www.geeksforgeeks.org/find-all-ranges-of-consecutive-numbers-from-array/
 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputSize = scanner.nextInt();
        List<Integer> myList = new ArrayList<>();
        List<List<Integer>> values = new ArrayList<>();
        for (int i = 0; i < inputSize; i++) {
            int inputNum = scanner.nextInt();
            myList.add(inputNum);
        }

        Collections.sort(myList);
        
        List<Integer> ranges = new ArrayList<>();
        int currentPlace = 0;
        for (int j = 1; j < myList.size(); j++) {
            int startVal = myList.get(j - 1) + 1;
            int nextVal = myList.get(j);
            if (startVal != nextVal) {
                currentPlace = j;
                if (!ranges.contains(myList.get(j - 1))) {
                    ranges.add(myList.get(j - 1));
                }
                values.add(ranges);
                ranges = new ArrayList<>();
            }
            if (!ranges.contains(myList.get(currentPlace))) {
                ranges.add(myList.get(currentPlace));
            }
        }
        if (!ranges.contains(myList.get(myList.size() - 1))) {
            ranges.add(myList.get(myList.size() - 1));
        }
        values.add(ranges);

        String output = "";
        for (List<Integer> temp : values) {
            if (temp.size() == 2) {
                output += temp.get(0) + "-" + temp.get(1) + " ";
            }
            if (temp.size() == 1) {
                output += temp.get(0) + " ";
            }
        }
        System.out.println(output.trim());

        scanner.close();
    }
}
