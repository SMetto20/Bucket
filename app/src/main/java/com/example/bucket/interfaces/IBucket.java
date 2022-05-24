package com.example.bucket.interfaces;


import com.example.bucket.models.Bucket;

import java.util.List;

public interface IBucket {
    void addBucket(Bucket bucket);

    void updateBucket(Bucket bucket);

    void deleteBucket(Bucket bucket);

    Bucket getBucket(int id);

    List<Bucket> getAllBuckets();

}
