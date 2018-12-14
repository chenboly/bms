package com.example.bms.repositories.Providers;

import org.apache.ibatis.jdbc.SQL;

public class CategoryProviders {

    public String getAllCategoriesProvider(){
        return new SQL(){{
            SELECT("*");
            FROM("tb_category c");
            WHERE("c.status IS TRUE");
            ORDER_BY("c.id");

        }}.toString();
    }
}
