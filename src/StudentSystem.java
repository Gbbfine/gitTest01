import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
       loop: while(true){
           System.out.println("--------欢迎来到黑马学生管理系统-----------------");
           System.out.println("1: 添加学生");
           System.out.println("2: 删除学生");
           System.out.println("3: 修改学生");
           System.out.println("4: 查询学生");
           System.out.println("5: 退出");
           System.out.println("清楚如您的选择");
           String  choose = sc.next();
           switch (choose){
               case "1":
                   addStudent(list);
                   break;
               case "2":
                   deleteStudent(list);
                   break;
               case "3":
                   updatetudent(list);
                   break;
               case "4":
                   queryStudent(list);
                   break;
               case "5":
                   System.out.println("退出");
                   break loop;
               default:
                   System.out.println("没有这个选项");


           }
       }
    }



    //添加学生
    public static void addStudent(ArrayList<Student> list){
        System.out.println("添加学生");
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        String id = null;

        System.out.println("请输入学生id");
        while(true){
            id = sc.next();
            boolean flag = contains(list,id);
            if(flag){
                //表示id已经存在
                System.out.println("id已经存在，请重新录入");
            }else{
                //表示id不存在
                s.setId(id);
                break;
            }
        }


        System.out.println("请输入学生姓名");
        String name = sc.next();
        s.setName(name);

        System.out.println("请输入学生年龄");
        int age = sc.nextInt();
        s.setAge(age);

        System.out.println("请输入学生家庭住址");
        String address = sc.next();
        s.setAddress(address);

        //将学生对象添加到集合当中
        list.add(s);

        //提示用户
        System.out.println("学生信息添加成功");
    }

    //删除学生
    public static void deleteStudent(ArrayList<Student> list){
        System.out.println("删除学生");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生id");
        String id = sc.next();
        int index = getIndex(list,id);
        if(index>=0){
            //学生存在
            list.remove(index);
            System.out.println("id为:"+id+"的学生信息删除成功");
        }else{
            System.out.println("id不存在，删除失败");
        }

    }

    //修改学生
    public static void updatetudent(ArrayList<Student> list){
        System.out.println("修改学生");
        System.out.println("请输入需要修改学生的id");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(list,id);
        if(index == -1){
            System.out.println("需要修改的id:"+id+"不存在，请重新输入");
            return;
        }
        Student stu = list.get(index);

        System.out.println("清楚如要修改的学生名称");
        String newName = sc.next();
        stu.setName(newName);

        System.out.println("清楚如要修改的学生年龄");
        int newage = sc.nextInt();
        stu.setAge(newage);

        System.out.println("清楚如要修改的学生家庭地址");
        String newAddress = sc.next();
        stu.setAddress(newAddress);

        //提示
        System.out.println("学生信息修改成功");
    }

    //查询学生
    public static void queryStudent(ArrayList<Student> list){
        System.out.println("查询学生");
        if(list.size() == 0){
            System.out.println("当前无学生信息，请添加后再查询");
            return;
        }
        //打印表头
        System.out.println("id\t\t姓名\t年龄\t家庭住址");
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId() + "\t" + stu.getName() + "\t"+stu.getAge() + "\t" + stu.getAddress());
        }

    }

    //判断id在集合中是否存在
    public static boolean contains(ArrayList<Student> list, String id){
//        //循环遍历集合
//        for (int i = 0; i < list.size(); i++) {
//            Student stu = list.get(i);
//            if(id.equals(stu.getId())){
//                return true;
//            }
//        }
//        return false;
        return getIndex(list,id) >= 0;
    }

    //通过id获取索引
    public static int getIndex(ArrayList<Student> list, String id){
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if(id.equals(stu.getId())){
                return i;
            }
        }
        return -1;
    }

}