package tn.esprit.pidev.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.config.JwtService;
import tn.esprit.pidev.entities.user.User;
import tn.esprit.pidev.services.user.IGestionUser;

import java.util.Date;
import java.util.List;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/user")
public class UserController {
    @Autowired
    IGestionUser iGestionUser;
    @Autowired
    JwtService jwtService;
    @GetMapping("/getexpr/{token}")
    public ResponseEntity<Date> dd(@PathVariable String token)  {

        try {
            return ResponseEntity.ok(jwtService.extractExpiration(token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }    }
    // Read all
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<User>> findAll() {
        try {
            List<User> users = iGestionUser.findAll();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
            User newUser = iGestionUser.add(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        try {
            User user = iGestionUser.findById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    // Update
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        try {

            User updatedUser = iGestionUser.update(user);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/allact")
    public ResponseEntity<List<User>> findAllActice() {
        try {
            List<User> users = iGestionUser.findAll();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
