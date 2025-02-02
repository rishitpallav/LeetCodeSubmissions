class Solution {
    public List<String> fizzBuzz(int n) {

        List<String> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++ ) {
            String result = "";

            boolean three = i%3==0;
            boolean five = i%5==0;

            if (three && five) {
                result = "FizzBuzz";
            } else if (three) {
                result = "Fizz";
            } else if (five) {
                result = "Buzz";
            } else {
                result = Integer.toString(i);
            }

            answer.add(result);

        }

        return answer;
    }
}