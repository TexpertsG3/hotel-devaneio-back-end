create table cargo
(
    id_cargo        int auto_increment
        primary key,
    nome_cargo      varchar(100) not null,
    descricao_cargo varchar(255) not null
);

create table endereco
(
    id_endereco int auto_increment
        primary key,
    rua         varchar(100) not null,
    bairro      varchar(100) not null,
    numero      int          not null,
    cep         int          not null,
    cidade      varchar(100) not null,
    uf          varchar(2)   not null,
    complemento varchar(100) not null
);

create table hospede
(
    id_hospede int unsigned not null
        primary key,
    nome       varchar(100) not null,
    sobrenome  varchar(100) not null,
    cpf        int          not null,
    senha      varchar(25)  not null,
    constraint cpf_UNIQUE
        unique (cpf)
);

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

create index fk_contato_hospede_idx
    on contato (hospede_id_hospede);

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

create table promocao
(
    id_promocao   int auto_increment
        primary key,
    nome_promocao varchar(100)   null,
    desconto      decimal(10, 2) null,
    data_inicio   datetime       null,
    data_fim      datetime       null
);

create table quarto
(
    id_quarto int auto_increment
        primary key,
    nome      varchar(255)            not null,
    descricao varchar(255)            not null,
    preco     decimal(10, 2) unsigned not null
);

create table servico_adicional
(
    id_servico_adicional int auto_increment
        primary key,
    nome                 varchar(255)            not null,
    descricao            varchar(255)            not null,
    preco                decimal(10, 2) unsigned not null
);

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

