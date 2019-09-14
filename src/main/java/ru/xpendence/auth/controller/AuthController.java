package ru.xpendence.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.auth.dto.LoginDto;
import ru.xpendence.auth.dto.RegisterDto;
import ru.xpendence.auth.service.AuthService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.09.19
 * Time: 15:50
 * e-mail: v.chernyshov@pflb.ru
 */
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto dto) {
        return ResponseEntity.ok(service.login(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@Validated @RequestBody RegisterDto dto) {
        return ResponseEntity.ok(true);
    }

    //    @PreAuthorize("hasAnyAuthority(" +
//            "T(ru.xpendence.auth.base.RoleType).ADMIN,"+
//            "T(ru.xpendence.auth.base.RoleType).USER)"
//    )
    @Secured("ADMIN")
    @GetMapping
    public ResponseEntity test() {
        return ResponseEntity.ok().build();
    }
}
