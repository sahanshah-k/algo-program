class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {        
        
        int[][] adjMat = new int[numCourses][numCourses];
        
        for (int i = 0; i < prerequisites.length; i ++) {
            adjMat[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }

        int[] state = new int[numCourses];
                
        for (int i = 0; i < numCourses; i ++) {
            if (state[i] == 0) {
                if (isCyclic(adjMat, i, state)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isCyclic(int[][] adjMat, int course, int[] state) {
        if (state[course] == 1) {
            return true;
        }
        
        state[course] = 1;

        for (int i = 0; i < adjMat.length; i ++) {
            if (state[i] != 2 && adjMat[course][i] == 1 && isCyclic(adjMat, i, state)) {
                return true;
            }
        }
        
        state[course] = 2;
        return false;
    }
    
}