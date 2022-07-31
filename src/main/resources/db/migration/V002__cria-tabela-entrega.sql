create table entrega(

	id serial NOT NULL,
	cliente_id bigint NOT NULL,
	taxa decimal(10,2) NOT NULL,
	status varchar(20) NOT NULL,
	data_pedido date NOT NULL,
	data_finalizacao date,

	destinatario_nome varchar(60) NOT NULL,
	destinatario_logradouro varchar(255) NOT NULL,
	destinatario_numero varchar(30) NOT NULL,
	destinatario_complemento varchar(60) NOT NULL,
	destinatario_bairro varchar(30) NOT NULL,

	primary key (id)
);

alter table entrega add constraint fk_entrega_cliente
foreign key (cliente_id) references cliente (id);