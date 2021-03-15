package temp;
public class TestStringBuilder {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("I love java");
		//StringBuilder sb = new StringBuilder("I love java");
		System.out.println("sb.capacity() = "+sb.capacity());
		System.out.println("sb.length() = "+sb.length());
		sb.append(" and Pyton");
		System.out.println(sb);
		System.out.println("sb.charAt(3) = "+sb.charAt(3));
		sb.delete(7, 11);//[7,11)
		System.out.println("sb.delete(7, 11): "+sb);
		sb.deleteCharAt(6);
		System.out.println("sb.delete(6): "+sb);
		sb.insert(7, "C++ ");
		System.out.println("sb.insert(7, \"C++\" ): "+sb);
		sb.replace(7, 10, "Pascal");
		System.out.println("sb.replace(7, 10, \"Pascal\"): "+sb);
		//sb = sb+"hjklk";error
		String s = sb.substring(0, 6);
		System.out.println("sb.substring(0, 6): "+s);
		sb.setCharAt(0, 'H');
		System.out.println("sb.setCharAt(0, 'H'): "+sb);
		sb.setLength(6);
		System.out.println("sb.setLength(6) = "+sb);
		sb.setLength(36);
		System.out.println("sb.setLength(36) = "+sb);
		sb.setCharAt(35, '!');
		System.out.println("sb.setCharAt(35, '!'): "+sb);
		//sb.setCharAt(36, '!');error
		
		sb.reverse();
		System.out.println("sb.reverse(): "+sb);
	
	}

}
