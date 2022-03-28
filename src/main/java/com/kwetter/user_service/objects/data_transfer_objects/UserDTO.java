package com.kwetter.user_service.objects.data_transfer_objects;

import com.kwetter.user_service.objects.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String firstname;
    private String prefix;
    private String lastname;
    private String email;

    public UserDTO(User user){
        this.firstname = user.getFirstname();
        this.prefix = user.getPrefix();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
    }
}
