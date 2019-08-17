create table users
(
    id       bigint auto_increment
        primary key,
    active   int          not null,
    created  datetime     not null,
    updated  datetime     null,
    password varchar(255) null,
    username varchar(255) null
);
