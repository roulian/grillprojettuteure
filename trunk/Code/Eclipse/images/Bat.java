package images;

/**
 * Classe contenant les constantes contenant les images du projet, ainsi que quelques méthode pour les appeller
 * @author Andres Gomez Thomas
 * @version 1.0
 */
public final class Bat {
	public static final String BLANC = "images/blanc.PNG" ;
	public static final String BAT1 = "images/bat1.PNG" ;
	public static final String BAT2 = "images/bat2.PNG" ;
	public static final String BAT3 = "images/bat3.PNG" ;
	public static final String BAT4 = "images/bat4.png" ;
	public static final String BAT5 = "images/bat5.png" ;
	public static final String BAT6 = "images/bat6.png" ;
	
	public static final String BLANCANIM = "images/blancAnim.PNG" ;
	public static final String BAT1ANIM = "images/bat1Anim.PNG" ;
	public static final String BAT2ANIM = "images/bat2Anim.PNG" ;
	public static final String BAT3ANIM = "images/bat3Anim.PNG" ;
	public static final String BAT4ANIM = "images/bat4Anim.png" ;
	public static final String BAT5ANIM = "images/bat5Anim.png" ;
	public static final String BAT6ANIM = "images/bat6Anim.png" ;
	
	public static final String REDSQ = "images/redSquare.PNG" ;
	public static final String BAT1RED = "images/bat1Red.PNG" ;
	public static final String BAT2RED = "images/bat2Red.PNG" ;
	public static final String BAT3RED = "images/bat3Red.PNG" ;
	public static final String BAT4RED = "images/bat4Red.png" ;
	public static final String BAT5RED = "images/bat5Red.png" ;
	public static final String BAT6RED = "images/bat6Red.png" ;
	
	public static final String NUM0 = "images/num0.PNG" ;
	public static final String NUM1 = "images/num1.PNG" ;
	public static final String NUM2 = "images/num2.PNG" ;
	public static final String NUM3 = "images/num3.PNG" ;
	public static final String NUM4 = "images/num4.PNG" ;
	public static final String NUM5 = "images/num5.PNG" ;
	public static final String NUM6 = "images/num6.PNG" ;
	
	public static final String NUB0 = "images/numB0.PNG" ;
	public static final String NUB1 = "images/numB1.PNG" ;
	public static final String NUB2 = "images/numB2.PNG" ;
	public static final String NUB3 = "images/numB3.PNG" ;
	public static final String NUB4 = "images/numB4.PNG" ;
	public static final String NUB5 = "images/numB5.PNG" ;
	public static final String NUB6 = "images/numB6.PNG" ;
	
	public static final String ROUTEV = "images/routeV.PNG" ;
	public static final String ROUTEH = "images/routeH.PNG" ;
	public static final String CARFOU = "images/routeCar.PNG" ;
	
	
	
	
	/**
	 * accocie un int avec l'image d'un chiffre coloré
	 * @param pBatiment   un simple int symbolisant le nombre d'étage qu'un batiement comporte
	 * @return l'adresse phisyque de l'image associé dans un string
	 */
	public static String associatNC(int pBatiment){
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
	
	/**
	 * accocie un int avec l'image d'un chiffre en nour et blanc
	 * @param pBatiment   un simple int symbolisant le nombre d'étage qu'un batiement comporte
	 * @return l'adresse physique de l'image associé dans un string
	 */
	public static String associatNB(int pBatiment){
		if(pBatiment==1)
			return NUB1 ;
		else{
			if(pBatiment==2)
				return NUB2 ;
			else{
				if(pBatiment==3)
					return NUB3 ;
				else{
					if(pBatiment==4)
						return NUB4 ;
					else{
						if(pBatiment==5)
							return NUB5 ;
						else{
							if(pBatiment==6)
								return NUB6 ;
							else
								return NUB0 ;
						}
					}
				}
			}
		}
	}
	
	/**
	 * accocie un int avec l'image d'un batiment
	 * @param pBatiment   un simple int symbolisant le nombre d'étage qu'un batiement comporte
	 * @return l'adresse phisyque de l'image associé dans un string
	 */
	public static String associatBA(int pBatiment){
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
	
	/**
	 * accocie une image avec sa version encadre et réciproquement
	 * @param string
	 * @return string
	 */
	public static String switchToAnimatBatIcon(int pIcon){
		String newIcon = BLANC;
		if(pIcon == 0)
			newIcon = BLANCANIM ;
		if(pIcon == 1)
			newIcon = BAT1ANIM ;
		if(pIcon == 2)
			newIcon = BAT2ANIM ;
		if(pIcon == 3)
			newIcon = BAT3ANIM ;
		if(pIcon == 4)
			newIcon = BAT4ANIM ;
		if(pIcon == 5)
			newIcon = BAT5ANIM ;
		if(pIcon == 6)
			newIcon = BAT6ANIM ;
		return newIcon ;
	}
		
	/**
	 * accocie une image avec sa version barrer
	 * @param string
	 * @return string
	 */
	public static String associatRed(int pIcon){
		String newIcon = REDSQ;
		if(pIcon == 1)
			newIcon = BAT1RED ;
		if(pIcon == 2)
			newIcon = BAT2RED ;
		if(pIcon == 3)
			newIcon = BAT3RED ;
		if(pIcon == 4)
			newIcon = BAT4RED ;
		if(pIcon == 5)
			newIcon = BAT5RED ;
		if(pIcon == 6)
			newIcon = BAT6RED ;
		return newIcon ;
	}
}
