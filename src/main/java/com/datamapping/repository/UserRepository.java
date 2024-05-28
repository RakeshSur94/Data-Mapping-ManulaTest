package com.datamapping.repository;

import com.datamapping.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static List<User> generateUsers(int size){
        List<User>list = new ArrayList<>();
        for(int i=0; i<size; i++){
            User user = new User();
            user.setEmail("Email "+i);
            user.setPhoneNumber("PhoneNumber "+i);
            list.add(user);

          }
        return list;
    }

}
