package adapter;

public class DecimalDegrees implements Coordinates {

  private double latitude;

  private double longitude;

  public DecimalDegrees(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  @Override
  public void printCoordinate() {
    System.out.println("Latitude: " + latitude + " Longitude: " + longitude);
  }

}
