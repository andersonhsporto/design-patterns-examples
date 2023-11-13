package adapter;

public class DecimalUTMAdapter implements Coordinates {

  private Coordinates coordinates;

  public DecimalUTMAdapter(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  @Override
  public void printCoordinate() {
    coordinates.printCoordinate();
  }
  
  public UniversalTransverseMercator degreeToUTM(DecimalDegrees dd) {
    double Easting;
    double Northing;
    int Zone;
    char Letter;
    
    Zone= (int) Math.floor(dd.getLongitude()/6+31);
    if (dd.getLatitude()<-72) 
        Letter='C';
    else if (dd.getLatitude()<-64) 
        Letter='D';
    else if (dd.getLatitude()<-56)
        Letter='E';
    else if (dd.getLatitude()<-48)
        Letter='F';
    else if (dd.getLatitude()<-40)
        Letter='G';
    else if (dd.getLatitude()<-32)
        Letter='H';
    else if (dd.getLatitude()<-24)
        Letter='J';
    else if (dd.getLatitude()<-16)
        Letter='K';
    else if (dd.getLatitude()<-8) 
        Letter='L';
    else if (dd.getLatitude()<0)
        Letter='M';
    else if (dd.getLatitude()<8)  
        Letter='N';
    else if (dd.getLatitude()<16) 
        Letter='P';
    else if (dd.getLatitude()<24) 
        Letter='Q';
    else if (dd.getLatitude()<32) 
        Letter='R';
    else if (dd.getLatitude()<40) 
        Letter='S';
    else if (dd.getLatitude()<48) 
        Letter='T';
    else if (dd.getLatitude()<56) 
        Letter='U';
    else if (dd.getLatitude()<64) 
        Letter='V';
    else if (dd.getLatitude()<72) 
        Letter='W';
    else
        Letter='X';
    Easting=0.5*Math.log((1+Math.cos(dd.getLatitude()*Math.PI/180)*Math.sin(dd.getLongitude()*Math.PI/180-(6*Zone-183)*Math.PI/180))/(1-Math.cos(dd.getLatitude()*Math.PI/180)*Math.sin(dd.getLongitude()*Math.PI/180-(6*Zone-183)*Math.PI/180)))*0.9996*6399593.62/Math.pow((1+Math.pow(0.0820944379, 2)*Math.pow(Math.cos(dd.getLatitude()*Math.PI/180), 2)), 0.5)*(1+ Math.pow(0.0820944379,2)/2*Math.pow((0.5*Math.log((1+Math.cos(dd.getLatitude()*Math.PI/180)*Math.sin(dd.getLongitude()*Math.PI/180-(6*Zone-183)*Math.PI/180))/(1-Math.cos(dd.getLatitude()*Math.PI/180)*Math.sin(dd.getLongitude()*Math.PI/180-(6*Zone-183)*Math.PI/180)))),2)*Math.pow(Math.cos(dd.getLatitude()*Math.PI/180),2)/3)+500000;
    Easting=Math.round(Easting*100)*0.01;
    Northing = (Math.atan(Math.tan(dd.getLatitude()*Math.PI/180)/Math.cos((dd.getLongitude()*Math.PI/180-(6*Zone -183)*Math.PI/180)))-dd.getLatitude()*Math.PI/180)*0.9996*6399593.625/Math.sqrt(1+0.006739496742*Math.pow(Math.cos(dd.getLatitude()*Math.PI/180),2))*(1+0.006739496742/2*Math.pow(0.5*Math.log((1+Math.cos(dd.getLatitude()*Math.PI/180)*Math.sin((dd.getLongitude()*Math.PI/180-(6*Zone -183)*Math.PI/180)))/(1-Math.cos(dd.getLatitude()*Math.PI/180)*Math.sin((dd.getLongitude()*Math.PI/180-(6*Zone -183)*Math.PI/180)))),2)*Math.pow(Math.cos(dd.getLatitude()*Math.PI/180),2))+0.9996*6399593.625*(dd.getLatitude()*Math.PI/180-0.005054622556*(dd.getLatitude()*Math.PI/180+Math.sin(2*dd.getLatitude()*Math.PI/180)/2)+4.258201531e-05*(3*(dd.getLatitude()*Math.PI/180+Math.sin(2*dd.getLatitude()*Math.PI/180)/2)+Math.sin(2*dd.getLatitude()*Math.PI/180)*Math.pow(Math.cos(dd.getLatitude()*Math.PI/180),2))/4-1.674057895e-07*(5*(3*(dd.getLatitude()*Math.PI/180+Math.sin(2*dd.getLatitude()*Math.PI/180)/2)+Math.sin(2*dd.getLatitude()*Math.PI/180)*Math.pow(Math.cos(dd.getLatitude()*Math.PI/180),2))/4+Math.sin(2*dd.getLatitude()*Math.PI/180)*Math.pow(Math.cos(dd.getLatitude()*Math.PI/180),2)*Math.pow(Math.cos(dd.getLatitude()*Math.PI/180),2))/3);
    if (Letter<'M')
        Northing = Northing + 10000000;
    Northing=Math.round(Northing*100)*0.01;
    
    return new UniversalTransverseMercator(Easting, Northing, Zone, Letter);
  }
  
  public DecimalDegrees UTMToDegree(UniversalTransverseMercator UTM) {
    double latitude;
    double longitude;
    
    double Easting=UTM.getEasting();
    double Northing=UTM.getNorthing();          
    double Hem;
    
    if (UTM.getLetter()>'M')
        Hem='N';
    else
        Hem='S';            
    double north;
    if (Hem == 'S')
        north = Northing - 10000000;
    else
        north = Northing;
    latitude = (north/6366197.724/0.9996+(1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2)-0.006739496742*Math.sin(north/6366197.724/0.9996)*Math.cos(north/6366197.724/0.9996)*(Math.atan(Math.cos(Math.atan(( Math.exp((Easting - 500000) / (0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2))))*(1-0.006739496742*Math.pow((Easting - 500000) / (0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2)))),2)/2*Math.pow(Math.cos(north/6366197.724/0.9996),2)/3))-Math.exp(-(Easting-500000)/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2))))*( 1 -  0.006739496742*Math.pow((Easting - 500000) / (0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2)))),2)/2*Math.pow(Math.cos(north/6366197.724/0.9996),2)/3)))/2/Math.cos((north-0.9996*6399593.625*(north/6366197.724/0.9996-0.006739496742*3/4*(north/6366197.724/0.9996+Math.sin(2*north/6366197.724/0.9996)/2)+Math.pow(0.006739496742*3/4,2)*5/3*(3*(north/6366197.724/0.9996+Math.sin(2*north/6366197.724/0.9996 )/2)+Math.sin(2*north/6366197.724/0.9996)*Math.pow(Math.cos(north/6366197.724/0.9996),2))/4-Math.pow(0.006739496742*3/4,3)*35/27*(5*(3*(north/6366197.724/0.9996+Math.sin(2*north/6366197.724/0.9996)/2)+Math.sin(2*north/6366197.724/0.9996)*Math.pow(Math.cos(north/6366197.724/0.9996),2))/4+Math.sin(2*north/6366197.724/0.9996)*Math.pow(Math.cos(north/6366197.724/0.9996),2)*Math.pow(Math.cos(north/6366197.724/0.9996),2))/3))/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2))))*(1-0.006739496742*Math.pow((Easting-500000)/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2)))),2)/2*Math.pow(Math.cos(north/6366197.724/0.9996),2))+north/6366197.724/0.9996)))*Math.tan((north-0.9996*6399593.625*(north/6366197.724/0.9996 - 0.006739496742*3/4*(north/6366197.724/0.9996+Math.sin(2*north/6366197.724/0.9996)/2)+Math.pow(0.006739496742*3/4,2)*5/3*(3*(north/6366197.724/0.9996+Math.sin(2*north/6366197.724/0.9996)/2)+Math.sin(2*north/6366197.724/0.9996 )*Math.pow(Math.cos(north/6366197.724/0.9996),2))/4-Math.pow(0.006739496742*3/4,3)*35/27*(5*(3*(north/6366197.724/0.9996+Math.sin(2*north/6366197.724/0.9996)/2)+Math.sin(2*north/6366197.724/0.9996)*Math.pow(Math.cos(north/6366197.724/0.9996),2))/4+Math.sin(2*north/6366197.724/0.9996)*Math.pow(Math.cos(north/6366197.724/0.9996),2)*Math.pow(Math.cos(north/6366197.724/0.9996),2))/3))/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2))))*(1-0.006739496742*Math.pow((Easting-500000)/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2)))),2)/2*Math.pow(Math.cos(north/6366197.724/0.9996),2))+north/6366197.724/0.9996))-north/6366197.724/0.9996)*3/2)*(Math.atan(Math.cos(Math.atan((Math.exp((Easting-500000)/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2))))*(1-0.006739496742*Math.pow((Easting-500000)/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2)))),2)/2*Math.pow(Math.cos(north/6366197.724/0.9996),2)/3))-Math.exp(-(Easting-500000)/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2))))*(1-0.006739496742*Math.pow((Easting-500000)/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2)))),2)/2*Math.pow(Math.cos(north/6366197.724/0.9996),2)/3)))/2/Math.cos((north-0.9996*6399593.625*(north/6366197.724/0.9996-0.006739496742*3/4*(north/6366197.724/0.9996+Math.sin(2*north/6366197.724/0.9996)/2)+Math.pow(0.006739496742*3/4,2)*5/3*(3*(north/6366197.724/0.9996+Math.sin(2*north/6366197.724/0.9996)/2)+Math.sin(2*north/6366197.724/0.9996)*Math.pow(Math.cos(north/6366197.724/0.9996),2))/4-Math.pow(0.006739496742*3/4,3)*35/27*(5*(3*(north/6366197.724/0.9996+Math.sin(2*north/6366197.724/0.9996)/2)+Math.sin(2*north/6366197.724/0.9996)*Math.pow(Math.cos(north/6366197.724/0.9996),2))/4+Math.sin(2*north/6366197.724/0.9996)*Math.pow(Math.cos(north/6366197.724/0.9996),2)*Math.pow(Math.cos(north/6366197.724/0.9996),2))/3))/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2))))*(1-0.006739496742*Math.pow((Easting-500000)/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2)))),2)/2*Math.pow(Math.cos(north/6366197.724/0.9996),2))+north/6366197.724/0.9996)))*Math.tan((north-0.9996*6399593.625*(north/6366197.724/0.9996-0.006739496742*3/4*(north/6366197.724/0.9996+Math.sin(2*north/6366197.724/0.9996)/2)+Math.pow(0.006739496742*3/4,2)*5/3*(3*(north/6366197.724/0.9996+Math.sin(2*north/6366197.724/0.9996)/2)+Math.sin(2*north/6366197.724/0.9996)*Math.pow(Math.cos(north/6366197.724/0.9996),2))/4-Math.pow(0.006739496742*3/4,3)*35/27*(5*(3*(north/6366197.724/0.9996+Math.sin(2*north/6366197.724/0.9996)/2)+Math.sin(2*north/6366197.724/0.9996)*Math.pow(Math.cos(north/6366197.724/0.9996),2))/4+Math.sin(2*north/6366197.724/0.9996)*Math.pow(Math.cos(north/6366197.724/0.9996),2)*Math.pow(Math.cos(north/6366197.724/0.9996),2))/3))/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2))))*(1-0.006739496742*Math.pow((Easting-500000)/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2)))),2)/2*Math.pow(Math.cos(north/6366197.724/0.9996),2))+north/6366197.724/0.9996))-north/6366197.724/0.9996))*180/Math.PI;
    latitude=Math.round(latitude*10000000);
    latitude=latitude/10000000;
    longitude =Math.atan((Math.exp((Easting-500000)/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2))))*(1-0.006739496742*Math.pow((Easting-500000)/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2)))),2)/2*Math.pow(Math.cos(north/6366197.724/0.9996),2)/3))-Math.exp(-(Easting-500000)/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2))))*(1-0.006739496742*Math.pow((Easting-500000)/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2)))),2)/2*Math.pow(Math.cos(north/6366197.724/0.9996),2)/3)))/2/Math.cos((north-0.9996*6399593.625*( north/6366197.724/0.9996-0.006739496742*3/4*(north/6366197.724/0.9996+Math.sin(2*north/6366197.724/0.9996)/2)+Math.pow(0.006739496742*3/4,2)*5/3*(3*(north/6366197.724/0.9996+Math.sin(2*north/6366197.724/0.9996)/2)+Math.sin(2* north/6366197.724/0.9996)*Math.pow(Math.cos(north/6366197.724/0.9996),2))/4-Math.pow(0.006739496742*3/4,3)*35/27*(5*(3*(north/6366197.724/0.9996+Math.sin(2*north/6366197.724/0.9996)/2)+Math.sin(2*north/6366197.724/0.9996)*Math.pow(Math.cos(north/6366197.724/0.9996),2))/4+Math.sin(2*north/6366197.724/0.9996)*Math.pow(Math.cos(north/6366197.724/0.9996),2)*Math.pow(Math.cos(north/6366197.724/0.9996),2))/3)) / (0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2))))*(1-0.006739496742*Math.pow((Easting-500000)/(0.9996*6399593.625/Math.sqrt((1+0.006739496742*Math.pow(Math.cos(north/6366197.724/0.9996),2)))),2)/2*Math.pow(Math.cos(north/6366197.724/0.9996),2))+north/6366197.724/0.9996))*180/Math.PI+UTM.getZone()*6-183;
    longitude=Math.round(longitude*10000000);
    longitude=longitude/10000000;
    
    return new DecimalDegrees(latitude, longitude);
  }
  
  public Coordinates convert(Coordinates coord) {
    if (coord.getClass() == DecimalDegrees.class) {
      return this.degreeToUTM((DecimalDegrees) coord);
    }
    return this.UTMToDegree((UniversalTransverseMercator) coord);
  }

}
