create table clientes(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    cpf varchar(11) not null unique,
    endereco varchar(100) not null,
    telefone varchar(20) not null unique,
    email varchar(100) not null unique,

    primary key(id)

);