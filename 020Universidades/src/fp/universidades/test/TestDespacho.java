package fp.universidades.test;

import java.time.LocalDate;
import java.util.Set;

import fp.universidades.tipos.Despacho;
import fp.universidades.tipos.Profesor;
import fp.universidades.tipos.TipoCategoria;

public class TestDespacho {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Profesor p1 = new Profesor("45973397P", "ale", "martinez",LocalDate.of(2005, 2, 9), "c8534312@gmail.com", TipoCategoria.TITULAR);
		Profesor p2 = new Profesor("12384128S", "jesus", "jaén",LocalDate.of(2004, 4, 13), "jjaeper@gmail.com", TipoCategoria.TITULAR);
		Profesor p3 = new Profesor("12312387D", "olivia", "bautista",LocalDate.of(2005, 3, 2), "obaubau@gmail.com", TipoCategoria.TITULAR);
		Despacho d1 = new Despacho("Despacho1", 3, Set.of(p1,p2,p3));
		System.out.println(d1);
		System.out.println(d1.getCapacidad());
		System.out.println(d1.getProfesores());
		Despacho d2 = new Despacho("F1.43,1,3");
		System.out.println(d2);
		System.out.println(d2.getCapacidad());
	}

}
