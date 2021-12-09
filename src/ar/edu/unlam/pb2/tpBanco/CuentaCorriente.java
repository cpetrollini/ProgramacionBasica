package ar.edu.unlam.pb2.tpBanco;

public class CuentaCorriente extends Cuenta{

//	La m�s compleja de las cuentas, �sta permite establecer una cantidad de dinero a 
//	girar en descubierto. Es por ello que cada vez que se desee extraer dinero, no s�lo 
//	se considera el que se posee, sino el l�mite adicional que el banco estar� brindando.
//	Por supuesto esto no es gratis, ya que el banco nos cobrar� un 5% como comisi�n 
//	sobre todo el monto en descubierto consumido en la operaci�n.
//	Por ejemplo, si tuvi�ramos $ 100 en la cuenta, y quisi�ramos retirar $ 200 (con un 
//	descubierto de $ 150), podremos hacerlo. Pasaremos a deberle al banco $ 105 en 
//	total: los $ 100 que nos cubri�, m�s el 5% adicional sobre el descubierto otorgado
	
	private Double descubierto;
	
	public CuentaCorriente(Cliente propietario, Banco banco) {
		super(propietario, banco);
		this.descubierto = 0.0;
		super.setTc(TipoCuenta.Cuenta_Corriente);
	}
	
	

	private Double CalcularAdicional(Double monto) {
		Double adicional = monto*0.05;
		return adicional;
	}
	
	@Override
	public Boolean extraerDinero(Double monto) {
		Boolean extraido = false;
		Double limiteExtraible = this.descubierto + super.getSaldo();
		if(monto!=0 && monto<limiteExtraible) {
			super.setSaldo(super.getSaldo()-monto-this.CalcularAdicional(monto));
			extraido = true;
		}
		return extraido;
	}
	
	
}
