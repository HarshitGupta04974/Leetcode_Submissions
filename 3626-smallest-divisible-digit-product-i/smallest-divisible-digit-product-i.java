class Solution {
    private static int getDigitProduct(int n) {
        int product = 1;
        while (n != 0) {
            int temp = n % 10;
            product *= temp;
            n = n / 10;
        }
        return product;
    }

    public int smallestNumber(int n, int t) {
        while (true) {
            int digi = getDigitProduct(n);
            if (digi % t == 0) {
                return n;
            }
            n += 1;
        }

    }
}