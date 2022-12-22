import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        NumeralConverter converter = new NumeralConverter();
        while(true)
        {
            System.out.print("\n============================================================\n");
            System.out.print("\nType exit then press enter to exit");
            System.out.print("\nType a roman numeral to convert it to arabic");
            System.out.print("\nType an arabic numeral to convert it to roman");
            System.out.print("\nNumber goes here: ");
            String command = sc.nextLine();

            if(command.equals("exit"))
            {
                break;
            }
            else
            {
                System.out.println(converter.convert(command));
            }
        }
    }
}
