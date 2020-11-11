load data
		infile 'C:\Documents and Settings\admlab\Desktop\Prova\Carregando.txt'
		badfile 'c:\temp\ErroAoImportar.txt'
		into table Produto
		fields terminated by ";" 
  		(cod_prod , nome_prod, descricao_prod, valor_prod, status_prod)