package fp.universidades.tipos;

import java.util.Objects;

import fp.utiles.Checkers;

public class Espacio implements Comparable<Espacio>{
	private TipoEspacio espacio;
	private String nombre;
	private Integer capacidad;
	
	public Espacio(TipoEspacio espacio, String nombre, Integer capacidad) {
		super();
		this.espacio = espacio;
		this.nombre = nombre;
		Checkers.check("La capacidad debe ser mayor a 0",capacidad > 0);
		this.capacidad = capacidad;
	}
	
	public Espacio(String s) {
		String[] s1 = s.split(",");
		
		nombre = s1[0].strip();
		// La planta la puse como una propiedad derivada del nombre
		this.capacidad = Integer.valueOf(s1[2].strip());
		this.espacio = TipoEspacio.valueOf(s1[3].strip());
	}
	
	public TipoEspacio getEspacio() {
		return espacio;
	}

	public void setEspacio(TipoEspacio espacio) {
		this.espacio = espacio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getPlanta() {
		return "Planta " + getNombre().charAt(1);
	}
	
	public Integer getPlantaINT() {
		return Integer.valueOf(getNombre().charAt(1));
	}
	public String toString() {
		return nombre + " "+ getPlanta();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Espacio other = (Espacio) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(getPlanta(), other.getPlanta());
	}
	public int compareTo(Espacio o) {
		int r = getPlanta().compareTo(o.getPlanta());
		if(r==0) {
			r = getNombre().compareTo(o.getNombre());
		}
		return r;
	}
	
}
