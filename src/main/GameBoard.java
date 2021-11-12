package main;

public class GameBoard {
    private Position[] board = new Position[40];

    public GameBoard() {
        board[0] = new Position("Go");
        board[1] = new Land("Mediterranean Avenue", "Brown", 60, 30, 2,
                10, 30, 90, 160, 250,
                50, 50);
        board[2] = new Position("Community Chest");
        board[3] = new Land("Baltic Avenue","Brown", 60, 30, 4,
                20, 60, 180, 320, 450,
                50, 50);
        board[4] = new Position("Income Tax");
        board[5] = new RailRoad("Reading Railroad", 200, 100, 25,
                50, 100, 200);
        board[6] = new Land("Oriental Avenue", "Turquoise", 100, 50, 6,
                30, 90, 270, 400, 550,
                50, 50);
        board[7] = new Position("Chance");
        board[8] = new Land("Vermont Avenue", "Turquoise", 100, 50, 6,
                30, 90, 270, 400, 550,
                50, 50);
        board[9] = new Land("Connecticut Avenue", "Turquoise", 120, 60, 8,
                40, 100, 300, 450, 600,
                50, 50);
        board[10] = new Position("Jail");
        board[11] = new Land("St. Charles Place", "Pink", 140, 70, 10,
        50, 150, 450, 625, 750,
        100, 100);
        board[12] = new Utility("Electric Company", 150, 75);
        board[13] = new Land("States Avenue", "Pink", 140, 70, 10,
                50, 150, 450, 625, 750,
                100, 100);
        board[14] = new Land("Virginia Avenue" , "Pink", 160, 80, 12,
                60, 180, 500, 700, 900,
                100, 100);
        board[15] = new RailRoad("Pennsylvania Railroad", 200, 100, 25,
                50, 100, 200);
        board[16] = new Land("St. James Place", "Orange", 180, 90, 14,
                70, 200, 550, 750, 950,
                100, 100);
        board[17] = new Position("Community Chest");
        board[18] = new Land("Tennessee Avenue", "Orange", 180, 90, 14,
                70, 200, 550, 750, 950,
                100, 100);
        board[19] = new Land("New York Avenue", "Orange", 200, 100, 16,
                80, 220, 600, 800, 1000,
                100, 100);
        board[20] = new Position("Free Parking");
        board[21] = new Land("Kentucky Avenue", "Red", 220, 110, 18,
                90, 250, 700, 875, 1050,
                150, 150);
        board[22] = new Position("Chance");
        board[23] = new Land("Indiana Avenue", "Red", 220, 110, 18,
                90, 250, 700, 875, 1050,
                150, 150);
        board[24] = new Land("Illinois Avenue", "Red", 240, 120, 20,
                100, 300, 750, 925, 1100,
                150, 150);
        board[25] = new RailRoad("B. & O. Railroad", 200, 100, 25,
                50, 100, 200);
        board[26] = new Land("Atlantic Avenue", "Yellow", 260, 130, 22,
                110, 330, 800, 975, 1150,
                150, 150);
        board[27] = new Land("Ventnor Avenue", "Yellow", 260, 130, 22,
                110, 300, 800, 975, 1150,
                150, 150);
        board[28] = new Utility("Water Works", 150, 75);
        board[29] = new Land("Marvin Gardens", "Yellow", 280, 140, 24,
                120, 360, 850, 1025, 1200,
                150, 150);
        board[30] = new Position("Go To Jail");
        board[31] = new Land("Pacific Avenue", "Green", 300, 150, 26,
                130, 390, 900, 1100, 1275,
                200, 200);
        board[32] = new Land("North Carolina Avenue", "Green", 300, 150, 26,
                130, 390, 900, 1100, 1275,
                200, 200);
        board[33] = new Position("Community Chest");
        board[34] = new Land("Pennsylvania Avenue", "Green", 320, 160, 28,
                150, 450, 1000, 1200, 1400,
                200, 200);
        board[35] = new RailRoad("Short Line", 200, 100, 25,
                50, 100, 200);
        board[36] = new Position("Chance");
        board[37] = new Land("Park Place", "Blue", 350, 175, 35,
                175, 500, 1100, 1300, 1500,
                200, 200);
        board[38] = new Position("Luxury Tax");
        board[39] = new Land("Boardwalk", "Blue", 400, 200, 50,
                200, 600, 1400, 1700, 2000,
                200, 200);
    }

    public Position getPosition(int num){
        return this.board[num];
    }

    public void checkMonopoly(int index){
       if (this.getPosition(index) instanceof Utility){
           if (((Utility) this.getPosition(12)).getOwner() == ((Utility) this.getPosition(28)).getOwner()){
               ((Utility) this.getPosition(12)).setMonopoly(true);
               ((Utility) this.getPosition(28)).setMonopoly(true);
           }
           else return;
       }
       else if (this.getPosition(index) instanceof RailRoad){
           Player p1 = ((RailRoad) this.getPosition(5)).getOwner();
           Player p2 = ((RailRoad) this.getPosition(15)).getOwner();
           Player p3 = ((RailRoad) this.getPosition(25)).getOwner();
           Player p4 = ((RailRoad) this.getPosition(25)).getOwner();
           if (p1 == p2 && p2 == p3 && p3 == p4){
               ((RailRoad) this.getPosition(5)).setMonopoly(true);
               ((RailRoad) this.getPosition(15)).setMonopoly(true);
               ((RailRoad) this.getPosition(25)).setMonopoly(true);
               ((RailRoad) this.getPosition(35)).setMonopoly(true);
           }
           else return;
       }
       else if (this.getPosition(index) instanceof Land){
           if (((Land) this.getPosition(index)).getColor() == "Brown"){
               if (((Land) this.getPosition(1)).getOwner() == ((Land) this.getPosition(3)).getOwner()){
                   ((Land) this.getPosition(1)).setMonopoly(true);
                   ((Land) this.getPosition(3)).setMonopoly(true);
               }
               else return;
           }
           else if (((Land) this.getPosition(index)).getColor() == "Turquoise"){
               Player P1 = ((Land) this.getPosition(6)).getOwner();
               Player P2 = ((Land) this.getPosition(8)).getOwner();
               Player P3 = ((Land) this.getPosition(9)).getOwner();
               if (P1 == P2 && P2 == P3){
                   ((Land) this.getPosition(6)).setMonopoly(true);
                   ((Land) this.getPosition(8)).setMonopoly(true);
                   ((Land) this.getPosition(9)).setMonopoly(true);
               }
               else return;
           }
           else if (((Land) this.getPosition(index)).getColor() == "Pink"){
               Player p1 = ((Land) this.getPosition(11)).getOwner();
               Player p2 = ((Land) this.getPosition(13)).getOwner();
               Player p3 = ((Land) this.getPosition(14)).getOwner();
               if (p1 == p2 && p2 == p3){
                   ((Land) this.getPosition(11)).setMonopoly(true);
                   ((Land) this.getPosition(13)).setMonopoly(true);
                   ((Land) this.getPosition(14)).setMonopoly(true);
               }
               else return;
           }
           else if (((Land) this.getPosition(index)).getColor() == "Orange") {
               Player p1 = ((Land) this.getPosition(16)).getOwner();
               Player p2 = ((Land) this.getPosition(18)).getOwner();
               Player p3 = ((Land) this.getPosition(19)).getOwner();
               if (p1 == p2 && p2 == p3) {
                   ((Land) this.getPosition(16)).setMonopoly(true);
                   ((Land) this.getPosition(18)).setMonopoly(true);
                   ((Land) this.getPosition(19)).setMonopoly(true);
               } else return;
           }
           else if (((Land) this.getPosition(index)).getColor() == "Red") {
               Player p1 = ((Land) this.getPosition(21)).getOwner();
               Player p2 = ((Land) this.getPosition(23)).getOwner();
               Player p3 = ((Land) this.getPosition(24)).getOwner();
               if (p1 == p2 && p2 == p3) {
                   ((Land) this.getPosition(21)).setMonopoly(true);
                   ((Land) this.getPosition(23)).setMonopoly(true);
                   ((Land) this.getPosition(24)).setMonopoly(true);
               } else return;
           }
           else if (((Land) this.getPosition(index)).getColor() == "Yellow") {
               Player p1 = ((Land) this.getPosition(26)).getOwner();
               Player p2 = ((Land) this.getPosition(27)).getOwner();
               Player p3 = ((Land) this.getPosition(29)).getOwner();
               if (p1 == p2 && p2 == p3) {
                   ((Land) this.getPosition(26)).setMonopoly(true);
                   ((Land) this.getPosition(27)).setMonopoly(true);
                   ((Land) this.getPosition(29)).setMonopoly(true);
               } else return;
           }
           else if (((Land) this.getPosition(index)).getColor() == "Green") {
               Player p1 = ((Land) this.getPosition(31)).getOwner();
               Player p2 = ((Land) this.getPosition(32)).getOwner();
               Player p3 = ((Land) this.getPosition(34)).getOwner();
               if (p1 == p2 && p2 == p3) {
                   ((Land) this.getPosition(31)).setMonopoly(true);
                   ((Land) this.getPosition(32)).setMonopoly(true);
                   ((Land) this.getPosition(34)).setMonopoly(true);
               } else return;
           }
           else if (((Land) this.getPosition(index)).getColor() == "Blue") {
               Player p1 = ((Land) this.getPosition(37)).getOwner();
               Player p2 = ((Land) this.getPosition(39)).getOwner();
               if (p1 == p2 ) {
                   ((Land) this.getPosition(37)).setMonopoly(true);
                   ((Land) this.getPosition(39)).setMonopoly(true);
               } else return;
           }
           else return;
       }
       else return;
    }


}
