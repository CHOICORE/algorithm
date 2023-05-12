public class Solution {
    LinkedHashSet<List<Integer>> al;
    List<List<Integer>> al1;
    int n;

    void permutate(List<Integer> a, int index) {

        for (int i = index; i < n; i++) {
            List<Integer> b = new ArrayList<Integer>(a);
            int temp = b.get(index);
            b.set(index, b.get(i));
            b.set(i, temp);
            al.add(b);
            permutate(b, index + 1);

        }
    }

    public List<List<Integer>> permute(int[] a) {
        ArrayList<Integer> A = new ArrayList<>();
        for (int i : a) {
            A.add(i);
        }
        al = new LinkedHashSet<>();
        n = A.size();
        permutate(A, 0);
        al1 = new ArrayList<>();
        for (List<Integer> integers : al) {
            List<Integer> l = new ArrayList<>(integers);
            al1.add(l);
        }
        return al1;
    }
}