package Arrays;


import java.util.HashMap;
import java.util.Map;

public class RearrangeToTarget {

    public static void rearrange(int[] input, int[] target) {
        assert (input.length == target.length);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        buildIndex(input, map);
        int zeroIndex = findIndex(input, 0);
        int numMoves = 0;

        while (numMoves < input.length) {
            if (target[zeroIndex] == 0) {
                int outOfOrderIndex = findFirstOutOfOrderIndex(input, target);
                if (outOfOrderIndex == -1) {
                    return;
                }

                map.put(input[outOfOrderIndex], zeroIndex);
                swap(input, zeroIndex, outOfOrderIndex);
                zeroIndex = outOfOrderIndex;

            } else {
                int nextZeroIndex = map.get(target[zeroIndex]);
                swap(input, zeroIndex, nextZeroIndex);
                zeroIndex = nextZeroIndex;
                numMoves++;
            }
        }

    }

    private static void swap(int[] input, int zeroIndex, int nextZeroIndex) {
        int temp = input[zeroIndex];
        input[zeroIndex] = input[nextZeroIndex];
        input[nextZeroIndex] = temp;
    }

    private static int findIndex(int[] input, int num) {
        for(int i = 0; i < input.length; i++){
            if (num == input[i]){
                return i;
            }
        }
        return -1;
    }


    private static void buildIndex(int[] input, Map<Integer, Integer> index) {
        for (int location = 0; location < input.length; location++) {
            index.put(input[location], location);
        }
    }

    private static int findFirstOutOfOrderIndex(int[] input, int[] target) {
        assert (input.length == target.length);

        for (int index = 0; index < input.length; index++) {
            if (input[index] != target[index]) {
                return index;
            }
        }

        return -1;
    }
}
