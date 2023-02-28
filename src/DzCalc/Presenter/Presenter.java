package DzCalc.Presenter;

import DzCalc.Model.Model;
import DzCalc.ui.Viem;


public class Presenter {

    private final Model model;
    private final Viem viem;
    private final Client client;

    public Presenter(Model model, Viem viem) {
        this.model = model;
        this.viem = viem;
        client = new Client();
        viem.setPresenter(this);
        model.setPresenter(this);
        client.setPresenter(this);
    }
    public void start(){
        viem.start();
    }
    public void inputtExample(String example) {
        client.sendToServerAndInput(example);
    }
    public void outputRes(String ex){
        viem.print(ex);
    }


}
