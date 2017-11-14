drop database if exists jsf1;
create database jsf1;

use jsf1;

create table cliente(idCliente int primary key auto_increment,
  nome varchar (35),
  email varchar (50) unique,
  sexo enum ('m','f'));
 

   insert into cliente values (null,'jose','jose@gmail.com','m');
   insert into cliente values (null,'lu','lu@gmail.com','f');
   insert into cliente values (null,'marcelo','marcelo@gmail.com','m');

   
select * from cliente;
   
------------

