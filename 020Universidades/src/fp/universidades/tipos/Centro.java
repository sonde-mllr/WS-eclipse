package fp.universidades.tipos;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import fp.utiles.Checkers;

public class Centro implements Comparable<Centro>{
	private String nombre;
	private String direccion;
	private Integer plantas;
	private Integer sotanos;
	private Set<Espacio> espacios;
	
	
	
	public Centro(String nombre, String direccion, Integer plantas, Integer sotanos) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		Checkers.check("Un centro debe tener al menos una planta",plantas >= 1);
		this.plantas = plantas;
		Checkers.check("Un centro debe tener 0 o más sotanos",sotanos >=0);
		this.sotanos = sotanos;
		this.espacios = new HashSet<Espacio>();
	}
	public void nuevoEspacio(Espacio e) {
		Integer numPlanta = Integer.valueOf(e.getPlanta().charAt(7));
		if((-sotanos < numPlanta && numPlanta < plantas-1)){
			throw new IllegalArgumentException("La planta del espacio debe estar comprendido en el intervalo de sotanos y plantas del centro");
		} else {
			this.espacios.add(e);
		}
	}
	public void eliminaEspacio(Espacio e) {
		if(espacios.contains(e)) {
			espacios.remove(e);
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public Integer getPlantas() {
		return plantas;
	}
	public Integer getSotanos() {
		return sotanos;
	}
	public Set<Espacio> getEspacios() {
		return espacios;
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
		Centro other = (Centro) obj;
		return Objects.equals(nombre, other.nombre);
	}
	public String toString() {
		return nombre;
	}
	
	public int compareTo(Centro c) {
		Integer r = nombre.compareTo(c.nombre);
		return r;
	}
	
	//TODO
	@SuppressWarnings("null")
	public Integer[] getConteosEspacios() {
		Integer[] res = null;
		for(Espacio e : espacios) {
			switch (e.getEspacio()) {
			case TipoEspacio.TEORIA: {
				res[0]++;
			}
			case TipoEspacio.LABORATORIO:{
				res[1]++;
			}
			case TipoEspacio.SEMINARIO: {
				res[2]++;
			}
			case TipoEspacio.EXAMEN:{
				res[3]++;
			}
			case TipoEspacio.OTRO:{
				res[4]++;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + e.getEspacio());
			}
		}
		return res;
	}
	public Set<Despacho> getDespachos() {
		Set<Despacho> despachos = new HashSet<Despacho>();
		for(Espacio e : espacios) {
			if(e instanceof Despacho){
				despachos.add((Despacho) e);
			}
		}
		return despachos;
	}
	public Set<Despacho> getDespachos(Departamento d){
		Set<Despacho> despachos = new HashSet<Despacho>();
		for(Espacio e : espacios) {
			if(e instanceof Despacho){
				for(Profesor p: ((Despacho) e).getProfesores()) {
					if(d.Profesores().contains(p)) {
						despachos.add((Despacho) e);
					}
				}
			}
		}
		return despachos;
	}
	
	public Set<Profesor> getProfesores(){
		return this.getDespachos().stream().flatMap(x->x.getProfesores().stream()).collect(Collectors.toSet());

	}
	public Set<Profesor> getProfesores(Departamento d){
		return this.getDespachos(d).stream().flatMap(x->x.getProfesores().stream()).collect(Collectors.toSet());
	}
	public Espacio getEspacioMayorCapacidad() {
		return espacios.stream().sorted(Comparator.comparingInt(x->x.getCapacidad())).toList().getLast();
	}
	
	public SortedMap<String,Despacho> getDespachosPorProfesor(){
		SortedMap<String,Despacho> res = new TreeMap<String, Despacho>();
		for (Profesor p : this.getProfesores()) {			
			for (Despacho d: this.getDespachos()) {
				if(d.getProfesores().contains(p)){
					res.put(p.toString(), d);
				}
			}
		}
		return res;
	}
	
}
