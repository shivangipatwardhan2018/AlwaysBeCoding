package Algorithms;

/**
 * Created by shivangipatwardhan on 3/1/18.
 */
public class MagicIndex {


  //Questions to Ask
    // Distict vs. not distict
    // Will there be negative numbers
    // input format, expected output


  public int magicalIndexRecurseNotDistinct(int[] input){
      if(input == null) return -1;
      if(input.length == 0)  return (input[0] == 0) ? 0: -1;

      return findTheMagic(input, 0, input.length);
  }

  public int magicalIndexRecurse(int[] input){
      if(input == null) return -1;
      if(input.length == 0)  return (input[0] == 0) ? 0: -1;

      return findTheMagic(input, 0, input.length);
  }

    private int findTheMagic(int[] input, int start, int end) {
        //Base Case
        if(input.length <= end || start < 0 || start > end){
            return -1;
        }

        int mid = (end - start)/2;
        if(input[mid] == mid) return mid;
        if(input[mid] < mid) return findTheMagic(input, mid, end);
        if(input[mid] > mid) return findTheMagic(input, start, mid + 1);
        return -1;
    }

    public int  magicalIndexBasic(int[] input){
      for(int i = 0; i < input.length; i++){
          if(input[i] == i) return i;
          if(input[i] > input.length) return -1;
      }
      return -1;
  }

  public int magicalIndexJump(int[] input){
        int magic = -1;

        for(int i = 0; i < input.length; i++){
            if(input[i] == i){
                magic = i;
                break;
            }

            if (input[i] < input.length && input[i] >= 0){
                i = input[i];
            }else{
                //If here there is no chance of the input[index] == index since array is sorted.
                break;
            }

        }
    return magic;
  }

}
