create table objetos(

                        id bigint not null auto_increment,
                        nome varchar(100) not null,
                        dica varchar(100) not null unique,

                        primary key(id)

);