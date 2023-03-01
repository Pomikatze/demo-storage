create sequence if not exists storage_info_seq;

create table if not exists storage_info
(
    storage_info_id bigint not null default nextval('storage_info_seq'),
    address varchar(255) not null default 'n/a',
    phone varchar(11),
    constraint storage_info_pk primary key (storage_info_id)
);

create sequence if not exists storage_seq;

create table if not exists storage
(
    storage_id bigint not null default nextval('storage_seq'),
    name varchar(100) not null,
    storage_info_id bigint not null,
    constraint storage_pk primary key (storage_id),
    constraint storage_info_fk foreign key (storage_info_id)
        references storage_info (storage_info_id)
);

create sequence if not exists order_info_seq;

create table if not exists order_info
(
    order_info_id bigint not null default nextval('order_info_seq'),
    storage_id bigint not null,
    file_id bigint not null,
    constraint order_info_pk primary key (order_info_id),
    constraint storage_order_fk foreign key (storage_id)
        references storage (storage_id)
);