create table contato
(
    id_contato         int auto_increment
        primary key,
    email              varchar(255) not null,
    telefone           varchar(45)  not null,
    celular            varchar(45)  not null,
    hospede_id_hospede int unsigned not null,
    constraint fk_contato_hospede
        foreign key (hospede_id_hospede) references hospede (id_hospede)
);

create index fk_contato_hospede_idx
    on contato (hospede_id_hospede);

