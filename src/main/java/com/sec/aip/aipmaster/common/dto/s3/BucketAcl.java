package com.sec.aip.aipmaster.common.dto.s3;

import java.util.List;

import lombok.Data;

@Data
public class BucketAcl {

    private String bucketId;
    private List<String> acl;
}
