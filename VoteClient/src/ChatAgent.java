

import java.net.Socket;
import java.util.List;

public class ChatAgent extends AbstractAgent {
	int sw,sw2;
	public ChatAgent(Socket socket) throws Exception {
		super(socket);
		sw=0;
		sw2=0;
	}

	@Override
	protected void execute() throws Exception {
		String msg=readMsg();
		if(msg.startsWith("로그인")){
			sw=1;
		}
		if(msg.startsWith("참여가능한")){
			sw2=1;
		}
		System.out.println(msg);
	}

}
