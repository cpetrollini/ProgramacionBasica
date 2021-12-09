package ar.edu.unlam.pb2.tpBanco;

public class clienteNoExistenteException extends Exception {

	public clienteNoExistenteException() {
		super("El cliente no fue registrado");
	}
	

	
}
