package test.EPAM_Task1;

public class Surface {
    Dot a;
    Dot b;
    Dot c;
    private double indexX;
    private double indexY;
    private double indexZ;
    private double indexK;
    private double[] surfaceIndexSet = new double[4];

    Surface(Dot a, Dot b, Dot c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] getSurfaceIndexSet() {
        return surfaceIndexSet;
    }

    public void setSurfaceIndexSet(double[] indexSet) {
        this.surfaceIndexSet = indexSet;
    }



    public Dot getA() {
        return a;
    }

    public Dot getB() {
        return b;
    }

    public Dot getC() {
        return c;
    }

    public void setA(Dot a) {
        this.a = a;
    }

    public void setB(Dot b) {
        this.b = b;
    }

    public void setC(Dot c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Surface:\nFirst dot: " + getA().toString() + "\nSecond dot: " + getB().toString() + "\nThird dot: " + getC().toString() + "\n";
    }
}
