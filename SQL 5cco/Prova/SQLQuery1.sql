CREATE TABLE Produto
(
cod_prod             INT,
nome_prod            VARCHAR(100),
descricao_prod           varchar(100) ,
valor_prod              VARCHAR(100) ,
status_prod            varCHAR(100) 
);

Bulk Insert pRODUTO
From 'C:\Documents and Settings\admlab\Desktop\Prova\Carregando.txt'
With
( 	FieldTerminator = ';',
	RowTerminator = '\n',
	Fire_Triggers  )
	
		
INSERT INTO PRODUTO
SELECT * FROM OPENROWSET('Microsoft.Jet.OLEDB.4.0', 
'Excel 8.0;Database=C:\Documents and Settings\admlab\Desktop\Prova\PRODUTO.XLS', 
'SELECT COD, NOME, DESC, VALOR, STATUS FROM [NOMES$]') 

INSERT INTO PRODUTO
SELECT *
   FROM OPENROWSET('Microsoft.Jet.OLEDB.4.0',
      'C:\Documents and Settings\admlab\Desktop\Prova\Pedidos2000.mdb';
      'admin';'',Prova) 
      
      INSERT INTO OPENROWSET('Microsoft.Jet.OLEDB.4.0', 
'Excel 8.0;Database=C:\Documents and Settings\admlab\Desktop\Prova\PRODUTO.XLS', 
'SELECT COD, NOME, DESC, VALOR, STATUS FROM [NOMES$]') 
SELECT * FROM Produto


select * from Produto;