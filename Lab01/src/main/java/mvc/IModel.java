package mvc;

public interface IModel {
    void addView(IView view);

    void changed();
}
