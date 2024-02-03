package jeu;
public class Affichage<T>{

        private T[][] tab;
        public static final String RED_BACKGROUND = "\u001B[41m";
        public static final String BLUE_BACKGROUND = "\u001B[44m";
        public static final String RESET = "\u001B[0m";

        public Affichage(T[][] tab) {
                this.tab = tab;
        }

        public void setTable(T[][] tab){
                this.tab = tab;
        }

        public void print(){
                System.out.println("                        {NOIR}\n     1     2     3     4     5     6     7     8   ");
                System.out.println("  \u2554"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2566"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2566"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2566"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2566"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2566"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550" +"\u2550"+ "\u2566"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2566"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2557");
                String line;
                for(int y = 0; y< tab.length; y++){
                        line = "" + (char)(y+'A') + " \u2551";
                        for(int x = 0; x<tab.length;x++){
                                if((y+x)%2==0) line+= RED_BACKGROUND;
                                else line += BLUE_BACKGROUND;
                                line+= "  ";
                                if(tab[y][x] == null)line+= " ";
                                else line += tab[y][x];
                                line+= "  "+ RESET +"\u2551";
                        }
                        System.out.println(line +" "+(char)(y+'A'));
                        if(y!=(tab.length -1))System.out.println("  "+"\u2560"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u256c"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u256c"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u256c"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u256c"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u256c"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550" +"\u2550"+ "\u256c"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u256c"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+"\u2563"+" ");
                        else System.out.println("  \u255a"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2569"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2569"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2569"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2569"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2569"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550" +"\u2550"+ "\u2569"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2569"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u2550"+ "\u255d");
                }
                System.out.println("     1     2     3     4     5     6     7     8    \n                       {BLANC}\n");
        }

        public static void clearScreen() {  
                System.out.print("\033[H\033[2J");  
                System.out.flush();  
        }
}
