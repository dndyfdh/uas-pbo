package login;

import java.util.List;

public class UserListView {
    private User user;

    public UserListView() {
        this.user = new User();
    }

    public void displayUserList(List<User> userList) {
        if (userList.isEmpty()) {
            System.out.println("No users available.");
        } else {
            System.out.println("User List:");
            for (User user : userList) {
                System.out.println("User ID: " + user.getUserId());
                System.out.println("Password: " + user.getPassword());
                System.out.println("------------");
            }
        }
    }

    public List<User> getUserList() {
        return user.getUserList();
    }

    public void addUser(User newUser) {
        user.addUser(newUser);
        System.out.println("User added successfully.");
    }
    
    public void changePassword(String userId, String newPassword) {
        user.changePassword(userId, newPassword);
        System.out.println("Password changed successfully.");
    }

}
