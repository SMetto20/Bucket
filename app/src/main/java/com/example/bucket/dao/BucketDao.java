package com.example.bucket.dao;


import com.example.bucket.interfaces.IBucket;
import com.example.bucket.models.Bucket;

import java.util.List;

public class BucketDao implements IBucket {
    @Override
    public boolean addBucket(Bucket bucket) {
       return false;
    }

    @Override
    public boolean updateBucket(Bucket bucket) {
        return false;
    }

    @Override
    public boolean deleteBucket(Bucket bucket) {
        try {
            //Remove from the list
            List<Bucket> buckets = Bucket.getAllBuckets();
            for (int i = 0; i < buckets.size(); i++) {
                if (buckets.get(i).getId() == bucket.getId()) {
                    buckets.remove(i);
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Bucket getBucket(int id) {
        for (Bucket bucket : Bucket.getAllBuckets()) {
            if (bucket.getId() == id) {
                return bucket;
            }
        }
        return null;
    }

    @Override
    public List<Bucket> getAllBuckets() {
        return Bucket.getAllBuckets();
    }

}
