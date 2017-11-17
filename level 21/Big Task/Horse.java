package test;

public class Horse {

    String name;
    double speed;
    double distance;
    static int totalDist = 20;

    public Horse (String n, double s, double d){
        this.name = n;
        this.speed = s;
        this.distance = d;
    }

    public void setName(String s){
        this.name = s;
    }

    public void setSpeed(double s){
        this.speed = s;
    }

    public void setDistance(double d){
        this.distance = d;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }


    public void move(){
        distance +=speed*Math.random();
    }
    public void print(){
            for (int x=0; x<Horse.this.getDistance(); x++)
                {System.out.print(".");}

        System.out.println(" -> " + this.getName());
    }
}
