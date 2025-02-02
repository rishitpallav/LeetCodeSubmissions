class Solution {
    public List<String> fizzBuzz(int n) {

        List<String> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++ ) {
            String result = "";

            if (i % 3 == 0) {
                result = "Fizz";
            }
            if (i % 5 == 0) {
                result = result + "Buzz";
            }
            if (i%3!=0 && i%5!=0) {
                result = Integer.toString(i);
            }

            answer.add(result);

        }

        return answer;
    }
}