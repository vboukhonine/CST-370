/*
 * INSTRUCTION:
 *     This is a Java starting code for hw4_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw4_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw4_2.java
 * Abstract: The program takes user input in the form of set of numbers that represent apples in baskets corresonding to the index position the apple value is assigned. So we start at basket 0 essentially instead of basket one. Then we find the maximum amount of apples we can obtain from the baskets keeping in mind to skip one basket in set of baskets with apples. This is done by finding the binary represention of n numbers which which find by 2^x = n which gives the total amount of possible subsets. From their we can find different subsets and find their corresponding basket based on the order of the binary string. Then we can find the maxmimum number of apples in the subsets of baskets we've found. 
 * ID: 5323
 * Name: Vera Boukhonine
 * Date: 02/22/2023
 * References: https://www.geeksforgeeks.org/maximum-consecutive-ones-or-zeros-in-a-binary-array/
   https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
   https://www.geeksforgeeks.org/program-decimal-binary-conversion/
   https://www.geeksforgeeks.org/java-program-to-convert-string-to-integer-array/
   hw2_2
 */
import java.util.*;
class Main 
{
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

    static String findSubset(String binary, List<Integer> set) {
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
                output += set.get(j) + " ";
            }
        }
        if (total == 0) {
            output += "EMPTY";
        }
        return output.trim();
    }

    static int getMaxLength(String binary) {
        int[] arr = splitString(binary);

        int count = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                count = 0;
            else {
                count++;
                result = Math.max(result, count);
            }
        }

        return result;
    }

    static int[] splitString(String binary) {
        String[] string = binary.split(" ");
        int[] arr = new int[string.length];
        for (int i = 0; i < string.length; i++) {
            arr[i] = Integer.valueOf(string[i]);
        }
        return arr;
    }
     static void printMax(List<String> myList){
        String boxes = "";
        int maxApples=0;
        for(int i = 0; i< myList.size();i++){
            String[] str = myList.get(i).split(":");
            if(Integer.valueOf(str[1])>maxApples){
                boxes = str[0];
                maxApples=Integer.valueOf(str[1]);
            }
        }
        System.out.println("Boxes:"+boxes+"\n"+"Max Apples:"+maxApples);
    }

    static Integer findApples(String subsets) {
        int[] apples = splitString(subsets);
        int totalApples = 0;
        for (int j = 0; j < apples.length; j++) {
            totalApples += apples[j];
        }
        return totalApples;
    }

    static String findBaskets(String binary) {
        int[] baskets = splitString(binary);
        String temp = "";
        for (int i = 0; i < baskets.length; i++) {
            if (baskets[i] == 1) {
                temp += i + " ";
            }
        }
        return temp.trim();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> boxes = new ArrayList<>();
        
        int numBoxes = scanner.nextInt();
        for(int i = 0;i<numBoxes;i++){
            Integer elem = scanner.nextInt();
            boxes.add(elem);
        }
        
        //number of subsets including empty set
        double n = (int) Math.pow(2, numBoxes);
        
        List<String> myList = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            String binary = decToBinary(j, boxes.size());
            String temp = "";
            if (getMaxLength(binary) == 1) {
                temp += findBaskets(binary) + ":" + findApples(findSubset(binary, boxes));
                myList.add(temp);
            }
        }
        printMax(myList);
        
        
        scanner.close();
    }
}

