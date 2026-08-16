class Solution {

   HashMap<Integer,Integer>map=new HashMap<>();
    public int clac(int i , int n){
      

        if(i==n)
            return 1;
        if(i>n)
            return 0;
        if(map.containsKey(i))
            return map.get(i);
        int ans= clac(i+1,n)+ clac(i+2,n);
        map.put(i,ans);


        return ans;
        

    }
    public int climbStairs(int n) {
        return clac(0,n);
       
    }
}