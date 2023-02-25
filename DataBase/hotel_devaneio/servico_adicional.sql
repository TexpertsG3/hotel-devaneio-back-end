create table servico_adicional
(
    id_servico_adicional int auto_increment
        primary key,
    nome                 varchar(255)            not null,
    descricao            varchar(255)            not null,
    preco                decimal(10, 2) unsigned not null
);

