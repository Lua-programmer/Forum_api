create table user_role
(
    id      bigint primary key auto_increment,
    user_id bigint not null,
    role_id bigint not null,
    foreign key (user_id) references user (id),
    foreign key (role_id) references role (id));