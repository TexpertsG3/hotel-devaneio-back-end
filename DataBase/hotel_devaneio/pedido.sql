create table pedido
(
    id_pedido            int auto_increment
        primary key,
    valot_total          decimal(10, 2) unsigned not null,
    valor_desconto       decimal(10, 2) unsigned null,
    id_reserva           int                     not null,
    id_servico_adicional int                     not null,
    id_promocao          int                     not null,
    constraint fk_pedido_promocao
        foreign key (id_promocao) references promocao (id_promocao),
    constraint fk_pedido_reserva
        foreign key (id_reserva, id_servico_adicional) references reserva (id_reserva, id_servico_adicional)
);

create index fk_pedido_promocao_idx
    on pedido (id_promocao);

create index fk_pedido_reserva_idx
    on pedido (id_reserva, id_servico_adicional);

