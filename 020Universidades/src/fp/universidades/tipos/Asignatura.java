package fp.universidades.tipos;

import java.util.Objects;

import fp.utiles.Checkers;

public record Asignatura(String Nombre,String Codigo,Double Creditos,TipoAsignatura Tipo,Integer curso)implements Comparable<Asignatura>{
	public Asignatura{
		Checkers.check("El código debe tener 7 dígitos", Codigo.length() == 7);
	}
	public String toString() {
		return "("+Codigo+")" + Nombre;		
	}
	@Override
	public int hashCode() {
		return Objects.hash(Codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return Objects.equals(Codigo, other.Codigo);
	}
	public int compareTo(Asignatura o) {
		int r = Codigo.compareTo(o.Codigo);
		return r;
	}
	
	public String getAcronimo() {
		String res = "";
		for(int i = 0; i< this.Nombre().length() ; i++) {
			Character caracter = this.Nombre().charAt(i);
			if(Character.isUpperCase(caracter)) {
				res += caracter;
			}
		}
		return res;
	}
}
