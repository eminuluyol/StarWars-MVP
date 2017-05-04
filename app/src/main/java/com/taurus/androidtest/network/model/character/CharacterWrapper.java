package com.taurus.androidtest.network.model.character;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterWrapper {

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("next")
    @Expose
    private int next;

    @SerializedName("previous")
    @Expose
    private int previous;

    @SerializedName("results")
    @Expose
    private List<Character> results = null;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }

}
