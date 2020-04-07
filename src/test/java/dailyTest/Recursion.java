package dailyTest;

/**
 * @Description:
 * @Author: yangdongwei
 * @CreateDate: 2020/1/19
 * @Version: 1.0
 */
public class Recursion {
    public static void main(String[] args) {
        System.out.println(multipy(10));
    }
    public static Integer multipy(int num){
        if (num == 1){
            return num;
        }
        return num * multipy(num - 1);
    }
}
