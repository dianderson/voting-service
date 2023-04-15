CREATE TABLE agenda (
    id                varchar(36) primary key,
    name              varchar(30)  not null,
    subject           varchar(80)  not null,
    comments          varchar(250) not null,
    start_time        timestamp    not null,
    duration_in_hours integer      not null,
    created_at        timestamp    not null,
    created_by        varchar(100) not null,
    updated_at        timestamp    not null,
    updated_by        varchar(100) not null,
    unique (name, start_time)
);
