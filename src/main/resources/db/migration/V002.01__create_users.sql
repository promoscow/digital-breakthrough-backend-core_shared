create table users
(
    id         bigint auto_increment
        primary key,
    active     int          not null default 1,
    created    datetime     not null default CURRENT_TIMESTAMP,
    updated    datetime     null     default CURRENT_TIMESTAMP,
    password   varchar(255) null,
    username   varchar(255) null,
    first_name varchar(255),
    last_name  varchar(255),
    email      varchar(255),
    confirmed  boolean
);
