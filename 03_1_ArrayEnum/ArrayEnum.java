import java.util.Scanner;
enum Command {ADD, LIST, SUM, MAX, MIN, QUIT, INVALID};

public class ArrayEnum {
    public static void main(String[] args) {
        int index = 0, values[] = new int[100];
        final Scanner scanner = new Scanner(System.in);

        while ( true ){
            final Command command = getCommand(scanner);
            if( command == Command.QUIT ){
                System.out.println("Bye!");
                break;
            }
            switch ( command ) {
                case ADD:
                    final int newValue = getValue(scanner);
                    values[index] = newValue;
                    index++;
                    break;
                case LIST:
                    printList(values, index);
                    break;
                case SUM:
                    System.out.println(getSum(values, index));
                    break;
                case MAX:
                    System.out.println(getMinMax(values, index, true));
                    break;
                case MIN:
                    System.out.println(getMinMax(values, index, false));
                    break;
                case INVALID:
                    System.out.println("Invalid Command");
                    break;
            }
        }
        scanner.close();
    }
    private static Command getCommand(final Scanner scanner){
        final String CmdName = scanner.next();

        Command cmd;
        try {
            cmd = Command.valueOf(CmdName.toUpperCase());
        }
        catch ( IllegalArgumentException e ){
            cmd = Command.INVALID;
        }
        return cmd;
    }
    private static int getValue(Scanner scanner){
        final int nextNum = scanner.nextInt();
        return nextNum;
    }
    private static void printList(int Arr[], int ArrIndex){
        for (int i = 0; i < ArrIndex; i++){
            System.out.printf("%d ", Arr[i]);
        }
        System.out.println();
    }
    private static int getSum(int Arr[], int ArrIndex){
        int sum = 0;
        for (int i = 0; i < ArrIndex; i++){
            sum += Arr[i];
        }
        return sum;
    }
    private static int getMinMax(int Arr[], int ArrIndex, boolean Option) {
        int MinMaxNum = Arr[0];
        if (Option){
            for (int i = 1; i < ArrIndex; i++) {
                MinMaxNum = Math.max(MinMaxNum, Arr[i]);
            }
        }
        else {
            for (int i = 1; i < ArrIndex; i++) {
                MinMaxNum = Math.min(MinMaxNum, Arr[i]);
            }
        }
        return MinMaxNum;
    }
}
