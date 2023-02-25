create table funcionario
(
    id_funcionario        int auto_increment
        primary key,
    nome_funcionario      varchar(100) not null,
    sobrenome_funcionario varchar(100) not null,
    cpf                   int unsigned not null,
    id_cargo              int          not null,
    id_contato            int          not null,
    id_endereco           int          not null,
    constraint cpf_UNIQUE
        unique (cpf),
    constraint fk_funcionario_cargo
        foreign key (id_cargo) references cargo (id_cargo),
    constraint fk_funcionario_contato
        foreign key (id_contato) references contato (id_contato),
    constraint fk_funcionario_endereco
        foreign key (id_endereco) references endereco (id_endereco)
);

create index fk_funcionario_cargo_idx
    on funcionario (id_cargo);

create index fk_funcionario_contato_idx
    on funcionario (id_contato);

create index fk_funcionario_endereco_idx
    on funcionario (id_endereco);

