
package com.sec.aip.aipmaster.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sec.aip.aipmaster.common.dto.s3.Bucket;
import com.sec.aip.aipmaster.common.dto.s3.BucketAcl;

@Service
public interface S3Service {

    public List<Bucket> getBucketList();
    
    public Bucket getBucket(String bucketId);
    
    public void createBucket(Bucket bucket);
    
    public BucketAcl getBucketAcl(String bucketId);
    
    public void applyBucketAcls(BucketAcl acl);
}
