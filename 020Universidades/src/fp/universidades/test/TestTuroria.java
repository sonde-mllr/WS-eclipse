package fp.universidades.test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

import fp.universidades.tipos.Tutoria;

public class TestTuroria {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tutoria tut = new Tutoria(DayOfWeek.MONDAY,LocalTime.of(10, 30),Duration.ofMinutes(120));
		//Tutoria tut1 = new Tutoria(DayOfWeek.THURSDAY,LocalTime.of(10, 30),LocalTime.of(10,45));
		System.out.println(tut);
		System.out.println(tut.getDuracion());

	}

}
