//Toca a musica do jogo
var musica = new Audio("musica.mp3");
musica.loop = true;
musica.play();

var player = new Array();//player[0] guarda um array contendo a [coluna, linha] em que o player está 
var estrelas = new Array();//Cada posição deste array guarda um array contendo a [coluna, linha] em que uma estrela está
var destinos = new Array();//Cada posição deste array guarda um array contendo a [coluna, linha] em que um destino possível para uma estrela está

//###########################Cria os níveis do jogo###############################
var nivel = new Array();
var nivel1 = new Array();//cada posição deste array representará uma linha do nível 1 do jogo
nivel1[0] = [4, 4, 4, 4, 4, 4, 4,4, 4, 4, 4, 4, 4, 4];
nivel1[1] = [4, 0, 2, 2, 2, 2, 2,2, 4, 2, 2, 4, 3, 4];
nivel1[2] = [4, 2, 4, 4, 4, 2, 4,2, 4, 2, 4, 4, 2, 4];
nivel1[3] = [4, 2, 4, 2, 2, 2, 2,2, 2, 2, 2, 4, 2, 4];
nivel1[4] = [4, 2, 4, 2, 4, 4, 2,2, 2, 4, 2, 4, 2, 4];
nivel1[5] = [4, 2, 2, 2, 2, 2, 2,4, 2, 2, 2, 2, 2, 4];
nivel1[6] = [4, 2, 4, 4, 4, 4, 4,2, 2, 2, 4, 4, 2, 4];
nivel1[7] = [4, 2, 4, 4, 4, 4, 4,2, 4, 2, 4, 4, 2, 4];
nivel1[8] = [4, 2, 2, 2, 2, 2, 2,2, 4, 2, 2, 2, 2, 4];
nivel1[9] = [4, 2, 4, 2, 4, 2, 4,2, 4, 2, 4, 4, 2, 4];
nivel1[10] =[4, 2, 4, 2, 4, 2, 4,2, 4, 2, 4, 4, 2, 4];
nivel1[11] =[4, 2, 4, 2, 4, 4, 4,4, 4, 2, 4, 2, 2, 4];
nivel1[12] =[4, 2, 2, 2, 4, 2, 4,2, 4, 2, 2, 2, 2, 4];
nivel1[13] =[4, 2, 4, 2, 2, 2, 2,2, 2, 2, 2, 2, 4, 4];
nivel1[14] =[4, 2, 4, 2, 4, 4, 2,2, 2, 2, 2, 4, 4, 4];
nivel1[15] =[4, 2, 2, 2, 2, 2, 2,4, 4, 4, 2, 2, 4, 4];
nivel1[16] =[4, 2, 4, 2, 4, 4, 2,4, 4, 4, 4, 4, 4, 4];
nivel1[17] =[4, 2, 1, 2, 4, 4, 2,4, 4, 4, 4, 4, 4, 4];
nivel1[18] =[4, 2, 2, 2, 2, 2, 2,2, 4, 2, 2, 2, 4, 4];
nivel1[19] =[4, 4, 4, 4, 4, 4, 4,4, 4, 4, 4, 4, 4, 4];
nivel[0] = nivel1;//Guardo o nivel criado no array de niveis

var canvas = document.getElementById('canvas');
var contextoCanvas = null;

if (canvas && canvas.getContext) {
	contextoCanvas = canvas.getContext('2d');
	//###########################Carrega todas as imagens utilizadas no jogo em objetos Image dentro de um array imagens###############################
	var imagens = new Array();//Array de objetos Image contendo as imagens utilizadas no jogo
	var noImagesLoaded = 0;//Controla quantas imagens do jogo foram carregadas
	loadImagem(0, "bola.png");
	loadImagem(1, "estrela-off.png");
	loadImagem(2, "grid.png");
	loadImagem(3, "estrela-place.png");
	loadImagem(4, "parede.png");
	loadImagem(5, "estrela-on.png");
}

//Salvar um objeto Image dentro da posição "pId" no array imagens e manda que "pImagem" seja carregada em tal objeto. Ainda nesta função especificaremos que quando uma imagem for carregada a variável "noImagesLoaded" será incrementada em 1 e verificaremos se o número de imagens carregadas coincide com o número de imagens usadas no jogo, se sim chamaremos o método startGame() que será responsavel pro prosseguir com o jogo
function loadImagem(pId, pImagem){
	imagens[pId] = new Image();
	imagens[pId].onload = function(){//Uso o método onload do objeto Image para desenhar a imagem no canvas da página somente quando a mesma for carregada
		noImagesLoaded++;
		if (noImagesLoaded == 6){
			startGame();//Todas imagens foram carregadas, começo o jogo
		}
	}
	imagens[pId].src = "http://www.progamacaoweb.com.br/tutoriais/html5/jogo-html5/imagens/" + pImagem;//Especifíco o caminho da imagem a ser usada
}

function startGame(){
	gerarNivel(0);
	iniciaElementosDinamicos(0);
	desenhaItensDinamicos();
}

document.onkeydown = apertaTecla;//Detecta quando uma tecla é pressionada e chama a função apertaTecla
function apertaTecla(e){
	//Lógica para capturar o código da tecla pressionada
	var evtobj;
    if (window.event){
    	evtobj = event;
   	}else{
    	evtobj = e;
    }
    var unicode;
    if (evtobj.charCode){
    	code = evtobj.charCode;
    }else{
    	code = evtobj.keyCode;
    }

	//Com o código pego verifico qual ação irei fazer
	var novaPosicao = [player[0][0], player[0][1]];
	var posicaoAFrente = [player[0][0], player[0][1]];
	if (code == 87 || code == 38 ){//W = Movo para cima
		novaPosicao[1]--;
		posicaoAFrente[1] -= 2;
	}else if (code == 65 || code == 37){//A = Movo para esquerda
		novaPosicao[0]--;
		posicaoAFrente[0] -= 2;
	}else if (code == 83 || code == 40){//S = Movo para baixo
		novaPosicao[1]++;
		posicaoAFrente[1] += 2;
	}else if (code == 68 || code == 39){//D = Movo para direita
		novaPosicao[0]++;
		posicaoAFrente[0] += 2;
	}
	
	if (novaPosicaoEValida(novaPosicao, posicaoAFrente)){
		player[0] = novaPosicao;//Move o personagem	
		var indiceEstrela = temEstrela(novaPosicao);
		if (indiceEstrela != -1){//Nova posição é uma estrela
			estrelas[indiceEstrela] = posicaoAFrente;//Movo a estrela para a posição a frente
		}
		gerarNivel(0);//Limpa o canvas e redesenha a parte estatica
		desenhaItensDinamicos();//Desenha novamente parte dinamica
		jogoTerminou();//verifica se o jogo terminou
	}
}

//Verifica se o player pode mover-se para uma determinada posição. Se na posição houver uma estrela, verifico se posso empurrar esta estrela
function novaPosicaoEValida(pPosicao, pPosicaoAfrente){
	var nivelInfo = nivel[0];
	var valida = false;
	if (temEstrela(pPosicao) != -1){//Nova posição é uma estrela
		if (nivelInfo[pPosicaoAfrente[1]][pPosicaoAfrente[0]] != 4){//Posição a frente da nova posição não é uma parede
			valida = true;
		}
	}else if (nivelInfo[pPosicao[1]][pPosicao[0]] != 4){//Nova posição não é uma parede
		valida = true;
	}
	return valida;
}

//Verifica no array estrelas se em pPosicao existe uma estrela retornando -1 se não houver ou o id da estrela
function temEstrela(pPosicao){
	var temEstrela = -1;
	for (var i = 0; i < estrelas.length; i++){
		if ((estrelas[i][0] == pPosicao[0]) && (estrelas[i][1] == pPosicao[1])){
			temEstrela = i;
			break;
		}
	}
	return temEstrela;
}

//Vai no Array "nivel" buscar as informações dos grids do nivel "pNivel" e com estas informações utilizando o método "drawImage" do contexto canvas 2d desenha no canvas do documento toda a parte estática (tudo que não se move) do nível "pNivel" do jogo
function gerarNivel(pNivel){
	var nivelADesenhar = nivel[pNivel];//recupera o nivel a ser desenhado na tela
	var gridId;
	var imgObj;
	contextoCanvas.clearRect(0, 0, 600, 600);//Limpa a area do jogo
	//Percorre as linhas e colunas do nivel especificado desenhando-o na tela
	for (var linha = 0; linha < 20; linha++){//O canvas possui 600x600 pixels logo possuimos 20 grids na horizontal e vertical
		if (nivelADesenhar[linha] != null){//A linha existe neste nivel?
			for (var coluna = 0; coluna < 20; coluna++){//O canvas possui 600x600 pixels logo possuimos 20 grids na horizontal e vertical
				if (nivelADesenhar[linha][coluna] != null){//A coluna existe neste nivel?
					gridId = nivelADesenhar[linha][coluna];//pega o id do grid para uma determinada linha, coluna
					//Estipulo qual objeto Imagem irei usar neste grid
					if (gridId == 4){//Grid de parede
						imgObj = imagens[4];
					}else{//outro grid
						imgObj = imagens[2];
					}					
					contextoCanvas.drawImage(imgObj, coluna * 30, linha * 30);//Desenha o imgObj no canvas
				}
			}
		}
	}
}

//Vai no Array "nivel" buscar as informações dos grids do nivel "pNivel" e com estas informações irá setar as posições iniciais dos elementos dinamicos do jogo
function iniciaElementosDinamicos(pNivel){
	var nivelInfo = nivel[pNivel];//recupera informações do nivel
	var gridId;
	//Percorre as linhas e colunas do nivel especificado desenhando-o na tela
	for (var linha = 0; linha < 20; linha++){//O canvas possui 600x600 pixels logo possuimos 20 grids na horizontal e vertical
		if (nivelInfo[linha] != null){//A linha existe neste nivel?
			for (var coluna = 0; coluna < 20; coluna++){//O canvas possui 600x600 pixels logo possuimos 20 grids na horizontal e vertical
				if (nivelInfo[linha][coluna] != null){//A coluna existe neste nivel?
					gridId = nivelInfo[linha][coluna];//pega o id do grid para uma determinada linha, coluna
					//Salva a posição deste grid em seu respectivo array  					
					if (gridId == 0){//Grid do player
						player[0] = [coluna, linha];
					}else if (gridId == 1){//Grid de estrela
						estrelas[estrelas.length] = [coluna, linha];
					}else if (gridId == 3){//Grid de destino
						destinos[destinos.length] = [coluna, linha];
					}
				}
			}
		}
	}
}

//Verifica a posição de cada um dos elementos dinamicos do jogo guardadas nos Arrays "player", "estrelas" e "destinos" e os desenha em suas respectivas posições.
function desenhaItensDinamicos(){
	//Desenha todas estrelas
	for (var i = 0; i < estrelas.length; i++){	
		contextoCanvas.drawImage(imagens[1], estrelas[i][0] * 30, estrelas[i][1] * 30);//Desenha estrela "i" no canvas
	}
	//Desenha todos destinos
	for (var i = 0; i < destinos.length; i++){
		if (temEstrela(destinos[i]) != -1){//existe alguma estrela neste destino?
			contextoCanvas.drawImage(imagens[5], destinos[i][0] * 30, destinos[i][1] * 30);//Desenha destino finalizado no canvas
		}else{
			contextoCanvas.drawImage(imagens[3], destinos[i][0] * 30, destinos[i][1] * 30);//Desenha destino "i" no canvas
		}
	}					
	contextoCanvas.drawImage(imagens[0], player[0][0] * 30, player[0][1] * 30);//Desenha o player no canvas
}

function jogoTerminou(){
	var terminou = true;
	for (var i = 0; i < destinos.length; i++){
		if (temEstrela(destinos[i]) == -1){//existe um destino sem estrela em cima...
			terminou = false;
			break;
		}
	}
	
	if (terminou){
		alert("Fim de jogo!");
	}
}