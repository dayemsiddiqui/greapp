package com.example.root.greapp.model;

/**
 * Created by root on 12/13/16.
 */
public class Word {

    private int id;
    private String word;
    private String meaning;
    private boolean bookmarked;


    public Word(String id, String word, String meaning, boolean bookmarked){
        this.id = Integer.parseInt(id);
        this.word = word;
        this.meaning = meaning;
        this.bookmarked = bookmarked;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getWord() {
        return word;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }
}
