import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanValidator
{
    public RomanValidator()
    {

    }

    public boolean validate(String numeral)
    {
        String pattern = "[M|D|C|L|X|V|I]*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(numeral);

        return m.matches();
    }
}
