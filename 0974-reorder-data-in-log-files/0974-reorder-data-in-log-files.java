class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<>();
        
        List<String> letterLogs = new ArrayList<>();
        List<String> letterhead = new ArrayList<>();
        
        String[] result = new String[logs.length];

        for (String line : logs) {
            int index = 0;
            while (line.charAt(index) != ' ') {
                index++;
            }
            String identifier = line.substring(0, index);
            index++;
            String values = line.substring(index);

            if (Character.isDigit(line.charAt(index))) {
                digitLogs.add(line);
            } else {
                int i = 0;
                while (i < letterLogs.size() && letterLogs.get(i).compareTo(values) < 0) {
                    i++;
                }
                while (i < letterLogs.size() && letterLogs.get(i).compareTo(values) == 0 && letterhead.get(i).compareTo(identifier) < 0) {
                    i++;
                }
                letterLogs.add(i, values);
                letterhead.add(i, identifier);
            }
        }

        for (int i = 0; i < letterLogs.size(); i++ ) {
            result[i] = letterhead.get(i) + " " + letterLogs.get(i);
        }
        int index = letterhead.size();
        for (int i = 0; i < digitLogs.size(); i++ ) {
            result[index++] = digitLogs.get(i);
        }

        return result;
    }
}