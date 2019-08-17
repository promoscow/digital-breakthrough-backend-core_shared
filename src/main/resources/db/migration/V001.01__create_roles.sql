create table roles
(
    id        bigint auto_increment
        primary key,
    active    int          not null,
    created   datetime     not null,
    updated   datetime     null,
    role_type varchar(255) not null
);

alter table roles
    add constraint uk_roles_role_type unique (role_type);
