import java.util.*;
class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        List<Integer> result = new ArrayList<>();
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
        while(!queue.isEmpty()){
            int current = queue.poll();
            result.add(current);
            
            for(int neighbor : graph.get(current)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.add(neighbor);
                }
            }
        }
        if(result.size() == numCourses){
            return result.stream().mapToInt(i -> i).toArray();
        }
        return new int[0];
    }
}
