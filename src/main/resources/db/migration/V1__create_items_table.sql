create table items
(
    id int not null,
    name  varchar(50) not null,
    price decimal(10, 2),
    description  varchar(150),
    primary key (id),
    constraint ix_name
        unique (name)
);