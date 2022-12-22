import java.util.ArrayList;
import java.util.List;

public class NumeralConverter
{
    String[] romanNumerals = new String[] {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
    int[] arabicNumerals = new int[] {1,4,5,9,10,40,50,90,100,400,500,900,1000};
    RomanNumeralProcessor validator = new RomanNumeralProcessor();
    public String convert(String numeral)
    {
        int i;
        int number;
        int division = 0;
        List<Integer> arabicEquivalents = new ArrayList<Integer>();
        StringBuilder finalRomanNumeral = new StringBuilder();
        if (numeral.matches("[0-9]+")) // it's arabic
        {
            try
            {
                number = Integer.parseInt(numeral);
            }
            catch(Exception e)
            {
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
            i = 12;
            while(number > 0)
            {
                System.out.println("Number: " + number);
                System.out.println("Division: " + division);
                division = number/arabicNumerals[i];
                number = number%arabicNumerals[i];
                while(division > 0)
                {
                    finalRomanNumeral.append(romanNumerals[i]);
                    division--;
                }
                i--;
            }
            return(numeral + " represented in the roman system: " + finalRomanNumeral);
        }
        if(validator.validate(numeral)) // If it's a valid roman numeral
        {
            arabicEquivalents = validator.getArabicEquivalents(numeral);
            int running_total = 0;
            for(int j = 0; j < arabicEquivalents.size(); j++)
            {
                if(j == arabicEquivalents.size()-1 || arabicEquivalents.get(j) >= arabicEquivalents.get(j + 1))
                {
                    running_total += arabicEquivalents.get(j);
                }
                else
                {
                    running_total += arabicEquivalents.get(j+1) - arabicEquivalents.get(j);
                    j++;
                }
            }
            return(numeral + " represented in the arabic system: " + running_total);
        }
        return("Invalid number, please try again.");
    }
}
