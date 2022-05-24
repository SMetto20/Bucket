package com.example.bucket.interfaces;


import com.example.bucket.models.Bucket;

import java.util.List;

public interface IBucket {
    boolean addBucket(Bucket bucket);

    boolean updateBucket(Bucket bucket);

    boolean deleteBucket(Bucket bucket);

    Bucket getBucket(int id);

    List<Bucket> getAllBuckets();

}
