package view;

import controller.ControllerPing;

public class Main {
	
	public static void main(String[] args) {
		ControllerPing google = new ControllerPing("www.google.com.br");
		ControllerPing uol = new ControllerPing("www.uol.com.br");
		ControllerPing terra = new ControllerPing("www.terra.com.br");
		google.start();
		uol.start();
		terra.start();
	}
	
}
