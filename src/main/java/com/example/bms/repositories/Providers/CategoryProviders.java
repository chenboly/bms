package com.example.bms.repositories.Providers;

import com.example.bms.models.Category;
import com.example.bms.utilities.Paginate;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class CategoryProviders {

    public String getOneCategoryByIdProvider(Integer id){
        return new SQL(){{
            SELECT("*");
            FROM("tb_category");
            WHERE("id = #{id}");
        }}.toString();
    }
    public String getAllCategoriesProvider(String name){
        return new SQL(){{
            SELECT("*");
            FROM("tb_category c");
            if(name != null && !name.isEmpty()){
                System.out.println("ok check");
                WHERE("c.name ilike '%'|| #{name} || '%' ");
            }
//            WHERE("c.status IS TRUE");
            ORDER_BY("c.id");

        }}.toString();
    }

    //for pagination
    public String getAllCategoriesPaginateProvider(@Param("name") String name,
                                                   @Param("paginate") Paginate paginate){
        return new SQL(){{
            SELECT("*");
            FROM("tb_category c");
            if(name != null && !name.isEmpty()){
                WHERE("c.name ilike '%'|| #{name} || '%' ");
            }
//            WHERE("c.status IS TRUE");
            ORDER_BY("c.id asc LIMIT #{paginate.limit} OFFSET #{paginate.offset}");

        }}.toString();
    }

    public String saveCategoryProvider(@Param("category") Category category){
        return new SQL(){{
            INSERT_INTO("tb_category");
            VALUES("name","#{category.name}");
        }}.toString();
    }

    public String updateCategoryProvider(Category category){
        return new SQL(){{
            UPDATE("tb_category");
            SET("name=#{name}");
            SET("status=#{status}");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String deleteCategoryProvider(@Param("id") Integer id){
        return new SQL(){{
            DELETE_FROM("tb_category");
            WHERE("id = #{id}");
//            UPDATE("tb_category");
//            SET("status = false");
//            WHERE("id = #{id}");
        }}.toString();
    }
}
