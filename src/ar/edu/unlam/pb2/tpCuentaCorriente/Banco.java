package ar.edu.unlam.pb2.tpCuentaCorriente;

public class Banco {
	private Cliente[] clientes;
	private Cuenta[] cuentas;

	public Banco() {
		this.clientes = new Cliente[100];
		this.cuentas = new Cuenta[300];
	}

	public Boolean agregarCliente(Cliente cliente) {
		Boolean fueAgregado = false;
		if (this.consultarSiYaFueAgregado(cliente)) {
			for (int i = 0; i < clientes.length; i++) {
				if (clientes[i] == null) {
					clientes[i] = cliente;
					fueAgregado = true;
					break;
				}
			}
		}
		return fueAgregado;
	}

	private Boolean consultarSiYaFueAgregado(Cliente aVerificar) {
		Boolean fueAgregado = false;
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] != null) {
				if (clientes[i].getDni().equals(aVerificar.getDni())) {
					fueAgregado = true;
					break;
				}
			}
		}
		return fueAgregado;
	}

	public Boolean agregarCuenta(Cuenta cuenta) {
		Boolean fueAgregada = false;
		if (!this.consultarSiYaFueAgregada(cuenta)) {
			for (int i = 0; i < cuentas.length; i++) {
				if (cuentas[i] == null) {
					cuentas[i] = cuenta;
					fueAgregada = true;
					break;
				}
			}
		}
		return fueAgregada;
	}

	private Boolean consultarSiYaFueAgregada(Cuenta cuenta) {
		Boolean encontrada = false;
		for (int i = 0; i < cuentas.length; i++) {
			if (cuentas[i] != null) {
				if (cuentas[i].getCbu().equals(cuenta.getCbu())) {
					encontrada = true;
					break;
				}
			}
		}
		return encontrada;
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
		// como solo se podia acceder a la cuenta a traves del cliente. primero debi
		// iterar en la lista
		// de clientes para en cada una iterar en su lista de cuenta spara comparar el
		// cbu de la cuenta con el
		// cbu pasado x parametro
		for (int i = 0; i < clientes.length; i++) {
			if (this.clientes[i] != null) {
				for (int j = 0; j < clientes[i].getCuentas().length; j++) {
					if (clientes[i].getCuentas()[j] != null) {
						if (clientes[i].getCuentas()[j].getCbu().equals(cbu)) {
							saldoEnLaCuenta = clientes[i].getCuentas()[j].getSaldo();
							break;
						}
					}
				}
			}
		}
		return saldoEnLaCuenta;
	}

	public Double consultarSaldoCuentaConMapeo(Integer cbu) {
		// accedo al mismo dato pero desde el array de cuentas, ya que ahora cada cuenta
		// posee el dato del
		// Cliente propietario
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
	
	public Boolean transferir(Double monto, Cuenta queTransfiere, Cuenta queRecibe) {
		Boolean transferido = false;
		if (this.consultarSiTieneSaldoSuficiente(queTransfiere, monto)) {
			queTransfiere.extraerDinero(monto);
			queRecibe.depositarDinero(monto);
			transferido = true;
		}
		return transferido;
	}
	
	private Boolean consultarSiTieneSaldoSuficiente(Cuenta aConsultar, Double monto) {
		Boolean disponible = false;
		if (aConsultar.getSaldo() >= monto) {
			disponible = true;
		}
		return disponible;
	}
}
