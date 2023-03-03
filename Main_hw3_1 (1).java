/*
 * INSTRUCTION:
 *     This is a Java starting code for hw3_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw3_1.java".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw3_1.java
 * Abstract: The purpose of this program is to convert directed weight graph data from a user into its adjacency list format. It does by creating a map with the starting vertex as the key the ending vertex and cost are put into an arraylist. 
 * ID: 5323
 * Name: Vera Boukhonine
 * Date: 02/17/2023
 * References: https://stackoverflow.com/questions/10794148/sort-an-arraylist-of-arraylist-of-integers
    https://www.geeksforgeeks.org/print-adjacency-list-for-a-directed-graph/
 */
import java.util.*;

public class Main {

    static void addEdge(Map<Integer, ArrayList<ArrayList<Integer>>> adjacenyListMap, List<Integer> myList) {
        //ex.startVertex = 0, endingVertex = 1, cost = 5
        int startVertex = myList.get(0); 
        int endingVertex = myList.get(1);
        int cost = myList.get(2);
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(endingVertex);
        temp.add(cost);
        adjacenyListMap.get(startVertex).add(temp);

    }

    static void sortMap(Map<Integer, ArrayList<ArrayList<Integer>>> adjacenyListMap) {
        //sorted map ex. {0=[[1, 5], [2, 7]], 1=[], 2=[[0, 9], [1, 3]]}
        for (Integer entry : adjacenyListMap.keySet()) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>(adjacenyListMap.get(entry));
            Collections.sort(temp, new Comparator<ArrayList<Integer>>() {
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    return o1.get(0).compareTo(o2.get(0));
                }
            });
            adjacenyListMap.put(entry, temp);
        }
    }

    static void printGraph(Map<Integer, ArrayList<ArrayList<Integer>>> adjacenyListMap, int vertices) {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i);
            for (int j = 0; j < adjacenyListMap.get(i).size(); j++) {
                ArrayList<Integer> temp = adjacenyListMap.get(i).get(j);
                System.out.print("->" + temp.get(0) + "," + temp.get(1));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int numEdges = scanner.nextInt();

        Map<Integer, ArrayList<ArrayList<Integer>>> adjacenyListMap = new HashMap<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacenyListMap.put(i, new ArrayList<>());
        }

        List<List<Integer>> numList = new ArrayList<>();

        for (int j = 0; j < numEdges; j++) {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int inputNum = scanner.nextInt();
                numbers.add(inputNum);
            }
            numList.add(numbers);
        }
        
        //numList ex. [[0,1,5],[0,2,7],[2,1,3],[2,0,9]]
        
        for (int k = 0; k < numList.size(); k++) {
            addEdge(adjacenyListMap, numList.get(k));
        }
        
        sortMap(adjacenyListMap);
        printGraph(adjacenyListMap, vertices);

        scanner.close();
    }
}