package oscarblancarte.ipd.state.states;
import oscarblancarte.ipd.state.Server;

public class ShudingDownState extends AbstractServerState{


    public ShudingDownState(final Server server) {
       new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("Server is shutding down");
                    Thread.sleep(1000 * 10);
                    if (server.getMessageProcess().countMessage() < 1) {
                        server.setState(new StopServerState(server));
                    }
                    System.out.println("Server is shutdown");
                } catch (Exception e) {
                }
            }
        }
        ).start();
    }

    @Override
    public void handleMessage(Server server, String message) {
        System.out.println("The server is stoping, no more messages will be send");
    }
}
