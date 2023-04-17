CREATE TABLE voting_fields (
    id_voting_session varchar(36) not null,
    field_name        varchar(50) not null,
    quantity          integer     not null default 0,
    primary key (id_voting_session, field_name),
    foreign key (id_voting_session) references voting_sessions (id_voting_session)
);

CREATE INDEX idx_id_voting_session on voting_fields (id_voting_session);