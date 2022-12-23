import java.util.List;
import java.util.Objects;

public class NumeralConverter
{
    String[] romanNumerals = new String[] {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"}; // Roman numerals for later referencing
    int[] arabicNumerals = new int[] {1,4,5,9,10,40,50,90,100,400,500,900,1000}; // Arabic equivalents of the roman numerals array
    RomanNumeralProcessor RomanProcessor = new RomanNumeralProcessor();
    public String convert(String numeral)
    {
        int i;
        int number; // For input numeral converted to integer
        int division = 0; // For dividing numbers in arabic to roman conversion algorithm

        StringBuilder finalRomanNumeral = new StringBuilder();
        String arabicValidation = RomanProcessor.validateArabic(numeral);

        if(Objects.equals(arabicValidation, "ok"))
        {
            number = Integer.parseInt(numeral);
            i = 12; // for iterating through the arabic numeral array
            while(number > 0) // do until the division has no remainder
            {
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
        else if(!Objects.equals(arabicValidation, "0"))
        {
            return arabicValidation;
        }

        List<Integer> arabicEquivalents; // List of the arabic equivalent of each roman symbol in the user input numeral

        if(RomanProcessor.validateRoman(numeral)) // If it's a valid roman numeral
        {
            arabicEquivalents = RomanProcessor.getArabicEquivalents(numeral);
            int result = RomanProcessor.ArabicListToRoman(arabicEquivalents);
            return(numeral + " represented in the arabic system: " + result);
        }
        return("Invalid number, please try again.");
    }
}
