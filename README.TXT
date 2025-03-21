create database if not exists projeto_contas;
use projeto_contas;

create table if not exists endereco (
    idendereco INT AUTO_INCREMENT PRIMARY KEY,
    estado varchar(45) not null,
    cidade varchar(45) not null,
	bairro varchar(45) not null,
    rua varchar(45) not null,
    numero varchar(45) not null,
    cep varchar(9) not null

);

create table if not exists telefone (
    idtelefone INT AUTO_INCREMENT PRIMARY KEY,
    numero varchar(45) not null,
    tipo_numero varchar(45) not null

);

create table if not exists usuario (
    idusuario INT AUTO_INCREMENT PRIMARY KEY,
    nome varchar(45) not null,
    cpf varchar(45) not null,
	email varchar(45) not null,
    login varchar(45) not null,
    senha varchar(45) not null,
    idendereco int not null,
    constraint fk_idendereco_endereco foreign key (idendereco)
	references endereco(idendereco),
    idtelefone int not null,
    constraint fk_idtelefone_telefone foreign key (idtelefone)
	references telefone(idtelefone)

);


create table if not exists categoria (
    idcategoria INT AUTO_INCREMENT PRIMARY KEY,
    descricao varchar(45) not null,
    tipo varchar(45) not null

);

create table if not exists contas (
    idcontas INT AUTO_INCREMENT PRIMARY KEY,
    descricao varchar(45) not null,
    valor float not null,
	data_vencimento date not null,
    data_pagamento date,
    tipo_conta varchar(45) not null,
	status_contas boolean not null,
    idusuario int not null,
    constraint fk_idusuario_usuario foreign key (idusuario)
	references usuario(idusuario),
    idcategoria int not null,
    constraint fk_idcategoria_categoria foreign key (idcategoria)
	references categoria(idcategoria)

);

create table if not exists parcela (
    idparcela INT AUTO_INCREMENT PRIMARY KEY,
    data_vencimento date not null,
    numero_parcela int not null,
	valor_parcela double not null,
    idcontas int not null,
    constraint fk_idcontas_contas foreign key (idcontas)
	references contas(idcontas)

);


INSERT INTO endereco (estado, cidade, bairro, rua, numero, cep) VALUES
('São Paulo', 'São Paulo', 'Centro', 'Av. Paulista', '1000', '01310-000'),
('Rio de Janeiro', 'Rio de Janeiro', 'Copacabana', 'Rua Barata Ribeiro', '500', '22040-002'),
('Minas Gerais', 'Belo Horizonte', 'Savassi', 'Rua Pernambuco', '300', '30130-150'),
('Bahia', 'Salvador', 'Pituba', 'Av. Paulo VI', '250', '41810-001'),
('Paraná', 'Curitiba', 'Batel', 'Rua Vicente Machado', '1200', '80420-011'),
('Rio Grande do Sul', 'Porto Alegre', 'Moinhos de Vento', 'Rua Padre Chagas', '450', '90570-080'),
('Pernambuco', 'Recife', 'Boa Viagem', 'Av. Boa Viagem', '900', '51011-000'),
('Ceará', 'Fortaleza', 'Meireles', 'Av. Beira Mar', '600', '60165-121'),
('Distrito Federal', 'Brasília', 'Asa Sul', 'SQS 206', 'Bloco B', '70252-540'),
('Santa Catarina', 'Florianópolis', 'Centro', 'Rua Felipe Schmidt', '200', '88010-001');

INSERT INTO telefone (numero, tipo_numero) VALUES
('11987654321', 'Celular'),
('11976543210', 'Residencial'),
('21987654321', 'Celular'),
('31965432100', 'Comercial'),
('41987651234', 'Celular'),
('51965439876', 'Residencial'),
('61987654321', 'Celular'),
('71965432222', 'Comercial'),
('81987655555', 'Celular'),
('91965431111', 'Residencial');

INSERT INTO usuario (nome, cpf, email, login, senha, idendereco, idtelefone) VALUES
('Carlos Silva', '123.456.789-01', 'carlos.silva@email.com', 'carloss', 'senha123', 1, 1),
('Maria Souza', '987.654.321-02', 'maria.souza@email.com', 'marias', 'senha456', 2, 2),
('João Pereira', '321.654.987-03', 'joao.pereira@email.com', 'joaop', 'senha789', 3, 3),
('Ana Oliveira', '654.987.321-04', 'ana.oliveira@email.com', 'anao', 'senhaabc', 4, 4),
('Fernando Lima', '147.258.369-05', 'fernando.lima@email.com', 'fernandol', 'senhadef', 5, 5),
('Camila Rocha', '369.258.147-06', 'camila.rocha@email.com', 'camilar', 'senhaghi', 6, 6),
('Roberto Mendes', '159.753.852-07', 'roberto.mendes@email.com', 'robertom', 'senhajkl', 7, 7),
('Juliana Costa', '753.159.852-08', 'juliana.costa@email.com', 'julianac', 'senhamno', 8, 8),
('Ricardo Alves', '852.159.753-09', 'ricardo.alves@email.com', 'ricardoa', 'senhapqr', 9, 9),
('Vanessa Martins', '258.369.147-10', 'vanessa.martins@email.com', 'vanessam', 'senhastu', 10, 10);

INSERT INTO categoria (descricao, tipo) VALUES 
('Alimentação', 'Despesa'),
('Transporte', 'Despesa'),
('Saúde', 'Despesa'),
('Educação', 'Despesa'),
('Lazer', 'Despesa'),
('Moradia', 'Despesa'),
('Salário', 'Receita'),
('Investimentos', 'Receita'),
('Renda Extra', 'Receita'),
('Impostos', 'Despesa');

INSERT INTO contas (descricao, valor, data_vencimento, data_pagamento, tipo_conta, status_contas, idusuario, idcategoria) VALUES
('Compra', 250.50, '2025-03-15', '2025-03-14', 'Cartão de Crédito', true, 1, 1),
('Aluguel de Apartamento', 1500.00, '2025-03-05', '2025-03-03', 'Boleto', true, 2, 6),
('Consulta Médica', 120.00, '2025-03-10', '2025-03-09', 'Dinheiro', true, 3, 3),
('Curso de Programação', 300.00, '2025-03-20', '2025-03-18', 'Cartão de Crédito', true, 4, 4),
('Cinema', 40.00, '2025-03-25', '2025-03-23', 'Dinheiro', false, 5, 5),
('Contas de Água e Luz', 200.00, '2025-03-12', '2025-03-11', 'Boleto', true, 6, 6),
('Salário de Março', 3500.00, '2025-03-30', '2025-03-30', 'Transferência', true, 7, 7),
('Investimentos em Ações', 500.00, '2025-03-28', '2025-03-26', 'Transferência', true, 8, 8),
('Renda Extra Freelance', 1000.00, '2025-03-15', '2025-03-14', 'Dinheiro', true, 9, 9),
('Impostos sobre Renda', 800.00, '2025-03-10', '2025-03-09', 'Boleto', false, 10, 10);

INSERT INTO parcela (data_vencimento, numero_parcela, valor_parcela, idcontas) VALUES
('2025-03-15', 1, 100.00, 1),
('2025-04-15', 2, 100.00, 1),
('2025-05-15', 3, 100.00, 1),
('2025-06-15', 4, 100.00, 1),
('2025-03-05', 1, 1500.00, 2),
('2025-03-05', 1, 120.00, 3),
('2025-03-20', 1, 300.00, 4),
('2025-03-25', 1, 40.00, 5),
('2025-03-12', 1, 200.00, 6);

#('2025-03-30', 1, 3500.00, 7)
