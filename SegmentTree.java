package DataStructureInterviewPreparation;

public class SegmentTree {

    public static void main(String[] args){

        int arr[] = {3 , 8 , 7 , 6 , -2 , -8 , 4 , 9};

        SegmentTree tree = new SegmentTree(arr);
        System.out.println(tree.query(0 ,90));

    }

    private static class Node{

        int data;
        int startingInterval;
        int endingInterval;
        Node left;
        Node right;

        public Node(int startingInterval , int endingInterval){

            this.startingInterval = startingInterval;
            this.endingInterval = endingInterval;
        }


    }

    Node root;

    public SegmentTree(int arr[]){

       if(arr.length == 0){
           System.out.println("Please insert elements in array");
       }else{
           this.root = constructTree(arr , 0 , arr.length-1);
       }



    }

    private Node constructTree(int arr[] , int start , int end){

        if(arr.length == 0){
            return null;
        }

if(start > end){

    return null;
}

if(start == end){

    Node leaf = new Node(start , end);
    leaf.data = arr[start];
return leaf;
}

Node node = new Node(start , end);

int mid = (end-start)/2 + start;

node.left = this.constructTree(arr , start , mid);
node.right = this.constructTree(arr , mid+1 , end);

int nodeleftData = 0;
int noderightData = 0;
if(node.left != null){
    nodeleftData = node.left.data;
}
if(node.right != null){

    noderightData = node.right.data;
}

node.data = nodeleftData + noderightData;
return node;


    }

    public void display(){

display(this.root);

    }

    private void display(Node node){

        if(node == null){
            return;
        }

        String str = "";

        if(node.left != null){

        str = str + "Interval=[" + node.left.startingInterval + "-" + node.left.endingInterval + "] and data: " +
                node.left.data + " => ";
        }else{

            str = str + "No Left Child";
        }

        str = str + "Interval=[" + node.startingInterval + "-" + node.endingInterval + "] and data: " +
                node.data + " <= ";

        if(node.right != null){

            str = str + "Interval=[" + node.right.startingInterval + "-" + node.right.endingInterval + "] and data: " +
                    node.right.data + " => ";
        }else{

            str = str + "No Right Child";
        }

        System.out.println(str);

        if(node.left != null){
            display(node.left);
        }

        if(node.right != null){
            display(node.right);
        }

    }

    // query

    public int query(int queryStartIndex , int queryEndIndex){

        return query(this.root , queryStartIndex , queryEndIndex);

    }

    private int query(Node node , int queryStartIndex , int queryEndIndex){



        if(node.startingInterval >= queryStartIndex && node.endingInterval <= queryEndIndex){

                      return node.data;
            // node is completley inside the query

        }else if(node.startingInterval > queryEndIndex || node.endingInterval < queryStartIndex){

            return 0;
        }else{

            return this.query(node.left , queryStartIndex , queryEndIndex )+this.query(node.right,queryStartIndex,queryEndIndex);
        }





    }

    public void update(int index , int value){

        if(root == null){
            System.out.println("Array is empty");
        }else{
            this.root.data = update(this.root , index , value);
        }

    }

    private int update(Node node, int index , int value) {

        if(node == null){
            return 0;
        }

        if (index >= node.startingInterval && index <= node.endingInterval) {

            if (index == node.startingInterval && index == node.endingInterval) {
                node.data = value;
                return node.data;
            }else {

            int leftans = update(node.left, index, value);
            int rightans = update(node.right, index, value);
             node.data = leftans + rightans;
             return node.data;
        }
    }

return node.data;

    }

}
