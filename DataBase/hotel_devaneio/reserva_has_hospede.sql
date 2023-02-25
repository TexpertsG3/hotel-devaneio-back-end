create table reserva_has_hospede
(
    id_reserva                                     int          not null,
    reserva_servico_adicional_id_servico_adicional int          not null,
    hospede_id_hospede                             int unsigned not null,
    primary key (id_reserva, reserva_servico_adicional_id_servico_adicional, hospede_id_hospede),
    constraint fk_reserva_has_hospede_hospede1
        foreign key (hospede_id_hospede) references hospede (id_hospede),
    constraint fk_reserva_has_hospede_reserva1
        foreign key (id_reserva, reserva_servico_adicional_id_servico_adicional) references reserva (id_reserva, id_servico_adicional)
);

create index fk_reserva_has_hospede_hospede_idx
    on reserva_has_hospede (hospede_id_hospede);

create index fk_reserva_has_hospede_reserva_idx
    on reserva_has_hospede (id_reserva, reserva_servico_adicional_id_servico_adicional);

