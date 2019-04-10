package model;

import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserModel {

    public boolean insert(User user) {
        String sql = "insert into users (username, password, fullname, created_at, updated_at) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullname());
            preparedStatement.setLong(4, user.getCreated_at());
            preparedStatement.setLong(5, user.getUpdated_at());
            preparedStatement.execute();
            return true;
        } catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public User getOneByUsernameAndPassword(String username, String password) {
        String sql = "select * from users where username=? and password=?";
        User user = null;
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword("");
                user.setFullname(rs.getString("fullname"));
                user.setRole(rs.getInt("role"));
                user.setStatus(rs.getInt("status"));
                user.setCreated_at(rs.getLong("created_at"));
                user.setUpdated_at(rs.getLong("updated_at"));
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return user;
    }

    public User getOneByUsername(String username) {
        String sql = "select * from users where username=?";
        User user = null;
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword("");
                user.setFullname(rs.getString("fullname"));
                user.setRole(rs.getInt("role"));
                user.setStatus(rs.getInt("status"));
                user.setCreated_at(rs.getLong("created_at"));
                user.setUpdated_at(rs.getLong("updated_at"));
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return user;
    }
}
