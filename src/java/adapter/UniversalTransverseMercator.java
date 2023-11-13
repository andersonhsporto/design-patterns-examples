package adapter;

public class UniversalTransverseMercator implements Coordinates {

  double Easting;

  double Northing;

  int Zone;

  char Letter;

  public UniversalTransverseMercator(double easting, double northing, int zone, char letter) {
    Easting = easting;
    Northing = northing;
    Zone = zone;
    Letter = letter;
  }

  public double getEasting() {
    return Easting;
  }

  public void setEasting(double easting) {
    Easting = easting;
  }

  public double getNorthing() {
    return Northing;
  }

  public void setNorthing(double northing) {
    Northing = northing;
  }

  public int getZone() {
    return Zone;
  }

  public void setZone(int zone) {
    Zone = zone;
  }

  public char getLetter() {
    return Letter;
  }

  public void setLetter(char letter) {
    Letter = letter;
  }

  @Override
  public void printCoordinate() {
    StringBuilder sb = new StringBuilder();

    sb.append("Easting: " + Easting).append(" Northing: " + Northing).append(" Zone: " + Zone)
        .append(" Letter: " + Letter).toString();

    System.out.println(sb.toString());
  }
}
