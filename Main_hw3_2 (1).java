/*
 * INSTRUCTION:
 *     This is a Java starting code for hw3_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw3_2.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw3_2.java
 * Abstract: The purpose of this program is to find when two events take place concurrently in a data set consisting of when events start and end. It does so by finding which ranges or time intervals overlapp and keeping a count of them return the result to the user.
 * ID: 5323
 * Name: Vera Boukhonine
 * Date: 02/17/2023
 * References: https://www.geeksforgeeks.org/check-if-any-two-intervals-overlap-among-a-given-set-of-intervals/
https://stackoverflow.com/questions/10794148/sort-an-arraylist-of-arraylist-of-integers
https://stackoverflow.com/questions/3269434/whats-the-most-efficient-way-to-test-if-two-ranges-overlap
 */
import java.util.*;

public class Main 
{
     static void sortIntervals(ArrayList<ArrayList<Integer>> timeIntervals){
       Collections.sort(timeIntervals, new Comparator<ArrayList<Integer>>() {
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    return o1.get(0).compareTo(o2.get(0));
                }
            });
    }
    static int isIntersect(ArrayList<ArrayList<Integer>> timeIntervals, int numberOfEvents){
        int intersectionCount = 0;
        int result = 0;
        //If numberOfEvents is equal to one we have some event taking place but no intersections
        if(numberOfEvents == 1){
            result = 1;
            return result;
        }
        // (x1,x2) and (y1,y2)
        //x1 <= y2 && y1 <= x2
        for (int i = 1; i < numberOfEvents; i++) {
            int firstIntervalStart = timeIntervals.get(i-1).get(0);
            int firstIntervalEnd = timeIntervals.get(i-1).get(1);
            int secondIntervalStart = timeIntervals.get(i).get(0);
            int secondIntervalEnd = timeIntervals.get(i).get(1);
            
            if(firstIntervalStart<=secondIntervalEnd&&secondIntervalStart<=firstIntervalEnd){
                intersectionCount++;
            }

            //This code checks if their is any number the the time intervals that intersect keeping count
            if(firstIntervalStart == secondIntervalStart && firstIntervalEnd == secondIntervalEnd){
                intersectionCount--;
            } 
        }
        //This code checks if we do have events but no intersections and returns the result one 
         if(numberOfEvents !=0 && intersectionCount == 0){
            result = 1;
            return result;
        }
        
        return intersectionCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEvents = scanner.nextInt();
        ArrayList<ArrayList<Integer>> timeIntervals = new ArrayList<>();
        for(int i = 0;i<numberOfEvents;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            temp.add(startTime);
            temp.add(endTime);
            timeIntervals.add(temp);
        }
        sortIntervals(timeIntervals);

        System.out.println("Max events: "+isIntersect(timeIntervals,numberOfEvents));
        
        scanner.close();
    }
}