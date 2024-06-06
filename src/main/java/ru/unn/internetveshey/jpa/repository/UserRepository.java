package ru.unn.internetveshey.jpa.repository;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.unn.internetveshey.exceptions.NotFoundException;
import ru.unn.internetveshey.jpa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByLogin(String login);

    default User findFirstByLoginSafe(String login) {
        User user = findFirstByLogin(login);
        if (user == null) {
            throw new NotFoundException("USER_NOT_FOUND", String.format("Пользователь %s не найден", login));
        }

        return user;
    }
}
