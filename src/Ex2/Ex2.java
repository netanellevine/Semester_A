package Ex2;

import java.util.Objects;

		// Netanel Levine
		// ID: 312512619

/* In this Class I used GeoGabra.org, he.symbolab.com and Wikipedia(Bisection  Method).
 * In addition I learned some about the Objects.equals to compare two strings and used it.
 */

public class Ex2 {

	/*
	 *  This function receives an array and converts the values of the array to a string of a polynom.
	 * The polynomial is organized  by the location of each value from the array stack,
	 * and returns the string that represents the polynomial.  
	 * */
	public static String poly(double[] poly) {
		int l=poly.length-1;
		String strPoly="";
		if(poly.length==1) {strPoly += poly[0]; return strPoly;}
		if (poly[l]!=0) {strPoly += poly[l]+"x^"+(l)+" ";}
		for (int i = l-1; i>0; i--) {
			if (poly[i]!=0) { 
				if (i!=1.0) {strPoly+= poly[i]>0 ?"+"+ poly[i]+"x^"+i+" ":poly[i]+"x^"+i+" ";}
				else {strPoly+= poly[1]>0 ?"+"+ poly[1]+"x ":poly[1]+"x ";}
			}
		}
		if (poly[0]!=0) {strPoly+= poly[0]>0 ?"+"+ poly[0]:poly[0];}
		if (strPoly=="") {strPoly+="0.0";}
		if (strPoly.startsWith("+")) { return strPoly.substring(1);	}
		else { return strPoly;}
	}


	/* 
	 * This function receives  an array and a double number (X).
	 * Then it places the value of the X in every value of the array (considering the location of every one of the values), and calculates 
	 * The value of a double number (Y) by summing all the numbers of the array after it adds  the X.
	 * At the end the function return the value of the Y that exist  with this individual X.
	 */
	public static double f(double[] poly, double x) {
		double f=0;
		for (int i = 0; i < poly.length; i++) {
			f+=poly[i]*(Math.pow(x, i));
		}
		return (Math.round((f)*10000)/10000.0);
	}


	/*
	 *  This function receives  two arrays and return a new array in the length of the bigger one of this two.
	 * In the new array it adds the two arrays into one(considering the location of every one of the values),
	 *  and returns the new array.
	 */
	public static double[] add(double[] p1, double[] p2) {
		double add[];
		double addIsZero[]= {0};
		int j=0;
		if (p1.length>p2.length) {
			add= new double[p1.length];
			j=p2.length;
			for (int k=p2.length; k<add.length ; k++) {
				add[k]= p1[k];
			}
		}
		else {
			add= new double[p2.length];
			j=p1.length;
			for (int k=p1.length; k<add.length ; k++) {
				add[k]= p2[k];
			}
		}
		for (int i=0; i<j; i++) {
			add[i]= Math.round((p1[i] + p2[i])*10000)/ 10000.0;
		}
		if (Objects.equals(poly(add),"0.0")) {return addIsZero;}
		else {return add;}
	}


	/* This function receives an array that represent a polynomial  and 
	 * return a new array of the derivative of this array.
	 * The length of the new array will be the length of the incoming array minus 1, 
	 * because derivative always will be shorter in one num from the original function.
	 * In addition every coefficient of the X will remain (with some changes) but there always will 
	 * be one number without X, even if there is not any number written ,this function considers it as zero.
	 */
	public static double[] derivative (double[] po) {
		double[] derivativeIsZero= {0};
		if (po.length==1) {return derivativeIsZero;}
		double[] derivative= new double [po.length-1];
		int j=1;
		for (int i = 0; i < po.length-1; i++) {
			derivative [i] = Math.round((j) * (po [j])*10000)/ 10000.0;
			j++;
		}
		if (Objects.equals(poly(derivative),"0.0")) {return derivativeIsZero;}
		else {return derivative;}
	}


	/* This function receives two arrays and multiple the two of them.
	 * And puts the result in a new array , the length of the new array will be the sum of the two arrays minus one.
	 * This function multiple each number from the first array to all  the numbers from 
	 * the second array doing it for the two arrays,
	 * (considering the location of every one of the values) ,it returns the new array.
	 */
	public static double[] mul(double[] p1, double[] p2) {
		int length =(p1.length)+(p2.length)-1;
		double [] mul  = new double [length];
		double [] mullIsZero = {0};
		int k=0;
		for (int i = 0; i < p1.length; i++) {
			for (int j = 0; j < p2.length; j++) {
				k=j+i;
				mul[k]+= Math.round((p1[i] *p2[j])*10000)/ 10000.0;
			}
		}
		if (Objects.equals(poly(mul),"0.0")) {return mullIsZero;}
		else {return mul;}
	}


	/*This function receives an array, two values of X (assuming that F(x1deviation )*F(x2)<0),and an epsilon. 
	 *The function finds the most accurate X-intercept (with deviation  of an epsilon) between X1 and X2,
	 *using the Bisection  Method, and returns the value of the nearest X to zero,
	 */
	public static double root (double[] p,double x1,double x2,double eps){
		double a =0, b=0, c=0;
		if(x2>x1 ) {a=x1 ; b=x2 ;}
		else {b=x1 ; a=x2;}
		double fxa = f(p,x1);
		double fxb = f(p,x2);
		double fxc = 0;
		if (fxa<=eps && fxa>=0) { return  (a); }
		if (fxb<=eps && fxb>=0) { return  (b); }
		while (b-a>eps) {
			c=(a+b)/2;
			fxa = f(p,a);
			fxb = f(p,b);
			fxc = f(p,c);
			if (fxc<=eps && fxc>=0) { return  (c); }
			else if (fxa*fxc<0) { b=c; }
			else { a=c; }
		}
		return (c);
	}
}
