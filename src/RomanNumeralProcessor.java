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

    public List<Integer> getArabicEquivalents(String numeral) // Get arabic equivalent of each roman symbol in the input
    {
        List<Integer> arabicEquivalents = new ArrayList<Integer>();

        for(char inputRomanSymbol : numeral.toCharArray()) // Get each roman symbol  from the input
        {
            for(int j = 0; j < romanNumerals.length; j++) // For each one, go in the roman numerals array
            {
                String romanSymbol = romanNumerals[j];
                if(String.valueOf(inputRomanSymbol).equals(romanSymbol)) // When it finds itself in the array
                {
                    arabicEquivalents.add(arabicNumerals[j]); // Then add it to the arabic equivalent list
                }
            }
        }
        return arabicEquivalents;
    }

    public int ArabicListToRoman(List<Integer> arabicEquivalents) // Process the list of arabic equivalents of roman symbols
    {
        int running_total = 0;
        for(int j = 0; j < arabicEquivalents.size(); j++) // Iterate through the list of equivalents
        {
            if(j == arabicEquivalents.size()-1 || arabicEquivalents.get(j) >= arabicEquivalents.get(j + 1))
            { // If the current numeral is bigger or equal to the next, or it's the last one
                running_total += arabicEquivalents.get(j); // then simply add it to the running total
            }
            else
            { // Otherwise, as per the subtraction rule, subtract the current one from the next, then skip one iteration
                running_total += arabicEquivalents.get(j+1) - arabicEquivalents.get(j);
                j++;
            }
        }
        return running_total;
    }

    public String ArabicToRoman(int number)
    {
        StringBuilder finalRomanNumeral = new StringBuilder(); // For building the final roman numeral
        int i = 12; // for iterating through the arabic numeral array
        int division = 0;
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
        return finalRomanNumeral.toString();
    }
}
