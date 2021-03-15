package Ex4;


	// Netanel Levine.
	// ID: 312512619. 
public class Ex4_Main {

	public static void main(String[] args) {
		Ex4 win = new Ex4();
		GUI_Shape_Collection sc = win.getShape_Collection();
		sc.load(args[0]);
		int sortNum = Integer.parseInt(args[1]);
		Shape_Comp comp = new Shape_Comp(sortNum);
		sc.sort(comp);
		System.out.println("**** Sorting according to flag="+sortNum+" ****");
		System.out.println(sc);
		System.out.println();
		win.show();
	}

}
