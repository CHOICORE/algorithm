class Solution {
    public String pushDominoes(String dominoes) {
        char[] charArray = dominoes.toCharArray();
        int length = charArray.length;
        int[] forces = new int[length];

        int force = 0;
        for (int i = 0; i < length; ++i) {
            if (charArray[i] == 'R') force = length;
            else if (charArray[i] == 'L') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] += force;
        }

        force = 0;
        for (int i = length - 1; i >= 0; --i) {
            if (charArray[i] == 'L') force = length;
            else if (charArray[i] == 'R') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] -= force;
        }

        StringBuilder sb = new StringBuilder();
        for (int f : forces)
            sb.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
        return sb.toString();
    }
}