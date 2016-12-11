package com.example.chris.languagetag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.chris.languagetag.api.FrenchInflection;
import com.example.chris.languagetag.api.GermanInflection;
import com.example.chris.languagetag.api.Inflection;
import com.example.chris.languagetag.api.JapaneseInflection;
import com.example.chris.languagetag.api.Word;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private final RuntimeTypeAdapterFactory<Inflection> inflectionRuntimeTypeAdapter = RuntimeTypeAdapterFactory
            .of(Inflection.class, "language")
            .registerSubtype(FrenchInflection.class, "French")
            .registerSubtype(GermanInflection.class, "German")
            .registerSubtype(JapaneseInflection.class, "Japanese");

    private final Gson gson = new GsonBuilder().registerTypeAdapterFactory(inflectionRuntimeTypeAdapter).create();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        try {
            final InputStream is = getResources().getAssets().open("words.json");
            java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
            String json = s.hasNext() ? s.next() : "";
            is.close();
            ArrayList<Word> words = gson.fromJson(json, new TypeToken<ArrayList<Word>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
