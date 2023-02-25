create table hospede
(
    id_hospede int unsigned not null
        primary key,
    nome       varchar(100) not null,
    sobrenome  varchar(100) not null,
    cpf        int          not null,
    senha      varchar(25)  not null,
    constraint cpf_UNIQUE
        unique (cpf)
);

