create table dados_hotel
(
    id_dados_hotel int auto_increment
        primary key,
    nome           varchar(255) not null,
    cnpj           int          not null,
    id_contato     int          not null,
    id_endereco    int          not null,
    constraint cnpj_UNIQUE
        unique (cnpj),
    constraint fk_dados_hotel_contato
        foreign key (id_contato) references contato (id_contato),
    constraint fk_dados_hotel_endereco
        foreign key (id_endereco) references endereco (id_endereco)
);

create index fk_dados_hotel_contato_idx
    on dados_hotel (id_contato);

create index fk_dados_hotel_endereco_idx
    on dados_hotel (id_endereco);

