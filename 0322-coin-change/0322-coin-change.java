class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] mem = new int[amount + 1];
        Arrays.fill(mem, Integer.MAX_VALUE);
        mem[0] = 0;
        int toCompare = 0;
        for (int i = 0; i < coins.length; i ++) {
            for (int j = 0; j < mem.length; j ++) {
                if (coins[i] <= j) {
                    toCompare = mem[j - coins[i]] == Integer.MAX_VALUE
                        ? mem[j - coins[i]]
                        : mem[j - coins[i]] + 1; //To prevent Integer Overflow
                    mem[j] = Math.min(mem[j], toCompare);
                } 
            }
        }
        return mem[amount] != Integer.MAX_VALUE ? mem[amount] : -1;
    }
    
}