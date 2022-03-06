package model;

public class Monom implements Comparable<Monom>{
    private float coef;
    private int power;
    public float getCoef() {
        return coef;
    }
    public void setCoef(float coef) {
        this.coef = coef;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    @Override
    public int compareTo(Monom m)
    {
        return m.power - this.power;
    }

}
