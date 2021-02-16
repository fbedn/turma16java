-- Atividade 6

create database db_curso_da_minha_vida;

use db_curso_da_minha_vida;

create table tb_categoria (
    id bigint auto_increment,
    descricao varchar(255) not null,
    ativo boolean not null,
    primary key(id)
);

create table tb_curso (
    id bigint auto_increment,
    nome varchar(255) not null,
    professor varchar(255) not null,
    categoria_id bigint,
    preco decimal(7,2),
    primary key(id),
    foreign key(categoria_id) references tb_categoria(id)
);

insert into tb_categoria (descricao,ativo)
values
    ("Utilização de Software",true),
    ("Desenvolvimento de Software",true),
    ("Design",true),
    ("Fotografia e vídeo",true),
    ("Música",true);

insert into tb_curso (nome,professor,categoria_id,preco)
values
    ("Microsoft Excel: Completo de A a Z","Rafael Santos",1,27.90),
    ("Microsoft Word Super Completo do Básico ao Avançado","Ricardo Cunha",1,27.90),
    ("Curso React do Básico ao Avançado","Leonardo Leite",2,34.90),
    ("Java do Zero a Maestria","Matheus Batista",2,27.90),
    ("Curso Blender: Aprenda 3D do Zero!","Daniel França",3,50.90),
    ("Adobe Photoshop Completo: do Iniciante ao Avançado","Thiago Cristiano",3,27.90),
    ("Guia Completo de Fotografia","Felipe Estêvão",4,60.90),
    ("Teoria Musical do Básico ao Avançado","Josemir do Vale",5,54.90);

-- Faça um select que retorne os produtos com o valor maior do que 50 reais
select * from tb_curso
where preco > 50;

-- Faça um select trazendo os produtos com valor entre 3 e 60 reais
select * from tb_curso
where preco between 3 and 60;

-- Faça um select utilizando LIKE buscando os produtos com a letra J
select * from tb_curso
where nome like "j%"; -- produtos iniciando com a letra j

-- Faça um um select com inner join entre tabela categoria e produto
select tb_curso.id, nome, professor, tb_categoria.descricao as categoria, preco
from tb_curso inner join tb_categoria
on tb_curso.categoria_id = tb_categoria.id;

-- Faça um select onde traga todos os produtos de uma categoria específica
select tb_curso.id, nome, professor, tb_categoria.descricao as categoria, preco
from tb_curso inner join tb_categoria
on tb_curso.categoria_id = tb_categoria.id
where tb_categoria.id = 2; -- cursos da categoria desenvolvimento de software
