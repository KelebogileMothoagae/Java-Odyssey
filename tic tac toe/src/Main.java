import java.util.Scanner;

/*
 * Create a tic tac toe game 2Player game
 */
public class Main {

	public static void main(String[] args) {
		// initialize the array of board
		char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		char player = 'X';
		boolean endgame = false;
		//input from user
		Scanner scan = new Scanner(System.in);
	
		while(!endgame) {
			
			 //print the current board
			
			displayboard(board);
			System.out.println("\n");
			//get rows and columns from the user
			System.out.println("Player"+player+" enter row (0-2):");
			int row = scan.nextInt();
			System.out.println("Player"+player+" enter column (0-2):");
			int col = scan.nextInt();
		
			//make sure the board is empty before allowing a move
			if(board[row][col]==' ') {
				board[row][col]= player;
                	
                //check for a win
                if(checkgame(board,player)){
	       System.out.println("\n");
        	displayboard(board);
            System.out.println("Player "+ player+"wins!");
            endgame= true;
                }else{
                    //allow another player to enter their input
                    if(player=='X'){
                        player='O';
                    }else{
                        player='X';
                    }
                }
			}
		}
	}
	
	 
		// create a function to display board
		public static void displayboard(char[][] board) {
			//print board 
			for(int i=0;i<3;i++) {
				System.out.println(" "+board[i][0]+" | "+board[i][1]+" | "+board[i][2]);
			
			if(i!=2) {
				System.out.println("---"+"|---|"+"---");
			}}
		}
		
    //check if the game won
    public static boolean checkgame(char[][]board,char player){

    //check rows first if they are the same
    for(int i=0;i<3;i++){
     if(board[i][0]==player && board[i][1]==player && board[i][2]==player){
    return true;
      }  
    }
    //check cols first if they are the same
    for(int i=0;i<3;i++){
    if(board[0][i]==player && board[1][i]==player && board[2][i]==player){
    return true;
      } }

      //check diagonal rows if they are the same
    if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
    return true;
    }

    //check diagonal cols if they are the same
    if(board[2][0]==player && board[1][1]==player && board[0][2]==player){
    return true;
    }
	return false;}}
    
   

