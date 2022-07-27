create table cliente(
    id serial primary key NOT NULL,
	nome varchar(60) NOT NULL,
	email varchar(255) NOT NULL,
	telefone varchar(20) NOT NULL
);