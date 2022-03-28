package com.kwetter.user_service.interfaces;

import com.kwetter.user_service.objects.data_transfer_objects.UserForAlterationDTO;
import com.kwetter.user_service.objects.models.User;

import java.util.UUID;

public interface IUserService {
    User getUser(UUID id);
    boolean deleteUser(UUID id);
    User createUser(UserForAlterationDTO userDTO);
    User updateUser(UserForAlterationDTO userDTO);
}
