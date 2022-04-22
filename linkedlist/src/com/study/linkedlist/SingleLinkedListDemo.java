package com.study.linkedlist;

/**
 * @author RenAshbell
 * @create 2022-04-22-21:33
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        // 先创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        // 创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        // 加入
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode4);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);

        // 加入按照编号的顺序
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode3);

        // 显示
        singleLinkedList.list();

        // 测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2,"小卢","玉麒麟~~");
        singleLinkedList.update(newHeroNode);

        System.out.println("修改后的链表情况~");
        singleLinkedList.list();


        // 测试删除节点的代码
        singleLinkedList.delete(1);
        singleLinkedList.delete(4);
        System.out.println("删除后的链表情况~");
        singleLinkedList.list();

        // 测试一下求单链表中有效节点的个数
        System.out.println("有效的节点个数 = " + getLength(singleLinkedList.getHead()));

        // 测试一下是否得到了倒数第k个节点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(),3);
        System.out.println("res = " + res);

        reversed(singleLinkedList.getHead());

    }

    public static void reversed(HeroNode head){
        HeroNode temp = head;
        HeroNode temp1 = head;
        HeroNode reverseHead = new HeroNode(0,"","");
        int size = getLength(head);
        while (size > 0){
            for (int i = 0; i < size - 1; i++) {
                temp = temp.next;
            }
            reverseHead.next = temp;
            size--;
            temp = temp1;
            reverseHead = reverseHead.next;
        }

        System.out.println(reverseHead);

//        // 判断链表是否为空
//        if (reverseHead.next == null){
//            System.out.println("链表为空");
//        }
//        // 因为头节点不能动，因此我们需要一个辅助变量来遍历
//        HeroNode temprh = reverseHead.next;
//        while (true){
//            // 判断是否到链表最后
//            if (temprh == null){
//                break;
//            }
//            System.out.println(temprh);
//            // 将next后移，一定小心
//            temprh = temprh.next;
//        }
    }

    // 查找单链表中的倒数第k个节点
    // 思路
    // 1.编写一个方法，接收head节点，同时接收一个index
    // 2.index 表示倒数第index个节点
    // 3.先把链表从头到尾遍历一下，得到链表的总的长度getLength
    // 4.得到size后，我们从链表的第一个开始遍历(size-index)个
    // 5.如果找到了返回该节点，否则返回为空
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        // 判断，如果链表为空，返回null
        if (head.next == null){
            return null;
        }
        // 第一次遍历得到链表的长度
        int size = getLength(head);
        // 第二次遍历 size-index 位置，就是我们倒数的第k个节点
        // 先做一个index的校验
        if (index <= 0 || index > size){
            return null;
        }
        // 定义个辅助变量，for循环定位到倒数的index
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // 方法：获取到单链表的节点的个数(如果是带头节点的链表，需要不统计头节点)

    /**
     *
     * @param head 链表的头节点
     * @return  返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        // 定义一个辅助的变量
        HeroNode temp = head.next;
        while (temp != null){
            length++;
            temp = temp.next;// 遍历
        }
        return length;
    }
}

// 定义SingleLinkedList 管理英雄
class SingleLinkedList{
    // 先初始化一个头节点，头节点不要动，不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    // 添加节点到单向链表
    // 思路，当不考虑编号的顺序时
    // 1.找到当前链表的最后节点
    // 2.将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode){
        // 因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (true){
            // 找到链表的最后
            if (temp.next == null){
                break;
            }
            // 如果没有找到最后，将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向链表的最后
        temp.next = heroNode;
    }

    // 第二种添加英雄时，根据排名将英雄插入到指定位置
    // 如果有这个排名，则添加失败，并给出提示
    public void addByOrder(HeroNode heroNode){
        // 因为头节点不能动，因此我们仍然通过一个辅助指针来帮助找到添加的位置
        // 因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;// 标志添加的编号是否存在，默认false
        while (true){
            if (temp.next == null){// 说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no){// 位置找到了，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no){// 说明希望添加的heroNode的编号已然存在
                flag = true;
                break;
            }
            temp = temp.next;// 后移，遍历当前链表
        }
        // 判断flag的值
        if (flag){// 不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在，不能加入\n" , heroNode.no);
        } else {
            // 加入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 修改节点的信息，根据no编号来修改，即no编号不能改
    // 说明
    // 1.根据newHeroNode 的 no 来修改即可
    public void update(HeroNode newHeroNode){
        // 判断是否为空
        if (head.next == null){
            System.out.println("链表为空！");
            return;
        }
        // 找到需要修改的节点，根据no编号
        // 定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;// 已经遍历完链表
            }
            if (temp.no == newHeroNode.no){
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag 判断是否找到要修改的节点
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {// 没有找到
            System.out.printf("没有找到编号 %d 的节点,不能修改",newHeroNode.no);
        }
    }

    // 删除节点
    // 思路
    // 1.head不能动，因此我们需要一个temp辅助节点找到待删除的前一个节点
    // 2.说明我们在比较时，是temp.next.no 和 需要删除的节点的no比较
    public void delete(int no){
        // 判断是否为空
        if (head.next == null){
            System.out.println("链表为空！");
            return;
        }
        // 找到需要修改的节点，根据no编号
        // 定义一个辅助变量
        HeroNode temp = head;
        boolean flag = false;// 标志是否找到待删除节点
        while (true){
            if (temp.next == null){ // 已经到了链表的最后
                break;
            }
            if (temp.next.no == no){
                // 找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag 判断是否找到要删除的节点
        if(flag) {
            temp.next = temp.next.next;
        } else {// 没有找到
            System.out.printf("没有找到编号 %d 的节点,不能删除",no);
        }
    }

    // 显示链表[遍历]
    public void list(){
        // 判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
        }
        // 因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            // 判断是否到链表最后
            if (temp == null){
                break;
            }
            System.out.println(temp);
            // 将next后移，一定小心
            temp = temp.next;
        }
    }

}

// 定义一个HeroNode , 每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    // 构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 为了显示方便，重写toString方法
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' + '}';
    }
}
