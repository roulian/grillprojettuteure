package images;

public final class Bat {
	public static final String BLANC = "images/blanc.PNG" ;
	public static final String BAT1 = "images/bat1.PNG" ;
	public static final String BAT2 = "images/bat2.PNG" ;
	public static final String BAT3 = "images/bat3.PNG" ;
	public static final String BAT4 = "images/bat4.png" ;
	public static final String BAT5 = "images/bat5.png" ;
	public static final String BAT6 = "images/bat6.png" ;
	
	public static final String NUM0 = "images/num0.PNG" ;
	public static final String NUM1 = "images/num1.PNG" ;
	public static final String NUM2 = "images/num2.PNG" ;
	public static final String NUM3 = "images/num3.PNG" ;
	public static final String NUM4 = "images/num4.PNG" ;
	public static final String NUM5 = "images/num5.PNG" ;
	public static final String NUM6 = "images/num6.PNG" ;
	
	public static final String ROUTEV = "images/routeV.PNG" ;
	public static final String ROUTEH = "images/routeH.PNG" ;
	public static final String CARFOU = "images/routeCar.PNG" ;
	
	public static String associatO(int pBatiment){
		if(pBatiment==1)
			return NUM1 ;
		else{
			if(pBatiment==2)
				return NUM2 ;
			else{
				if(pBatiment==3)
					return NUM3 ;
				else{
					if(pBatiment==4)
						return NUM4 ;
					else{
						if(pBatiment==5)
							return NUM5 ;
						else{
							if(pBatiment==6)
								return NUM6 ;
							else
								return NUM0 ;
						}
					}
				}
			}
		}
	}
	
	public static String associatB(int pBatiment){
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
					else{
						if(pBatiment==5)
							return BAT5 ;
						else{
							if(pBatiment==6)
								return BAT6 ;
							else
								return BLANC ;
						}
					}
				}
			}
		}
	}
}
