package com.example.bms.repositories.Providers;

import com.example.bms.models.Category;
import org.apache.ibatis.annotations.Param;
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

    public String saveCategoryProvider(@Param("category") Category category){
        return new SQL(){{
            INSERT_INTO("tb_category");
            VALUES("name","#{category.name}");
        }}.toString();
    }
}
