-- Atividade 2

-- Crie um banco de dados para um e commerce, onde o sistema trabalhará com as informações dos produtos deste ecommerce
create database db_ecommerce;

use db_ecommerce;

-- Crie uma tabela produtos e utilizando a habilidade de abstração e determine 5 atributos relevantes dos produtos para se trabalhar com o serviço deste ecommerce
create table tb_produtos (
	id bigint auto_increment,
    nome varchar(255) not null,
    categoria varchar(255) not null, -- o ideal seria ter outra tabela com as categorias, e referenciar aqui o id da categoria
    preco_unitario float not null,
    qtd_estoque int not null,
    primary key(id)
);

-- Popule esta tabela com até 8 dados
insert into tb_produtos (nome,categoria,preco_unitario, qtd_estoque)
values
	("kit chave de fenda","ferramentas",30.00, 70),
	("espelho 50x40 cm com moldura","decoração",70.00,40),
	("vaso de vidro 6x15 cm","decoração",35.00,60),
	("conjunto de talheres","cozinha",150.00,15),
	("alicate de pressão","ferramentas",79.00,49),
    ("estátua réplica cristo redentor 1,5m ","decoração",800.00,1),
    ("cômoda 1,3x0,7 m","móveis",600.00,4),
    ("conjunto de 6 copos americanos","cozinha",50.00,80);

-- Faça um select que retorne os produtos com o valor maior do que 500
select * from tb_produtos
where preco_unitario > 500;

-- Faça um select que retorne os produtos com o valor menor do que 500
select * from tb_produtos
where preco_unitario < 500;

-- Ao término atualize um dado desta tabela através de uma query de atualização
update tb_produtos
set qtd_estoque = 90
where id = 1;
