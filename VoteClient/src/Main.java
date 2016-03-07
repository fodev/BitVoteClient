import java.net.Socket;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String token="";
		try {
			Socket client=new Socket("localhost",5555);
			ChatAgent agent=new ChatAgent(client);
			agent.start();//메시지를 계속읽어온다.
			while(agent.sw!=1){
				System.out.print("아이디 : ");
				String userId=sc.nextLine();

				System.out.print("패스워드 : ");
				String userPwd=sc.nextLine();
				token="F1:"+userId+":"+userPwd;
				agent.writeMsg(token);
				Thread.sleep(1000);
			}

			String bno="";
			while(true){
				if(agent.sw2!=1){
				if(bno.equals("")){//아직 투표를 선택하지 않았으면.
					System.out.println("투표할 번호를 입력");
					bno=sc.nextLine();
					token="F2:"+bno;
				}else{
					System.out.println("누구에게 투표를 하시겠습니까?");
					token="F3:"+bno+":"+sc.nextLine();
					bno="";
				}
				agent.writeMsg(token);
				Thread.sleep(1000);
				}else{
					break;	
				}
			}
		} catch (Exception e){

		}

	}
}
