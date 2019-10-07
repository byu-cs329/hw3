package edu.byu.cs329.pbt.stateless;
import java.util.Random;

public class BinarySearchTest {
  public static Random rand = new Random();
  
  /**
   * cs329.requires: 
   *    array is non null.
   *    array is sorted by increasing value: 
   *       \forall i, 0 < i < array.length - 1 implies array[i] < array[i+1]
   * cs329.ensures:  
   *       true if an only if \exists i, 0 <= i < array.length /\ value == array[i]
   **/
  public static boolean search(int[] array, int value) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int index = (right + left) / 2;
      if (array[index] == value)
        return true;
      if (array[index] < value)
        right = index - 1;
      else
        left = index + 1;
    }
    return false;

  }

}

