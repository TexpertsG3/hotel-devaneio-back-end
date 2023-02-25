create table administrador
(
    id_administrador int auto_increment
        primary key,
    nome_admin       varchar(100) not null,
    senha_admin      varchar(100) not null,
    id_contato       int          not null,
    id_endereco      int          not null,
    constraint fk_administrador_contato
        foreign key (id_contato) references contato (id_contato),
    constraint fk_administrador_endereco
        foreign key (id_endereco) references endereco (id_endereco)
);

create index fk_administrador_contato_idx
    on administrador (id_contato);

create index fk_administrador_endereco_idx
    on administrador (id_endereco);

