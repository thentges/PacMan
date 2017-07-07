import java.util.Random;

public class Fantome {
	private int posA;
	private int posO;
	private int right, left, up, down;
	private int numero;
	private int choix;
	private int cellule=8;
	private boolean goR, goL, goU, goD;
	
	Random rand = new Random();
	
///// CONSTRUCTEURS \\\\\\

public Fantome(int a, int x, int y){ // 10 : rouge | 11 : rose | 12 : bleu | 13 : vert
	numero = a;
	setPos(x,y);
}
///// GETTERS \\\\\\	

public int getPosA(){
	return posA;
}
public int getPosO(){
	return posO;
}
public int getCellule(){
	return cellule;
}
///// SETTERS \\\\\\

public void resetCellule(){
	cellule=8;
}

public void setPos(int x,int y){ // place le fantome 
	Labyrinthe.map[y][x]=numero;
	posA = x;
	posO = y;
}

public void vider(int b, int x, int y){ // vide la case
	Labyrinthe.map[y][x]=b;
}

public void avancer (int x, int y){
	if (Labyrinthe.map[y][x]==3){ // si le fantome va sur pacman
		Joueur.setViePerdue();	

	}
	else {
		cellule=Labyrinthe.map[y][x];
		Labyrinthe.map[y][x]=numero;
	}
}

///// TEST MUR \\\\\\


public void testMur(){							
	up = down = left = right = 0;
	
	if ( (posA==0 && posO==14) || (posA==27 && posO==14) ){ //si le joueur se trouve au bord de la ligne centrale
	left = right = 1; // il peut continuer
	}
	else{	
	if (Labyrinthe.map[posO][posA+1] != 1 && Labyrinthe.map[posO][posA+1] !=10 && Labyrinthe.map[posO][posA+1] !=11 && Labyrinthe.map[posO][posA+1] !=12 && Labyrinthe.map[posO][posA+1] !=13){ // right 
		right = 1;
		
	}
	if (Labyrinthe.map[posO-1][posA] != 1 && Labyrinthe.map[posO-1][posA] != 10 && Labyrinthe.map[posO-1][posA] != 11 && Labyrinthe.map[posO-1][posA] != 12 && Labyrinthe.map[posO-1][posA] != 13){ // up 
		up = 1;
		
	}	
	if (Labyrinthe.map[posO][posA-1] != 1 && Labyrinthe.map[posO][posA-1] != 10 && Labyrinthe.map[posO][posA-1] != 11 && Labyrinthe.map[posO][posA-1] != 12 && Labyrinthe.map[posO][posA-1] != 13){ // left 
		left = 1;
		
	}
	
	if (Labyrinthe.map[posO+1][posA] != 1 && Labyrinthe.map[posO+1][posA] != 20 && Labyrinthe.map[posO+1][posA] !=10 && Labyrinthe.map[posO+1][posA] !=11 && Labyrinthe.map[posO+1][posA] !=12 && Labyrinthe.map[posO+1][posA] !=13){ // down 
		down = 1;
		
	}
}}
///// DEPLACEMENTS \\\\\\

public void goRight(){
	
		if (posA==27 && posO==14){
			vider (cellule, 27, 14);
			avancer(0, 14);
			posA = 0;
			}
		
			else {
				vider(cellule, posA, posO);
				avancer(posA+1,posO);
				posA = posA+1;
			}

	
	}

public void goUp(){
	vider (cellule, posA, posO);
	avancer(posA,posO-1);
	posO = posO-1;


	

}
	
public void goLeft(){
	if (posA==0 && posO==14){
		vider(cellule, 0, 14);
		avancer(27, 14);
		posA = 27;
		}
	
	else {
		vider(cellule, posA, posO);
		avancer(posA-1,posO);
		posA = posA-1;
		}

	

}


public void goDown(){
	vider(cellule,posA,posO);
	avancer(posA,posO+1);
		posO = posO+1;

	}

//////////////////////////////////////////////////////////////////////

public void deplacer(){
	if (Labyrinthe.map[posO-1][posA] == 20){
		vider(cellule, posA, posO);
		Labyrinthe.map[posO-2][posA]=numero;
		posO=posO-2;
	}
	testMur();
	if (goL && left==1 && up==0 && down==0 || goR && right==1 && up==0 && down==0 || goU && up==1 && left==0 && right==0 ||goD && down==1 && left==0 && right==0 ){
	if (goL && left==1){
		goLeft();
	}
	if (goR && right==1){
		goRight();
	}
	if (goU && up==1){
		goUp();
	}
	if (goD && down==1){
		goDown();
	}
}
	else{	
	if (down==1 && left==0 && up==0 && right==0) { // D
		goDown();
		goD=true;
		goL=goR=goU=false;
	
	}
	if (down==0 && left==1 && up==0 && right==0) { // L
		goLeft();
		goL=true;
		goR=goU=goD=false;
	}
	if (down==0 && left==0 && up==1 && right==0) { // U
		goUp();
		goU=true;
		goR=goU=goL=false;
	}
	if (down==0 && left==0 && up==0 && right==1) { // R
		goRight();
		goR=true;
		goL=goU=goD=false;
	}
	
	if (down==1 && left==1 && up==0 && right==0) { // D L 
		choix=rand.nextInt(2);
		if (choix==0){
			goDown();
			goD=true;
			goL=goR=goU=false;
		}
		if (choix == 1){
			goLeft();
			goL=true;
			goR=goU=goD=false;
		}
	}
	if (down==1 && left==0 && up==1 && right==0) { // D U
		choix=rand.nextInt(2);
		if (choix==0){
			goDown();
			goD=true;
			goL=goR=goU=false;
		}
		if (choix == 1){
			goUp();
			goU=true;
			goR=goU=goL=false;
		}
	}
	if (down==1 && left==0 && up==0 && right==1) { // D R 
		choix=rand.nextInt(2);
		if (choix==0){
			goDown();
			goD=true;
			goL=goR=goU=false;
		}
		if (choix == 1){
			goRight();
			goR=true;
			goL=goU=goD=false;
		}
	}
	if (down==0 && left==1 && up==1 && right==0) { // L U
		choix=rand.nextInt(2);
		if (choix==0){
			goLeft();
			goL=true;
			goR=goU=goD=false;
		}
		if (choix == 1){
			goUp();
			goU=true;
			goR=goD=goL=false;
		}
	}
	if (down==0 && left==1 && up==0 && right==1) { // L R
		choix=rand.nextInt(2);
		if (choix==0){
			goLeft();
			goL=true;
			goR=goU=goD=false;
		}
		if (choix == 1){
			goRight();
			goR=true;
			goL=goU=goD=false;
		}
	}
	if (down==0 && left==0 && up==1 && right==1) { // U R
		choix=rand.nextInt(2);
		if (choix==0){
			goUp();
			goU=true;
			goR=goD=goL=false;
		}
		if (choix == 1){
			goRight();
			goR=true;
			goL=goU=goD=false;
		}
	}
		if (down==1 && left==1 && up==1 && right==0) { // D L U
			choix=rand.nextInt(3);
			if (choix==0){
				goDown();
				goD=true;
				goL=goR=goU=false;
			}
			if (choix == 1){
				goLeft();
				goL=true;
				goR=goU=goD=false;
			}
			if (choix == 2){
				goUp();
				goU=true;
				goR=goD=goL=false;
			}
		}
		if (down==0 && left==1 && up==1 && right==1) { // L U R
			choix=rand.nextInt(3);
			if (choix==0){
				goLeft();
				goL=true;
				goR=goU=goD=false;
			}
			if (choix == 1){
				goUp();
				goU=true;
				goR=goD=goL=false;
			}
			if (choix == 2){
				goRight();
				goR=true;
				goL=goU=goD=false;
			}
		}
		if (down==1 && left==1 && up==0 && right==1) { // D L R
			choix=rand.nextInt(3);
			if (choix==0){
				goDown();
				goD=true;
				goL=goR=goU=false;
			}
			if (choix == 1){
				goLeft();
				goL=true;
				goR=goU=goD=false;
			}
			if (choix == 2){
				goRight();
				goR=true;
				goL=goU=goD=false;
			}
		}
		if (down==1 && left==0 && up==1 && right==1) { // D U R
			choix=rand.nextInt(3);
			if (choix==0){
				goDown();
				goD=true;
				goL=goR=goU=false;
			}
			if (choix == 1){
				goUp();
				goU=true;
				goR=goD=goL=false;
			}
			if (choix == 2){
				goRight();
				goR=true;
				goL=goU=goD=false;
			}
		}
		if (down==1 && left==1 && up==1 && right==1) { // D L U R
			choix=rand.nextInt(4);
			if (choix==0){
				goDown();
				goD=true;
				goL=goR=goU=false;
			}
			if (choix == 1){
				goLeft();
				goL=true;
				goR=goU=goD=false;
			}
			if (choix == 2){
				goUp();
				goU=true;
				goR=goD=goL=false;
			}
			if (choix == 3){
				goRight();
				goR=true;
				goL=goU=goD=false;
			}
		}
	}
		
		Affichage.majMap();
	}
}