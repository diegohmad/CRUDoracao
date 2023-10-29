create database dbContatoOra;

use dbContatoOra;

create table tb_contato(
id Integer auto_increment primary KEY,
nome varchar(255),
sobrenome varchar(255),
celular varchar(255),
email varchar(255)
);

insert into tb_contato (nome, sobrenome, celular, email)
values ('Gretchen','Cantora','11-9999-0000','gretchen@cantora.com.br'),
('João','Engenheiro','11-8888-1234','joao@engenheiro.com'),
('Maria','Professor','11-7777-5678','maria@professor.com'),
('Carlos','Médico','11-6666-4321','carlos@medico.com'),
('Ana','Advogada','11-5555-8765','ana@advogada.com'),
('Pedro','Arquiteto','11-4444-2345','pedro@arquiteto.com');

select id, nome,sobrenome,celular,email from tb_contato;