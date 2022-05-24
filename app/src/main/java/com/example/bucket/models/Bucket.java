package com.example.bucket.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bucket {
    private static int id;
    private static String title;
    private static String description;
    private static String isCompleted;

    private static ArrayList<Bucket> buckets = new ArrayList<>();
    public Bucket(String title, String description, String isCompleted) {
        this.id = new Random().nextInt(100000);
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
        buckets.add(this);
    }

    public static int getId() {
        return id;
    }

    public static String getTitle() {
        return title;
    }

    public static String getDescription() {
        return description;
    }

    public static String getIsCompleted() {
        return isCompleted;
    }

    public static List<Bucket> getAllBuckets() {
        return buckets;
    }

    public static void setBucket(Bucket bucket) {
        id = bucket.getId();
        title = bucket.getTitle();
        description = bucket.getDescription();
        isCompleted = bucket.getIsCompleted();
    }

    public static void setId(int bucketId) {
        id = bucketId;
    }

    public static void setTitle(String bucketTitle) { title = bucketTitle;
    }

    public static void setDescription(String desc) {
        description = desc;
    }

    public static void setCompleted(String completed) {
        isCompleted = completed;
    }
}
