package builder;

public class Main {
  public static void main(String[] args) {
    House house = new House
        .Builder()
        .name("Casa")
        .windows(4)
        .doors(3)
        .walls(5)
        .build();
    
    System.out.println(house.toString());
  }
}