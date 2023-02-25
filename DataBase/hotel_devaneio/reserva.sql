create table reserva
(
    id_reserva           int auto_increment,
    check_in             datetime     not null,
    check_out            datetime     not null,
    qtd_adultos          int unsigned not null,
    qtd_criancas         int unsigned not null,
    id_servico_adicional int          not null,
    id_quarto            int          not null,
    primary key (id_reserva, id_servico_adicional),
    constraint fk_reserva_quarto
        foreign key (id_quarto) references quarto (id_quarto),
    constraint fk_reserva_servico_adicional
        foreign key (id_servico_adicional) references servico_adicional (id_servico_adicional)
);

create index fk_reserva_quarto_idx
    on reserva (id_quarto);

create index fk_reserva_servico_adicional_idx
    on reserva (id_servico_adicional);

