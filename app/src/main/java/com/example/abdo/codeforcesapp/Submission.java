package com.example.abdo.codeforcesapp;

public class Submission {
    private String id;
    private  String name;
    private String lang;
    private String result;

    public Submission(String id, String name, String lang, String result) {
        this.id = id;
        this.name = name;
        this.lang = lang;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
