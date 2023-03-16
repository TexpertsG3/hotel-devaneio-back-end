use hotel_devaneio;

create table if not exists cargo
(
    id_cargo   int auto_increment
        primary key,
    nome_cargo varchar(100) not null
)
    auto_increment = 2;

create table if not exists contato
(
    id_contato int auto_increment
        primary key,
    email      varchar(255) not null,
    telefone   varchar(45)  not null,
    celular    varchar(45)  not null
)
    auto_increment = 2;

create table if not exists endereco
(
    id_endereco int auto_increment
        primary key,
    rua         varchar(100) not null,
    bairro      varchar(100) not null,
    numero      int unsigned not null,
    cep         varchar(8)   not null,
    cidade      varchar(100) not null,
    uf          varchar(2)   not null,
    complemento varchar(100) not null
)
    auto_increment = 2;

create table if not exists dados_hotel
(
    id_dados_hotel int auto_increment
        primary key,
    nome           varchar(255) not null,
    cnpj           varchar(14)  not null,
    id_contato     int          not null,
    id_endereco    int          not null,
    constraint fk_dados_hotel_contato
        foreign key (id_contato) references contato (id_contato)
            on update cascade on delete cascade,
    constraint fk_dados_hotel_endereco
        foreign key (id_endereco) references endereco (id_endereco)
            on update cascade on delete cascade
)
    auto_increment = 2;

create index fk_dados_hotel_contato_idx
    on dados_hotel (id_contato);

create index fk_dados_hotel_endereco_idx
    on dados_hotel (id_endereco);

create table if not exists hotel
(
    id_hotel       int auto_increment
        primary key,
    id_dados_hotel int not null,
    constraint id_dados_hotel_UNIQUE
        unique (id_dados_hotel),
    constraint fk_hotel_dadosHotel
        foreign key (id_dados_hotel) references dados_hotel (id_dados_hotel)
            on update cascade on delete cascade
)
    auto_increment = 2;

create table if not exists administrador
(
    id_administrador int auto_increment
        primary key,
    nome_admin       varchar(100) not null,
    senha_admin      varchar(100) not null,
    id_contato       int          not null,
    id_endereco      int          not null,
    id_hotel         int          not null,
    constraint fk_administrador_contato
        foreign key (id_contato) references contato (id_contato),
    constraint fk_administrador_endereco
        foreign key (id_endereco) references endereco (id_endereco),
    constraint fk_administrador_hotel
        foreign key (id_hotel) references hotel (id_hotel)
);

create index fk_administrador_contato_idx
    on administrador (id_contato);

create index fk_administrador_endereco_idx
    on administrador (id_endereco);

create table if not exists funcionario
(
    id_funcionario        int auto_increment
        primary key,
    nome_funcionario      varchar(100)            not null,
    sobrenome_funcionario varchar(100)            not null,
    cpf                   varchar(15)             not null,
    id_cargo              int                     not null,
    id_contato            int                     not null,
    id_endereco           int                     not null,
    id_hotel              int                     not null,
    salario               decimal(10, 2) unsigned not null,
    constraint cpf_UNIQUE
        unique (cpf),
    constraint fk_funcionario_id_cargo
        foreign key (id_cargo) references cargo (id_cargo),
    constraint fk_funcionario_id_contato
        foreign key (id_contato) references contato (id_contato),
    constraint fk_funcionario_id_endereco
        foreign key (id_endereco) references endereco (id_endereco),
    constraint fk_funcionario_id_hotel
        foreign key (id_hotel) references hotel (id_hotel)
)
    auto_increment = 2;

create index fk_funcionario_cargo_idx
    on funcionario (id_cargo);

create index fk_funcionario_contato_idx
    on funcionario (id_contato);

create index fk_funcionario_endereco_idx
    on funcionario (id_endereco);

create index fk_funcionario_id_hotel_idx
    on funcionario (id_hotel);

create table if not exists hospede
(
    id_hospede int          not null
        primary key,
    nome       varchar(100) not null,
    sobrenome  varchar(100) not null,
    cpf        int          not null,
    senha      varchar(25)  not null,
    id_contato int          not null,
    id_hotel   int          null,
    constraint cpf_UNIQUE
        unique (cpf),
    constraint fk_hospede_id_hotel
        foreign key (id_hotel) references hotel (id_hotel)
            on update cascade on delete cascade
);

create index fsdf_idx
    on hospede (id_hotel);

create index fk_hotel_dadosHotel_idx
    on hotel (id_dados_hotel);

create table if not exists promocao
(
    id_promocao   int auto_increment
        primary key,
    nome_promocao varchar(100)            null,
    desconto      decimal(10, 2) unsigned null,
    data_inicio   datetime                null,
    data_fim      datetime                null
);

create table if not exists quarto
(
    id_quarto int auto_increment
        primary key,
    id_hotel  int                     not null,
    nome      varchar(255)            not null,
    descricao varchar(255)            not null,
    preco     decimal(10, 2) unsigned not null,
    constraint fk_quarto_hotel
        foreign key (id_hotel) references hotel (id_hotel)
            on update cascade on delete cascade
);

create index fk_quarto_hotel_idx
    on quarto (id_hotel);

create table if not exists reserva
(
    id_reserva     int auto_increment
        primary key,
    id_hospede     int                     not null,
    check_in       datetime                not null,
    check_out      datetime                not null,
    qtd_adultos    int unsigned            not null,
    qtd_criancas   int unsigned            not null,
    id_quarto      int                     not null,
    id_hotel       int                     not null,
    total_servicos decimal(10, 2) unsigned not null,
    total_reserva  decimal(10, 2) unsigned not null,
    constraint fk_reserva_hospede
        foreign key (id_hospede) references hospede (id_hospede)
            on update cascade on delete cascade,
    constraint fk_reserva_hotel
        foreign key (id_hotel) references hotel (id_hotel)
            on update cascade on delete cascade,
    constraint fk_reserva_quarto
        foreign key (id_quarto) references quarto (id_quarto)
            on update cascade on delete cascade
);

create index fk_reserva_hospede_idx
    on reserva (id_hospede);

create index fk_reserva_hotel_idx
    on reserva (id_hotel);

create index fk_reserva_quarto_idx
    on reserva (id_quarto);

create table if not exists servico_adicional
(
    id_servico_adicional int auto_increment
        primary key,
    nome                 varchar(255)            not null,
    preco                decimal(10, 2) unsigned not null,
    id_hotel             int                     not null,
    constraint fk_servico_adicional_id_hotel
        foreign key (id_hotel) references hotel (id_hotel)
);

create table if not exists reserva_servico
(
    idreserva_servico    int auto_increment
        primary key,
    id_reserva           int not null,
    id_servico_adicional int not null,
    constraint fk_reserva_servico_id_reserva
        foreign key (id_reserva) references reserva (id_reserva),
    constraint fk_reserva_servico_id_servico_adicional
        foreign key (id_servico_adicional) references servico_adicional (id_servico_adicional)
);

create index fk_reserva_servico_id_reserva_idx
    on reserva_servico (id_reserva);

create index fk_reserva_servico_id_servico_adicional_idx
    on reserva_servico (id_servico_adicional);

create index fk_servico_adicional_id_hotel_idx
    on servico_adicional (id_hotel);

