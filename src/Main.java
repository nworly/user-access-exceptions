import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин:");
        String login = scanner.nextLine();
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();
        validateUser(getUserByLoginAndPassword(login, password));
        System.out.println("Доступ предоставлен");
    }

    public static User[] getUsers() {
        User user1 = new User("mickey", "1234s", 20, "box@mail.net");
        User user2 = new User("lipniss", "wabbit", 28, "mines@mail.net");
        User user3 = new User("rouge45", "10020", 17, "winona23@mail.net");
        return new User[]{user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for(User user : users) {
            if (Objects.equals(user.login, login) && Objects.equals(user.password, password)) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.age < 18) {
            throw new AccessDeniedException();
        }
    }
}
