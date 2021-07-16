package com.sec.aip.aipmaster.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AipUser {

    private String userId;
    private String password;
    private String email;
}
