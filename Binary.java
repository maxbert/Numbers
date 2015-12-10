//skeleton file for class Binary

//Max Bertfield
//APCS pd 10
//Hw 43 - Binary;

public class Binary implements Comparable{

    private int _decNum;
    private String _binNum;


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
	/****** YOUR IMPLEMENTATION HURRR ******/
	_decNum = 0;
	_binNum ="0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
	_decNum = n;
	_binNum = decToBin(n);
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
	_decNum = binToDec(s);
	_binNum = s;
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }

    public double get(){
	return(double) _decNum;
    }
    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	/****** YOUR IMPLEMENTATION HURRR ******/
	return _binNum;//This is really hard
    }


    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
    public static String decToBinR( int n ) {
	if (n/2 <= 1){
	    return "" + (n/2);
	}else{
	    return decToBin(n/2) + n%2 + "";
		}
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ) { 
	/****** YOUR IMPLEMENTATION HURRR */
	int i = n;
	String ret = "";
	while (n >= 1){//This is like the only time ive ever used a while loop instead of a for loop, and it makes me happy
	    ret += n%2;
	    n /= 2;
	}
	return ret;
	    
	    
    }


    /*=====================================
      String binToDec(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
    public static int binToDec( String s ) {
	int fin = 0;
	for (int i = 0; i < s.length(); i++){
	    fin +=(int)( Math.pow(2.0,s.length() -1 -i))*Integer.parseInt(s.substring(i,i+1));//So many close Parens. Make sure to typecast as an int so you can add it to Fin
	}
	return fin;
	    
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      String binToDecR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
    public static int binToDecR( String s ) {
	if (s.length() == 1){
	    return Integer.parseInt(s);
	}else{
	    return (int) Math.pow(2.0,s.length() - 1)* Integer.parseInt(s.substring(0,1)) + binToDecR(s.substring(1));
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }
    }

    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) {
	Binary mother = new Binary();
	mother = (Binary)other;
	return ( binToDec(mother._binNum) == binToDec(_binNum));
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	/****** YOUR IMPLEMENTATION HURRR ******/
		if (!(other instanceof Comparable || other instanceof Binary)){
	    throw new ClassCastException( "invalid input");
		}
	if (other instanceof Comparable){
	    Comparable mother =(Comparable)other;
	    return (int)(this.get() - mother.get());


	}
	else if (other instanceof Binary){
	    Binary mother =(Binary)other;
	    return (int)(this.get() - mother.get());
	}
	    return -9;
    }

    //main method for testing
    public static void main( String[] args ) {


	System.out.println();
	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	Binary b4 = new Binary(7);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );       

	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos
    }//end main()

} //end class
