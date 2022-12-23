import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanValidator
{
    public RomanValidator()
    {

    }

    public boolean validate(String numeral) // Check the validity of a roman numeral input
    {
        String pattern = "[M|D|C|L|X|V|I]*"; // A pattern for checking if it only contains valid roman symbols
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(numeral);

        return m.matches(); // Return the matches
    }
}
