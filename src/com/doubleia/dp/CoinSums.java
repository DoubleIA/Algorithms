package com.doubleia.dp;

/**
 * 
 * 给你一个数小于1000000，分别用100,50,20,10,5,1块表示出来，有多少种表示方法。
 * 
 * * 给定一个数值sum，假设我们有m种不同类型的硬币{V1, V2, ..., Vm}，如果要组合成sum，那么我们有
 * *		sum = x1 * V1 + x2 * V2 + ... + xm * Vm
 * * 求所有可能的组合数，就是求满足前面等值的系数{x1, x2, ..., xm}的所有可能个数。
 * * [思路1] 当然我们可以采用暴力枚举，各个系数可能的取值无非是x1 = {0, 1, ..., sum / V1}, x2 = {0, 1, ..., sum/ V2}等等。
 * * 这对于硬币种类数较小的题目还是可以应付的，比如华为和创新工厂的题目，但是复杂度也很高O（sum/V1 * sum/V2 * sum/V3 * ...）
 * * 
 * * [思路2] 从上面的分析中我们也可以这么考虑，我们希望用m种硬币构成sum，根据最后一个硬币Vm的系数的取值为无非有这么几种情况，xm分别取
 * *｛0, 1, 2, ..., sum/Vm｝，换句话说，上面分析中的等式和下面的几个等式的联合是等价的。
 * *		sum = x1 * V1 + x2 * V2 + ... + 0 * Vm
 * * 		sum = x1 * V1 + x2 * V2 + ... + 1 * Vm
 * * 		sum = x1 * V1 + x2 * V2 + ... + 2 * Vm
 * * 		...
 * * 		sum = x1 * V1 + x2 * V2 + ... + K * Vm 
 * * 其中K是该xm能取的最大数值K = sum / Vm。可是这又有什么用呢？不要急，我们先进行如下变量的定义：
 * * 
 * * dp[i][sum] = 用前i种硬币构成sum 的所有组合数。那么题目的问题实际上就是求dp[m][sum]，即用前m种硬币（所有硬币）构成sum的所有组合数。
 * * 在上面的联合等式中：当xn=0时，有多少种组合呢？ 实际上就是前i-1种硬币组合sum，有dp[i-1][sum]种！ xn = 1 时呢，有多少种组合？ 
 * * 实际上是用前i-1种硬币组合成(sum - Vm)的组合数，有dp[i-1][sum -Vm]种; xn =2呢， dp[i-1][sum - 2 * Vm]种，等等。
 * * 所有的这些情况加起来就是我们的dp[i][sum]。所以：
 * * dp[i][sum] = dp[i-1][sum - 0*Vm] + dp[i-1][sum - 1*Vm] + dp[i-1][sum - 2*Vm] + ... + dp[i-1][sum - K*Vm]; 其中K = sum / Vm
 * * 那么初始情况是什么呢？如果sum=0，那么无论有前多少种来组合0，只有一种可能，就是各个系数都等于0；
 * * dp[i][0] = 1   // i = 0, 1, 2, ... , m
 * * 如果我们用二位数组表示dp[i][sum], 我们发现第i行的值全部依赖与i-1行的值，所以我们可以逐行求解该数组。如果前0种硬币要组成sum，我们规定为dp[0][sum] = 0. 
 * * 
 * 
 * @author wangyingbo
 *
 */
public class CoinSums {
	/**
	 * dp[i][j] = sum(dp[i-1][j-k*coins[i-1]]) for k = 1,2,..., j/coins[i-1]
	 * dp[0][j] = 1 for j = 0, 1, 2, ..., sum
	 * 
	 * @param coins - array store all values of the coins
	 * @param sum - the number you want to construct using coins
	 * @return the number of combinations using coins construct sum
	 */
	int coinCombinations(int coins[], int sum) {
		int ckinds = coins.length;
		int[][] dp = new int[ckinds + 1][sum + 1];
		
		for (int i = 0; i <= ckinds; i++) 
			dp[i][0] = 1;
		
		for (int i = 1; i <= ckinds; i++) {
			for (int j = 1; j <= sum; j++) {
				dp[i][j] = 0;
				for (int k = 0; k <= j / coins[i - 1]; k++) {
					dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
				}
			}
		}
		
		return dp[ckinds][sum];
	}
	
	public static void main(String[] args) {
		CoinSums coinSum = new CoinSums();
		System.out.println(coinSum.coinCombinations(new int[]{1,5,10,20,50,100}, 15));
	}

}
