package com.kwetter.user_service.controllers;

import com.kwetter.user_service.interfaces.IUserService;
import com.kwetter.user_service.objects.data_transfer_objects.UserDTO;
import com.kwetter.user_service.objects.data_transfer_objects.UserForAlterationDTO;
import com.kwetter.user_service.objects.models.User;
import com.kwetter.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final IUserService userService = new UserService();

    @GetMapping(path = "/")
    public @ResponseBody ResponseEntity<Object> getUser(HttpServletRequest request, @RequestBody UUID id){
        User user = userService.getUser(id);

        if (user == null){
            return new ResponseEntity<>("Requested user could not be found.", HttpStatus.NOT_FOUND);
        }

        UserDTO userDTO = new UserDTO(user);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/")
    public @ResponseBody ResponseEntity<String> deleteUser(HttpServletRequest request, @RequestBody UUID id) {
        boolean success = userService.deleteUser(id);

        if (!success) {
            return new ResponseEntity<>("Please login with the account you are trying to delete.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Account has been deleted successfully.", HttpStatus.OK);
    }

    @PostMapping(path="/register")
    public @ResponseBody ResponseEntity<Object> createUser(@RequestBody UserForAlterationDTO alterationDTO) {
        if(alterationDTO.validateForCreation()){
            return new ResponseEntity<>("Incomplete data or username already exists", HttpStatus.CONFLICT);
        }

        User user = userService.createUser(alterationDTO);

        if (user == null){
            return new ResponseEntity<>("something went wrong wile creating a new user account", HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping(path ="/{id}")
    public @ResponseBody ResponseEntity<Object> updateUserAccount(HttpServletRequest request, @RequestBody UserForAlterationDTO alterationDTO) {
        if(alterationDTO.validateForUpdate()){
            return new ResponseEntity<>("Please provide valid profile details.", HttpStatus.NOT_FOUND);
        }

        User user = userService.updateUser(alterationDTO);

        if (user == null){
            return new ResponseEntity<>("Something went wrong while updating your profile", HttpStatus.NOT_FOUND);
        }

        UserDTO userDTO = new UserDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
