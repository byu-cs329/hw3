package edu.byu.cs329.mcdc;

public class McDcTest {


  public static boolean f(boolean a, boolean b, boolean c, boolean d) {
    return (a && b) || (c && d);
  }
  
  public static int[] sort(int[] array, int from, int to) {
    if (from >= to) {
      return new int[] { array[from] };
    }

    int m = (from + to) / 2;
    int[] left = sort(array, from, m - 1);
    int[] right = sort(array, m + 1, to);

    int[] result = new int[left.length + right.length];
    int li = 0;
    int ri = 0;
    for (int i = 0; i < result.length; i++) {
      if (li < left.length && (ri >= right.length || left[li] < right[ri])) {
        result[i] = left[li];
        li++;
      } else {
        result[i] = right[ri];
        ri++;
      }
    }

    return result;
  }

}