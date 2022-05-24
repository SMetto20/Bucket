package com.example.bucket.utils;

import com.example.bucket.adapters.BucketAdapter;
import com.example.bucket.dao.BucketDao;

public class ServiceLocator {

    private static ServiceLocator instance = null;

    private ServiceLocator() {}

    public static ServiceLocator getInstance() {
        if (instance == null) {
            synchronized(ServiceLocator.class) {
                instance = new ServiceLocator();
            }
        }
        return instance;
    }

    public BucketDao getBucketDao() {
        return new BucketDao();
    }

}
