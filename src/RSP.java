import java.util.Scanner;
class Player {
    private String name;
    private Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }
    public String getName() { return name; }
    public int turn() {
        System.out.print(name + "[가위(1), 바위(2), 보(3), 끝내기(4)]>>");
        return  scanner.nextInt();
    }
}
class Computer extends Player {
    public Computer(String name) {
        super(name);
    }
    public int turn() {
        return (int)(Math.random() * 3 + 1);
    }
}
public class RSP {
    private final String s[] = {"가위", "바위", "보"};
    private Player [] players = new Player[2];
    public RSP() {
        players[0] = new Player("철수");
        players[1] = new Computer("컴퓨터");
    }

    public void run() {
        int userChoice, computerChoice;
        while (true) {
            userChoice = players[0].turn(); // 철수 차례
            if (userChoice == 4)
                break;

            computerChoice = players[1].turn(); // 컴퓨터 차례

            if (userChoice < 1 || userChoice > 3) {
                System.out.println("잘못 입력하셨습니다.");
            }
            else {
                System.out.print(players[0].getName() + "(" + s[userChoice-1] + ")" + " : ");
                System.out.println(players[1].getName() + "(" + s[computerChoice-1] + ")");
                int diff = userChoice - computerChoice;
                switch (diff) {
                    case 0:
                        System.out.println("비겼습니다.");
                        break;
                    case -1:
                    case 2:
                        System.out.println(players[1].getName()+"가 이겼습니다.");
                        break;
                    case 1:
                    case -2:
                        System.out.println(players[0].getName()+"가 이겼습니다.");
                }
            }
        }
    }

    public static void main (String[] args) {
        RSP game = new RSP();
        game.run();
    }
}