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
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
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
            
                memo.put(currentHd, currentNode.data);
            
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
