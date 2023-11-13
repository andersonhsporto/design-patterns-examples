package strategy;

public class BubbleSort implements SortingAlgorithm {

  @Override
  public void sort(int[] array) {
    boolean swapping = true;
    
    while(swapping) {
      swapping = false;
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i] > array[1 + i]) {
          int temp = array[1 + i];
          
          array[1 + i] = array[i];
          array[i] = temp;
          swapping = true;                      
        }
      }
    }
  }

}
