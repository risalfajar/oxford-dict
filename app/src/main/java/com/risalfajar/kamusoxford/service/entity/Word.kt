package com.risalfajar.kamusoxford.service.entity

import java.util.*

data class Word(var id: String) {
    var origin: String? = null
    var lexicalEntries: ArrayList<LexicalEntry>? = null
}

class LexicalEntry {
    var entries: ArrayList<Entry>? = null
    var lexicalCategory: String? = null
    var pronouncitations: ArrayList<Pronouncitation>? = null
    var text: String? = null
}

class Entry {
    var origin: String? = null
    var senses: ArrayList<Sense>? = null
}

class Sense {
    var definitions: Array<String>? = null
    var examples: Array<String>? = null
    var shortDefinitions: Array<String>? = null
    var subsenses: ArrayList<Subsense>? = null
}

class Subsense {
    var definitions: Array<String>? = null
    var examples: Array<String>? = null
}