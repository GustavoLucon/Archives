package IP;

public class ip {

	public String IP;
	public String nome;
	public int altura;
	public boolean trace; // Ver se é trace ou ping
	public String resultado;

	public ip(String IP, String nome, String Trace) {
		this.setIP(IP);
		this.setNome(nome);
		if (Trace.equals("T") || Trace.equals("t")) {
			this.trace = true;
		} else {
			this.trace = false;
		}

	}

	public boolean isTrace() {
		return trace;
	}

	public void setTrace(boolean trace) {
		this.trace = trace;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
