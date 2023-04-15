CREATE TABLE customers (
    id         varchar(36) primary key,
    id_user    int          not null,
    name       varchar(50)  not null,
    document   varchar(20)  not null,
    phone      varchar(15)  not null,
    created_at timestamp    not null,
    created_by varchar(100) not null,
    updated_at timestamp    not null,
    updated_by varchar(100) not null,
    unique (id_user, document, phone)
);
