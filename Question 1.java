class Solution {
  public int maxArea(int[] height) {
    int ans=0;
    int l=0;
    int b=height.length - 1;

    while (l<b) {
      int minHeight=Math.min(height[l], height[b]);
      ans=Math.max(ans,minHeight*(b-l));
      if (height[l]<height[b])
        ++l;
      else
        --b;
    }

    return ans;
  }
}
