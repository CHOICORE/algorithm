class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        List<Double> passRatios = new ArrayList<>();

        for (int[] aClass : classes) {
            double initialRatio =
                    (double) aClass[0] / aClass[1];
            passRatios.add(initialRatio);
        }

        while (extraStudents > 0) {
            List<Double> updatedRatios = new ArrayList<>();

            for (
                    int classIndex = 0;
                    classIndex < classes.length;
                    classIndex++
            ) {
                double newRatio =
                        (double) (classes[classIndex][0] + 1) /
                                (classes[classIndex][1] + 1);
                updatedRatios.add(newRatio);
            }

            int bestClassIndex = 0;
            double maximumGain = 0;

            for (
                    int classIndex = 0;
                    classIndex < updatedRatios.size();
                    classIndex++
            ) {
                double gain =
                        updatedRatios.get(classIndex) - passRatios.get(classIndex);
                if (gain > maximumGain) {
                    bestClassIndex = classIndex;
                    maximumGain = gain;
                }
            }

            passRatios.set(bestClassIndex, updatedRatios.get(bestClassIndex));
            classes[bestClassIndex][0]++;
            classes[bestClassIndex][1]++;

            extraStudents--;
        }
        
        double totalPassRatio = 0;
        for (double passRatio : passRatios) {
            totalPassRatio += passRatio;
        }

        return totalPassRatio / classes.length;
    }
}