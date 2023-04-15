CREATE TABLE voting_sessions (
    id                  varchar(36) primary key,
    id_agenda           varchar(36)  not null,
    start_date          timestamp    not null,
    duration_in_minutes integer      not null,
    allowed_roles       varchar(100) not null,
    created_at          timestamp    not null,
    created_by          varchar(100) not null,
    updated_at          timestamp    not null,
    updated_by          varchar(100) not null
);
