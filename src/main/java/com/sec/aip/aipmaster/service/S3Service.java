
package com.sec.aip.aipmaster.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sec.aip.aipmaster.common.dto.s3.Bucket;

@Service
public class S3Service {

    public boolean canCreateBucket(String projectName) {
        
        return true;
    }

    public List<Bucket> getBucketList() {
        
        return new ArrayList<>();
    }
    
    public Bucket getBucket(String bucketId) {
        
        return new Bucket();
    }
    
    public Bucket createBucket(String bucketId) {
        
        return new Bucket();
    }
    
//    public BucketAcl getBucketAcl(String bucketId);
//    
//    public void applyBucketAcls(BucketAcl acl);

}
