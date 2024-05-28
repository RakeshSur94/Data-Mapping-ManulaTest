package com.datamapping.api;

import com.datamapping.dto.UserDto;
import com.datamapping.entity.User;
import com.datamapping.repository.UserRepository;
import com.datamapping.service.CoreUserService;
import com.datamapping.service.MapStructUserService;
import com.datamapping.service.ModelMapperUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final CoreUserService coreUserService;
    private final ModelMapperUserService modelMapperUserService;
    private final MapStructUserService mapStructUserService;

    @GetMapping("/corejava")
    public String performanceTest(){
        Instant start = Instant.now();
        // Generating a large data set with C performance testing
        List<User> user = UserRepository.generateUsers(100000);
        this.coreUserService.convertEntityToDto(user);
        return "Plain java conversion time :: "+ Duration.between(start,Instant.now()).toMillis()+" ms";

    }
    @GetMapping("/model")
    public String modelMapperPerformance(){
        Instant start = Instant.now();
        //generate a large data set with C performance testing
        List<User> user = UserRepository.generateUsers(100000);
        this.modelMapperUserService.convertEntityToDto(user);
        return "Model mapper conversion time :: "+Duration.between(start,Instant.now()).toMillis()+" ms";
    }
    @GetMapping("/mapstruct")
    public String mapStructTest(){
        Instant start = Instant.now();
        //generate a large data set with C performance testing
     List<User> user = UserRepository.generateUsers(100000);
     this.mapStructUserService.generateUser(user);
     return "MapStruct conversion time :: "+Duration.between(start,Instant.now()).toMillis()+" ms";
    }
}
