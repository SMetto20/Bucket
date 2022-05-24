package com.example.bucket.dao;

import android.util.Log;

import com.example.bucket.interfaces.IBucket;
import com.example.bucket.models.Bucket;
import com.example.bucket.utils.ServiceLocator;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class BucketDao implements IBucket {
    @Override
    public void addBucket(Bucket bucket) {
        new Bucket().setBucket(bucket);
    }

    @Override
    public void updateBucket(Bucket bucket) {
        try {
            List<Bucket> buckets = bucket.getAllBuckets();
            for (Bucket b : buckets) {
                if (b.getId() == bucket.getId()) {
                    b.setTitle(bucket.getTitle());
                    b.setDescription(bucket.getDescription());
                    if (bucket.getIsCompleted().equals("Completed")) {
                        b.setCompleted("Pending");
                    } else {
                        b.setCompleted("Completed");
                    }

                }
            }
        } catch (Exception e) {
            Log.e("BucketDao", e.getMessage());
        }
    }

    @Override
    public void deleteBucket(Bucket bucket) {
        try {
            //Remove from the list
            List<Bucket> buckets = bucket.getAllBuckets();
            System.out.println(buckets.size());
            for (int i = 0; i < buckets.size(); i++) {
                if (buckets.get(i).getId() == bucket.getId()) {
                    buckets.remove(i);
                    break;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Bucket getBucket(int id) {
        for (Bucket bucket : new Bucket().getAllBuckets()) {
            if (bucket.getId() == id) {
                return bucket;
            }
        }
        return null;
    }

    @Override
    public List<Bucket> getAllBuckets() {
        return new Bucket().getAllBuckets();
    }

}
