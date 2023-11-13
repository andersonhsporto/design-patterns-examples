package strategy;

public class Context {

  private SortingAlgorithm sortingAlgorithm;

  public Context(SortingAlgorithm sortingAlgorithm) {
    this.sortingAlgorithm = sortingAlgorithm;
  }

  public SortingAlgorithm getSortingAlgorithm() {
    return sortingAlgorithm;
  }

  public void setSortingAlgorithm(SortingAlgorithm sortingAlgorithm) {
    this.sortingAlgorithm = sortingAlgorithm;
  }
  
  public void sort(int array[]) {
    this.sortingAlgorithm.sort(array);
  }
  
  public void printArray(int array[]) {
    for (int n: array) {
      System.out.println(n);
    }
  }
  
}