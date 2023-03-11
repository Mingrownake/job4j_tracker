package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
            throw new UserNotFoundException("The user " + login + " was not found.");
        }
        return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() >= 3 && user.isValid()) {
            return true;
        }
        throw new UserInvalidException("The user " + user.getUsername() + " is not valid.");
    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User("Qwe", true)
        };
        User user = findUser(users, "Qwe");
        try {
            if (validate(user)) {
                System.out.println("This user has the access.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
