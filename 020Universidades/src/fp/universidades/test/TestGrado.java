package fp.universidades.test;

import java.util.HashSet;
import java.util.Set;

import fp.universidades.tipos.Asignatura;
import fp.universidades.tipos.Grado;
import fp.universidades.tipos.TipoAsignatura;

public class TestGrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Asignatura a1 = new Asignatura("Fundamentos de Programacion", "0000230",12.,TipoAsignatura.ANUAL, 1);
		
		Asignatura a2 = new Asignatura("Tecnología de computadores", "0000340",6.,TipoAsignatura.PRIMER_CUATRIMESTRE, 2);
		Asignatura a3 = new Asignatura("Matematicas discretas", "0000310",6.,TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2);
		
		Asignatura a4 = new Asignatura("Administracion de empresas", "0000210",6.,TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
		
		Asignatura a5 = new Asignatura("Arquitectura de computadores", "0000350",6.,TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2);
		Asignatura a6 = new Asignatura("ISSI", "0000300",12.,TipoAsignatura.ANUAL, 2);

		Set<Asignatura> as1 = new HashSet<Asignatura>();
		as1.add(a1);
		as1.add(a2);
		as1.add(a6);
		as1.add(a5);
		Set<Asignatura> as2 = new HashSet<Asignatura>();
		as2.add(a3);
		as2.add(a4);
		Grado g1 = new Grado("Ingeniria informatica - Ingenieria de Computadores",as1,as2,12.);
		System.out.println(g1);
		System.out.println("Minimo creditos optativos " + g1.getMinCreditosOpt());
		System.out.println("Total Creditos " +g1.getTotalCreditos());
		System.out.println("Asignaturas obligatorias: " + g1.getObligatorias());
		System.out.println("Asignatuas optativas : " +g1.getOptativas());
		System.out.println("getAsignaturas: "+ g1.getAsignaturas(1));
		System.out.println("getAsignatura: "+ g1.getAsignatura("0000300"));
		System.out.println(g1.getCreditosPorAsignatura());
		System.out.println(g1.getTotalCreditosPorCurso());
	
	}

}
