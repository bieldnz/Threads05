package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ControllerPing extends Thread {

	String servidor;

	public ControllerPing(String servidor) {
		this.servidor = servidor;
	}

	@Override
	public void run() {
		if(System.getProperty("os.name").contains("Linux")) {
			String nomeServer = servidor.substring(4, servidor.length()-7).toUpperCase();
			String tempoMedio = "";
			String proc = "ping -4 -c 10 "+servidor;
			String[] exec = proc.split(" ");
			try {
				Process p = Runtime.getRuntime().exec(exec);
				InputStream inputStream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(inputStream);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				while(linha != null) {
					tempoMedio = linha;
					System.out.println(nomeServer+": "+linha);
					linha = buffer.readLine();
				}
				long tempo = 10000;
				sleep(tempo);
				tempoMedio = tempoMedio.substring(40, tempoMedio.length());
				System.out.println(nomeServer+" "+tempoMedio);
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

}
