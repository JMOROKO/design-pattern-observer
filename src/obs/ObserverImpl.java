package obs;

import java.util.ArrayList;
import java.util.List;


// observateur numéro deux
public class ObserverImpl implements Observer {
    private List<Integer> historique = new ArrayList<>();
    /*@Override // methode push
    public void update(int newState) {
        historique.add(newState);
        double sum = 0;

        for(int i = 0; i<=historique.size(); i++){
            sum+= historique.get(i);
        }
        System.out.println("************** Observable IMPL 2*******************");
        System.out.println("Moyenne = "+sum/historique.size());
        System.out.println("************** Observable IMPL 2*******************");
    }*/
    // methode pull
    @Override
    public void update(Observable observable) {
        historique.add(((ObservableImpl) observable).getState());
        double sum = 0;

        for(int i = 0; i<=historique.size(); i++){
            sum+= historique.get(i);
        }
        System.out.println("************** Observable IMPL 2*******************");
        System.out.println("Moyenne = "+sum/historique.size());
        System.out.println("************** Observable IMPL 2*******************");
    }
}
