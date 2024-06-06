package ru.unn.internetveshey.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.unn.internetveshey.dto.UserInformationDto;
import ru.unn.internetveshey.exceptions.NotFoundException;
import ru.unn.internetveshey.jpa.repository.UserRepository;
import ru.unn.internetveshey.mapper.UserMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserInformationDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::fromUser)
                .toList();
    }

    public UserInformationDto getUserById(Long id) {
        return userMapper.fromUser(userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND", "Пользователь не найден")));
    }

    public UserInformationDto getUserByLogin(String login) {
        return userMapper.fromUser(userRepository.findFirstByLoginSafe(login));
    }
}
