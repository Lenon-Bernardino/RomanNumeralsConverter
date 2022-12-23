import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArabicValidator
{
    public ArabicValidator()
    {

    }

    public String validate(String numeral) // Check the validity of an arabic input
    {
        int number;
        if (numeral.matches("[0-9]+")) // It only contains numbers
        {
            try
            {
                number = Integer.parseInt(numeral); // Check if it can be converted to integer
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                return "Invalid number, please try again."; // If not, it might be too big
            }

            if(numeral.equals("0")) // There's no roman numeral for the number 0
            {
                return("The roman system did not need any value to represent zero. But instead of zero, the word nulla was used by the Romans to specify zero.");
            }
            if(number > 3999) // Romans didn't count up to more than 3999 with this numeral system
            {
                return("The roman system can only represent numbers up to 3999");
            }

            return("ok");
        }
        return("0");
    }
}
