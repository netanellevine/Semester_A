package temp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;





public class SimpleTextFile {

	public static void main(String[] args)  {
	
		File f = new File("C:\\FileExamples\\numbers.txt");
		System.out.println(f.getName());
		System.out.println("Exists? " + f.exists());
		System.out.println("Is file? " + f.isFile());
		System.out.println("Is directory? " + f.isDirectory());
		System.out.println("Can read? " + f.canRead());
		System.out.println("Can write? " + f.canWrite());
		System.out.println("Can execute? " + f.canExecute());
		System.out.println("Path: " + f.getPath());
		System.out.println("Parent: " + f.getParentFile().getPath());
		System.out.println("Length: " + f.length());
		
		try {
			saveToFile(f);
			readFromFile(f);
			
			Point2D p1 = new Point2D(-1.0,2.2);
			p1.save("C:\\FileExamples\\Point_p1.txt");
			
			// 1. Using the object's load function
			Point2D p2 = new Point2D();
			p2.load("C:\\FileExamples\\Point_p1.txt");
			System.out.println("p1 == p2? " + p1.equals(p2));
			
			// 2. Using the object's constructor from String
			Scanner myReader = new Scanner(new File("C:\\FileExamples\\Point_p1.txt"));
			Point2D p3 = new Point2D(myReader.nextLine());
			System.out.println("p1 == p3? " + p1.equals(p3));
			myReader.close();
			
			// writing an array of objects
			final int NUM_POINTS = 3;
			Point2D[] arr = new Point2D[NUM_POINTS];
			for(int i=0; i<arr.length ;++i)
				arr[i] = new Point2D(i*1.1,i*2.2);
			
			System.out.println("The points array:");
			for(int i=0; i<arr.length ;++i)
				System.out.println(arr[i]);
			
			FileWriter fw = new FileWriter(new File("C:\\FileExamples\\points.txt"));
			fw.write(arr.length + "\n");
			for(int i=0; i<arr.length ;++i)
				arr[i].save(fw);
			fw.close();
			
			// reading an array of objects
			myReader = new Scanner(new File("C:\\FileExamples\\points.txt"));
			int lenOfArray = myReader.nextInt();
			myReader.nextLine();
			Point2D[] arr2 = new Point2D[lenOfArray];
			for(int i=0; i < lenOfArray ;++i)
				arr2[i] = new Point2D(myReader.nextLine());
			myReader.close();
			
			System.out.println("The points array that I read:");
			for(int i=0; i<arr2.length ;++i)
				System.out.println(arr2[i]);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveToFile(File f) throws IOException {
		
		FileWriter fw = new FileWriter(f);
		fw.write("hi\n");
		for (int i=1 ; i <=3 ; ++i) {
			fw.write(i + " ");
		}
		fw.close();	
	}
	
	public static void readFromFile(File f) throws FileNotFoundException {
	    Scanner myReader = new Scanner(f);
	    int i=0;
	    while (myReader.hasNextLine())
	    {
	        String data = myReader.nextLine();
	        System.out.println(i+") "+data);
	        i=i+1;
	    }
	    myReader.close();		
	}
}
