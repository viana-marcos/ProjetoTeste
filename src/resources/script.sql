
use venda;

CREATE TABLE tb_venda
(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   data DATE,
   loja INT,
   pdv  INT,
   status VARCHAR(50)    
);

CREATE TABLE tb_item_venda
(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   id_venda INT,   
   produto VARCHAR(500),
   preco_unitario DECIMAL(10,2),
   desconto DECIMAL(10,2),    
   FOREIGN KEY(id_venda) references tb_venda(id)   
);

CREATE TABLE tb_processamento
(
   id INT AUTO_INCREMENT PRIMARY KEY,   
   data DATE,
   loja INT,
   pdv  INT, 
   nome_arquivo VARCHAR(200),
   status VARCHAR(50) 
   
)