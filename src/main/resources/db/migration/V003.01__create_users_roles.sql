create table users_roles
(
    user_id bigint not null,
    role_id bigint not null
);

create index fk_users_roles_user_id
    on users_roles (user_id);

create index fk_users_roles_role_id
    on users_roles (role_id);

