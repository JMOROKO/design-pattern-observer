package obs;

//creation de l'observateur
public class ObserverImpl1 implements Observer {
    /*@Override //methode push
    public void update(int newState) {
        System.out.println("************** Observable IMPL 1*******************");
        System.out.println("New state = "+newState);
        System.out.println("************** Observable IMPL 1*******************");
    }*/
    // utilisation de la technique pull
    @Override
    public void update(Observable observable) {
        if(observable instanceof ObservableImpl obs){
            System.out.println("************** Observable IMPL 1*******************");
            //System.out.println("New state = "+((ObservableImpl) observable).getState());
            System.out.println("New state = "+obs.getState()); // les deux sont identique
            System.out.println("************** Observable IMPL 1*******************");
        }
    }
}
