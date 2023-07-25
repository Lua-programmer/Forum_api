create table user_role
(
    id      bigint primary key auto_increment,
    user_id bigint not null,
    role_id bigint not null,
    foreign key (user_id) references user_model (id),
    foreign key (role_id) references role (id)
);

insert into user_role (id, user_id, role_id)
values (1, 1, 1);