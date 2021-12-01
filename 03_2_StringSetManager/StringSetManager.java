import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum StringCommand { ADD, REMOVE, CLEAN, QUIT, INVALID};
public class StringSetManager {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] stringSet = new String[100];
        while ( true ){
            final StringCommand command = getCommand(scanner);
            if ( command == StringCommand.QUIT ){
                System.out.println("BYE!"); break;
            }
            switch ( command ){
                case ADD: {
                    final String str = getString(scanner);
                    add(stringSet, str);
                    break;
                }
                case REMOVE: {
                    final String str = getString(scanner);
                    remove(stringSet, str);
                    break;
                }
                case CLEAN: {
                    clear(stringSet);
                    break;
                }
                default:
                    System.out.println("Unknown Command!");
                    break;
            }
            print(stringSet);
        }
    }
    private static StringCommand getCommand(final Scanner scanner){
        String str = scanner.next();
        StringCommand strCommand;
        try {
            strCommand = StringCommand.valueOf(str.toUpperCase());
        }
        catch (IllegalArgumentException e){
            strCommand = StringCommand.INVALID;
        }
        return strCommand;
    }
    private static String getString(final Scanner scanner){
        String str = scanner.next();
        return str;
    }
    private static void add(String[] strArr, String str){
        for (int i = 0; i < strArr.length; i++){
            if (strArr[i] == null){
                strArr[i] = str;
                break;
            }
            else if (strArr[i].equals(str))
                break;
        }
    }
    private static void remove(String[] strArr, String str){
        List<String> strList = new ArrayList<>(Arrays.asList(strArr));
        int index = strList.indexOf(str);
        if(index == -1)
            return ;
        for (int i = index; i < strArr.length-1; i++){
            strArr[i] = strArr[i+1];
        }
        strArr[strArr.length-1] = null;
    }
    private static void clear(String[] strArr){
        for (int i = 0; i < strArr.length; i++)
            strArr[i] = null;
    }
    private static void print(String[] strArr){
        List<String> strList = new ArrayList<>();
        int index = 0;
        while (true){
            if (strArr[index] == null)
                break;
            strList.add(strArr[index]);
            index++;
        }
        System.out.println("Element Size: " + index + ", Values = " + strList.toString());
    }
}
