package com.whistle.wfjava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.whistle.whistlefeedjava.Whistlefeed;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Whistlefeed whistlefeed = findViewById(R.id.whistlefeed);
        whistlefeed.setadds("YOUR_PUBLISHER_TOKEN","1");

    }
}