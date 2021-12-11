package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.pb2.tpBanco.Banco;
import ar.edu.unlam.pb2.tpBanco.Cliente;
import ar.edu.unlam.pb2.tpBanco.Cuenta;
import ar.edu.unlam.pb2.tpBanco.CuentaCajaAhorro;
import ar.edu.unlam.pb2.tpBanco.CuentaCorriente;
import ar.edu.unlam.pb2.tpBanco.CuentaSueldo;
import ar.edu.unlam.pb2.tpBanco.TipoCuenta;

public class TestBanco {

	@Test
	public void queSePuedaConsultarElSaldoDeDistintasCuentas() {
		Banco banco = new Banco();
		Cuenta cuenta;
		Cliente cliente = new Cliente("mario", 42565898);
		Double saldoCuentaCorriente = 20.0;
		Double saldoCajaAhorro = 30.0;
		Double saldoCuentaSueldo = 10.0;

		cuenta = new CuentaCorriente(cliente, banco); // cbu = 1
		banco.agregarCuenta(cuenta);
		cuenta.depositarDinero(saldoCuentaCorriente);

		cuenta = new CuentaCajaAhorro(cliente, banco); // cbu = 2
		banco.agregarCuenta(cuenta);
		cuenta.depositarDinero(saldoCajaAhorro);

		cuenta = new CuentaSueldo(cliente, banco); // cbu = 3
		cuenta.depositarDinero(saldoCuentaSueldo);
		banco.agregarCuenta(cuenta);

		Double saldoEncontradoCC = banco.consultarSaldoCuenta(1);
		assertEquals(saldoCuentaCorriente, saldoEncontradoCC);
		Double saldoEncontradoCA = banco.consultarSaldoCuenta(2);
		assertEquals(saldoCajaAhorro, saldoEncontradoCA);
		Double saldoEncontradoCS = banco.consultarSaldoCuenta(3);
		assertEquals(saldoCuentaSueldo, saldoEncontradoCS);
	}

	@Test
	public void queSeRegistreUnNuevoClienteYBuscarloPorDni() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("Martin", 42595790);
		banco.registrarCliente("Martin", 42595790);
		assertEquals(cliente, banco.buscarUnClientePorDni(42595790));
	}

	@Test
	public void queSeAgregueUnaCuenta() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("mario", 42565898);
		Cuenta cuenta = new CuentaCorriente(cliente, banco);
		assertTrue(banco.agregarCuenta(cuenta));
	}

	@Test
	public void queSeTranfieraDeUnaCuentaAOtra() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("mario", 42565898);

		Cuenta cuenta1 = new CuentaCorriente(cliente, banco);
		cuenta1.depositarDinero(170.0);

		Cuenta cuenta = new CuentaCorriente(cliente, banco);
		cuenta.depositarDinero(20.0);

		Double monto = 150.0;
		assertTrue(banco.transferir(monto, cuenta1, cuenta));
	}
	
	@Test
	public void crearCuentaAUnCliente() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("mario", 42565898);
		banco.registrarCliente(cliente.getNombre(), cliente.getDni());
		assertTrue(banco.crearCuentaAUnCliente(cliente.getDni(), TipoCuenta.Caja_Ahorro));	
	}
	
	@Test
	public void queNoSeCreeUnaCuentaAUnClienteNoRegistrado() {
		
	}
//	@Test
//	public void queSeAsigneCategoriaVip(){
//		Banco banco = new Banco();
//		Integer dni = 42565898;
//		Cliente cliente = new Cliente("mario", dni );
//		
//		Cuenta cuenta1 = new CuentaCorriente(cliente, banco);
//		cuenta1.depositarDinero(5500000.0);
//
//		Cuenta cuenta2 = new CuentaCorriente(cliente, banco);
//		cuenta.depositarDinero(4500000.0);
//		
//		banco.
		

	
	
}
