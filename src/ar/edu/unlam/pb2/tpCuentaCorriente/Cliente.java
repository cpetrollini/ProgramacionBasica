package ar.edu.unlam.pb2.tpCuentaCorriente;

import java.util.Set;

public class Cliente {
	private String nombre;
	private Integer dni;
	private Set <Cuenta> cuentas;
	
	public Cliente(String nombre, Integer dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Set<Cuenta> getCuentas() {
		return this.cuentas;
	}
	
	public void setCuenta(Cuenta cuentaAgregar) {
		this.cuentas.add(cuentaAgregar);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	
	
	
	
}
