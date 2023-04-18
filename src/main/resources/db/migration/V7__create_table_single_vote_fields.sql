CREATE TABLE single_vote_fields (
    id_voting_session varchar(36)  not null,
    user_name         varchar(100) not null,
    field_name        varchar(50)  not null,
    primary key (id_voting_session, user_name)
);