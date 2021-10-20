package ar.edu.unlam.pb2.tpCuentaCorriente;

import java.util.Set;

public class Banco {
	
	private Set <Cliente> clientes;
	private Set <Cuenta> cuentas;

	public Banco() {
	}

	public Boolean agregarCliente(Cliente cliente) {
		Boolean fueAgregado = false;
		if(this.clientes.add(cliente)) {
			fueAgregado = true;
		}
		return fueAgregado;
	}

//	private Boolean consultarSiYaFueAgregado(Cliente aVerificar) {
//		Boolean fueAgregado = false;
//		for (int i = 0; i < clientes.length; i++) {
//			if (clientes[i] != null) {
//				if (clientes[i].getDni().equals(aVerificar.getDni())) {
//					fueAgregado = true;
//					break;
//				}
//			}
//		}
//		return fueAgregado;
//	}

	public Boolean agregarCuenta(Cuenta cuenta) {
		Boolean fueAgregada = false;
		if(this.cuentas.add(cuenta)) {
			fueAgregada = true;
		}
		return fueAgregada;
	}


	public Set<Cuenta> buscarCuentasDeUnClientePorDni(Integer dni) {
		// devuelve el array de las cuentas de ese cliente
		Set <Cuenta> cuentasDelClienteBuscado = null;
		for (Cliente c : this.clientes) {
			if(c.getDni().equals(dni)) {
				cuentasDelClienteBuscado = c.getCuentas();
				break;
			}
		}
		return cuentasDelClienteBuscado;
	}

//	public Double consultarSaldoCuenta(Integer cbu) {
//		Double saldoEnLaCuenta = 0.0;
//		// como solo se podia acceder a la cuenta a traves del cliente. primero debi
//		// iterar en la lista
//		// de clientes para en cada una iterar en su lista de cuenta spara comparar el
//		// cbu de la cuenta con el
//		// cbu pasado x parametro
//		for (int i = 0; i < clientes.length; i++) {
//			if (this.clientes[i] != null) {
//				for (int j = 0; j < clientes[i].getCuentas().length; j++) {
//					if (clientes[i].getCuentas()[j] != null) {
//						if (clientes[i].getCuentas()[j].getCbu().equals(cbu)) {
//							saldoEnLaCuenta = clientes[i].getCuentas()[j].getSaldo();
//							break;
//						}
//					}
//				}
//			}
//		}
//		return saldoEnLaCuenta;
//	}

	public Double consultarSaldoCuentaConMapeo(Integer cbu) {
		// accedo al mismo dato pero desde el array de cuentas, ya que ahora cada cuenta
		// posee el dato del
		// Cliente propietario
		Double saldoEnLaCuenta = 0.0;
		for (Cuenta cuenta : this.cuentas) {
			if(cuenta.getCbu().equals(cbu)) {
				saldoEnLaCuenta = cuenta.getSaldo();
				break;
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
