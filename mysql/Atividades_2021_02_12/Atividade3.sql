-- Atividade 3

-- Crie um banco de dados para um registro de uma escola, onde o sistema trabalhará com as informações dos alunos deste registro dessa escola
create database db_escola;

use db_escola;

-- Crie uma tabela alunos/a e utilizando a habilidade de abstração e determine 5 atributos relevantes dos alunos/a para se trabalhar com o serviço dessa escola
create table tb_alunos (
	id bigint auto_increment,
    nome varchar(255) not null,
    ano_nascimento int not null,
    serie_e_turma_atual varchar(255) not null,
    media_notas float,
    primary key(id)
);

-- Popule esta tabela com até 8 dados
insert into tb_alunos (nome,ano_nascimento,serie_e_turma_atual,media_notas)
values
	("João",2005,"Ensino Médio 2ª série, turma A", 7.4),
	("Julia",2006,"Ensino Médio 1ª série, turma C",5.9),
	("Ana",2005,"Ensino Médio 2ª série, turma B",8.1),
	("Beatriz",2008,"Ensino Fundamental 7ª série, turma B",6.2),
	("Roberto",2007,"Ensino Fundamental 8ª série, turma A",8.4),
    ("Pedro",2008,"Ensino Fundamental 7ª série, turma B",5.5),
    ("Bruno",2005,"Ensino Médio 2ª série, turma B",6.8),
    ("Fabiana",2006,"Ensino Médio 1ª série, turma A",6.5);

-- Faça um select que retorne o/as alunos/a com a nota maior do que 7
select * from tb_alunos
where media_notas > 7;

-- Faça um select que retorne o/as alunos/a com a nota menor do que 7.
select * from tb_alunos
where media_notas < 7;

-- Ao término atualize um dado desta tabela através de uma query de atualização
update tb_alunos
set media_notas = 6.3
where id = 2;