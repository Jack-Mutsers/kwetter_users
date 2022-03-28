package com.kwetter.user_service.objects.models;

import com.kwetter.user_service.objects.data_transfer_objects.UserForAlterationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    private UUID id;

    private String firstname;
    private String prefix;
    private String lastname;
    private String email;

    public User(UserForAlterationDTO alterationDTO){
        this.id = alterationDTO.getId();
        this.firstname = alterationDTO.getFirstname();
        this.prefix = alterationDTO.getPrefix();
        this.lastname = alterationDTO.getLastname();
        this.email = alterationDTO.getEmail();
    }
}
