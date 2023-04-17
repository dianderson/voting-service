CREATE TABLE roles (
    id   int primary key,
    role varchar(100) not null
);

CREATE TABLE users (
    id        int primary key,
    user_name varchar(100) not null,
    password  varchar(100) not null,
    unique (user_name)
);

CREATE INDEX idx_user_name on users (user_name);

CREATE TABLE user_roles (
    id_role int not null,
    id_user int not null,
    primary key (id_role, id_user),
    foreign key (id_user) references users (id),
    foreign key (id_role) references roles (id)
);

insert into roles(id, role) values (1, 'USER');
insert into roles(id, role) values (2, 'ADMIN');
insert into roles(id, role) values (3, 'MASTER');

insert into users(id, user_name, password) values (1, 'user@test.com', 'user123');
insert into users(id, user_name, password) values (2, 'admin@test.com', 'admin123');
insert into users(id, user_name, password) values (3, 'master@test.com', 'master123');

insert into user_roles(id_role, id_user) values (1, 1);
insert into user_roles(id_role, id_user) values (2, 2);
insert into user_roles(id_role, id_user) values (3, 3);