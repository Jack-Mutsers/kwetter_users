package com.kwetter.user_service.services;

import com.kwetter.user_service.helpers.logger.LoggerService;
import com.kwetter.user_service.interfaces.IUserService;
import com.kwetter.user_service.objects.data_transfer_objects.UserForAlterationDTO;
import com.kwetter.user_service.objects.models.User;
import com.kwetter.user_service.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepo userRepo;

    public User getUser(UUID id) {
        Optional<User> userOptional = userRepo.findById(id);

        if(userOptional.isEmpty()){return null;}

        return userOptional.get();
    }

    @Transactional
    public boolean deleteUser(UUID id) {
        try{
            userRepo.deleteById(id);
            return true;
        }catch (Exception ex){
            LoggerService.warn(ex.getMessage());
            return false;
        }
    }

    public User createUser(UserForAlterationDTO alterationDTO) {
        try{
            User user = new User(alterationDTO);
            User newObject = userRepo.save(user);

            return newObject;
        }catch (Exception ex){
            LoggerService.warn(ex.getMessage());
            return null;
        }
    }

    public User updateUser(UserForAlterationDTO alterationDTO) {
        try{
            User user = new User(alterationDTO);
            userRepo.save(user);
            return user;
        }catch (Exception ex){
            LoggerService.warn(ex.getMessage());
            return null;
        }
    }
}
