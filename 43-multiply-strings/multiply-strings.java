class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] arr = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                int d3 = d1 * d2;

                int p1 = i + j;
                int p2 = i + j + 1;
                
                int sum = d3 + arr[p2];

                arr[p2] = sum % 10;
                arr[p1] += sum / 10;
            }
        }
        int startIdx = 0;
        while (startIdx < arr.length && arr[startIdx] == 0) 
        {
            startIdx++;
        }
        if (startIdx == arr.length) 
        {
            return "0";
        }
        char[] resultChars = new char[arr.length - startIdx];
        for (int i = 0; i < resultChars.length; i++) 
        {
            resultChars[i] = (char) (arr[startIdx + i] + '0');
        }

        return new String(resultChars);
    }
}