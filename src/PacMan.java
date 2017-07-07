import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;



public class PacMan {
	
	static boolean rejouer = false;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		/// INITIALISATION DES PARAMÈTRES DE LA FENETRE \\\
		
		StdDraw.setCanvasSize(500,700);
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.setXscale(-1,Labyrinthe.map[0].length);
		StdDraw.setYscale(-3,Labyrinthe.map.length);
		
		Affichage.initMap(); // affichage de la map
		
		 
	
		do{
			
			Joueur j1 = new Joueur(); // création du joueur
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.textLeft(0, -2, "Score : " + j1.getScore());
			StdDraw.textRight(27, -2, "Vies : " + j1.getVie());
			Affichage.majMap(); // actualisation de la map
			
			
		while (j1.getVie()>0 && !j1.getVictoire()){ // tant que la partie est en cours
			j1.deplacer(); // fonction de déplacement du joueur
			StdDraw.show(30);			
		}
		if (j1.getVie()==0){
		/// Affichage de l'écran de défaite \\\
		StdDraw.enableDoubleBuffering();
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(13.5, 23, "Vous avez perdu,");
		StdDraw.text(13.5, 22, "votre score final est de " +j1.getScore() +" points");
		StdDraw.picture(13.5, 15, "pacman_defaite.png");
		StdDraw.text(13.5, 6, "Appuyez sur Entrée pour rejouer");
		StdDraw.show(30);
		while(j1.getVie()==0) {
		if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
			Labyrinthe.map = Labyrinthe.resetMap;
			StdDraw.clear(StdDraw.BLACK);
			Affichage.initMap();
			j1.setScore(0);
			j1.resetPartie();
			j1.resetVie();
			Affichage.majMap();
			rejouer=true;
		}
		}
		}
		if (j1.getVictoire()){
		/// Affichage de l'écran de victoire \\\
		j1.setScore(j1.getScore() + 200*j1.getVie()); // + 200 points par vie restante
		StdDraw.enableDoubleBuffering();
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(13.5, 26, "Vous avez gagné !");
		StdDraw.text(13.5, 25, j1.getVie() + " vies restantes => + " +200*j1.getVie() + " points");
		StdDraw.text(13.5, 24, "votre score final est de " +j1.getScore() +" points");
		StdDraw.picture(12, 14, "pacman_victoire.png", 15, 17);
		StdDraw.text(13.5, 4, "Appuyez sur Entrée pour continuer");
		
		StdDraw.show(30);
		while(j1.getVictoire()) {
			if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
				Labyrinthe.map = Labyrinthe.resetMap;
				StdDraw.clear(StdDraw.BLACK);
				Affichage.initMap();
				j1.resetPartie();
				Affichage.majMap();
				j1.resetVictoire();
				rejouer=true;
			}
			}
		}
		}while(rejouer);
		

	}

}
