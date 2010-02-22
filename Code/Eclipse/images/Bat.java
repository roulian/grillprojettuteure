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
	
	public static final String BANIM = "images/blancAnim.PNG" ;
	
	
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
	 * @return l'adresse phisyque de l'image associé dans un string
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
}
