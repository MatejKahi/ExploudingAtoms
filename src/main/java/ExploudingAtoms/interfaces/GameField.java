package ExploudingAtoms.interfaces;

public class GameField {
    private int Occupancy;
    private int Player;

    public int getOccupancy() {
        return Occupancy;
    }

    public void setOccupancy(int occupancy) {
Occupancy = occupancy;
    }

    public int getPlayer() {
        return Player;
    }

    public void setPlayer(int player) {
        Player = player;
    }

}
