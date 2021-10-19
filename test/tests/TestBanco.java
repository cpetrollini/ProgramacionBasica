package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.pb2.tpCuentaCorriente.Banco;
import ar.edu.unlam.pb2.tpCuentaCorriente.Cliente;
import ar.edu.unlam.pb2.tpCuentaCorriente.Cuenta;
import ar.edu.unlam.pb2.tpCuentaCorriente.CuentaCajaAhorro;
import ar.edu.unlam.pb2.tpCuentaCorriente.CuentaCorriente;
import ar.edu.unlam.pb2.tpCuentaCorriente.CuentaSueldo;

public class TestBanco {

	@Test
	public void queSePuedaConsultarElSaldoDeDistintasCuentas() {
		Banco banco = new Banco();
		Cuenta cuenta;
		Cliente cliente = new Cliente("mario", 42565898);
		Double saldoCuentaCorriente = 20.0;
		Double saldoCajaAhorro = 30.0;
		Double saldoCuentaSueldo = 10.0;
		
		cuenta = new CuentaCorriente(1212, saldoCuentaCorriente, cliente,  150.0);
		banco.agregarCuenta(cuenta);
		cuenta = new CuentaCajaAhorro(1213, saldoCajaAhorro, cliente);
		banco.agregarCuenta(cuenta);
		cuenta = new CuentaSueldo(1214, saldoCuentaSueldo, cliente);
		banco.agregarCuenta(cuenta);
		
		Double saldoEncontradoCA = banco.consultarSaldoCuentaConMapeo(1213);
		banco.consultarSaldoCuentaConMapeo(1214);
		Double saldoEncontradoCC = banco.consultarSaldoCuentaConMapeo(1212);
		assertEquals(saldoCuentaCorriente,saldoEncontradoCC);
		assertEquals(saldoCajaAhorro, saldoEncontradoCA);
		assertEquals(saldoCuentaSueldo, banco.consultarSaldoCuentaConMapeo(1214));
	}

	@Test 
	public void queSeAgregueUnaCuenta(){
		Banco banco = new Banco();
		Cliente cliente = new Cliente("mario", 42565898);
		Cuenta cuenta = new CuentaCorriente(1212, 20.0,cliente, 150.0);
		assertTrue(banco.agregarCuenta(cuenta));
	}
	
	@Test
	public void queSeTranfieraDeUnaCuentaAOtra() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("mario", 42565898);
		Cuenta cuenta1 = new CuentaCorriente(1213, 20.0,cliente, 150.0);
		Cuenta cuenta = new CuentaCorriente(1212, 20.0,cliente, 150.0);
		Double monto = 150.0;
		banco.transferir(monto, cuenta1, cuenta);
		
		
		
	}
}
