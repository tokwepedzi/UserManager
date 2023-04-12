package com.tafrica.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> listAll(){
       return (List<User>) repository.findAll();
    }

    public void save(User user) {
        repository.save(user);
    }

    public User get(Integer id) throws UserNotFoundException{
        Optional<User> result =  repository.findById(id);
        if(result.isPresent()){
            return result.get();
        }

        throw new UserNotFoundException("No user found with ID "+id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = repository.countById(id);
        if(count == null || count ==0){
            throw new UserNotFoundException("Could not find any users wih ID "+id);
        }
        repository.deleteById(id);
    }
}
