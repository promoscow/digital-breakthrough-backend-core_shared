package ru.xpendence.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.auth.dto.LoginDto;
import ru.xpendence.auth.service.LoginService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.09.19
 * Time: 15:50
 * e-mail: v.chernyshov@pflb.ru
 */
@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
    
    private final LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginDto dto) {
        return ResponseEntity.ok(service.login(dto));
    }
}
