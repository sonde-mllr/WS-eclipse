package fp.universidades.tipos;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import fp.utiles.Checkers;

public class Alumno extends Persona{
	private Set<Asignatura> asignaturas;
	//TODO
	// Curso del alumno: propiedad derivada de la asignatura de curso mayor o 0 si no está matriculado
	private Expediente expediente;
	
	public Alumno(String dNI, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
		super(dNI, nombre, apellidos, fechaNacimiento,
				email);
		this.asignaturas = new HashSet<Asignatura>();
		this.expediente = new Expediente();
		Checkers.check("El email no puede ser una cadena vacía y debe acabar en @alum.us.es",email.length() > 0 && email.endsWith("@alum.us.es"));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(asignaturas);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(getDNI(), other.getDNI()) && Objects.equals(getApellidos(),other.getApellidos()) && Objects.equals(getNombre(), other.getNombre());
	}
	
	//TODO no se si es correcto
	public int compareTo(Alumno o) {
		return super.compareTo(o);
	}
	
	//TODO
	public Integer getCurso() {
		return this.getAsignaturas().stream().map(x->x.curso()).max(Comparator.naturalOrder()).orElseThrow(() -> new NoSuchElementException("No hay cursos"));
	}
	
	public String toString() {
		return "(?º) " + super.toString(); 
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public Expediente getExpediente() {
		return expediente;
	}
	// Se podría hacer estaMatriculadoEn para que este metodo lance la exception siempre que no esté matriculado
	// Y solo tener que añadir el metodo una vez
	public void matriculaAsignatura(Asignatura a) {
		if(!(asignaturas.contains(a))) {
			asignaturas.add(a);
		} else {
			throw new IllegalArgumentException("El alumno ya está matriculado en esa asignatura");
		}
	}
	
	public void eliminaAsignatura(Asignatura a) {
		if(!(asignaturas.contains(a))) {
			throw new IllegalArgumentException("El alumno no está matriculado en esa asignatura");
		} else {
			asignaturas.remove(a);
		}
	}
	
	public Boolean estaMatriculadoEn(Asignatura a) {
		return asignaturas.contains(a);
	}
	
	public void evaluaAsignatura(Asignatura a,Integer curso,TipoConvocatoria convocatoria,Double notaValor,Boolean honor) {
		if(!estaMatriculadoEn(a)){
			throw new IllegalArgumentException("El alumno no esta matriculado en la aignatura");
		} else {
			expediente.nuevaNota(new Nota(a,curso,convocatoria,notaValor,honor));
		}
	}
	
	public SortedMap<Asignatura,TipoNota> getCalificacionPorAsignatura(){
		Map<Asignatura,TipoNota> res = this.getExpediente().getNotas().stream().collect(Collectors.toMap(x->x.Asignatura(), x->x.getCalificacion()));
		return new TreeMap<Asignatura,TipoNota>(res);
	}
	
	public Map<Integer,Integer> getNumAsignaturasPorCurso(){
		return this.getAsignaturas().stream().collect(Collectors.groupingBy(x->x.curso(),Collectors.collectingAndThen(Collectors.counting(),Long::intValue)));
	}
	
	
}
