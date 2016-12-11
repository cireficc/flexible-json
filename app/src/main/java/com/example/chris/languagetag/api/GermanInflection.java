package com.example.chris.languagetag.api;

import com.google.gson.annotations.SerializedName;

public class GermanInflection extends Inflection {

    @SerializedName("case")
    String kase;
    String person;
}
