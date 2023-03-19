import java.util.Scanner;

class Player {
private String name; 
private char symbol;

public Player(String name, char symbol) {
setName(name); 
setSymbol(symbol);
}

public void setName(String name) {

if(!name.isEmpty()) {
this.name = name;
}
}

public String getName() {
return this.name;
}

public void setSymbol(char symbol) {
if(symbol != '\0') {
this. symbol = symbol;
}
}

public char getSymbol() {
return this.symbol;
}
}


class Board {
private char board[][];
private int boardSize = 3;
private char p1Symbol, p2Symbol;
private int count;
public final static int PLAYER1WINS = 1;
public final static int PLAYER2WINS = 2;
public final static int DRAW = 3;
public final static int INCOMPLETE = 4;
public final static int INVALIDMOVE = 5;
private static final char EMPTY = ' ';


public Board(char p1Symbol, char p2Symbol){
board = new char[boardSize][boardSize];
for(int i =0; i < boardSize; i++){
for(int j =0; j < boardSize; j++){
board[i][j] = ' ';
}
}
this.p1Symbol = p1Symbol;
this.p2Symbol = p2Symbol;
}
public int move(char symbol, int x, int y) {
if(x < 0 || x >= boardSize || y < 0 || y >= boardSize ||board[x][y] != EMPTY){
return INVALIDMOVE;
}

board[x][y] = symbol;
count++;

// Check Row
if(board[x][0] == board[x][1] && board[x][0] == board[x][2]){
return symbol == p1Symbol ? PLAYER1WINS :PLAYER2WINS;
}
// Check Col
if(board[0][y] == board[1][y] && board[0][y] == board[2][y]){
return symbol == p1Symbol ? PLAYER1WINS :PLAYER2WINS;
}
// First Diagonal
if(board[0][0] != EMPTY && board[0][0] == board[1][1] && board[0][0] == board[2][2]){
return symbol == p1Symbol ? PLAYER1WINS :PLAYER2WINS;
}
// Second Diagonal
if(board[0][2] != EMPTY && board[0][2] == board[1][1] && board[0][2] == board[2][0]){
return symbol == p1Symbol ? PLAYER1WINS :PLAYER2WINS;
}

if(count == boardSize * boardSize){
return DRAW;
}
return INCOMPLETE;
}
public void print() {
System.out.println("---------------");
for(int i =0; i < boardSize; i++){
for(int j =0; j < boardSize; j++){
System.out.print("| " + board[i][j] + " |");
}
System.out.println();
}
System.out.println();
System.out.println("---------------");
}
}



public class TicTacToe {

private Player player1, player2;
private Board board;
private int numPlayers;

public static void main(String args[]){
TicTacToe t = new TicTacToe();
t.startGame();
}

public void startGame(){
Scanner s = new Scanner(System.in);
// Take Players input
player1 = takePlayerInput(++numPlayers);
player2 = takePlayerInput(++numPlayers);
while(player1.getSymbol() == player2.getSymbol()){
System.out.println("Symbol Already taken !! Pick another symbol !!");
player2.setSymbol(s.next().charAt(0));
}

// Create the Board
board = new Board(player1.getSymbol(), player2.getSymbol());

// Play the game
boolean player1Turn = true;
int status = Board.INCOMPLETE;
while(status == Board.INCOMPLETE || status == Board.INVALIDMOVE){
if(player1Turn){
System.out.println("Player 1 - " + player1.getName() + "'s turn");
System.out.println("Enter x: ");
int x = s.nextInt();
System.out.println("Enter y: ");
int y = s.nextInt();

status = board.move(player1.getSymbol(), x, y);

if(status == Board.INVALIDMOVE){
System.out.println("Invalid move !! Please try again !!");
continue;
}
}
else{
System.out.println("Player 2 - " + player2.getName() + "'s turn");
System.out.println("Enter x: ");
int x = s.nextInt();
System.out.println("Enter y: ");

int y = s.nextInt();
status = board.move(player2.getSymbol(), x, y);

if(status == Board.INVALIDMOVE){
System.out.println("Invalid move !! Please try again !!");
continue;
}
}
player1Turn=!player1Turn;
board.print();
}
if(status == Board.PLAYER1WINS){
System.out.println("Player 1 - " + player1.getName() +" wins !!");

}else if(status == Board.PLAYER2WINS){
System.out.println("Player 2 - " + player2.getName() +" wins !!");
} else {
System.out.println("Draw !!");
}
}

private Player takePlayerInput(int num){
Scanner s = new Scanner(System.in);
System.out.println("Enter Player " + num + " name: ");
String name = s.nextLine();
System.out.println("Enter Player " + num + " symbol: ");
char symbol = s.next().charAt(0);
Player p = new Player(name, symbol);
return p;
}
}
