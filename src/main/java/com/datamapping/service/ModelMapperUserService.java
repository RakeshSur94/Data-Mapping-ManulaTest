package com.datamapping.service;

import com.datamapping.dto.UserDto;
import com.datamapping.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModelMapperUserService {
    private final ModelMapper modelMapper;


    public List<UserDto> convertEntityToDto(List<User> users){
        return users.stream()
                .map(user ->
                    modelMapper.map(user,UserDto.class))
                .collect(Collectors.toList());
    }

}
