package main;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class MigratoryBirds {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int migratoryBirds(List<Integer> arr) {
        SortedMap<Integer, Integer> results = new TreeMap<>();

        int highestCountSoFar = 0;
//        int keyOfHighestCountSoFar = 0;

        for (Integer current : arr) {
            Integer inResults = results.get(current);
            if (null == inResults) {
                inResults = 0;
            }

            results.put(current, ++inResults);

            if (inResults > highestCountSoFar) {
                highestCountSoFar = inResults;
//                keyOfHighestCountSoFar = current;
            }

            //System.out.println("current: " + current);
        }

//        System.out.println("highestCountSoFar: " + highestCountSoFar);
//        System.out.println("keyOfHighestCountSoFar: " + keyOfHighestCountSoFar);
//        System.out.println("results: " + results.toString());

        Integer lowestId = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : results.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (highestCountSoFar == value && key < lowestId) {
                lowestId = key;
            }
        }

        return lowestId;
    }
}
