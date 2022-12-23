import java.util.List;
import java.util.Objects;

public class NumeralConverter
{
    String[] romanNumerals = new String[] {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"}; // Roman numerals for later referencing
    int[] arabicNumerals = new int[] {1,4,5,9,10,40,50,90,100,400,500,900,1000}; // Arabic equivalents of the roman numerals array
    RomanNumeralProcessor romanNumeralProcessor = new RomanNumeralProcessor(); // Processing of roman numerals
    ArabicValidator arabicValidator = new ArabicValidator(); // Check the validity of arabic numeral input
    RomanValidator romanValidator = new RomanValidator(); // Check the validity of roman numeral input
    public String convert(String numeral)
    {
        int number; // For input numeral converted to integer

        String arabicValidation = arabicValidator.validate(numeral);

        if(Objects.equals(arabicValidation, "ok")) // If it outputs ok, it means it's valid
        {
            number = Integer.parseInt(numeral);
            return(numeral + " represented in the roman system: " + romanNumeralProcessor.ArabicToRoman(number));
        }
        else if(!Objects.equals(arabicValidation, "0")) // If it outputs 0, do nothing
        {
            return arabicValidation; // If it's not 0 or ok, then it means it's not valid at all, return its error message
        }

        List<Integer> arabicEquivalents; // List of the arabic equivalent of each roman symbol in the user input numeral

        if(romanValidator.validate(numeral)) // If it's a valid roman numeral
        {
            arabicEquivalents = romanNumeralProcessor.getArabicEquivalents(numeral); // Get arabic equivalent of each roman symbol into a list
            int result = romanNumeralProcessor.ArabicListToRoman(arabicEquivalents); // Process the list into an arabic numeral
            return(numeral + " represented in the arabic system: " + result); // Output it into the main function
        }
        return("Invalid number, please try again."); // Nothing worked, it was a completely invalid input
    }
}
