package WineExe;

import java.util.Scanner;
import member.MemberService;

public class Application {

	Scanner scn = new Scanner(System.in);

	MemberService ms = new MemberService();

	public Application() {
		start();
	}

	private void start() {
		new ManageMent();
	}
}
