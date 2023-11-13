package strategy;

public class QuickSort implements SortingAlgorithm {

  @Override
  public void sort(int[] array) {
    int low = 0;
    int high = array.length - 1;

    mainSort(array, low, high);
  }

  private void mainSort(int[] arr, int low, int high) {
    if (low < high) {

      // pi is partitioning index, arr[p]
      // is now at right place
      int pi = partition(arr, low, high);

      // Separately sort elements before
      // partition and after partition
      mainSort(arr, low, pi - 1);
      mainSort(arr, pi + 1, high);
    }
  }

  private int partition(int[] arr, int low, int high) {
    // Choosing the pivot
    int pivot = arr[high];

    // Index of smaller element and indicates
    // the right position of pivot found so far
    int i = (low - 1);

    for (int j = low; j <= high - 1; j++) {

      // If current element is smaller than the pivot
      if (arr[j] < pivot) {

        // Increment index of smaller element
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, high);
    return (i + 1);
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
