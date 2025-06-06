package fp.universidades.test;

import java.time.LocalDate;

import fp.universidades.tipos.Alumno;
import fp.universidades.tipos.Asignatura;
import fp.universidades.tipos.TipoAsignatura;
import fp.universidades.tipos.TipoConvocatoria;

public class TestAlumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno al1 = new Alumno("45973397P", "Ale", "Martinez", LocalDate.of(2005, 2, 9), "alemargon1@alum.us.es");
		System.out.println(al1);
		Alumno al2 = al1;
		Alumno al3 = new Alumno("45973396P", "Jesis", "Jaen", LocalDate.of(2004, 3, 14), "jjaeper@alum.us.es");
		Alumno al4 = new Alumno("45973397P", "Ale", "Martinez", LocalDate.of(2005, 2, 9), "alemargon1@alum.us.es");

		System.out.println(al1.equals(al2));
		System.out.println(al1.equals(al3));
		System.out.println(al1.equals(al4));

		System.out.println(al1 == al2);
		System.out.println(al1 == al3);
		System.out.println(al1 == al4);
		
		Asignatura a1 = new Asignatura("Fundamentos de Programacion", "0000230",12.,TipoAsignatura.ANUAL, 1);
		Asignatura a2 = new Asignatura("Tecnología de computadores", "0000340",6.,TipoAsignatura.PRIMER_CUATRIMESTRE, 2);
		Asignatura a3 = new Asignatura("Matematicas discretas", "0000310",6.,TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2);
		Asignatura a4 = new Asignatura("Administracion de empresas", "0000210",6.,TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
		//Asignatura a5 = new Asignatura("Arquitectura de computadores", "0000350",6.,TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2);
		//Asignatura a6 = new Asignatura("ISSI", "0000300",12.,TipoAsignatura.ANUAL, 2);
		
		al1.matriculaAsignatura(a1);
		System.out.println(al1.getAsignaturas());
		al1.matriculaAsignatura(a2);
		al1.matriculaAsignatura(a3);
		al1.matriculaAsignatura(a4);
		System.out.println(al1.getAsignaturas());
		al1.evaluaAsignatura(a1, 2011,TipoConvocatoria.PRIMERA, 9.2, false);
		System.out.println(al1.getExpediente());

	}

}
