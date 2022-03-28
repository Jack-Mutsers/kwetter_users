package com.kwetter.user_service.repositories;

import com.kwetter.user_service.objects.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends CrudRepository<User, UUID> {
    Optional<User> findById(UUID id);
    void deleteById(UUID id);
}
