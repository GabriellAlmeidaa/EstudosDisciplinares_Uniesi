
create database estoque_modaamor;
use estoque_modaamor;

create table entrada_produto (
cod_etiqueta int not null,
tipo_roupa varchar(30) not null,
cor varchar(30) not null,
tamanho varchar(10) not null,
quantidade int not null,
valor_compra double not null,
Fornecedor varchar(30) not null,
primary key (cod_etiqueta));
