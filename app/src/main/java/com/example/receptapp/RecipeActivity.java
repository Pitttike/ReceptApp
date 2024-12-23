package com.example.receptapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RecipeActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView qualityTextView;
    private TextView difficultyTextView;
    private TextView yearTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        String name = getIntent().getStringExtra("name");
        String quality = getIntent().getStringExtra("quality");
        String difficulty = getIntent().getStringExtra("difficulty");
        Random random = new Random();
        Integer year = random.nextInt(2022 - 1900) + 1900;

        init(name, quality, difficulty, year);
    }

    private void init( String name, String quality, String difficulty, int year) {
        nameTextView = findViewById(R.id.name_text);
        qualityTextView = findViewById(R.id.quality_text);
        difficultyTextView = findViewById(R.id.difficulty_text);
        yearTextView = findViewById(R.id.year_text);
        backButton = findViewById(R.id.back_button);

        nameTextView.setText(name);
        qualityTextView.setText(quality);
        difficultyTextView.setText(difficulty);
        yearTextView.setText(String.valueOf(year));

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
