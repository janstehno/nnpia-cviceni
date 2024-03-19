package cz.upce.fei.nnpia.cviceni.controllers;

import cz.upce.fei.nnpia.cviceni.entities.AppUser;
import cz.upce.fei.nnpia.cviceni.service.AppUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/app-user")
public class AppUserController {

    private final AppUserService service;

    @GetMapping()
    public List<AppUser> getAllAppUser() {
        return service.getAllObjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getAppUserById(@PathVariable Long id) {
        AppUser appUser = service.getObjectById(id);
        if (appUser != null) {
            return ResponseEntity.ok(appUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Void> createUser(@RequestBody @Valid AppUser appUser) {
        service.createObject(appUser);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody @Valid AppUser appUser) {
        service.updateObject(appUser);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteObject(id);
        return ResponseEntity.noContent().build();
    }

}
