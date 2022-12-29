package com.study.jdbc;

import java.sql.ResultSet;

public class Member {
    private String id;
    private String code;
    private String email;

    // All Args Constructor
    public Member(String id, String code, String email) {
        this.id = id;
        this.code = code;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
