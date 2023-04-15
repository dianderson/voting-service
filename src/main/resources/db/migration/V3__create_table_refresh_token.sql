CREATE TABLE refresh_token (
    user_name     varchar(100) primary key,
    refresh_token varchar(36) not null,
    id_user       int         not null,
    expires_at    timestamp   not null,
    unique (refresh_token, id_user),
    foreign key (id_user) references users (id)
);