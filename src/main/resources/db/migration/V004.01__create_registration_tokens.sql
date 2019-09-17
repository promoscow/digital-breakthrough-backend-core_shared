create table registration_tokens
(
    id              bigint auto_increment
        primary key,
    active          int      not null default 1,
    created         datetime not null default CURRENT_TIMESTAMP,
    updated         datetime null     default CURRENT_TIMESTAMP,
    username        varchar(255),
    token           varchar(1000),
    expiration_time datetime
)
