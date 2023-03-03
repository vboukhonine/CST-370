/*
 * INSTRUCTION:
 *     This is a Java starting code for hw2_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw2_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw2_1.java
 * Abstract: The purpose of this program is to take a string and determine if it is palindrome. This program uses regular expressions to remove all special characters ignoring them when determining if the input is a palindrome. A palindrome is word that is the same forwards as it is backwards. 
 * ID: 5323
 * Name: Vera Boukhonine
 * Date: 02/09/2023
 * Reference: https://www.javatpoint.com/how-to-remove-special-characters-from-string-in-java
   https://www.geeksforgeeks.org/reverse-a-string-in-java/
   https://www.geeksforgeeks.org/java-string-charat-method-example/
 */
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = "";
        inputString = scanner.nextLine();
        //Here I make all the letters uppercase for ease of comparison
        inputString = inputString.toUpperCase();
        //I use this line to remove any special characters
        inputString = inputString.replaceAll("[^a-zA-Z0-9]", "");
        
        StringBuilder pString = new StringBuilder();
        pString.append(inputString);
        pString.reverse();
      
        String str = "";
        str = pString.toString();
        int stringSize = str.length();
        //This loop finds the first char that is different
        for(int i= 0;i<stringSize;i++){
            if(inputString.charAt(i)!=str.charAt(i)){
                char answer = inputString.charAt(i);
                System.out.println("NO:"+answer);
                break;
            }
        }
        //I check if my reversed string is the same as input string
        if (inputString.equals(str)) {
            System.out.println("PALINDROME");
        } 
        scanner.close();
    }
}

