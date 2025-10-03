public class lcs {

    public static void print(String A, String B, int[][] c, char[][] dir) {
        int m = A.length();
        int n = B.length();
        System.out.println("Matrix :");
        System.out.print(" ");
        for (int j = 0; j < n; j++) {
            System.out.print(" " + B.charAt(j) + " ");
        }
        System.out.println();

        for (int i = 0; i <= m; i++) {
            if (i == 0)
                System.out.print(" ");
            else
                System.out.print(" " + A.charAt(i - 1) + " ");
            for (int j = 0; j <= n; j++) {
                String val = String.valueOf(c[i][j]);
                char arrow = dir[i][j];

                if (i == 0 || j == 0) {
                    System.out.printf("%3s ", val);
                } else {
                    System.out.printf("%2s%s ", val, arrow);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static String lcs(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] c = new int[m + 1][n + 1];
        char[][] dir = new char[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                    dir[i][j] = ' ';
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    dir[i][j] = 'd';
                } else {
                    if (c[i - 1][j] >= c[i][j - 1]) {
                        c[i][j] = c[i - 1][j];
                        dir[i][j] = 'u';
                    } else {
                        c[i][j] = c[i][j - 1];
                        dir[i][j] = 'h';
                    }
                }
            }
        }

        print(A, B, c, dir);
        int index = c[m][n];
        char[] lcsArr = new char[index];
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
                lcsArr[index - 1] = A.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (c[i - 1][j] >= c[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return new String(lcsArr);
    }

    public static void main(String[] args) {
        String A = "AGCCCTAAGGGCTACCTAGCTT";
        String B = "GACAGCCTACAAGCGTTAGCTTG";
        System.out.println("TASK-1: ");
        String lcsStr = lcs(A, B);
        System.out.println("Length of LCS: " + lcsStr.length());
        System.out.println("LCS sequence: " + lcsStr);
    }
}
