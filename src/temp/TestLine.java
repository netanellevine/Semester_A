package temp;
public class TestLine {

	public static void main(String[] args) {
		Line l = new Line(86,15);
		Station s = new Station("Peth-Tiqwa","Hanna Rovina");
		l.addStation(s);
		s.setStreetName("Menachem Begin");
		l.addStation(s);
		if(!l.addStation(s))
			l.addStation(new Station("Ariel","University"));
		System.out.println(l);
	}

}
