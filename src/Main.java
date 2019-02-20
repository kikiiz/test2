public class Main {
    /**
     * 打印
     * @param index 索引
     * @param object 对象
     */
    public static void print(int index,Object object){
        System.out.println(String.format("{%d},%s",index,object.toString()));
    }

    public static void demoOperation(){
        print(1,5+2);
        print(1,5-2);
        print(1,5*2);
        print(1,5/2);
        print(1,5%2);
        print(1,5<<2);//整体左移，变大
        print(1,5>>2);//整体右移，变小
        print(1,5|2);//或，0x101 0x10 → 0x111
        print(1,5^2);//抑或
        print(1,5==2);
        print(1,5!=2);
    }

    public static void main(String[] args) {
        demoOperation();
    }

}
