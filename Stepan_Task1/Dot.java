package test.EPAM_Task1;

public class Dot {
    double x;
    double y;
    double z;

    Dot (double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y + ", z= " + z;
    }

    public boolean equals(Dot d) {
        if((d.getX() == this.x) && (d.getY() == this.y) && (d.getZ() == d.getZ()))
        return true;
        return false;
    }
}