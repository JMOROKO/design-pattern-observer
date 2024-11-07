package obs;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private int state;
    @Override
    public void subscribe(Observer o) {
        // ajouter un observateur à la liste des observateur
        observers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        // retirer un observateur de la liste
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        // transmission du nouveau state à chaque observeur
        for(Observer o : observers){
            // o.update(state); // methode push
            // methode pull
            o.update(this);
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }
}
