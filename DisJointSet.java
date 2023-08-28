package DataStructureInterviewPreparation;

import java.util.ArrayList;

public class DisJointSet {

    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    ArrayList<Integer>  size = new ArrayList<>();

    public DisJointSet(int n){

        for(int i = 0;i <= n; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){

        if(node == parent.get(node)){
            return node;
        }

        int ulp = findUPar(parent.get(node));
      parent.set(node , ulp);

      return parent.get(node);

    }

    public void unionByRank(int u , int v){

        int u_parent = findUPar(u);
        int v_parent = findUPar(v);

        if(u_parent == v_parent){
            return;
        }

        if(rank.get(u_parent) < rank.get(v_parent)){

            parent.set(u_parent , v_parent);
        }else if(rank.get(v_parent) < rank.get(u_parent)){

            parent.set(u_parent , v_parent);

        }else{
            parent.set(v_parent , u_parent);
            rank.set(u_parent ,rank.get(u_parent) + 1);

        }



    }




    public void unionBySize(int u , int v){

        int u_parent = findUPar(u);
        int v_parent = findUPar(v);

if(size.get(u_parent) < size.get(v_parent)){
    parent.set(u_parent , v_parent);

    int a = size.get(v_parent);
    int b = size.get(u_parent);
    size.set(v_parent , a+b);
}else{

parent.set(v_parent , u_parent);

    int a = size.get(v_parent);
    int b = size.get(u_parent);
    size.set(u_parent , a+b);
}


    }




}
