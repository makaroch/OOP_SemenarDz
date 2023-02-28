package DzCalc.Presenter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private Presenter presenter;

    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }
    public void sendToServerAndInput(String example) {
        try (Socket socket = new Socket("localhost", 8080)) {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream.writeUTF(example);
            presenter.outputRes(dataInputStream.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
