package com.udacity.gradle.builditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;
//    private JokesTellerJava jokesTellerJava; //TODO: 1
//
//    public MyBean() {
//        jokesTellerJava = new JokesTellerJava();
//    }
//
//    public String getJoke() {
//        return jokesTellerJava.moreJokes();
//    }

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}