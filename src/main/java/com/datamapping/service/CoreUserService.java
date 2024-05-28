package com.datamapping.service;

import com.datamapping.dto.UserDto;
import com.datamapping.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoreUserService {


    public List<UserDto> convertEntityToDto(List<User> users){
        return users.stream()
                .map(user -> {
                    UserDto userDto = new UserDto();
                    userDto.setEmail(user.getEmail());
                    userDto.setPhoneNumber(user.getPhoneNumber());
                    return userDto;
                }).collect(Collectors.toList());
    }

}
