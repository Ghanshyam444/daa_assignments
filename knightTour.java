class knightTour {
    static final int n = 6;

    public static boolean isValid(int i, int j, int sol[][]) {
        if (i >= 0 && i < n && j >= 0 && j < n) {
            if (sol[i][j] == -1)
                return true;
        }
        return false;
    }

    public static boolean knightTour(int sol[][], int i, int j, int stepCount, int xMove[], int yMove[]) {
        if (stepCount == n * n)
            return true;
        for (int k = 0; k < 8; k++) {
            int nextI = i + xMove[k];
            int nextJ = j + yMove[k];
            if (isValid(nextI, nextJ, sol)) {
                sol[nextI][nextJ] = stepCount;
                if (knightTour(sol, nextI, nextJ, stepCount + 1,
                        xMove, yMove))
                    return true;
                sol[nextI][nextJ] = -1; // backtracking
            }
        }
        return false;
    }

    public static boolean startKnightTour() {
        int[][] sol = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sol[i][j] = -1;
            }
        }
        int xMove[] = { 1, 2, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 2, 1, 2, 1, -1, -2, -2, -1 };
        sol[0][0] = 0; // placing knight at cell(1, 1)
        if (knightTour(sol, 0, 0, 1, xMove, yMove)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(sol[i][j] + "\t");
                }
                System.out.println("\n");
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        startKnightTour();
    }
}