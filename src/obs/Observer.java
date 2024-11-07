package obs;

public interface Observer {
    //technique push
    // void update(int newState);

    // technique pop
    void update(Observable o);
}
