create table cargo
(
    id_cargo        int auto_increment
        primary key,
    nome_cargo      varchar(100) not null,
    descricao_cargo varchar(255) not null
);

