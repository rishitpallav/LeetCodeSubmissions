class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentToPath = new HashMap<>();

        for (String s : paths) {
            String[] files = s.split(" ");
            String originalPath = files[0];

            for (int i = 1; i < files.length; i++ ) {
                int j = files[i].indexOf('(');
                String subPath = files[i].substring(0, j);
                String content = files[i].substring(j+1);
                contentToPath.computeIfAbsent(content, k -> new ArrayList<String>()).add(originalPath+"/"+subPath);
            }
        }

        List<List<String>> result = new ArrayList<>();
        
        for (Map.Entry<String, List<String>> entry : contentToPath.entrySet()) {
            if (entry.getValue().size() > 1)
                result.add(entry.getValue());
        }

        return result;
    }
}