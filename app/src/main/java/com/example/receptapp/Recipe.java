package com.example.receptapp;

public class Recipe {
    private String name;
    private String quality;
    private String difficulty;

    public Recipe(String name, String quality, String difficulty) {
        this.name = name;
        this.quality = quality;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public String getQuality() {
        return quality;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
