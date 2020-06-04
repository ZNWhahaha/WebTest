package znwhahaha;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    public static float[] side;

    public static boolean triangle(float a,float b,float c)throws Exception{
        if (a<=0||b<=0||c<=0||a>200|b>200||c>200){
            System.out.println("输入数据非法");
            return false;
        }
        if((a+b>c)&&(a+c>b)&&(b+c>a)){
            if(a==b && b==c)
                System.out.println("三角形为等边三角形");
            else if(a==b||a==c||b==c){
                System.out.println("三角形为等腰三角形");
            }
            else
            System.out.println("三角形为普通三角形");
        }
        else     {
            System.out.println("无法构成三角形");
            return false;
        }
        return true;
    }

    public static void main( String[] args ) {
            side = new float[3];
            Scanner input = new Scanner(System.in);
            try {
                side[0] = input.nextFloat();
                side[1] = input.nextFloat();
                side[2] = input.nextFloat();
                Arrays.sort(side);
                triangle(side[0], side[1], side[2]);
            } catch (IllegalArgumentException e) {
                e.getMessage();
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                input.close();
            }

    }
}
