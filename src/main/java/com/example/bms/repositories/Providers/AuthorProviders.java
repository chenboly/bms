package com.example.bms.repositories.Providers;


import org.apache.ibatis.jdbc.SQL;

public class AuthorProviders {

    public String getAllAuthorsProvider(){
        return new SQL(){{
            SELECT("*");
            FROM("tb_author");
            WHERE("status IS TRUE");
            ORDER_BY("id");
        }}.toString();
    }
}
