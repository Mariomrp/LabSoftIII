CREATE TABLE Cliente (
  matricula INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NULL,
  email VARCHAR(50) NULL,
  saldo REAL NULL,
  PRIMARY KEY(matricula)
)
TYPE=InnoDB;

CREATE TABLE Funcionario (
  matricula INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NULL,
  email VARCHAR(50) NULL,
  PRIMARY KEY(matricula)
)
TYPE=InnoDB;

CREATE TABLE Produto (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  tipo VARCHAR(50) NULL,
  preco REAL NULL,
  PRIMARY KEY(codigo)
)
TYPE=InnoDB;

CREATE TABLE Venda (
  codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Funcionario_matricula INTEGER UNSIGNED NOT NULL,
  Cliente_matricula INTEGER UNSIGNED NOT NULL,
  valor REAL NULL,
  dataVenda DATE NULL,
  PRIMARY KEY(codigo),
  INDEX Venda_FKIndex1(Funcionario_matricula),
  INDEX Venda_FKIndex2(Cliente_matricula)
)
TYPE=InnoDB;

CREATE TABLE Venda_Produto (
  Venda_codigo INTEGER UNSIGNED NOT NULL,
  Produto_codigo INTEGER UNSIGNED NOT NULL,
  quantidade INTEGER UNSIGNED NULL,
  valor REAL NULL,
  dataVendaProduto DATE NULL,
  PRIMARY KEY(Venda_codigo, Produto_codigo),
  INDEX Venda_has_Produto_FKIndex1(Venda_codigo),
  INDEX Venda_has_Produto_FKIndex2(Produto_codigo)
)
TYPE=InnoDB;


