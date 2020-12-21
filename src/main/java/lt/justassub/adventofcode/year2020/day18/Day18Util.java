package lt.justassub.adventofcode.year2020.day18;

public class Day18Util {

    private static long getMathNoParenthesesPriority(String line, String priority) {
        if (priority == null) {
            return getMathNoParenthesesNoPriority(line);
        }
        if (!line.contains(priority)) {
            return getMathNoParenthesesNoPriority(line);
        }

        String[] values = line.split(" ");


        int firstNumberIndex = 0;
        int secondNumberIndex = 0;
        for (int i = 0; i < values.length; i++) {
            if (priority.equals(values[i])) {
                firstNumberIndex = i - 1;
                secondNumberIndex = i + 1;
                break;
            }
        }
        StringBuilder lineToCalculate = new StringBuilder();
        for (int i = firstNumberIndex; i <= secondNumberIndex; i++) {
            lineToCalculate.append(values[i]).append(" ");
        }

        StringBuilder previousPart = new StringBuilder();
        for (int i = 0; i < firstNumberIndex; i++) {
            previousPart.append(values[i]).append(" ");
        }

        StringBuilder secondPart = new StringBuilder();
        for (int i = secondNumberIndex + 1; i < values.length; i++) {
            secondPart.append(values[i]).append(" ");
        }

        line = "" + previousPart + getMathNoParenthesesPriority(lineToCalculate.toString(), null) + " " + secondPart;

        return getMathNoParenthesesPriority(line.trim(), priority);
    }

    private static long getMathNoParenthesesNoPriority(String line) {
        String[] symbols = line.split(" ");
        long answer = Long.parseLong(symbols[0]);

        for (int i = 1; i < symbols.length - 1; i += 2) {
            String action = symbols[i];
            long nextNumber = Long.parseLong(symbols[i + 1]);
            switch (action) {
                case "*":
                    answer *= nextNumber;
                    break;
                case "+":
                    answer += nextNumber;
                    break;
                default:
                    throw new UnsupportedOperationException(action + " is not supported");
            }
        }
        return answer;
    }

    public static long calculateLineWithParenthesesNoPriority(String line) {

        return calculateLineWithParentheses(line, null);
    }


    public static long calculateLineWithParentheses(String line, String priority) {
        if (!line.contains("(")) {
            return getMathNoParenthesesPriority(line, priority);
        }
        int lastBracketOpensIndex = line.lastIndexOf('(');
        int firstBracketCloses = line.indexOf(")", lastBracketOpensIndex);
        String replacementString = line.substring(lastBracketOpensIndex + 1, firstBracketCloses);
        long replacementAnswer = getMathNoParenthesesPriority(replacementString, priority);
        line = line.substring(0, lastBracketOpensIndex) + replacementAnswer + line.substring(firstBracketCloses + 1);
        return calculateLineWithParentheses(line, priority);
    }
}
