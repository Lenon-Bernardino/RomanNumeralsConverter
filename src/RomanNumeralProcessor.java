import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumeralProcessor
{
    String[] romanNumerals = new String[] {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
    int[] arabicNumerals = new int[] {1,4,5,9,10,40,50,90,100,400,500,900,1000};
    public RomanNumeralProcessor()
    {

    }

    public boolean validate(String romanNumber)
    {
        String pattern = "[M|D|C|L|X|V|I]*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(romanNumber);

        return m.matches();
    }

    public List<Integer> getArabicEquivalents(String numeral)
    {
        List<Integer> arabicEquivalents = new ArrayList<Integer>();

        for(char inputRomanSymbol : numeral.toCharArray())
        {
            for(int j = 0; j < romanNumerals.length; j++)
            {
                String romanSymbol = romanNumerals[j];
                if(String.valueOf(inputRomanSymbol).equals(romanSymbol))
                {
                    arabicEquivalents.add(arabicNumerals[j]);
                }
            }
        }
        return arabicEquivalents;
    }
}
