package ownUtil;

public class FormalePlausiException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	protected String feldname;

	public FormalePlausiException(String feldname){
		this.feldname = feldname;
	}
	
	public String getMessageForUser(){
		return "Bitte korrigieren Sie den formalen " 
	  	    + "Eingabefehler im Feld " + this.feldname + ".";
	}
}
