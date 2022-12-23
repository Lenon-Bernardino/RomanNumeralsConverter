import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArabicValidator
{
    public ArabicValidator()
    {

    }

    public String validate(String numeral)
    {
        int number;
        if (numeral.matches("[0-9]+")) // it's arabic
        {
            try
            {
                number = Integer.parseInt(numeral);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                return "Invalid number, please try again.";
            }

            if(numeral.equals("0"))
            {
                return("The roman system did not need any value to represent zero. But instead of zero, the word nulla was used by the Romans to specify zero.");
            }
            if(number > 3999)
            {
                return("The roman system can only represent numbers up to 3999");
            }

            return("ok");
        }
        return("0");
    }
}
