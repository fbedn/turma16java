-- Atividade 2

create database db_pizzaria_legal;

use db_pizzaria_legal;

create table tb_categoria (
	id bigint auto_increment,
    descricao varchar(255) not null,
    ativo boolean not null,
    primary key(id)
);

create table tb_pizza (
	id bigint auto_increment,
    nome varchar(255) not null,
    lista_ingredientes varchar(255) not null,
    categoria_id bigint,
    preco decimal(7,2),
    primary key(id),
    foreign key(categoria_id) references tb_categoria(id)
);

insert into tb_categoria (descricao,ativo)
values
	("Pizzas tradicionais",true),
    ("Pizzas especiais",true),
    ("Pizzas com massa integral",true),
	("Pizzas vegetarianas",true),
    ("Pizzas doces",true);

insert into tb_pizza (nome,lista_ingredientes,categoria_id,preco)
values
	("Mussarela","mussarela e orégano",1,28.00),
    ("Calabresa","calabresa e cebola fatiada",1,34.00),
    ("Marguerita","mussarela, parmesão, tomate e manjericão",1,34.00),
    ("À moda da casa","mussarela, provolone, parmesão, cebola fatiada e orégano",2,46.00),
    ("Mussarela com massa integral","massa integral, mussarela e orégano",3,40.00),
    ("Mussarela vegetariana","mussarela vegana e orégano",4,38.00),
    ("Chocolate","chocolate coberto com granulado",5,61.00),
	("Chocolate com cereja","chocolate, leite condensado e cereja",5,61.00);


-- Faça um select que retorne os produtos com o valor maior do que 45 reais
select * from tb_pizza
where preco > 45;

-- Faça um select trazendo os produtos com valor entre 29 e 60 reais
select * from tb_pizza
where preco between 29 and 60;

-- Faça um select utilizando LIKE buscando os produtos com a letra C
select * from tb_pizza
where nome like "c%"; -- produtos iniciando com a letra c

-- Faça um um select com inner join entre tabela categoria e pizza
select tb_pizza.id, nome, lista_ingredientes, tb_categoria.descricao as categoria, preco
from tb_pizza inner join tb_categoria
on tb_pizza.categoria_id = tb_categoria.id;

-- Faça um select onde traga todos os produtos de uma categoria específica (exemplo todos os produtos que são pizza doce)
select tb_pizza.id, nome, lista_ingredientes, tb_categoria.descricao as categoria, preco
from tb_pizza inner join tb_categoria
on tb_pizza.categoria_id = tb_categoria.id
where tb_categoria.id = 5;
