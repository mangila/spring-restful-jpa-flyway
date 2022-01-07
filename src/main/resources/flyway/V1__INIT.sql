create table actor
(
    actor_id bigint      not null auto_increment,
    created  datetime(6) not null,
    updated  datetime(6),
    version  bigint,
    name     varchar(255),
    picture  varchar(255),
    primary key (actor_id)
);
create table actor_nickname
(
    actor_id bigint not null,
    nickname varchar(255)
);
create table director
(
    director_id bigint      not null auto_increment,
    created     datetime(6) not null,
    updated     datetime(6),
    version     bigint,
    name        varchar(255),
    picture     varchar(255),
    actor_id    bigint,
    primary key (director_id)
);
create table movie
(
    movie_id       bigint      not null auto_increment,
    created        datetime(6) not null,
    updated        datetime(6),
    version        bigint,
    banner         varchar(255),
    genre          varchar(255),
    publisher_name varchar(255),
    title          varchar(255),
    director_id    bigint,
    primary key (movie_id)
);
create table movies_actors
(
    actor_id bigint not null,
    movie_id bigint not null,
    primary key (actor_id, movie_id)
);
alter table actor_nickname
    add constraint FKg7byyk4qmi1mrtlfudfx4tbhr foreign key (actor_id) references actor (actor_id);
alter table director
    add constraint FKcio802gyl5hcnm6avd5j4eglc foreign key (actor_id) references actor (actor_id);
alter table movie
    add constraint FKbi47w3cnsfi30gc1nu2avgra2 foreign key (director_id) references director (director_id);
alter table movies_actors
    add constraint FKt4csle7iqbjbi9g5892po4xrq foreign key (movie_id) references movie (movie_id);
alter table movies_actors
    add constraint FK74tucnxqgrmg25c1i3rcskrwb foreign key (actor_id) references actor (actor_id);