CREATE TABLE roles (
    id   int primary key,
    role varchar(100) not null
);

insert into roles(id, role) values (1, 'USER');
insert into roles(id, role) values (2, 'ADMIN');
insert into roles(id, role) values (3, 'MASTER');

CREATE TABLE users (
    id        int primary key,
    user_name varchar(100) not null,
    password  varchar(100) not null,
    unique (user_name)
);

CREATE INDEX idx_users_user on users (user_name);

CREATE TABLE user_roles (
    id_role int not null,
    id_user int not null,
    primary key (id_role, id_user),
    foreign key (id_user) references users (id),
    foreign key (id_role) references roles (id)
);