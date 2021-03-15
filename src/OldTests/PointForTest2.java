package OldTests;

/*****************************************************************
*  @author Eyal Levi
*  קורס מבו�? לחישוב - �?וניברסיטת �?רי�?ל
*  https://github.com/LeviEyal
******************************************************************/

public final class PointForTest2 {
    // ******** private data members ********
    private double _x, _y;  // we "mark" data members of the classusing.

    // ********* constructors ********
    // initilizesthe point according to its coordinates: (x1,y1)
    public PointForTest2 (double x1, double y1){
        _x = x1;
        _y = y1;
    }

    // initializesthe point -origin (0,0)
    public PointForTest2 (){
        _x = 0;
        _y = 0;
    }

    //copy constructor
    public PointForTest2 (PointForTest2 p){
        _x = p._x;
        _y = p._y;
    }

    // ********** public methodes*********
    // returns the first coordinate of the point
    public double x() {
        return _x;
    }

    // returns the second coordinate of the point
    public double y() {
        return _y;
    }

    /** @return the distance between two points
     * @param p - other Point.
     */
    public double distance (PointForTest2 p)  {
        double temp = (p.x()-_x)*(p.x()-_x)+(p.y()-_y)*(p.y()-_y);
        return Math.sqrt(temp);
    }

    /** @return a String contains the Point data
    */
    public String toString()  {
        String s = " (" + _x + "," + _y+")";
        return s;
    }

    /** logical equals: 
     * @param p other Point.
     * @return true if p logicly the same)
     */
    public boolean equals (PointForTest2 p) {
        boolean ans = false;
        if((p!=null) && (p.x()==_x) && (p.y()==_y)){
            ans = true;
        }
        return ans;
    }
}
