create view Commandes_terminees as
	select * from Commandes where upper(etat) = upper("annulee") or dateDep > sysdate order by 2 ;

create view Commandes_enCours as
	select * from Commandes where upper(etat) = upper("en cours") order by 2 ;
	
create view liste_Voyage as
	select voy.destination, op.intitule, op.prix
	from Voyages voy, Options op
	where voy.idRef = op.idRef ;