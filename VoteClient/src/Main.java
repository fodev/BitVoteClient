import java.net.Socket;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String token="";
		try {
			Socket client=new Socket("localhost",5555);
			ChatAgent agent=new ChatAgent(client);
			agent.start();//�޽����� ����о�´�.
			while(agent.sw!=1){
				System.out.print("���̵� : ");
				String userId=sc.nextLine();

				System.out.print("�н����� : ");
				String userPwd=sc.nextLine();
				token="F1:"+userId+":"+userPwd;
				agent.writeMsg(token);
				Thread.sleep(1000);
			}

			String bno="";
			while(true){
				if(agent.sw2!=1){
				if(bno.equals("")){//���� ��ǥ�� �������� �ʾ�����.
					System.out.println("��ǥ�� ��ȣ�� �Է�");
					bno=sc.nextLine();
					token="F2:"+bno;
				}else{
					System.out.println("�������� ��ǥ�� �Ͻðڽ��ϱ�?");
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
