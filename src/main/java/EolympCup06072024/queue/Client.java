package EolympCup06072024.queue;

public class Client {

    private int serviceTime;
    private int positionForGiveUp;

    public Client(int serviceTime, int positionForGiveUp) {
        this.serviceTime = serviceTime;
        this.positionForGiveUp = positionForGiveUp;
    }

    public Client(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public int getPositionForGiveUp() {
        return positionForGiveUp;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public void setPositionForGiveUp(int positionForGiveUp) {
        this.positionForGiveUp = positionForGiveUp;
    }
}
