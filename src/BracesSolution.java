import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BracesSolution {
	 static Pattern curly = Pattern.compile("\\{\\}");
		static Pattern square = Pattern.compile("\\[\\]");
		static Pattern round = Pattern.compile("\\(\\)");

		static String[] Braces(String[] values)
		{
			String[] result = new String[values.length];

			for (int i = 0; i < values.length; i++)
			{
				String input = values[i];
				result[i] = isMatching(input) ? "YES" : "NO";
			}

			return result;
		}

		static boolean isMatching(String input)
		{
			System.err.println("checking " + input);

			//empty or unbalanced string
			if (input == null || (input.length() & 1) != 0)
			{
				return false;
			}

			//now start removing matched brackets
			do
			{
				Matcher curlyFinder = curly.matcher(input);
				Matcher squareFinder = square.matcher(input);
				Matcher roundFinder = round.matcher(input);

				if (curlyFinder.find())
				{
					input = curlyFinder.replaceAll("");
				}
				else if (squareFinder.find())
				{
					input = squareFinder.replaceAll("");
				}
				else if (roundFinder.find())
				{
					input = roundFinder.replaceAll("");
				}
				else if (input.length() > 0)
				{
					break;
				}
			}
			while (input.length() > 0);

			return input.isEmpty() ? true : false;
	    }

		public static void main(String[] args) throws IOException{
	        Scanner in = new Scanner(System.in);
	        final String fileName = System.getenv("OUTPUT_PATH");
	        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
	        String[] res;
	        
	        int _values_size = 0;
	        _values_size = Integer.parseInt(in.nextLine());
	        String[] _values = new String[_values_size];
	        String _values_item;
	        for(int _values_i = 0; _values_i < _values_size; _values_i++) {
	            try {
	                _values_item = in.nextLine();
	            } catch (Exception e) {
	                _values_item = null;
	            }
	            _values[_values_i] = _values_item;
	        }
	        
	        res = Braces(_values);
	        for(int res_i=0; res_i < res.length; res_i++) {
	            bw.write(String.valueOf(res[res_i]));
	            bw.newLine();
	        }
	        
	        bw.close();
	    }
	}