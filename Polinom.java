package model;

import java.util.ArrayList;
import java.util.Collections;

public class Polinom {
    private ArrayList<Monom> polinom;

    public ArrayList<Monom> getPolinom() {
        return polinom;
    }

    public void setPolinom(ArrayList<Monom> polinom) {
        //Collections.sort(polinom);
        this.polinom = polinom;
    }
}
