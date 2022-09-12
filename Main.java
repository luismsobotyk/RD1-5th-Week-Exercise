import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InetAddress host = null;
        int port = 5000;
        try {
            host = InetAddress.getByName("moodle.inf.poa.ifrs.edu.br");
        } catch (UnknownHostException e) {
            System.out.println("Host não existe");
        }
        GreetClient client = new GreetClient();
        try {
            assert host != null;
            client.startConnection(host.getHostAddress(), port);
        } catch (IOException e) {
            System.out.println("Erro na Conexão");
        } finally {
            assert host != null;
            System.out.println("Conexão estabelecida, IP= " + host.getHostAddress() + ":" + port);
        }

        String text = scanner.next();
        String response = null;

        try {
            response = client.sendMessage(text);
        } catch (IOException e) {
            System.out.println("Erro desconhecido");
        } finally {
            System.out.println(response);
        }
    }

}
