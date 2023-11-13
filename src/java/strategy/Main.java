package strategy;

public class Main {

    public static void main(String[] args) {
      
      int array[] = { 42, 13, 24, 19, 894, -32, -1};
      
      // bubble sort
      Context context = new Context(new BubbleSort());
      int bubbleArray[] = array.clone();
      System.out.println("Before BubbleSort: ");
      context.printArray(bubbleArray);
      
      context.sort(bubbleArray);
      
      System.out.println("After BubbleSort: ");
      context.printArray(bubbleArray);
      
      //
      // quick sort
      context = new Context(new QuickSort());
      int quickArray[] = array.clone();
      
      System.out.println("Before QuickSort: ");
      context.printArray(quickArray);
      
      context.sort(quickArray);
      
      System.out.println("After QuickSort: ");
      context.printArray(quickArray);
    }
}