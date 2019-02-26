package com.risalfajar.kamusoxford.Entity;

import java.util.ArrayList;

public class Sense{
    String[] definitions;
    String[] examples;
    String[] shortDefinitions;
    ArrayList<Subsense> subsenses;

    public String[] getDefinitions() {
        return definitions;
    }

    public void setDefinitions(String[] definitions) {
        this.definitions = definitions;
    }

    public String[] getExamples() {
        return examples;
    }

    public void setExamples(String[] examples) {
        this.examples = examples;
    }

    public String[] getShortDefinitions() {
        return shortDefinitions;
    }

    public void setShortDefinitions(String[] shortDefinitions) {
        this.shortDefinitions = shortDefinitions;
    }

    public ArrayList<Subsense> getSubsenses() {
        return subsenses;
    }

    public void setSubsenses(ArrayList<Subsense> subsenses) {
        this.subsenses = subsenses;
    }
}
