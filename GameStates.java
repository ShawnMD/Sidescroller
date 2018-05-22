
public class GameStates {

    public static boolean MENU = false;
    public static boolean PLAY = false;
    public static boolean PAUSE = false;
    public static boolean END = false;
    public static int DISTANCE = 4000;
    public static boolean DEAD = false;

    public static boolean isMENU(){
        return MENU;
    }

    public static void setMENU(boolean MENU){
        GameStates.MENU = MENU;
    }

    public static boolean isPLAY(){
        return PLAY;
    }

    public static void setPLAY(boolean PLAY){
        GameStates.PLAY = PLAY;
    }

    public static boolean isPAUSE(){
        return PAUSE;
    }

    public static void setPAUSE(boolean PAUSE){
        GameStates.PAUSE = PAUSE;
    }

    public static boolean isEND(){
        return END;
    }

    public static void setEND(boolean END){
        GameStates.END = END;
    }

    public static int getDISTANCE(){
        return DISTANCE;
    }

    public static void setDISTANCE(int DISTANCE){
        GameStates.DISTANCE = DISTANCE;
    }
}
