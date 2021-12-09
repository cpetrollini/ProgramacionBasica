package ar.edu.unlam.pb2.tpBanco;

public class CuentaSueldo extends Cuenta{

	public CuentaSueldo(Cliente propietario, Banco banco) {
		super(propietario, banco);
		super.setTc(TipoCuenta.Cuenta_Sueldo);
	}

	@Override
	public Boolean extraerDinero(Double monto) {
		Boolean extraido = false;
		if (monto<=this.getSaldo() && monto>0) {
			this.setSaldo(getSaldo()-monto);
			extraido = true;
		}
		return extraido;
	}

	
}
