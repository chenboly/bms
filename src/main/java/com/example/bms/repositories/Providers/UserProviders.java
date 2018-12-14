package com.example.bms.repositories.Providers;

import com.example.bms.models.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class UserProviders {

    public String getAllUsersProvider(){
        return new SQL(){{
            SELECT("*");
            FROM("tb_user");
            WHERE("status IS TRUE");
            ORDER_BY("id");
        }}.toString();
    }

    public String saveUserProvider(User user){
        return new SQL(){{
            INSERT_INTO("tb_user");
            VALUES("username","#{username}");
            VALUES("fullname","#{fullname}");
            VALUES("gender","#{gender}");
            VALUES("email","#{email}");
        }}.toString();
    }

    public String updateUserProvider(@Param("p_user") User user){
        return new SQL(){{
            UPDATE("tb_user");
            SET("username = #{p_user.username}",
                    "fullname = #{p_user.fullname}",
                    "gender = #{p_user.gender}",
                    "email = #{p_user.email}");
            WHERE("id = #{p_user.id}");
        }}.toString();
    }

    public String deleteUserProvider(@Param("id") Integer id){
        return new SQL(){{
            UPDATE("tb_user");
            SET("status = FALSE");
            WHERE("id = #{id}");
        }}.toString();
    }
}
