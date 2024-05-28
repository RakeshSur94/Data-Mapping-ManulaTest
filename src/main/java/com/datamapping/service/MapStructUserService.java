package com.datamapping.service;

import com.datamapping.dto.UserDto;
import com.datamapping.dto.UserMapper;
import com.datamapping.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapStructUserService {


    public List<UserDto> generateUser(List<User> users){
        return users.stream().map(UserMapper.INSTANCE::userToUserDto).collect(Collectors.toList());
    }
}
