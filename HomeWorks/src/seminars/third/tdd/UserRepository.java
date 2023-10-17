package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (!user.isAuthenticate) return;
        data.add(user);
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    // HW 3.3
    public void logoutUser(User user) {
        user.isAuthenticate = false;
        data.remove(user);
    }

    public void logoutAllButAdm() {
        List<User> users = data.stream()
                .filter(u -> !u.isAdmin())
                .collect(Collectors.toList());

        users.forEach(this::logoutUser);
    }

}