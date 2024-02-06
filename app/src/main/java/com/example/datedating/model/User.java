package com.example.datedating.model;

class User {
    String name;
    String age;
    String gifUrl;
    String message;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGifUrl() {
        return gifUrl;
    }

    public void setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}