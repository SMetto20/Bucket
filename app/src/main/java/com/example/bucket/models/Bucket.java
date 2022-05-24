package com.example.bucket.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bucket {
    private  int id;
    private  String title;
    private  String description;
    private  String isCompleted;

    private static List<Bucket> buckets = new ArrayList<>();
    public Bucket(String title, String description, String isCompleted) {
        this.id = new Random().nextInt(100000);
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
    }
    public Bucket(){

    }

    public  int getId() {
        return id;
    }

    public  String getTitle() {
        return title;
    }

    public  String getDescription() {
        return description;
    }

    public  String getIsCompleted() {
        return isCompleted;
    }

    public  List<Bucket> getAllBuckets() {
        return buckets;
    }

    public  void setBucket(Bucket bucket) {
        buckets.add(bucket);
    }

    public  void setId(int bucketId) {
        id = bucketId;
    }

    public  void setTitle(String bucketTitle) { title = bucketTitle;
    }

    public  void setDescription(String desc) {
        description = desc;
    }

    public  void setCompleted(String completed) {
        isCompleted = completed;
    }
}
