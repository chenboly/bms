package com.example.bms.repositories.Providers;

import com.example.bms.models.User;
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
}
