package com.study.jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try {
            // 1
            // Connection 연결
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "oracle", "oracle");

            // 2
            Statement stm = conn.createStatement();

            // 3
            ResultSet rs = stm.executeQuery("SELECT * FROM MEMBER");

            while (rs.next()){
                System.out.println(MemberRepository.create(rs));
            }

            stm.addBatch("UPDATE member SET gender = 's' WHERE id = 'admin'");
            stm.addBatch("UPDATE member SET gender = 's' WHERE id = 'admin1'");
            stm.addBatch("UPDATE member SET gender = 's' WHERE id = 'admin2'");
            stm.addBatch("UPDATE member SET gender = 's' WHERE id = 'test1'");

            try{
               int[] result =  stm.executeBatch();
                System.out.println("update of record : " + result.length);
            } catch (BatchUpdateException e){
                e.printStackTrace();
            }

            ResultSet afterResult = stm.executeQuery("SELECT * FROM member");
            while (afterResult.next()){
                System.out.println(MemberRepository.create(afterResult));
            }






            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
