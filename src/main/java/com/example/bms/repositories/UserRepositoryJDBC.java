//package com.example.bms.repositories;
//
//import com.example.bms.models.User;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class UserRepositoryJDBC {
//
//    private DataSource dataSource;
//
//    public UserRepositoryJDBC(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    public List<User> getAllUsers(){
//        ResultSet resultSet = null;
//        List<User> userList = new ArrayList<>();
//        try (Connection connection = dataSource.getConnection()){
//            String sql = "SELECT * FROM tb_user WHERE status IS TRUE";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()){
//                User user = new User(
//                    resultSet.getInt(1),
//                    resultSet.getString(2),
//                    resultSet.getString(3),
//                    resultSet.getString(4),
//                    resultSet.getString(5),
//                    resultSet.getBoolean(6),
//                    resultSet.getTimestamp(7)
//                );
//                userList.add(user);
//            }
//
//            return userList;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
//
//    public int save(User user){
//
//        try {
//            Connection connection = dataSource.getConnection();
//            String sql = "INSERT INTO tb_user(username, fullname, gender, email) VALUES (?,?,?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, user.getUsername());
//            preparedStatement.setString(2, user.getFullname());
//            preparedStatement.setString(3, user.getGender());
//            preparedStatement.setString(4, user.getEmail());
//            int status = preparedStatement.executeUpdate();
//            return status;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return 0;
//        }
//
//    }
//
//    public int update (User user){
//
//        try {
//            Connection connection = dataSource.getConnection();
//            String sql = "UPDATE tb_user SET username = ?, fullname = ?, gender = ?, email = ? WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, user.getUsername());
//            preparedStatement.setString(2, user.getFullname());
//            preparedStatement.setString(3, user.getGender());
//            preparedStatement.setString(4, user.getEmail());
//            preparedStatement.setInt(5, user.getId());
//            int status = preparedStatement.executeUpdate();
//            return status;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
////    public int delete (Integer id){
////        try {
////            Connection connection = dataSource.getConnection();
////            String sql = "DELETE FROM tb_user WHERE id = ?";
////            PreparedStatement preparedStatement = connection.prepareStatement(sql);
////            preparedStatement.setInt(1, id);
////            int status = preparedStatement.executeUpdate();
////            return status;
////        } catch (SQLException e) {
////            e.printStackTrace();
////            return 0;
////        }
////    }
//
//    public int delete (Integer id){
//        try {
//            Connection connection = dataSource.getConnection();
//            String sql = "UPDATE tb_user SET status = FALSE WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            int status = preparedStatement.executeUpdate();
//            return status;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return 0;
//        }
//
//    }
//}
