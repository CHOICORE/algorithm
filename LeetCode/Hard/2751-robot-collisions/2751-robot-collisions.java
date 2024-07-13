class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Robot[] robots = new Robot[positions.length];
        List<Robot> stack = new ArrayList<>();

        for (int i = 0; i < positions.length; ++i) {
            robots[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));
        }

        Arrays.sort(robots, Comparator.comparingInt(a -> a.position));

        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.add(robot);
                continue;
            }
            while (!stack.isEmpty() && stack.getLast().direction == 'R' && robot.health > 0) {
                if (stack.getLast().health == robot.health) {
                    stack.removeLast();
                    robot.health = 0;
                } else if (stack.getLast().health < robot.health) {
                    stack.removeLast();
                    robot.health -= 1;
                } else {
                    stack.getLast().health -= 1;
                    robot.health = 0;
                }
            }
            if (robot.health > 0)
                stack.add(robot);
        }

        stack.sort(Comparator.comparingInt(a -> a.index));

        return stack.stream().map(robot -> robot.health).collect(Collectors.toList());
    }

    static class Robot {
        public int index;
        public int position;
        public int health;
        public char direction;

        public Robot(int index, int position, int health, char direction) {
            this.index = index;
            this.position = position;
            this.health = health;
            this.direction = direction;
        }
    }
}