create table promocao
(
    id_promocao   int auto_increment
        primary key,
    nome_promocao varchar(100)   null,
    desconto      decimal(10, 2) null,
    data_inicio   datetime       null,
    data_fim      datetime       null
);

