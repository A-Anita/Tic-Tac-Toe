import java.util.Scanner;
public class Tictactoe{
    public static String tictacboard[][]={{"00","01","02"},{"10","11","12"},{"20","21","22"}};
    public static int playercount=0;

    public static void print(){
        for(int i=0;i<tictacboard.length;i++){
            for(int j=0;j<tictacboard[i].length;j++){
                System.out.print(tictacboard[i][j]+" | ");
            }
            System.out.println();
        }

    }
    public static void greet(Scanner s){
        int x=0;
        int y=0;
        System.out.println(playercount%2==0?"player X":"player O");
        System.out.print("Enter X value:");
        x=s.nextInt();
        System.out.print("Enter Y value:");
        y=s.nextInt();
        System.out.println(insert(x,y,playercount%2==0?"X":"O"));
    }
    public static String insert(int x,int y,String playerName){
        if((x<3&&x>=0)&&(y<3&&y>=0)){
           if(!tictacboard[x][y].equals("X")&&!tictacboard[x][y].equals("O")){
            tictacboard[x][y]=playerName;
            print();
            playercount++;
            if(check()){
                System.out.println(playerName+"wins!!");
                System.exit(0);
            }else if(playercount==9){
                System.out.println("It is a Draw!");
                System.exit(0);
            }
            return "inserted";
           }
        }
        else{
            return "Already Occupied";
        }
        return "Unexpected place";
    }
    public static boolean check(){
        //row
        for(int i=0;i<3;i++){
            if(tictacboard[i][0].equals(tictacboard[i][1])
            &&tictacboard[i][1].equals(tictacboard[i][2])
            &&!tictacboard[i][0].equals(""))
            return true;
        }
        //column
        for(int i=0;i<3;i++){
            if(tictacboard[0][i].equals(tictacboard[1][i])
            &&tictacboard[1][i].equals(tictacboard[2][i])
            &&!tictacboard[0][i].equals(""))
            return true;
        }
        //diagnonal
        if(tictacboard[0][2].equals(tictacboard[1][1])
        &&tictacboard[1][1].equals(tictacboard[2][0])
        &&!tictacboard[0][2].equals("")){
        return true;
        }
        if(tictacboard[0][0].equals(tictacboard[1][1])
        &&tictacboard[1][1].equals(tictacboard[2][2])
        &&!tictacboard[0][0].equals("")){
        return true;
        }
        return false;
    }


    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
       while(true){
        greet(s);
       }

    }
}