package adapter;

public class Main {
  
  public static void main (String[] args) {
    
    UniversalTransverseMercator utm = new UniversalTransverseMercator(388736.19, 110547.11, 31, 'N');
    
    DecimalDegrees dd = new DecimalDegrees(1.0,2.0); 
    
    
    DecimalUTMAdapter adapter = new DecimalUTMAdapter(dd);
    
    // method from Coordinate interface
    adapter.printCoordinate();
    
    // convert utm to dd
    adapter.convert(utm).printCoordinate();
    
    // convert dd to utm
    adapter.convert(dd).printCoordinate();
  }
  
}