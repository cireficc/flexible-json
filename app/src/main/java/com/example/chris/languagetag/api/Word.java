package com.example.chris.languagetag.api;

import java.util.List;

public class Word {

    int id;
    String language;
    String pos;

    String original;
    String alternative;
    String transliteration;

    List<Inflection> inflections;
}
