package images;

public final class Bat {
	public static final String BLANC = "images/blanc.PNG" ;
	public static final String BAT1 = "images/bat1.PNG" ;
	public static final String BAT2 = "images/bat2.PNG" ;
	public static final String BAT3 = "images/bat3.PNG" ;
	public static final String BAT4 = "images/bat4.png" ;
	
	public static String associat(int pBatiment){
		if(pBatiment==1)
			return BAT1 ;
		else{
			if(pBatiment==2)
				return BAT2 ;
			else{
				if(pBatiment==3)
					return BAT3 ;
				else{
					if(pBatiment==4)
						return BAT4 ;
					else
						return BLANC ;
				}
			}
		}
	}
}
