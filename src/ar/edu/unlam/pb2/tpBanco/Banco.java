package ar.edu.unlam.pb2.tpBanco;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Banco {

	private Set<Cliente> clientes;
	private Set<Cuenta> cuentas;
	private Double descubiertoCuentaCorriente = 0.0;

	public Banco() {
		this.cuentas = new TreeSet<Cuenta>();
		this.clientes = new HashSet<Cliente>();
	}

	private void agregarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}

	public Boolean consultarSiEsCliente(Cliente aVerificar) {
		return this.clientes.contains(aVerificar);
	}

	public Boolean agregarCuenta(Cuenta cuenta) {
		this.agregarCliente(cuenta.getCliente());
//		cuenta.getCliente().setCuenta(cuenta);
		return this.cuentas.add(cuenta);
	}

	public Set<Cuenta> buscarCuentasDeUnClientePorDni(Integer dni) {
		Set<Cuenta> cuentasDelClienteBuscado = null;
		for (Cliente c : this.clientes) {
			if (c.getDni().equals(dni)) {
				cuentasDelClienteBuscado = c.getCuentas();
				break;
			}
		}
		return cuentasDelClienteBuscado;
	}

	public Cliente buscarUnClientePorDni(Integer dni) {
		Cliente clienteBuscado = null;
		for (Cliente c : this.clientes) {
			if (c.getDni().equals(dni)) {
				clienteBuscado = c;
				break;
			}
		}
		return clienteBuscado;
	}

	/*
	 * public Double consultarSaldoCuenta(Integer cbu) { Double saldoEnLaCuenta =
	 * 0.0; // como solo se podia acceder a la cuenta a traves del cliente. primero
	 * debi // iterar en la lista // de clientes para en cada una iterar en su lista
	 * de cuenta spara comparar el // cbu de la cuenta con el // cbu pasado x
	 * parametro for (int i = 0; i < clientes.length; i++) { if (this.clientes[i] !=
	 * null) { for (int j = 0; j < clientes[i].getCuentas().length; j++) { if
	 * (clientes[i].getCuentas()[j] != null) { if
	 * (clientes[i].getCuentas()[j].getCbu().equals(cbu)) { saldoEnLaCuenta =
	 * clientes[i].getCuentas()[j].getSaldo(); break; } } } } } return
	 * saldoEnLaCuenta; }
	 */

	public Double consultarSaldoCuenta(Integer cbu) { // con mapeo
		Double saldoEnLaCuenta = 0.0;
		for (Cuenta cuenta : this.cuentas) {
			if (cuenta.getCbu().equals(cbu)) {
				saldoEnLaCuenta = cuenta.getSaldo();
				break;
			}
		}
		return saldoEnLaCuenta;
	}

	public Boolean transferir(Double monto, Cuenta queTransfiere, Cuenta queRecibe) {
		Boolean transferido = false;
		if (this.consultarSiTieneSaldoSuficiente(queTransfiere, monto)) {
			if (queTransfiere.extraerDinero(monto)) {
				queRecibe.depositarDinero(monto);
				transferido = true;
			}
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

	public void registrarCliente(String nombre, Integer dni) {
		Cliente nuevo = new Cliente(nombre, dni);
		this.agregarCliente(nuevo);
	}

	public Double getDescubiertoCuentaCorriente() {
		return descubiertoCuentaCorriente;
	}

	public void setDescubiertoCuentaCorriente(Double descubiertoCuentaCorriente) {
		this.descubiertoCuentaCorriente = descubiertoCuentaCorriente;
	}
}
