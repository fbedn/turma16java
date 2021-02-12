-- Atividade 1

-- Crie um banco de dados para um serviço de RH de uma empresa, onde o sistema trabalhará com as informações dos funcionários desta empresa
create database db_servico_rh;

use db_servico_rh;

-- Crie uma tabela de funcionários e utilizando a habilidade de abstração e determine 5 atributos relevantes dos funcionários para se trabalhar com o serviço deste RH
create table tb_funcionarios (
	id bigint auto_increment,
    nome varchar(255) not null,
    idade int not null,
    salario float not null,
    descricao_cargo varchar(255) not null,
    primary key(id)
);

-- Popule esta tabela com até 5 dados
insert into tb_funcionarios (nome,idade,salario, descricao_cargo)
values
	("Raphael",28,5000, "programador frontend"),
	("Rafão",32,8000,"diretor"),
	("Fernando",28,5000,"programador backend"),
	("Juliana",29,5500,"administrador do banco de dados"),
	("Rita",26,1999,"testador");

-- Faça um select que retorne os funcionários com o salário maior do que 2000
select * from tb_funcionarios
where salario > 2000;

-- Faça um select que retorne os funcionários com o salário menor do que 2000.
select * from tb_funcionarios
where salario < 2000;

-- Ao término atualize um dado desta tabela através de uma query de atualização.
update tb_funcionarios
set salario = 5000
where id = 5;
