package ar.edu.unlam.pb2.tpBanco;

import java.util.HashSet;
import java.util.Set;

public class Persona {

	private String nombre;
	private Integer dni;
	private Set<Cuenta> cuentas;

	public Persona(String nombre2, Integer dni2) {
		this.setNombre(nombre2);
		this.setDni(dni2);
		this.cuentas = new HashSet<Cuenta>();
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
		return cuentas;
	}

	public void setCuentas(Set<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	

}
