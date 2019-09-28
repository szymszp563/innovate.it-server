package com.hackathon.server.mappers;

import com.hackathon.server.dto.UserDto;
import com.hackathon.server.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {InvestitionMapper.class})
public interface UsersMapper {

    Users userDtoToUsers(UserDto dto);

    UserDto usersToUserDto(Users entity);
}
