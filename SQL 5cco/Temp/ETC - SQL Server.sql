--CRIA DATABASE
CREATE DATABASE IBTA

--ACESSA O DATABASE
USE IBTA

--CRIAR TABELA
create table ALUNO
(codAluno	int,
nomeAluno	varchar(100))

CREATE TABLE PESSOA 
(COD INT, 
NOME VARCHAR(50))

create table TRISTE
(codAluno	   int,
nomeAluno	   varchar(100),
estadoCivil	   varchar(1),
dataNascimento smalldatetime,
email          varchar(100))

Bulk Insert Triste
From 'c:\temp\5cco\Carregando.txt'
With
( 	FieldTerminator = ';',
	RowTerminator = '\n',
	Fire_Triggers  )

drop table TRISTE

select * from TRISTE


--BCP (bulk copy program)
bcp IBTA.dbo.Aluno in "c:\temp\5cco\CargaAluno.txt" -T -c -t";"

SELECT * FROM ALUNO

--CARGA DIRETA
Bulk Insert Aluno
From 'c:\temp\5cco\CargaAluno.txt'
With
( 	FieldTerminator = ';',
	RowTerminator = '\n',
	Fire_Triggers  )

select * from ALUNO

-- Habilitar a visibilidade das opções avançadas
EXEC sp_configure 'show advanced option', '1';
reconfigure

-- Habilitar a utilização de OPENROWSET
exec sp_configure 'Ad Hoc Distributed Queries',1
reconfigure

exec sp_configure 'xp_cmdshell',1
reconfigure

xp_cmdshell 'c:'
go
xp_cmdshell 'cd \'
go
xp_cmdshell 'dir /s'
go

xp_cmdshell 'fx'

--OPENROWSET(DRIVER, STRING DE CONEXÃO, SELECT)
--==================================================================
-- EXCEL
SELECT * FROM OPENROWSET('Microsoft.Jet.OLEDB.4.0', 
'Excel 8.0;Database=c:\temp\5cco\PESSOA.XLS', 
'SELECT COD, NOME FROM [NOMES$]') 

--IMPORTAR DADOS
INSERT INTO PESSOA
SELECT * FROM OPENROWSET('Microsoft.Jet.OLEDB.4.0', 
'Excel 8.0;Database=c:\temp\5cco\PESSOA.XLS', 
'SELECT COD, NOME FROM [NOMES$]') 

SELECT * FROM PESSOA

--EXPORTAR DADOS
INSERT INTO OPENROWSET('Microsoft.Jet.OLEDB.4.0', 
'Excel 8.0;Database=c:\temp\5cco\PESSOA.XLS', 
'SELECT COD, NOME FROM [NOMES$]') 
SELECT * FROM PESSOA


--==================================================================
-- MS-ACCESS
SELECT *
   FROM OPENROWSET('Microsoft.Jet.OLEDB.4.0',
      'c:\temp\5cco\Pedidos2000.mdb';
      'admin';'',PEDIDOS) 
      where VLR_TOTAL = 0
