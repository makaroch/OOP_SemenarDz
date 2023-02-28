package DzCalc.Model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Сервер запущен!");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент тут!");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            while (true){
                String clientRec = dataInputStream.readUTF();
                if ("end".equals(clientRec)) break;
                calculator.inputExample(clientRec);
                String res = calculator.outputRes();
                dataOutputStream.writeUTF(res);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
