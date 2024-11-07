import obs.*;

public class Main {
    public static void main(String[] args) {
        ObservableImpl observable = new ObservableImpl();

        Observer o1 = new ObserverImpl1();
        Observer o2 = new ObserverImpl();

        //souscription aux observateur
        observable.subscribe(o1);
        //observable.subscribe(o2);


        observable.setState(60);

        //creation d'un observateur anonyme (c'est l'objet d'une interface) pour le
        // creer ont est obligé de redéfinir l'implémentation de set intervale
        observable.subscribe(new Observer(){
            /*@Override //methode push
            public void update(int newState) {
                System.out.println("+++++++++++ Obs impl 3+++++++++++");
                System.out.println("Res "+newState * Math.cos(newState));
                System.out.println("+++++++++++ Obs impl 3+++++++++++");
            }*/
            // methode pull
            @Override
            public void update(Observable o) {
                if(o instanceof ObservableImpl obs){
                    System.out.println("+++++++++++ Obs impl 3+++++++++++");
                    System.out.println("Res "+ obs.getState() * Math.cos(obs.getState()));
                    System.out.println("+++++++++++ Obs impl 3+++++++++++");
                }

            }
        });
        // écriture lambda
        // methode push
        /*observable.subscribe(newState -> {
            System.out.println("+++++++++++ Obs impl 3+++++++++++");
            System.out.println("Res "+newState * Math.cos(newState));
            System.out.println("+++++++++++ Obs impl 3+++++++++++");
        });*/
        // écriture lambda
        // methode pull
        observable.subscribe(obs -> {
            if(obs instanceof ObservableImpl o ){
                System.out.println("+++++++++++ Obs impl 3+++++++++++");
                System.out.println("Res "+o.getState() * Math.cos(o.getState()));
                System.out.println("+++++++++++ Obs impl 3+++++++++++");
            }

        });

    }
}