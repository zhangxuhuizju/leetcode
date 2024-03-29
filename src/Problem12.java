/*
题目本身不难，但要把代码写的优雅，不要弄一堆的if
 */
public class Problem12 {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] reps = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String res = "";
        for(int i=0; i<13; i++)
        {
            while(num>=values[i])
            {
                num -= values[i];
                res += reps[i];
            }
        }
        return res;
    }
}
