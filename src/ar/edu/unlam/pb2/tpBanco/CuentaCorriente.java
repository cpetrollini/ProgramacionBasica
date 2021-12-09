package ar.edu.unlam.pb2.tpBanco;

public class CuentaCorriente extends Cuenta{

//	La más compleja de las cuentas, ésta permite establecer una cantidad de dinero a 
//	girar en descubierto. Es por ello que cada vez que se desee extraer dinero, no sólo 
//	se considera el que se posee, sino el límite adicional que el banco estará brindando.
//	Por supuesto esto no es gratis, ya que el banco nos cobrará un 5% como comisión 
//	sobre todo el monto en descubierto consumido en la operación.
//	Por ejemplo, si tuviéramos $ 100 en la cuenta, y quisiéramos retirar $ 200 (con un 
//	descubierto de $ 150), podremos hacerlo. Pasaremos a deberle al banco $ 105 en 
//	total: los $ 100 que nos cubrió, más el 5% adicional sobre el descubierto otorgado
	
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
