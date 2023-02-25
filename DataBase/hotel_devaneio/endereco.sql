create table endereco
(
    id_endereco int auto_increment
        primary key,
    rua         varchar(100) not null,
    bairro      varchar(100) not null,
    numero      int          not null,
    cep         int          not null,
    cidade      varchar(100) not null,
    uf          varchar(2)   not null,
    complemento varchar(100) not null
);

