CREATE TABLE voting_sessions (
    id_voting_session   varchar(36) primary key,
    id_agenda           varchar(36)  not null,
    start_time          timestamp    not null,
    duration_in_minutes integer      not null,
    allowed_roles       varchar(100) not null,
    created_at          timestamp    not null,
    created_by          varchar(100) not null,
    updated_at          timestamp    not null,
    updated_by          varchar(100) not null,
    unique (id_agenda, start_time),
    foreign key (id_agenda) references agenda (id_agenda)
);

CREATE INDEX idx_id_agenda_start_time on voting_sessions (id_agenda, start_time);