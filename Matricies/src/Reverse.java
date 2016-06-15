public class Reverse
{
	public static void main(String args[])
	{	
		int[][] mat = new int[5][5];
		for(int r =0; r<5; r++)
		{
			for(int c =0; c<5; c++)
			{
				mat[r][c] = 10 + (int)(Math.random() * 89); 
			}
		}
		for(int i =0; i<5; i++)
		{
			for(int k =0; k<5; k++)
			{
				System.out.print(mat[i][k] + " ");
			}
			System.out.println();
		}
	}
	
	public static void reverse(int[][] toRe)
	{
		int row = toRe.length;
		int col = toRe[0].length;
		int[][] reversed = new int[row][col];
			for(int i = row; i>0; i--)
			{
				for(int k = col; k>0; k--)
				{
					for(int g = row; g>0; g++)
					{
						for(int g = col; g>0; g--)
						{
							
						}
					}
				}
			}
	}
}
