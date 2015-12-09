/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully


Max Bertfield and  Matthew So Team CapZLoX
APCS pd 10
12/2/15
hw 40- SuperArray
 *****************************/

public class SuperArray {

		//~~~~~INSTANCE VARS~~~~~
		//underlying container, or "core" of this data structure:
    private int[] _data;

		//position of last meaningful value
    private int _lastPos;

		//size of this instance of SuperArray
		private int _size;

		
		//~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() {
	_data= new int[]{0,0,0,0,0,0,0,0,0,0};
	_lastPos= -1;
	    _size = 0;
    }
		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() { 
	
	String retstr= "[";
	for(int i=0; i <= _lastPos;i++){
		retstr += _data[i] +",";
	    }
	if (retstr.length() > 1){
	retstr = retstr.substring(0,retstr.length()-1);
	}
	retstr+= "]";
	return retstr;
}
    
		
    //double capacity of this SuperArray
    private void expand() {
	int[] temp = new int[_data.length*2];
	for(int i = 0; i < _data.length; i++){
	    temp[i] = _data[i];
	    }
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public int get( int index ) { return _data[index];}
	//Add, appends a specified value to the end of the SuperArray
    public void add(int a){
	if( _size + 1 < _data.length){//if theres enough room, dont expand just add, 
	    _data[_lastPos +1]= a;//just set the next value to the new one and increment _lastPos and Size by 1
	    _lastPos++;_size++;
	}
	else {//otherwise you need to expand then add.
	    this.expand();
	    add(a);
	}
	    
    }
	//Add at index- Adds a specified value at specifed index, if it exists.
	public void AddAtIndex(int a, int i){
		this.expand();//expands just in case, cant hurt right?

		if (i <= _lastPos && i >= 0 ){//if the given index is applicable then 
			int temp1;
			int temp2 = _data[i];
			for(int j = i+1; j <= _lastPos + 1; j++){//move everyhting 1 over
				temp1 = _data[j];
				_data[j] = temp2;
				temp2 = temp1;
			}
			_data[i] = a;//set the given to the newly created middle slot
			_size ++;//increment size and lastpos
			_lastPos ++; 
		}
		else {
			System.out.println("Index not within bounds, cannot add there");
		}
	}
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, int newVal ) {int temp = _data[index]; _data[index] = newVal; return temp;}

	public void remove (int i){
			if (!(_lastPos < i)){ //aslong as i is within the range
				int x = i; //create a value identical to the original input
				while (x < _lastPos){ //while x is within the range of the string
					_data[x] = _data[x+1];//put whats in the next box into the current one
					x++;
				} 
				_size = _size - 1; //fix size
				_lastPos = _lastPos - 1; //fix position
				}
	
			else{
				System.out.println("There's nothing to remove."); //Give a message if something is wrong
			}
	}	

		//main method for testing
		public static void main( String[] args ) {
				//*****INSERT ADEQUATE TEST CALLS HERE*****
		    SuperArray a = new SuperArray();
		    a.add(2);
		    a.add(3);
		    a.add(4);
		    a.add(2);
		    a.add(3);
		    a.add(4);
		    System.out.println(a);
		    a.remove(2);
		    System.out.println(a);
		    a.add(2);
		    System.out.println(a);
		    a.add(3);
		    System.out.println(a);
		    a.AddAtIndex(1,1);
		    System.out.println(a);
			}//end main
		
}//end class
