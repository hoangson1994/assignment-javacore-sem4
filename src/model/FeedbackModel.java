package model;

import entity.Feedback;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FeedbackModel {

    public boolean insert(Feedback feedback) {
        String sql = "insert into feedbacks (title, content, user_id, created_at, updated_at) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, feedback.getTitle());
            preparedStatement.setString(2, feedback.getContent());
            preparedStatement.setInt(3, feedback.getUser_id());
            preparedStatement.setLong(4, feedback.getCreated_at());
            preparedStatement.setLong(5, feedback.getUpdated_at());
            preparedStatement.execute();
            return true;
        } catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public ArrayList<Feedback> getListByStatus(int status) {
        String sql = "select * from feedbacks where status=?";
        ArrayList<Feedback> feedbacks = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, status);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Feedback feedback = new Feedback();
                feedback.setId(rs.getInt("id"));
                feedback.setTitle(rs.getString("title"));
                feedback.setContent(rs.getString("content"));
                feedback.setUser_id(rs.getInt("user_id"));
                feedback.setStatus(rs.getInt("status"));
                feedback.setCreated_at(rs.getLong("created_at"));
                feedback.setUpdated_at(rs.getLong("updated_at"));

                feedbacks.add(feedback);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return feedbacks;
    }

    public boolean updateStatusById(int id, int status) {
        String sql = "update feedbacks set status=? where id=?";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
