package ar.edu.unlam.pb2.tpBanco;

import java.util.HashSet;
import java.util.Set;

public class Cliente extends Persona{

	private Boolean vip;
	private Banco banco;
	private Set <Cuenta> cuentas;
	
	public Cliente(String nombre, Integer dni) {
		super(nombre, dni);
		this.cuentas = new HashSet<Cuenta>();
		this.setNombre(nombre);
		this.setDni(dni);
		this.vip = verificarCategoriaVip();
	}

	private Boolean verificarCategoriaVip() {
		
		for (Cuenta cuenta : cuentas) {
			
		}
		return null;
	}

	public Set<Cuenta> getCuentas() {
		return this.cuentas;
	}
	
	public void setCuenta(Cuenta cuentaAgregar) {
		this.cuentas.add(cuentaAgregar);
		super.getCuentas().add(cuentaAgregar);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getDni() == null) ? 0 : getDni().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (getDni() == null) {
			if (other.getDni() != null)
				return false;
		} else if (!getDni().equals(other.getDni()))
			return false;
		return true;
	}

	
	
	
	
}
