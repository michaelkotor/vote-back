create table PARTICIPANT_LIST
(
    ID          int generated by default as identity not null primary key,
    TITLE       varchar(100) not null,
    DESCRIPTION varchar(1000),
    PARTICIPANTS jsonb
);


create table POLL
(
    ID          int GENERATED BY DEFAULT AS IDENTITY not null primary key,
    TITLE       varchar(100) not null,
    DESCRIPTION varchar(1000),
    TIME_START  timestamp    not null,
    TIME_END    timestamp    not null,
    CREATED     timestamp    not null,
    UPDATED     timestamp,
    QUESTIONS   jsonb,
    PARTICIPANT_LIST jsonb,
    PUBLIC_UID  varchar(100)
);



create table VOTE
(
    VOTE_UID    varchar(100) not null primary key,
    POLL_ID     int not null,
    VOTER_ID    varchar(100),
    TIMESTAMP   timestamp    not null,
    ANSWERS     jsonb        not null,
    FACTS       jsonb,
    UPDATED_VOTE_UID varchar(100),
    constraint fk_vote foreign key (POLL_ID) references POLL(ID),
    constraint fk_updated_vote_uid foreign key (UPDATED_VOTE_UID) references VOTE(VOTE_UID)
);