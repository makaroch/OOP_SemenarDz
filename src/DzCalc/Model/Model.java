package DzCalc.Model;

import DzCalc.Presenter.Presenter;

public interface Model {
    void setPresenter(Presenter presenter);
    void inputExample(String example);
    String outputRes();
}
