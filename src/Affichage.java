import edu.princeton.cs.introcs.StdDraw;

public class Affichage {
	
	Affichage basique = new  Affichage();
	
	public static void initMap(){
		
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(13.5, -1.8, "pacman_logo.png", 10, 2);
		for (int i=0; i<Labyrinthe.map[0].length; i++){
			for (int j=0; j<Labyrinthe.map.length;j++){
				switch(Labyrinthe.map[Labyrinthe.map.length-1-j][i]){
				case 20: // barrière // sortie de la cage
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledRectangle(i,j,0.5, 0.05);
					break;
				case 0: // fromage
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledSquare(i, j, 0.40);
					StdDraw.setPenColor(StdDraw.ORANGE);
					StdDraw.filledCircle(i,j,0);
					break;
				case 1: // mur
					StdDraw.setPenColor(StdDraw.BLUE);
					StdDraw.filledSquare(i,j,0.55);
					break;
				case 8: // vide
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledSquare(i, j, 0.40);
					break;
				case 3: // pacman
					StdDraw.setPenColor(StdDraw.YELLOW);
					StdDraw.filledCircle(i, j, 0.35);
					
					break;
				
				

				}
	
			}
			
			// remplir de noir les murs \\
			StdDraw.setPenColor(StdDraw.BLACK); 
			StdDraw.filledRectangle(13.5, 0, (Labyrinthe.map[0].length/2)-0.8, 0.4); 
			StdDraw.filledRectangle(0, 7.5, 0.38, (Labyrinthe.map.length/4)+0.9); 
			StdDraw.filledRectangle(Labyrinthe.map[0].length-1, 7.5, 0.38, (Labyrinthe.map.length/4)+0.9);
			StdDraw.filledRectangle(0, 23.5, 0.38, 7-0.1);
			StdDraw.filledRectangle(Labyrinthe.map[0].length-1, 23.5, 0.38, 7-0.1);
			StdDraw.filledRectangle(13.5, Labyrinthe.map.length-1, (Labyrinthe.map[0].length/2)-0.8, 0.4);
			StdDraw.filledRectangle(2.5, 13, 3-0.1, (5/2)+0.4);
			StdDraw.filledRectangle(Labyrinthe.map[0].length-1-2.5, 13, 3-0.1, (5/2)+0.4);
			StdDraw.filledRectangle(2.5, 19, 3-0.1, (5/2)+0.4);
			StdDraw.filledRectangle(Labyrinthe.map[0].length-1-2.5, 19, 3-0.1, (5/2)+0.4);
			StdDraw.filledRectangle(1, 5.5, 1.4, 0.9);
			StdDraw.filledRectangle(Labyrinthe.map[0].length-2, 5.5, 1.4, 0.9);
			StdDraw.filledRectangle(13.5, 28, 0.9, 2.4);
			StdDraw.filledRectangle(9, 8.5, 2.4, 0.9);
			StdDraw.filledRectangle(18, 8.5, 2.4, 0.9);
			StdDraw.filledRectangle(13.5, 5.5, 3.9, 0.9);
			StdDraw.filledRectangle(13.5, 23.5, 3.9, 0.9);
			StdDraw.filledRectangle(13.5, 11.5, 3.9, 0.9);
			StdDraw.filledRectangle(13.5, 4, 0.9, 2.4);
			StdDraw.filledRectangle(13.5, 10, 0.9, 2.4);
			StdDraw.filledRectangle(13.5, 22, 0.9, 2.4);
			StdDraw.filledRectangle(7.5, 13, 0.9, 2.4);
			StdDraw.filledRectangle(19.5, 13, 0.9, 2.4);
			StdDraw.filledRectangle(7.5, 4, 0.9, 2.4);
			StdDraw.filledRectangle(19.5, 4, 0.9, 2.4);
			StdDraw.filledRectangle(4.5, 7, 0.9, 2.4);
			StdDraw.filledRectangle(22.5, 7, 0.9, 2.4);
			StdDraw.filledRectangle(9, 20.5, 2.4, 0.9);
			StdDraw.filledRectangle(18, 20.5, 2.4, 0.9);
			StdDraw.filledRectangle(3.5, 23.5, 1.9, 0.9);
			StdDraw.filledRectangle(23.5, 23.5, 1.9, 0.9);
			StdDraw.filledRectangle(3.5, 8.5, 1.9, 0.9);
			StdDraw.filledRectangle(23.5, 8.5, 1.9, 0.9);
			StdDraw.filledRectangle(9, 27, 2.4, 1.4);
			StdDraw.filledRectangle(18, 27, 2.4, 1.4);
			StdDraw.filledRectangle(3.5, 27, 1.9, 1.4);
			StdDraw.filledRectangle(23.5, 27, 1.9, 1.4);
			StdDraw.filledRectangle(6.5, 2.5, 4.9, 0.9);
			StdDraw.filledRectangle(20.5, 2.5, 4.9, 0.9);
			StdDraw.filledRectangle(7.5, 20.5, 0.9, 3.9);
			StdDraw.filledRectangle(19.5, 20.5, 0.9, 3.9);
			StdDraw.filledRectangle(10, 16, 0.4, 2.4);
			StdDraw.filledRectangle(17, 16, 0.4, 2.4);
			StdDraw.filledRectangle(11, 18, 1.4, 0.4);
			StdDraw.filledRectangle(16, 18, 1.4, 0.4);
			StdDraw.filledRectangle(13.5, 14, 3.9, 0.4);
			
		}		
	}
	
		public static void majMap(){
			
			StdDraw.enableDoubleBuffering();
			for (int i=0; i<Labyrinthe.map[0].length; i++){
				for (int j=0; j<Labyrinthe.map.length;j++){
					switch(Labyrinthe.map[Labyrinthe.map.length-1-j][i]){
					case 0: // fromage
						StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.filledSquare(i, j, 0.40);
						StdDraw.setPenColor(StdDraw.ORANGE);
						StdDraw.filledCircle(i,j,0);
						break;
					case 8: // vide
						StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.filledSquare(i, j, 0.4);
						break;
					case 3: // pacman
						StdDraw.setPenColor(StdDraw.YELLOW);
						StdDraw.filledCircle(i, j, 0.35);
					
						break;
					case 10: // fantome rouge
						StdDraw.picture(i, j, "fantome_samus.png", 0.83, 0.83);
						break;
					case 11: // fantome rose
						StdDraw.picture(i, j, "fantome_trooper.png", 0.76, 0.76);
						break;
					case 12: // fantome bleu
						StdDraw.picture(i, j, "fantome_sonic.png", 0.83, 0.83);
						break;
					case 13: // fantome vert
						StdDraw.picture(i, j, "fantome_creeper.png", 0.76, 0.76);
						break;
					
					}
				
				}
			}		
	}

	
		
}	
