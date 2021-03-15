package OldTests;

public class PointForTest1 {
	/**
	 * this class represent a 2d point in the plane. <br>
	 */
	    // ******** private data members ********
	        private double _x, _y;  // we "mark" data members of the classusing.
	     
	    // ********* constructors ********
	        // initilizes the point according to its coordinates: (x1,y1)
	        public PointForTest1 (double x1, double y1){
	                  _x = x1;
	                  _y = y1;
	        }
	    // initializes the point - origin (0,0)
	        public PointForTest1 (){
	                  _x = 0;
	                  _y = 0;
	        }
	    //copy constructor
	        public PointForTest1 (PointForTest1 p){
	                  _x = p._x;
	                  _y = p._y;
	        }
	    
	       // ********** public methodes *********
	       // returns the first coordinate of the point
	       public double x() {return _x;}
	       // returns the second coordinate of the point
	       public double y() {return _y;}
	    
	       /** @return the distance between two points
	           @parameter  p - other Point.*/
	       public double distance (PointForTest1 p)  {
	              double temp = (p.x()-_x)*(p.x()-_x)+(p.y()-_y)*(p.y()-_y);
	              return Math.sqrt (temp);
	       }
	           
	       /** @return a String contains the Point data*/
	       public String toString()  {
	          String s = " (" + _x + "," + _y+")";
	          return s;
	       }
	       
	       public boolean equals(PointForTest1 p) {
	           if(this._x==p._x   && this._y ==p._y)
	               return true;
	           else
	               return false;
	       }
	       
	       
	       public static void Psort(PointForTest1[] p) {
	    	   for(int i=p.length-1;i>0;i--) {
	    		   for(int j=0;j<i;j++) {
	    			   if(distFrom00(p[j])>distFrom00(p[j+1])) {
	    				   swap(p,j,j+1);
	    			   }
	    		   }
	    	   }
	       }
	       
	       public static double distFrom00(PointForTest1 p) {
	    	   double dist =Math.sqrt((p.x()*p.x())+(p.y()*p.y()));
//	    	   System.out.println(p.toString()+dist );
	    	   return dist;
	       }
	       
	       private static void swap(PointForTest1[] p, int i,int j) {
	    	   PointForTest1 temp=new PointForTest1(p[i]);
	    	   p[i]=new PointForTest1(p[j]);
	    	   p[j]=new PointForTest1(temp);
	       }
	   

	
	
	
	
}


