// @author: ALI GHANBARI 
// @email: alighanbari446@gmail.com

public class Predictor {
    public static int predict(int year) {
        int a = 0;
        for (int i = year; i < year+5; i++) {
        	if (i % 4 == 2) {
        		a = i;
        		break;
        	}
        }
		return a;
    }

    public static void main(String[] args) {
        System.out.println(predict(2021)); // 2022
        System.out.println(predict(2022)); // 2022
        System.out.println(predict(2023)); // 2026
    }
}