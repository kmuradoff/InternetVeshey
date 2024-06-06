package ru.unn.internetveshey.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.unn.internetveshey.dto.UserDto;
import ru.unn.internetveshey.jpa.model.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDto fromUser(User user);
    User toUser(UserDto userDto);
}
