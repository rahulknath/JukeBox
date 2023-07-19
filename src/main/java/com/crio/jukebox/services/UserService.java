package com.crio.jukebox.services;

import com.crio.jukebox.entities.User;
import com.crio.jukebox.repositories.UserRepository;

public class UserService implements IUserService {

    public UserRepository userRepository = new UserRepository();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(String name) {
        Integer t_id = userRepository.count() + 1;
        User obj = new User(t_id.toString(), name);
        if(userRepository.save(obj)!=null)
        {
            return obj;
        }
        return null;
    }
    
}
