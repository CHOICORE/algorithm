class Solution {
    public String destCity(List<List<String>> paths) {
        if (paths.size() == 1)
            return paths.get(0).get(1);

        Map<String, String> temp = new HashMap<>();
        for (List<String> path : paths) {
            temp.put(path.get(0), path.get(1));
        }

        String destination = paths.get(0).get(0);
        while (temp.containsKey(destination)) {
            destination = temp.get(destination);
        }

        return destination;

    }
}