alter table carros
add constraint FK_cliente_carro
foreign key (id_dono) references clientes(id);