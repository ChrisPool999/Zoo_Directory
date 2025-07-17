package edu.csueb.android.zoodirectory;

public class Animal {
    final private String name;
    final private int imageResId;
    final private String description;

    public Animal(String name, int imageResId, String description) {
        this.name = name;
        this.imageResId = imageResId;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public int getImageResId() {
        return this.imageResId;
    }

    public String getDescription() {
        return this.description;
    }
}
