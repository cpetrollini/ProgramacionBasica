package ar.edu.unlam.pb2.tpCuentaCorriente;

public class CuentaSueldo extends Cuenta{
	
	

	public CuentaSueldo(Integer cbu, Double saldo) {
		super(cbu, saldo);
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
