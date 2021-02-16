-- Atividade 5

create database db_construindo_a_nossa_vida;

use db_construindo_a_nossa_vida;

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
    ("Tijolos",true),
    ("Cimentos e Argamassas",true),
    ("Cerâmicas",true),
    ("Materiais elétricos",true),
    ("Materiais hidráulicos",true);

insert into tb_produto (nome,fabricante,categoria_id,preco)
values
    ("Tijolo Comum Vermelho 8,7x4,3x18,6cm","Bauth",1,0.59),
    ("Bloco de Concreto Vedação Vazado 19x14x39cm","Blojaf",1,2.10),
    ("Cimento Portland CP II F 32 50kg","Votoran",2,26.90),
    ("Lavatório com Coluna de Chão Sabará Branco 80x46x35cm","Icasa",3,107.30),
    ("Vaso Sanitário Convencional Saída Vertical Izy Gelo","Deca",3,119.90),
    ("Cabo Flexível 2,5mm 100m Cinza","Sil",4,189.90),
    ("Cano Marrom PVC Soldável 25mm ou 3/4\" 3m","Tigre",5,17.49),
    ("Fita Veda Rosca 18mmx10m","Equation",5,2.09);

-- Faça um select que retorne os produtos com o valor maior do que 50 reais
select * from tb_produto
where preco > 50;

-- Faça um select trazendo os produtos com valor entre 3 e 60 reais
select * from tb_produto
where preco between 3 and 60;

-- Faça um select utilizando LIKE buscando os produtos com a letra C
select * from tb_produto
where nome like "c%"; -- produtos iniciando com a letra c

-- Faça um um select com inner join entre tabela categoria e produto
select tb_produto.id, nome, fabricante, tb_categoria.descricao as categoria, preco
from tb_produto inner join tb_categoria
on tb_produto.categoria_id = tb_categoria.id;

-- Faça um select onde traga todos os produtos de uma categoria específica (exemplo todos os produtos que são da categoria hidráulica)
select tb_produto.id, nome, fabricante, tb_categoria.descricao as categoria, preco
from tb_produto inner join tb_categoria
on tb_produto.categoria_id = tb_categoria.id
where tb_categoria.id = 5;
