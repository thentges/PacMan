import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;


public class Joueur {

	private int posA=13; // position axe abscisses
	private int posO=23; // position axe ordonnées
	private static int score=0, pastilleEaten=0;
	private boolean right, left, up, down, posLeft=false, posRight=false, posUp=false, posDown=false; //viePerdue=false;
	private static boolean viePerdue=false;
	private static boolean victoire=false;
	private static int nombreVie = 3;
	private static int valeurShow=200;
	
	Fantome red = new Fantome(10, 11, 13); // création des 4 fantomes
	Fantome rose = new Fantome(11, 16, 15);
	Fantome blue = new Fantome(12, 11, 15);
	Fantome green = new Fantome(13, 16, 13);


///// CONSTRUCTEURS \\\\\\
	
	public Joueur(){
	}
	
///// GETTERS \\\\\\	
	
	public  int getScore(){
		return score;
	}
	
	public  int getVie(){
		return nombreVie;
	}
	
	public  boolean getVictoire(){
		return victoire;
	}
///// SETTERS \\\\\\	
	
	public void setPos(int x,int y){ // place le joueur 
		Labyrinthe.map[y][x]=3;
		posA = x;
		posO = y;
	}
	
	public static void setViePerdue(){
		viePerdue=true;	
	}
	public void resetVie(){
		nombreVie=3;
	}
	
	public void setScore(int nouveauScore){
		score=nouveauScore;
	}
	
	
	
	
	public void resetVictoire(){
		victoire=false;
	}
	
	/////////
	
	public void vider(int x, int y){ // vide la case
		Labyrinthe.map[y][x]=8;
	}
	public void deplacementFantomes(){
		red.deplacer();
		rose.deplacer();
		blue.deplacer();
		green.deplacer();
		
	}
	
	public void resetPartie(){
		posUp = posDown = posLeft = posRight = false;
		vider(posA, posO);
		setPos(13, 23);
		red.vider(red.getCellule(), red.getPosA(), red.getPosO()); // vide la case où étaient les fantomes
		rose.vider(rose.getCellule(), rose.getPosA(), rose.getPosO());
		blue.vider(blue.getCellule(), blue.getPosA(), blue.getPosO());
		green.vider(green.getCellule(), green.getPosA(), green.getPosO());
		red.setPos(11, 13); //reset la position des fantomes
		rose.setPos(16, 15);
		blue.setPos(11, 15);
		green.setPos(16, 13);
		red.resetCellule(); //reset les cellules en memoire
		rose.resetCellule();
		blue.resetCellule();
		green.resetCellule();
		pastilleEaten=0;
	}

	public void avancer(int x, int y){ // change la position du joueur dans le tableau
		if (Labyrinthe.map[y][x]==0){ // si la case d'arrivée du joueur est un fromage
			pastilleEaten++;
			score = score + 10; // le score augmente de 10 points
			afficherScore();
			testVictoire();
			Labyrinthe.map[y][x]=3;
			}	
		if (Labyrinthe.map[y][x]==8){ // si la case d'arrivée du joueur est vide
			Labyrinthe.map[y][x]=3;
		}

		if (Labyrinthe.map[y][x]==10 || Labyrinthe.map[y][x]==11 || Labyrinthe.map[y][x]==12 || Labyrinthe.map[y][x]==13){ //si la case d'arrivée est un fantome
			viePerdue=true;
		}
	}
	
	public void afficherScore(){
		StdDraw.setPenColor(StdDraw.BLACK); // efface l'ancien score affiché
		StdDraw.filledRectangle(2, -2, 4, 1);
		StdDraw.setPenColor(StdDraw.WHITE); // affiche le nouveau score
		StdDraw.textLeft(0, -2, "Score : " + score); 
	}
	
	public void afficherVie(){
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(25, -2, 4, 1);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.textRight(27, -2, "Vies : " +nombreVie);
	}
	
///// TEST MORT \\\\\\
	
	
	public void testMort(){ // RÉINITIALISE la map si le joueur vient de perdre une vie
		if (viePerdue){ 	
			nombreVie = nombreVie-1; // retire une vie en cas de collision avec un fantome
			afficherVie();
			posUp = posDown = posLeft = posRight = false;
			vider(posA, posO);
			setPos(13, 23);
			red.vider(red.getCellule(), red.getPosA(), red.getPosO()); // vide la case où étaient les fantomes
			rose.vider(rose.getCellule(), rose.getPosA(), rose.getPosO());
			blue.vider(blue.getCellule(), blue.getPosA(), blue.getPosO());
			green.vider(green.getCellule(), green.getPosA(), green.getPosO());
			red.setPos(11, 13); //reset la position des fantomes
			rose.setPos(16, 15);
			blue.setPos(11, 15);
			green.setPos(16, 13);
			red.resetCellule(); //reset les cellules en memoire
			rose.resetCellule();
			blue.resetCellule();
			green.resetCellule();
			viePerdue=false;
		}
	}
	
	
///// TEST VICTOIRE \\\\\\
	
	public void testVictoire(){ // teste si le joueur a gagné
		if (pastilleEaten == 244){
			victoire=true;
		}
	}
	
///// TEST MUR \\\\\\

	
	public void testMur(){							
		up = down = left = right = false;
		
		if ( (posA==0 && posO==14) || (posA==27 && posO==14) ){ //si le joueur se trouve au bord de la ligne centrale
		left = right = true; // il peut continuer
		}
		else{	
		if (Labyrinthe.map[posO][posA+1] != 1){ // right 
			right = true;
		}
		if (Labyrinthe.map[posO-1][posA] != 1){ // up 
			up = true;
		}	
		if (Labyrinthe.map[posO][posA-1] != 1 ){ // left 
			left = true;
		}
		
		if (Labyrinthe.map[posO+1][posA] != 1 && Labyrinthe.map[posO+1][posA] != 20 ){ // down 
			down = true;
		}
		
		}}
	

///// DEPLACEMENTS \\\\\\

	@SuppressWarnings("deprecation")
	public void goRight(){
		while(posRight && right){
			if (posA==27 && posO==14){
				deplacementFantomes();
				vider(posA, posO);
				avancer(0, 14);
				posA = 0;
			
				}
			
				else {
					deplacementFantomes();
					vider(posA, posO);
					avancer(posA+1,posO);
					posA = posA+1;
				}
			Affichage.majMap();
			StdDraw.show(valeurShow);
			testMur();
			testMort();
			if ( (StdDraw.isKeyPressed(KeyEvent.VK_UP) && up ) || (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && left ) || (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && down) || victoire){
				posRight=false;
				deplacer();
			}
		}
		}
	
	@SuppressWarnings("deprecation")
	public void goUp(){
		while (posUp && up){
			deplacementFantomes();
		vider(posA, posO);
		avancer(posA,posO-1);
		posO = posO-1;
		Affichage.majMap();
		StdDraw.show(valeurShow);
		testMur();
		testMort();
		if ( (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && right ) || (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && left ) || (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && down ) || victoire){
			posUp=false;
			deplacer();
			}
		}

	}
		
	@SuppressWarnings("deprecation")
	public void goLeft(){
		while (posLeft && left){
		if (posA==0 && posO==14){
			deplacementFantomes();
		    vider(posA, posO);
			avancer(27, 14);
			posA = 27;
			}
		
		else {
			deplacementFantomes();
			vider(posA, posO);
			avancer(posA-1,posO);
			posA = posA-1;
			}
		
		Affichage.majMap();
		StdDraw.show(valeurShow);
		testMur();
		testMort();
		if ( (StdDraw.isKeyPressed(KeyEvent.VK_UP) && up ) || (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && right ) || (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && down ) || victoire){
			posLeft=false;
			deplacer();
			}
		}

	}
	
	@SuppressWarnings("deprecation")
	public void goDown(){
		while (posDown && down){
		deplacementFantomes();
		vider(posA, posO);
		avancer(posA,posO+1);
			posO = posO+1;
			
		Affichage.majMap();
		StdDraw.show(valeurShow);
		testMur();
		testMort();
		if ( (StdDraw.isKeyPressed(KeyEvent.VK_UP) && up ) || (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && left ) || (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && right ) || victoire){
			posDown=false;
			deplacer();
			}
		}

	}
	


//////////////////////////////////////////////////////////////////////

	@SuppressWarnings("deprecation")
	public void deplacer(){
		if (!StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && !StdDraw.isKeyPressed(KeyEvent.VK_UP) && !StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && !StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
		deplacementFantomes();
		StdDraw.show(valeurShow);
		}
		testMur();
		if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && right) {
			posRight=true;
			posLeft=posUp=posDown=false;
			goRight();
		}
		else if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && up ) {
			posUp=true;
			posLeft=posRight=posDown=false;
			goUp();
		
		}
		else if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && left ) {
		    posLeft=true;
		    posRight=posUp=posDown=false;
			goLeft();
		      
		}
		else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && down ) {
		    posDown=true;
		    posLeft=posUp=posRight=false;
			goDown();
		 
		}
		
	}
	

}
