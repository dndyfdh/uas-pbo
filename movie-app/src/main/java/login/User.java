package login;

import connection.DBconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String password;

    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();

        try (Connection connection = DBconnection.getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM userlog")) {

            while (resultSet.next()) {
                String userId = resultSet.getString("userid");
                String password = resultSet.getString("password");

                User user = new User(userId, password);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public void addUser(User user) {
        try (Connection connection = DBconnection.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO users (user_id, password) VALUES (?, ?)")) {

            statement.setString(1, user.getUserId());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();

            System.out.println("User added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePassword(String userId, String newPassword) {
        try (Connection connection = DBconnection.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE users SET password = ? WHERE user_id = ?")) {

            statement.setString(1, newPassword);
            statement.setString(2, userId);
            statement.executeUpdate();

            System.out.println("Password changed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
