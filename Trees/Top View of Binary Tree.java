class Pair{
    Node node;
    int hd;
    Pair(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        int left = 1000000;
        int right = -1000000;
        
        if(root == null){
            return answer;
        }
        
        queue.add(new Pair(root, 0));
        
        while(!queue.isEmpty()){
            
            Pair currentPair = queue.remove();
            Node currentNode = currentPair.node;
            int currentHd = currentPair.hd;
            
            left = Math.min(left, currentHd);
            right = Math.max(right, currentHd);
            
            if(!memo.containsKey(currentHd)){
                memo.put(currentHd, currentNode.data);
            }
            
            if(currentNode.left != null){
                queue.add(new Pair(currentNode.left, currentHd - 1));
            }
            
            if(currentNode.right != null){
                queue.add(new Pair(currentNode.right, currentHd + 1));
            }
            
        }
        
        for(int i = left; i <= right; i++){
            answer.add(memo.get(i));
        }
        
        return answer;
        
    }
}
