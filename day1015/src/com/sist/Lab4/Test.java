package com.sist.Lab4;

public class Test {
	 public static void drawAll(GameCharacter []array) {
	    	for(GameCharacter character:array) {character.draw();
	    	if(character instanceof Hobit) {
	    	    ((Hobit)character).getRing();
	    	}
	    	}
}
	    	
	    	
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  /*GameCharacter g1 = new Hobit();
		  GameCharacter g2 = new Titan();
		  GameCharacter g3 = new Magician();
		  
		  GameCharacter g4 = new Hobit();
		  GameCharacter g5 = new Titan();
		  GameCharacter g6 = new Magician();*/
		  
		  /*GameCharacter[] inben = new GameCharacter[6];
		  
		  g1.getLife();
		  
		  inben[0] = g1;
		  inben[1] = g2;
		  inben[2] = g3;
		  inben[3] = g4;
		  inben[4] = g5;
		  inben[5] = g6;
		  
		  for(int i=0; i<6; i++)
		   inben[i].draw();
		   */
		
GameCharacter []array= {new Hobit(),new Hobit(),new Titan(),new Titan(),new Magician(),new Magician()};

drawAll(array);
	
	}

}
