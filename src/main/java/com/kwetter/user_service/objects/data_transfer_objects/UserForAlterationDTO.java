package com.kwetter.user_service.objects.data_transfer_objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import static com.kwetter.user_service.helpers.tools.Helper.IsEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserForAlterationDTO {
    private UUID id;
    private String firstname;
    private String prefix;
    private String lastname;
    private String email;

    public boolean validateForCreation() {
        return !(this.id == null || IsEmpty(this.firstname) || IsEmpty(this.lastname) || IsEmpty(this.email));
    }

    public boolean validateForUpdate() {
        return (validateForCreation());
    }
}
