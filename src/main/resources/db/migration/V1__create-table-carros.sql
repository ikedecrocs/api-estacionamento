create table carros(

    id bigint not null auto_increment,
    placa varchar(7) not null unique,
    marca varchar(50) not null,
    modelo varchar(50) not null,
    id_dono bigint not null,

    primary key(id)

);