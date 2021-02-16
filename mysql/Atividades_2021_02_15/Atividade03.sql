-- Atividade 3

create database db_farmacia_do_bem;

use db_farmacia_do_bem;

create table tb_categoria (
    id bigint auto_increment,
    descricao varchar(255) not null,
    ativo boolean not null,
    primary key(id)
);

create table tb_produto (
    id bigint auto_increment,
    nome varchar(255) not null,
    fabricante varchar(255) not null,
    categoria_id bigint,
    preco decimal(7,2),
    primary key(id),
    foreign key(categoria_id) references tb_categoria(id)
);

insert into tb_categoria (descricao,ativo)
values
    ("Medicamentos",true),
    ("Higiene pessoal",true),
    ("Nutrição",true),
    ("Aparelhos de medição",true),
    ("Cosméticos",true);

insert into tb_produto (nome,fabricante,categoria_id,preco)
values
    ("Acido Acetilsalicílico 500mg 10 comprimidos","Bayer",1,9.00),
    ("Dipirona Monoidratada 500mg 10 comprimidos","EMS",1,6.00),
    ("Piroxicam 20mg 15 comprimidos","Neo Química",1,12.00),
    ("Sabonete Dove 90g","Unilever",2,3.00),
    ("Sabonete Phebo Amazonian 90g","Granado",2,4.00),
    ("Suplemento Nutricional Ensure Baunilha 900g","Abbott",3,120.00),
    ("Termômetro Digital Multilaser","Multilaser",4,21.00),
    ("Paleta de Sombras Vult Visage Tons Quentes 16g","Vult",5,53.00),
    ("Batom Maybelline Color Sensational Mauva 4g","Maybelline",5,37.00);

-- Faça um select que retorne os produtos com o valor maior do que 50 reais
select * from tb_produto
where preco > 50;

-- Faça um select trazendo os produtos com valor entre 3 e 60 reais
select * from tb_produto
where preco between 3 and 60;

-- Faça um select utilizando LIKE buscando os produtos com a letra B
select * from tb_produto
where nome like "b%"; -- produtos iniciando com a letra b

-- Faça um um select com inner join entre tabela categoria e produto
select tb_produto.id, nome, fabricante, tb_categoria.descricao as categoria, preco
from tb_produto inner join tb_categoria
on tb_produto.categoria_id = tb_categoria.id;

-- Faça um select onde traga todos os produtos de uma categoria específica (exemplo todos os produtos que são cosméticos)
select tb_produto.id, nome, fabricante, tb_categoria.descricao as categoria, preco
from tb_produto inner join tb_categoria
on tb_produto.categoria_id = tb_categoria.id
where tb_categoria.id = 5;
