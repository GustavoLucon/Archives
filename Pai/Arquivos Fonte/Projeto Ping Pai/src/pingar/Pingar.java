package pingar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import IP.ip;

public class Pingar {

	public static ip[] ListaDeIps;
	public static String ArquivoDeTexto = "IP.txt";
	public static boolean barulho = false;
	public static boolean fazerBarulho;
	public static boolean ErroDePing;
	public static String Texto;

	public String getTexto() {
		return Texto;
	}

	public boolean getErroDePing() {
		return ErroDePing;
	}
		
	public boolean getfazerBarulho() {
		return fazerBarulho;
	}

	private static void CriarLista(boolean ligarBarulho) {
		// Construtor da classe pingar
		Pingar.ErroDePing = false;
		Pingar.fazerBarulho = false;
		Pingar.barulho = ligarBarulho;
		int quantidadeDeIps = LerNumeroDeLinhas();
		ListaDeIps = new ip[quantidadeDeIps];
		ListaDeIps = LerArquivo(quantidadeDeIps);
	}

	private static String Horas() {
		//verificar que horas são
		String data = "dd/MM/yyyy";
		String hora = "h:mm - a";
		String data1, hora1;

		java.util.Date agora = new java.util.Date();
		;
		SimpleDateFormat formata = new SimpleDateFormat(data);
		data1 = formata.format(agora);
		formata = new SimpleDateFormat(hora);
		hora1 = formata.format(agora);
		return data1 + "  " + hora1 + "\r\n";

	}

	private static ip[] LerArquivo(int quantidadeDeIps) {
		// ler arquivo texto

		ip[] ListaTemporaria = new ip[quantidadeDeIps];
		int contador = 0;

		try {
			FileReader arq = new FileReader(ArquivoDeTexto);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while (linha != null) {
				// limpar conteudo da linha , dividindo ip e nome

				String[] listalinha = linha.split(";");
				ListaTemporaria[contador] = new ip(listalinha[0],
						listalinha[1], listalinha[2]);

				contador++;

				linha = lerArq.readLine(); // lê da segunda até a última linha
			}
			arq.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Erro na Leitura do arquivo: \n" + e.getMessage());
		}
		return ListaTemporaria;
	}

	private static int LerNumeroDeLinhas() {
		// Verifica o numero de linhas totais para criar a lista de endereços
		int ContadorDeLinhas = 0;

		try {
			FileReader arq = new FileReader(ArquivoDeTexto);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while (linha != null) {
				linha = lerArq.readLine(); // lê da segunda até a última linha
				ContadorDeLinhas++;
			}
			arq.close();
		} catch (IOException e) {

			JOptionPane.showMessageDialog(null,
					"Erro na abertura do arquivo: \n" + e.getMessage());
		}
		System.out.println();

		return ContadorDeLinhas;
	}

	public Pingar(boolean ligarBarulho) {
		// Metodo de ativação do ping;
		CriarLista(ligarBarulho);
		PingarIp();
		MostrarResultado();

	}

	private static void MostrarResultado() {
		// Armazena na variavel texto o resultado da operação

		Texto = "Ping Realizado as " + Horas() + "\n";

		for (int i = 0; i < ListaDeIps.length; i++) {
			Texto = Texto + "IP: " + ListaDeIps[i].getIP() + " ||Nome: "
					+ ListaDeIps[i].getNome() + "\n     Resultado: "
					+ ListaDeIps[i].getResultado();
			if (ListaDeIps.length > (i - 1)) {
				Texto = Texto + "\n";
			}
		}
	}

	public static void PingarIp() {
		//Pingar o ip selecionado
		
		
		String inputLine;

		for (int i = 0; i < ListaDeIps.length; i++) {
			
			//setup dos comandos
			boolean resultado = false;
			String ip = ListaDeIps[i].getIP();
			String pingCmd = "ping " + ip + " -n 2";
			String pingTrace = "tracert " + ip;
			String pingResult = "";

			//fim dop setup
			
			try {
				//gerar o commando 
				Runtime r = Runtime.getRuntime();
				Process p;

				if (ListaDeIps[i].isTrace()) {
					//fazer caso for tracert
					p = r.exec(pingTrace);
				} else {
					//fazer caso for ping
					p = r.exec(pingCmd);
				}

				BufferedReader in = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				while ((inputLine = in.readLine()) != null) {
					pingResult += inputLine + "\n";
					//receber resultado e guarda-lo
					if (resultado == false) {
						if (inputLine
								.contains("Esgotado o tempo limite do pedido.")
								|| inputLine.contains("Request timed out")) {
							if (barulho != false) {
								Pingar.fazerBarulho = true;
							}
							Pingar.ErroDePing = true;
							ListaDeIps[i]
									.setResultado("Esgotado o tempo limite do pedido.");
							resultado = true;
						} else if (inputLine
								.contains("Host de destino inacessivel.")
								|| inputLine
										.contains("Destination host unreachable")) {
							if (barulho != false) {
								Pingar.fazerBarulho = true;
							}
							Pingar.ErroDePing = true;	
							ListaDeIps[i]
									.setResultado("Host de destino inacessivel.");
							resultado = true;
						} else if (inputLine.contains("bytes=32")) {
							if (barulho != false) {
								Pingar.ErroDePing = true;
							}

							ListaDeIps[i].setResultado(inputLine);
							resultado = true;
						}
					}
					if (ListaDeIps[i].isTrace()) {
						ListaDeIps[i].setResultado(pingResult);
					}
				}

				in.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"Erro no Ping: \n" + e.getMessage());
			}
		}

	}
}
