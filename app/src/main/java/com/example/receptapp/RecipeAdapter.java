package com.example.receptapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class RecipeAdapter extends BaseAdapter {
    private final MainActivity context;
    private final List<Recipe> recipes;

    public RecipeAdapter(MainActivity context, List<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    @Override
    public int getCount() {
        return recipes.size();
    }

    @Override
    public Object getItem(int position) {
        return recipes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Recipe recipe = recipes.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }
        TextView nameTextView = convertView.findViewById(R.id.name_text);
        TextView qualityTextView = convertView.findViewById(R.id.quality_text);
        TextView difficultyTextView = convertView.findViewById(R.id.difficulty_text);
        Button deleteButton = convertView.findViewById(R.id.delete_button);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RecipeActivity.class);
                intent.putExtra("name", recipe.getName());
                intent.putExtra("quality", recipe.getQuality());
                intent.putExtra("difficulty", recipe.getDifficulty());
                context.startActivity(intent);
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Recept törlése")
                        .setMessage("Biztosan törölni szeretnéd a receptet?")
                        .setPositiveButton("Igen", (dialog, which) -> {
                            recipes.remove(position);
                            notifyDataSetChanged();
                        })
                        .setNegativeButton("Nem", null)
                        .show();
            }
        });
        nameTextView.setText(recipe.getName());
        qualityTextView.setText(recipe.getQuality());
        difficultyTextView.setText(recipe.getDifficulty());
        return convertView;
    }
}
