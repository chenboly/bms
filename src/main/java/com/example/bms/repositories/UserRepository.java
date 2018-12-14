package com.example.bms.repositories;

import com.example.bms.models.User;
import com.example.bms.repositories.Providers.UserProviders;
import com.example.bms.services.UserService;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

//    This is the method which we use SQL statement directly in repository
//    @Select("SELECT * FROM tb_user WHERE status IS TRUE ORDER BY id")
//    This method use by calling another class named provider to execute sql statement in provider class
    @SelectProvider(type = UserProviders.class, method = "getAllUsersProvider")
    @Results({
            @Result(column = "created_at", property = "createdAt")
    })
    List<User> getAllUsers();


//    @Insert("INSERT INTO tb_user (username, fullname, gender, email) VALUES (#{username}, #{fullname}, #{gender}, #{email})")
    @InsertProvider(type = UserProviders.class, method = "saveUserProvider")
    int save(User user);

//    @Update("UPDATE tb_user SET username = #{username}, fullname = #{fullname}, gender = #{gender}, email = #{email} WHERE id = #{id}")
    @UpdateProvider(type = UserProviders.class, method = "updateUserProvider")
    int update (@Param("p_user") User user);

//    @Update("UPDATE tb_user SET status = FALSE WHERE id = #{id}")
    @DeleteProvider(type = UserProviders.class, method = "deleteUserProvider")
    int delete (@Param("id") Integer id);
}
