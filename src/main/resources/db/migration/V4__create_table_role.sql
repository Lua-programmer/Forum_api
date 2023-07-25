create table role
(
    id   bigint primary key auto_increment,
    name varchar(50) not null
);

insert into role(id, name)
values (1, 'LEITURA_ESCRITA');