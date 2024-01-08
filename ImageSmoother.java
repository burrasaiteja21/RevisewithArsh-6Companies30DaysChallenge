//leetcode link: https://leetcode.com/problems/image-smoother/
/**
 * Intuition
 * The problem appears to involve image smoothing, where each pixel in the output image is computed as the average of its value and the values of its neighboring pixels. To solve this, we need to iterate through each pixel and calculate the average of its neighbors.
 *
 * Approach
 * I will use a 2D array to represent the output image. For each pixel in the original image, I will calculate the average of its value and the values of its neighboring pixels in a 3x3 neighborhood. I will iterate through each pixel in the original image, and for each pixel, I will iterate through its neighbors, ensuring to handle boundary conditions appropriately. The average value will then be stored in the corresponding position of the output image.
 *
 * Complexity:
 * Time complexity:
 * O(n×m), where 'n' is the number of rows and 'm' is the number of columns in the image. We iterate through each pixel once, and for each pixel, we calculate the average of its neighbors in constant time.
 *
 * Space complexity:
 * * O(n×m), as we use a 2D array to store the output image.
 */

class Solution {
    public int[][] imageSmoother(int[][] img)
    {
        int n=img.length;
        int m=img[0].length;
        int[][] dp=new int[n][m];
        int[] row={-1,-1,0,1,1,1,0,-1};
        int[] col={0,1,1,1,0,-1,-1,-1};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int count=1;
                int sum=img[i][j];

                for(int k=0;k<8;k++)
                {
                    int r=i+row[k];
                    int c=j+col[k];

                    if((r>=0 && r<n) && (c>=0 && c<m))
                    {
                        count++;
                        sum+=img[r][c];
                    }
                }
                float avg=sum/count;
                int val=(int)avg;
                dp[i][j]=val;
            }
        }

        return dp;

    }
}