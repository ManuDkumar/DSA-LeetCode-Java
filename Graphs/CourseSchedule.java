import java.util.*;
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        
        for(int[] pre : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];
            
            graph.get(prerequisite).add(course);
            indegree[course]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
    
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        int count = 0;
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            count++;
            
            for(int neighbor : graph.get(current)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.add(neighbor);
                }
            }
        }
        
        return count == numCourses;
    }
}
