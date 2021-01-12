import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // variable initialization
        byte variableByte = -14;
        short variableShort = 12542;
        int variableInt = 16000000;
        long variableLong = 234L;
        float variableFloat = 123.25f;
        double variableDouble = 10.2;
        char variableChar = '\uf031';
        boolean variableBoolean = true;

        // start text user interface
        UI ui = new UI(scanner);
        ui.start();
        scanner.close();
    }
}
