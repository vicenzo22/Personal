package edu.cuny.csi.csc330.lab6;

public class LottoQuickPicker2Exception extends Exception {

	//errors
	public static int UNSET=0;
	public static int INVALID_GAME=1;
	public static int MISSING_PROPERTIES=2;
	
	//array
	public static String[] MESSAGE= {"Code unspecified",
			"Game coming soon","Missing properties"};
	
	
	//constructos
	protected int code;
	private LottoQuickPicker2Exception() {;}
	
	public LottoQuickPicker2Exception(String m) {
		
		super(m);
	}
	// with thrower message and code 
    public LottoQuickPicker2Exception(String message, int code) { 
    	super(message);
    	this.code = code;
	
	}
    public int getCode() {
    	return code;
    	}
    
    @Override
    public String toString() {
    	return"QuickpickerException[code=" + code + ", toString()="+ 
    			super.toString() + "]\n" + MESSAGE[code];  
    			}
    
    
    public static void main(String [] args) {
    	LottoQuickPicker2Exception re=new LottoQuickPicker2Exception("message..");
    	System.out.println("ex:"+re);
    	
    	re=new LottoQuickPicker2Exception("Message",LottoQuickPicker2Exception.MISSING_PROPERTIES);
    	System.out.println("EX: "+re);
    	
    }
    	
    	
    	
    	
    	
    	
    	
    }

