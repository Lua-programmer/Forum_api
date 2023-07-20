create table course
(
    id        bigint       not null auto_increment primary key,
    name      varchar(255) not null,
    category varchar(255) not null
);

insert into course(id, name, category)
values (1, 'Kotlin', 'Programação');

create table user_model
(
    id    bigint       not null auto_increment primary key,
    name  varchar(255) not null,
    email varchar(255) not null
);

insert into user_model(id, name, email)
values (1, 'Zoe', 'zoe@email.com');

create table topic
(
    id         bigint       not null auto_increment primary key,
    title      varchar(255) not null,
    message    varchar(255) not null,
    created_at datetime     not null,
    status     varchar(20)  not null,
    course_id  bigint       not null,
    author_id  bigint       not null,
    foreign key (course_id) references course (id),
    foreign key (author_id) references user_model (id)
);

create table answer
(
    id         bigint       not null auto_increment primary key,
    message    varchar(255) not null,
    created_at datetime     not null,
    topic_id   bigint       not null,
    author_id  bigint       not null,
    solution   boolean      not null,
    foreign key (topic_id) references topic (id),
    foreign key (author_id) references user_model (id)
);