class Solution {
    public int findComplement(int num) {

        String binary = "";

        while (num > 0) {
            binary += num % 2;
            num /= 2;
        }

        binary = new StringBuilder(binary).reverse().toString();

        char[] arr = binary.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == '0') ? '1' : '0';
        }

        binary = new String(arr);

        return Integer.parseInt(binary, 2);
    }
}