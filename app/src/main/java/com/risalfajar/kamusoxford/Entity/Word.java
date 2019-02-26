package com.risalfajar.kamusoxford.Entity;

public class Word {
    String word;
    String origin;
    LexicalEntry[] lexicalEntries;
}

class LexicalEntry{
    Entry[] entries;
    String lexicalCategory;
    Pronouncitation[] pronouncitations;
    String text;
}

class Entry{
    String origin;
    Sense[] senses;
}

class Sense{
    String[] definitions;
    String[] examples;
    String[] shortDefinitions;
    Subsense[] subsenses;
}

class Subsense{
    String[] definitions;
    String[] examples;
}

class Pronouncitation{
    String audioURL;
    String[] dialects;
}