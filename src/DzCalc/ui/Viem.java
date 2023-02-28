package DzCalc.ui;

import DzCalc.Presenter.Presenter;

public interface Viem {
    void setPresenter(Presenter presenter);
    void start();
    void print(String text);
}
