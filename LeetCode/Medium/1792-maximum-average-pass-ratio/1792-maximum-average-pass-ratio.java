class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Classroom> classrooms = new PriorityQueue<>(
            (a, b) -> Double.compare(b.getPassingIncrease(), a.getPassingIncrease())
        );
        
        Arrays.stream(classes)
              .map(Classroom::new)
              .forEach(classrooms::offer);
        
        for (int i = 0; i < extraStudents; i++) {
            Classroom classroom = classrooms.poll();
            classrooms.offer(classroom.addStudent());
        }
        
        return classrooms.stream()
                        .mapToDouble(Classroom::getPassingRatio)
                        .average()
                        .orElse(0.0);
    }
}

class Classroom {
    private final int passingStudents;
    private final int totalStudents;
    private final double passingIncrease;
    
    public Classroom(int[] classData) {
        this(classData[0], classData[1]);
    }
    
    private Classroom(int passingStudents, int totalStudents) {
        this.passingStudents = passingStudents;
        this.totalStudents = totalStudents;
        this.passingIncrease = calculatePassingIncrease();
    }
    
    public Classroom addStudent() {
        return new Classroom(passingStudents + 1, totalStudents + 1);
    }
    
    public double getPassingIncrease() {
        return passingIncrease;
    }
    
    public double getPassingRatio() {
        return (double) passingStudents / totalStudents;
    }
    
    private double calculatePassingIncrease() {
        return (passingStudents + 1.0) / (totalStudents + 1) - getPassingRatio();
    }
}