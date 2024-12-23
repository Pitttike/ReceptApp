package com.example.receptapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText qualityEditText;
    private EditText difficultyEditText;
    private Button addButton;

    private RecipeAdapter adapter;

    private ListView listView;
    private List<Recipe> recipes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    private boolean validateInput(String name, String quality, String difficulty) {
        return !name.isEmpty() && !quality.isEmpty() && !difficulty.isEmpty();
    }

    private void init() {
        nameEditText = findViewById(R.id.name_input);
        qualityEditText = findViewById(R.id.quality_input);
        difficultyEditText = findViewById(R.id.difficulty_input);
        addButton = findViewById(R.id.add_button);
        listView = findViewById(R.id.list_view);
        adapter = new RecipeAdapter(this, recipes);
        listView.setAdapter(adapter);
        addButton.setOnClickListener(v -> {
            if (!validateInput(nameEditText.getText().toString(), qualityEditText.getText().toString(), difficultyEditText.getText().toString())) {
                Toast.makeText(this, "A mezők kitöltése kötelező!", Toast.LENGTH_SHORT).show();
                return;
            }
            String name = nameEditText.getText().toString();
            String quality = qualityEditText.getText().toString();
            String difficulty = difficultyEditText.getText().toString();
            Recipe recipe = new Recipe(name, quality, difficulty);
            recipes.add(recipe);
            adapter.notifyDataSetChanged();
        });
    }
}