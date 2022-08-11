package WineExe;

import java.util.Scanner;

import Wine.WineDAO;
import Wine.WineService;
import member.MemberManage;
import member.MemberService;

public class Application {

	Scanner scn = new Scanner(System.in);

	MemberService ms = new MemberService();

	public Application() {
		start();
	}

	private void start() {
		ms.doLogin();
		if (MemberService.memberInfo != null) {
			new ManageMent();
		}
	}
}
