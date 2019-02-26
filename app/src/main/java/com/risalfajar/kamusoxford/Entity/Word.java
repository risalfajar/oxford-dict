package com.risalfajar.kamusoxford.Entity;

import java.util.ArrayList;

public class Word {
    String id;
    String origin;
    ArrayList<LexicalEntry> lexicalEntries;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public ArrayList<LexicalEntry> getLexicalEntries() {
        return lexicalEntries;
    }

    public void setLexicalEntries(ArrayList<LexicalEntry> lexicalEntries) {
        this.lexicalEntries = lexicalEntries;
    }
}
