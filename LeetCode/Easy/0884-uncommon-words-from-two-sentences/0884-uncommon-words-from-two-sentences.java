class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word : A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word : B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> answer = new LinkedList();
        for (String word : count.keySet())
            if (count.get(word) == 1)
                answer.add(word);

        return answer.toArray(new String[answer.size()]);
    }
}