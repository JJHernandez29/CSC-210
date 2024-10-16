public class MultiDimensionalArray {
    public static void main(String[] args) {
        int[] a1d = new int [3];
        int[] a1dinitialized = {1, 2, 3};

        int[][] a2d;
        a2d = new int[2][3];
        for (int i = 0; i < a2d.length; ++i) {
            for (int j = 0; j < a2d.length; ++j) {
                a2d[i][j] = i * 3 + j;
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        int[][] ragged = new int[2][0];
        ragged[0] = new int[3];
        ragged[1] = new int[2];
        for(int i = 0; i < ragged.length; ++i) {
            for (int i = 0; i < ragged[1].length; ++i) {
                ragged[1][i] = i;
            }
            
            System.out.println();

        }
        System.out.println();
        System.out.println();



    }

}
