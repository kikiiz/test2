import java.util.*;

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
        //常见操作符
        print(1,5+2);
        print(2,5-2);
        print(3,5*2);
        print(4,5/2);
        print(5,5%2);
        print(6,5<<2);//整体左移，变大
        print(7,5>>2);//整体右移，变小
        print(8,5|2);//或，0x101 0x10 → 0x111
        print(9,5^2);//抑或
        print(10,5==2);
        print(11,5!=2);
        print(12,5.0/2);
        print(13,5/2.0);


        int a=11;
        double b=2.2f;
        a+=2;
        print(14,a);
    }

    public static  void demoString(){
        //常见字符串操作
        String str="hello world";
        print(1,str.indexOf('h'));//包含在字符串内的(首个)位置（0开始）
        print(2,str.charAt(0));//字符串第n个字符，str[n]
        print(3,str.codePointAt(1));//ascii码
        print(4,str.compareToIgnoreCase("HELLO world"));//忽略大小写后比较大小
        print(5,str.compareTo("hello vorld"));//字符串间比较大小
        print(6,str.compareTo("hello world"));
        print(7,str.compareTo("hello xorld"));
        print(8,str.contains("hell"));
        print(9,str.toUpperCase());
        print(10,str.endsWith("world"));
        print(11,str.startsWith("hell"));
        print(12,str.replace('o','e'));
        print(13,str.replaceAll("o|l","a"));
        print(14,str.replaceAll("hello","hi"));
        print(15,str.concat("shake bilibili"));

        StringBuilder sb=new StringBuilder();//线程非安全
        sb.append("x ");
        sb.append(1.2);
        sb.append('a');
        sb.append(true);
        print(16,sb.toString());
    }
    public  static void demoControlFlow() {
        int a = 3;
        int target = a == 2 ? 1 : 3;
        print(1, target);

        String grade = "B";
        switch (grade) {
            case "A":
                print(3, ">80");
                break;
            case "B":
                print(4, "60-80");
                break;
            case "C":
                print(5, "<60");
                break;
            default:
                print(6, "error");
                break;
        }

        for(int i=0;i<4;i++){
            if(i==0)
                continue;
            print(7,i);
            if(i==3)
                break;

        }

        int score=60;
        while(score<100){
            print(8,score);
            score+=20;
        }
    }

    public  static void demoList(){
        //列表
        List<String> strlist=new ArrayList<String>(10);
        for(int i=0;i<4;i++){
            strlist.add(String.valueOf(i));//添加元素
        }
        print(1,strlist);

        List<String> strlistB=new ArrayList<String>();
        for(int i=0;i<4;i++){
            strlistB.add(String.valueOf(i*i));
        }
        strlist.addAll(strlistB);
        print(2,strlist);
        strlist.remove(0);//位置
        print(3,strlist);
        strlist.remove(String.valueOf(9));//对象
        print(4,strlist);
        print(5,strlist.get(1));//输出某位置对象

        Collections.reverse(strlist);//逆序
        print(6,strlist);

        Collections.sort(strlist);//排序
        print(7,strlist);

        Collections.sort(strlist, new Comparator<String>() {//自定义排序
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        print(8,strlist);

        for(String obj:strlist){//遍历
            print(9,obj);
        }

        for(int i=0;i<strlist.size();i++){//遍历，手动迭代
            print(10,strlist.get(i));
        }

        int[] array=new int[]{1,2,3};//数组
        print(11,array[1]);
        print(12,array);
    }

    public static void demoMapTable(){
        //映射
        Map<String,String> map=new HashMap<String, String>();
        for(int i=0;i<4;i++){
            map.put(String.valueOf(i),String.valueOf(i*i));
        }
        print(1,map);

        for(Map.Entry<String,String> entry:map.entrySet()){//遍历
            print(2,entry.getKey()+'|'+entry.getValue());
        }

        print(3,map.values());
        print(4,map.keySet());
        print(5,map.get("3"));//key对应的value
        print(6,map.containsKey("2"));
        print(7,map.containsKey("7"));

        map.replace("3","27");//替换某key的value
        print(8,map.get("3"));
    }

    public static void demoSet(){
        //集合
        Set<String> strset=new HashSet<String>();
        for(int i=0;i<4;i++){
            strset.add(String.valueOf(i));
            strset.add(String.valueOf(i));
            strset.add(String.valueOf(i));//元素不重复
        }
        print(1,strset);

        strset.remove(String.valueOf(1));//删除元素
        print(2,strset);
        print(3,strset.contains(String.valueOf(1)));//判断存在
        print(4,strset.isEmpty());
        print(5,strset.size());

        strset.addAll(Arrays.asList(new String[]{"a","b","c"}));
        print(6,strset);

        for(String value:strset){//遍历
            print(7,value);
        }
    }

    /**
     * 异常处理
     */
    public static void demoException(){
        try{
            print(1,5/0);
        }catch (Exception e){
            //异常捕获
            print(2,e.getMessage());
        } finally {
            //收尾工作，数据清理等
            print(3,"End");
        }

        try{
            //针对用户输入等情况
            int k=2;
            if(k==2){
                throw  new Exception("不能输入2");//主动抛出异常
            }
        }catch (Exception e){
            print(1,e.getMessage());
        }finally {
            print(2,"End");
        }
    }

    public static void main(String[] args) {
        //demoString();
        //demoControlFlow();
        //demoList();//O(n)
        //demoMapTable();//O(1)
        //demoSet();
        //demoException();
    }

}
