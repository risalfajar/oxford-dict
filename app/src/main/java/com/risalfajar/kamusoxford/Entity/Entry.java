package com.risalfajar.kamusoxford.Entity;

import java.util.ArrayList;

public class Entry{
    String origin;
    ArrayList<Sense> senses;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public ArrayList<Sense> getSenses() {
        return senses;
    }

    public void setSenses(ArrayList<Sense> senses) {
        this.senses = senses;
    }
}
