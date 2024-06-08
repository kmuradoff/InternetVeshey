package ru.unn.internetveshey.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.unn.internetveshey.dto.PaymentDto;
import ru.unn.internetveshey.dto.UserInformationDto;
import ru.unn.internetveshey.services.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserInformationDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInformationDto> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/{login}")
    public ResponseEntity<UserInformationDto> getUserByLogin(@PathVariable("login") String login) {
        return ResponseEntity.ok(userService.getUserByLogin(login));
    }

    @PostMapping("/add/payment")
    public ResponseEntity<String> addPayment(@RequestBody PaymentDto paymentDto, @RequestParam String login) {
        userService.addPayment(login, paymentDto);
        return ResponseEntity.ok(String.format("Payment added successfully to user %s", login));
    }

}
