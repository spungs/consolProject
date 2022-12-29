package com.study.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MemberRepository {
     static Member create(ResultSet rs) throws SQLException {


        return new Member(rs.getString(1), rs.getString(2), rs.getString(3));
    }
}
