/*
 * INSTRUCTION:
 *     This is a Java starting code for hw2_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw2_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw2_2.java
 * Abstract: The purpose of this program is to take a set of input and find all possible 
subsets that can be created from that set. In this program I find the number of potential subsets and convert ints to binary. Then I use the binary result to output and find each possible subset based on the input data.
 * ID: 5323
 * Name: Vera Boukhonine
 * Date: 02/09/2023
 * Reference: https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
   https://www.geeksforgeeks.org/program-decimal-binary-conversion/
   https://www.geeksforgeeks.org/java-program-to-convert-string-to-integer-array/
   https://www.quora.com/What-is-the-formula-to-find-how-many-subsets-are-there-to-a-set
 */
import java.util.*;


public class Main {
    static String decToBinary(int n, int size) {
        String temp = "";
        for (int i = size - 1; i >= 0; i--) {
            int k = n >> i;
            if ((k & 1) > 0) {
                temp += "1 ";
            } else {
                temp += "0 ";
            }
        }
        //ex.1 1 0 is returned
        return temp.trim();
    }

    static String findSubset(String binary, List<String> set) {
        //ex.
        //Set: A B C
        //binary: 0 0 1
        //output: C
        String output = "";
        int total = 0;
        String[] string = binary.split(" ");
        int[] arr = new int[string.length];
        for (int i = 0; i < string.length; i++) {
            arr[i] = Integer.valueOf(string[i]);
        }
        for (int j = 0; j < arr.length; j++) {
            total += arr[j];
            if (arr[j] == 1) {
                output += set.get(j)+" ";
            }
        }
        if (total == 0) {
            output += "EMPTY";
        }
        return output.trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int size = scanner.nextInt();
        List<String> elem = new ArrayList<>();
        
        //if the user enters zero output 
        if(size == 0){
            System.out.println("0:0:EMPTY");
            scanner.close();
            return;
        }
        
        for (int i = 0; i < size; i++) {
            String letter = scanner.next();
            elem.add(letter);
        }
        
        //number of subsets including empty set
        double n = (int) Math.pow(2, size);

        for (int j = 0; j < n; j++) {
            System.out.println(j + ":" + decToBinary(j, elem.size()).replaceAll(" ", "") + ":" + findSubset(decToBinary(j, elem.size()), elem));
        }

        scanner.close();
    }
}