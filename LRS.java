public class LRS {

    public static int lrs(String a){
        int n = a.length();

        int[][] c = new int[n+1][n+1];
        for (int i=0; i<= n; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    c[i][j] = 0;
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(a.charAt(i-1) == a.charAt(j-1) && i!=j){
                    c[i][j] = 1 + c[i-1][j-1];
                } else {
                    c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
                }
            }
        }
        return c[n][n];
    }

    public static void main(String[] args) {
        String a = "AABEBCDD";
        String b = "AABEBCDD";
        int str1 = lrs(a);
        System.out.println(str1);
        int str2 = lrs(b);
        System.out.println(str2);
    }

}