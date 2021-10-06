package ar.edu.unlam.pb2.tpCuentaCorriente;

public class Banco {
	private Cliente[] clientes;
	private Cuenta[] cuentas;

	public Banco() {
		this.clientes = new Cliente[100];
		this.cuentas = new Cuenta[300];
	}

	public Boolean agregarCliente(Cliente cliente) {
		return true;
	}

	public Boolean agregarCuenta(Cuenta cuenta) {
		return true;
	}

	public Cuenta[] buscarCuentaDeUnClientePorDni(Integer dni) {
		// devuelve el array de las cuentas de ese cliente
		Cuenta[] cuentasDelClienteBuscado = new Cuenta[10];

		for (int i = 0; i < this.clientes.length; i++) {
			if (this.clientes[i] != null) {
				if (this.clientes[i].getDni().equals(dni)) {
					cuentasDelClienteBuscado = this.clientes[i].getCuentas();
					break;
				}
			}
		}
		return cuentasDelClienteBuscado;
	}
	
	public Double consultarSaldoCuenta(Integer cbu) {
		Double saldoEnLaCuenta = 0.0;
		//como solo se podia acceder a la cuenta a traves del cliente. primero debi iterar en la lista
		//de clientes para en cada una iterar en su lista de cuenta spara comparar el cbu de la cuenta con el
		//cbu pasado x parametro
		for (int i = 0; i < clientes.length; i++) {
			if(this.clientes[i] != null) {
				for (int j = 0; j < clientes[i].getCuentas().length; j++) {
					if(clientes[i].getCuentas()[j] != null) {
						if(clientes[i].getCuentas()[j].getCbu().equals(cbu)) {
							saldoEnLaCuenta=clientes[i].getCuentas()[j].getSaldo();
							break;
						}
					}
				}
			}
		}
		return saldoEnLaCuenta;
	}
	
	public Double consultarSaldoCuentaConMapeo(Integer cbu) {
		//accedo al mismo dato pero desde el array de cuentas, ya que ahora cada cuenta posee el dato del 
		//Cliente propietario
		Double saldoEnLaCuenta = 0.0;
		for (int i = 0; i < cuentas.length; i++) {
			if (this.cuentas[i] != null) {
				if (this.cuentas[i].getCbu().equals(cbu)) {
					saldoEnLaCuenta = this.cuentas[i].getSaldo();
					break;
				}
			}
		}
		return saldoEnLaCuenta;
	}
}
