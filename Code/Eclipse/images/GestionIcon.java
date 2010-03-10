package images;

/**
 * Classe contenant les Méthode de gestion des images
 * @author Andres Gomez Thomas
 * @version 1.0
 */
public class GestionIcon {
	public static final int BATIMAGE = 1 ;
	public static final int BATNUM = 2 ;
	public static final int OBSCOUL = 1 ;
	public static final int OBSNOIR = 2 ;
	
	private static boolean redBat= false ;
	private static int batType = BATNUM ; 
	private static int obsType = OBSNOIR ;
//	private static int batType = BATIMAGE ; 
//	private static int obsType = OBSCOUL ;
	
	/**
	 * accocie un int avec l'image d'un batiment
	 * @param pBatiment   un simple int symbolisant le nombre d'étage qu'un batiement comporte
	 * @return l'adresse phisyque de l'image associé dans un string
	 */
	public static String getImage(int pElement,String pType){
		if(pType.equals("bat")||pType.equals("Batiment")){
			if(batType == 1){
				if(!redBat)
					return associatBA(pElement) ;
				else
					return associatBARed(pElement) ;
			}
			if(batType == 2){
				if(!redBat)
					return associatNC(pElement) ;
				else
					return associatNCRED(pElement) ;
			}
		}
		if(pType.equals("obs")||pType.equals("Observateur")){
			if(obsType == 1)
				return associatNC(pElement) ;
			else
				return associatNB(pElement) ;
		}
		return null ;
	}
	
	
	/**
	 * accocie un int avec l'image d'un chiffre coloré
	 * @param pBatiment   un simple int symbolisant le nombre d'étage qu'un batiement comporte
	 * @return l'adresse phisyque de l'image associé dans un string
	 */
	public static String associatNC(int pBatiment){
		if(pBatiment==1)
			return IconBat.NUM1 ;
		else{
			if(pBatiment==2)
				return IconBat.NUM2 ;
			else{
				if(pBatiment==3)
					return IconBat.NUM3 ;
				else{
					if(pBatiment==4)
						return IconBat.NUM4 ;
					else{
						if(pBatiment==5)
							return IconBat.NUM5 ;
						else{
							if(pBatiment==6)
								return IconBat.NUM6 ;
							else
								return IconBat.BLANC ;
						}
					}
				}
			}
		}
	}
	
	/**
	 * accocie un int avec l'image d'un chiffre coloré et Barré
	 * @param pBatiment   un simple int symbolisant le nombre d'étage qu'un batiement comporte
	 * @return l'adresse phisyque de l'image associé dans un string
	 */
	public static String associatNCRED(int pBatiment){
		if(pBatiment==1)
			return IconBat.NUM1RED ;
		else{
			if(pBatiment==2)
				return IconBat.NUM2RED ;
			else{
				if(pBatiment==3)
					return IconBat.NUM3RED ;
				else{
					if(pBatiment==4)
						return IconBat.NUM4RED ;
					else{
						if(pBatiment==5)
							return IconBat.NUM5RED ;
						else{
							if(pBatiment==6)
								return IconBat.NUM6RED ;
							else
								return IconBat.REDSQ ;
						}
					}
				}
			}
		}
	}
	
	/**
	 * accocie un int avec l'image d'un chiffre en noir et blanc
	 * @param pBatiment   un simple int symbolisant le nombre d'étage qu'un batiement comporte
	 * @return l'adresse physique de l'image associé dans un string
	 */
	public static String associatNB(int pBatiment){
		if(pBatiment==1)
			return IconBat.NUB1 ;
		else{
			if(pBatiment==2)
				return IconBat.NUB2 ;
			else{
				if(pBatiment==3)
					return IconBat.NUB3 ;
				else{
					if(pBatiment==4)
						return IconBat.NUB4 ;
					else{
						if(pBatiment==5)
							return IconBat.NUB5 ;
						else{
							if(pBatiment==6)
								return IconBat.NUB6 ;
							else
								return IconBat.BLANC ;
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
			return IconBat.BAT1 ;
		else{
			if(pBatiment==2)
				return IconBat.BAT2 ;
			else{
				if(pBatiment==3)
					return IconBat.BAT3 ;
				else{
					if(pBatiment==4)
						return IconBat.BAT4 ;
					else{
						if(pBatiment==5)
							return IconBat.BAT5 ;
						else{
							if(pBatiment==6)
								return IconBat.BAT6 ;
							else
								return IconBat.BLANC ;
						}
					}
				}
			}
		}
	}
	
	/**
	 * accocie une image de batiment avec sa version barrer
	 * @param string
	 * @return string
	 */
	public static String associatBARed(int pIcon){
		String newIcon = IconBat.REDSQ;
		if(pIcon == 1)
			newIcon = IconBat.BAT1RED ;
		if(pIcon == 2)
			newIcon = IconBat.BAT2RED ;
		if(pIcon == 3)
			newIcon = IconBat.BAT3RED ;
		if(pIcon == 4)
			newIcon = IconBat.BAT4RED ;
		if(pIcon == 5)
			newIcon = IconBat.BAT5RED ;
		if(pIcon == 6)
			newIcon = IconBat.BAT6RED ;
		return newIcon ;
	}
	
	/**
	 * accocie une image avec sa version encadre et réciproquement
	 * @param string
	 * @return string
	 */
//	OBSOLETTE !
//	public static String switchToAnimatBatIcon(int pIcon){
//		String newIcon = IconBat.BLANC;
//		if(pIcon == 0)
//			newIcon = IconBat.BLANCANIM ;
//		if(pIcon == 1)
//			newIcon = IconBat.BAT1ANIM ;
//		if(pIcon == 2)
//			newIcon = IconBat.BAT2ANIM ;
//		if(pIcon == 3)
//			newIcon = IconBat.BAT3ANIM ;
//		if(pIcon == 4)
//			newIcon = IconBat.BAT4ANIM ;
//		if(pIcon == 5)
//			newIcon = IconBat.BAT5ANIM ;
//		if(pIcon == 6)
//			newIcon = IconBat.BAT6ANIM ;
//		return newIcon ;
//	}
	
	
	//********** ACCESSEUR ************/

	public static boolean getRedBat() {
		return redBat;
	}


	public static void switchRedBat() {
		redBat = !redBat;
	}


	public static int getBatType() {
		return batType;
	}


	public static void setBatType(int pBatType) {
		batType = pBatType;
	}


	public static int getObsType() {
		return obsType;
	}


	public static void setObsType(int obstype) {
		obsType = obstype;
	}
}
