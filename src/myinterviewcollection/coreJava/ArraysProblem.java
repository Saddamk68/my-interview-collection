public class ArraysProblem {

    public static void main(String[] args) {
        int[][] pointsTbl = {{1, 3, 4, 5}, {7, 2, 3, 4}, {1, 3, 2, 1,}};
        System.out.println("Max Scored player is : " + findMaxScoredPlayer(pointsTbl, 3, 4));

        System.out.println("Top performed player is : " + topPerformedPlayer(pointsTbl, 3, 4));
    }

    public static int findMaxScoredPlayer(int[][] pointsTbl, int N, int M) {
        int maxPoint = 0;
        int playerNumber = 0;

        for (int i=0; i<N; i++) {
            int currentMax = 0;
            for (int j = 0; j < M; j++) {
                currentMax += pointsTbl[i][j];
            }
            if (currentMax > maxPoint) {
                maxPoint = currentMax;
                playerNumber = i + 1;
            }
        }
        System.out.println("Player number " + playerNumber + " has max point " + maxPoint);
        return playerNumber;
    }

    public static int topPerformedPlayer(int[][] pointsTbl, int N, int M) {
        int[] topPerfCount = new int[N];

        for (int i=0; i<M; i++) {
            int maxScore = 0;
            int topPlayerIndex = 0;

            for (int j=0; j<N; j++) {
                if (maxScore < pointsTbl[j][i]) { // the sequence is j and i not i and j
                    maxScore = pointsTbl[j][i];
                    topPlayerIndex = j;
                }
            }
            topPerfCount[topPlayerIndex]++;
        }

        int maxCount = 0;
        int topPlayer = 0;
        for (int k=0; k<N; k++) {
            if (topPerfCount[k] > maxCount) {
                maxCount = topPerfCount[k];
                topPlayer = k+1;
            }
        }
        System.out.println("Top player is " + topPlayer + " performed better in " + maxCount + " matches");
        return topPlayer;
    }

}
