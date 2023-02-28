create table hotel
(
    id_hotel             int auto_increment
        primary key,
    id_dados_hotel       int          not null,
    id_funcionario       int          not null,
    id_administrador     int          not null,
    id_servico_adicional int          not null,
    id_hospede           int unsigned not null,
    constraint fk_hotel_administrador
        foreign key (id_administrador) references administrador (id_administrador),
    constraint fk_hotel_dadosHotel
        foreign key (id_dados_hotel) references dados_hotel (id_dados_hotel),
    constraint fk_hotel_funcionario
        foreign key (id_funcionario) references funcionario (id_funcionario),
    constraint fk_hotel_hospede
        foreign key (id_hospede) references hospede (id_hospede),
    constraint fk_hotel_servico_adicional
        foreign key (id_servico_adicional) references servico_adicional (id_servico_adicional)
);

create index fk_hotel_administrador_idx
    on hotel (id_administrador);

create index fk_hotel_dadosHotel_idx
    on hotel (id_dados_hotel);

create index fk_hotel_funcionario_idx
    on hotel (id_funcionario);

create index fk_hotel_hospede_idx
    on hotel (id_hospede);

create index fk_hotel_servico_adicional_idx
    on hotel (id_servico_adicional);

