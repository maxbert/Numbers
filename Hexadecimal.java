//skeleton file for class Binary

//Max Bertfield and Grace Stempel -- Team Mr Brown give us a good grade.
//APCS pd 10
//Hw 44 - Hexadecimal;

public class Hexadecimal implements Comparable {

    private int _decNum;
    private String _hexNum;
    private final static String HEXDIGITS = "0123456789ABCDEF";


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _hexNum to "0"
      =====================================*/
    public Hexadecimal() { 
	/****** YOUR IMPLEMENTATION HURRR ******/
	_decNum = 0;
	_hexNum ="0";
    }


    public double  get(){
	return (double)_decNum;
    }
    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _hexNum to equiv string of bits
      =====================================*/
    public Hexadecimal( int n ) {
	_decNum = n;
	_hexNum = decToHex(n);
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _hexNum to input, _decNum to decimal equiv
      =====================================*/
    public Hexadecimal( String s ) {
	_decNum = hexToDecR(s);
	_hexNum = s;
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	/****** YOUR IMPLEMENTATION HURRR ******/
	return _hexNum;//This is really hard
    }


    /*=====================================
      String decToHex(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToHex(0) -> "0"
      decToHex(1) -> "1"
      decToHex(2) -> "10"
      decToHex(3) -> "11"
      decToHex(14) -> "1110"
      =====================================*/
    public static String decToHexR( int n ) {
	if (n/16 <= 1){
	    return "" + HEXDIGITS.substring((n%16), n%16 + 1);
	}else{
	    return decToHex(n/16) + HEXDIGITS.substring(n%16,n%16 + 1) + "";
		}
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      String decToHexR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToHexR(0) -> "0"
      decToHexR(1) -> "1"
      decToHexR(2) -> "10"
      decToHexR(3) -> "11"
      decToHexR(14) -> "1110"
      =====================================*/
    public static String decToHex( int n ) { 
	/****** YOUR IMPLEMENTATION HURRR */
	int i = n;
	String ret = "";
	while (n >= 1){//This is like the only time ive ever used a while loop instead of a for loop, and it makes me happy
	    ret += HEXDIGITS.substring(n%16, n%16+1);
	    n /= 16;
	}
	return ret;
	    
	    
    }


    /*=====================================
      String binToHex(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToHex("0") -> 0
      binToHex("1") -> 1
      binToHex("10") -> 2
      binToHex("11") -> 3
      binToHex("1110") -> 14
      =====================================*/
    public static int hexToDec( String s ) {
	int fin = 0;
	for (int i = 0; i < s.length(); i++){
	    fin +=(int) Math.pow(16.0, s.length() - 1 - i) *HEXDIGITS.indexOf((s.substring(0,1)));//So many close Parens. Make sure to typecast as an int so you can add it to Fin
	}
	return fin;
	    
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=====================================
      String binToHexR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToHexR("0") -> 0
      binToHexR("1") -> 1
      binToHexR("10") -> 2
      binToHexR("11") -> 3
      binToHexR("1110") -> 14
      =====================================*/
    public static int hexToDecR( String s ) {
	if (s.length() == 1){
	    return HEXDIGITS.indexOf(s);
	}else{
	    return (int) Math.pow(16.0, s.length() -1) * HEXDIGITS.indexOf((s.substring(0,1))) + hexToDecR(s.substring(1));
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }
    }

    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexadecimal
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) {
	Hexadecimal mother = new Hexadecimal();
	mother = (Hexadecimal)other;
	return ( hexToDecR(mother._hexNum) == hexToDecR(_hexNum));
	/****** YOUR IMPLEMENTATION HURRR ******/   
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Hexadecimal objects is greater
      pre:  other is instance of class Hexadecimal
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	/****** YOUR IMPLEMENTATION HURRR ******/
		if (!(other instanceof Comparable || other instanceof Hexadecimal)){
	    throw new ClassCastException( "invalid input");
	    }
	if (other instanceof Comparable){
	    Comparable mother =(Comparable)other;
	    return (int)(this.get() - mother.get());


	}
	else if (other instanceof Hexadecimal){
	    Hexadecimal mother =(Hexadecimal)other;
	    return (int)(this.get() - mother.get());
	}
	    return -9;
    }

    //main method for testing
    public static void main( String[] args ) {


	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal b1 = new Hexadecimal(15);
	Hexadecimal b2 = new Hexadecimal(15);
	Hexadecimal b3 = b1;
	Hexadecimal b4 = new Hexadecimal(17);
	Rational b5 = new Rational(17,1);
	Binary b6 = new Binary(17);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );
		System.out.println( b5 );       

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
	System.out.println( b4.compareTo(b5) ); //should be 0
	System.out.println( b4.compareTo(b6) ); //should be 0
    }//end main()

} //end class
