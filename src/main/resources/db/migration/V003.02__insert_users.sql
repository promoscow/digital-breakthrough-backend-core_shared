insert into users(id, password, username)
values (1, '$2a$10$XZOpy4KOtm80OcqdtPwt1.WzyqPcLXO6Y7ogmkO5NNlo4yElQsPAi', 'admin');

insert into users_roles
values (1, 1),
       (1, 2);
