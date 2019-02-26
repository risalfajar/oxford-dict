package com.risalfajar.kamusoxford.Entity;

import java.util.ArrayList;

public class LexicalEntry{
    ArrayList<Entry> entries;
    String lexicalCategory;
    ArrayList<Pronouncitation> pronouncitations;
    String text;

    public ArrayList<Entry> getEntries() {
        return entries;
    }

    public void setEntries(ArrayList<Entry> entries) {
        this.entries = entries;
    }

    public String getLexicalCategory() {
        return lexicalCategory;
    }

    public void setLexicalCategory(String lexicalCategory) {
        this.lexicalCategory = lexicalCategory;
    }

    public ArrayList<Pronouncitation> getPronouncitations() {
        return pronouncitations;
    }

    public void setPronouncitations(ArrayList<Pronouncitation> pronouncitations) {
        this.pronouncitations = pronouncitations;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
