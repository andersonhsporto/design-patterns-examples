package builder;

public class House {
  private final String name;
  private final int windows;
  private final int doors;
  private final int walls;
  
  public static class Builder {
    private String name;
    private int windows;
    private int doors;
    private int walls;
    
    public Builder name(String name) {
      this.name = name;
      return this;
    }
    
    public Builder windows(int windows) {
      this.windows = windows;
      return this;
    }
    
    public Builder doors(int doors) {
      this.doors = doors;
      return this;
    }
    
    public Builder walls(int walls) {
      this.walls = walls;
      return this;
    }
    
    public House build() {
      return new House(this);
    }
  }

  private House(Builder builder) {
    this.name = builder.name;
    this.windows = builder.windows;
    this.doors = builder.doors;
    this.walls = builder.walls;
  }

  @Override
  public String toString() {
    return "House [name=" + name + ", windows=" + windows + ", doors=" + doors + ", walls=" + walls
        + "]";
  }
  
  
}
