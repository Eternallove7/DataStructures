package com.study.linkedlist;

import java.util.Stack;

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
        singleLinkedList.delete(2);
        singleLinkedList.delete(3);
        System.out.println("删除后的链表情况~");
        singleLinkedList.list();

        // 测试一下求单链表中有效节点的个数
        System.out.println("有效的节点个数 = " + getLength(singleLinkedList.getHead()));

        // 测试一下是否得到了倒数第k个节点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(),3);
        System.out.println("res = " + res);

        singleLinkedList.add(heroNode1);

        System.out.println("原来的链表情况~");
        singleLinkedList.list();

//        System.out.println("反转后的链表情况~");
//        reverseList(singleLinkedList.getHead());
//        singleLinkedList.list();

        System.out.println("测试逆序打印单链表~");
        reversePrint(singleLinkedList.getHead());



        HeroNode one = new HeroNode(1, "一", "①");
        HeroNode two = new HeroNode(2, "二", "②");
        HeroNode three = new HeroNode(3, "三", "③");
        HeroNode zero = new HeroNode(0, "零", "棂");
        HeroNode two1 = new HeroNode(2, "二", "②");
        HeroNode four = new HeroNode(4, "四", "④");

        SingleLinkedList s1 = new SingleLinkedList();
        s1.add(one);
        s1.add(two);
        s1.add(three);

        SingleLinkedList s2 = new SingleLinkedList();
        s2.add(zero);
        s2.add(two1);
        s2.add(four);

        // 测试合并链表
        System.out.println("双链表合并~");
        HeroNode s3 = mergeTwoLists(s1.getHead(), s2.getHead());
        printList(s3);



    }

    public static HeroNode mergeTwoLists(HeroNode h1,HeroNode h2){
        HeroNode newHearNode = new HeroNode(0,"","");
        // temp用来操作链表，初始temp在链表头
        HeroNode temp = newHearNode;
        // 跳过链表头
        h1 = h1.next;
        h2 = h2.next;

        while (h1 != null && h2 != null){
            if (h1.no < h2.no){
                temp.next = h1;
                temp = temp.next;
                h1 = h1.next;
            } else {
                temp.next = h2;
                temp = temp.next;
                h2 = h2.next;
            }
        }
        if (h1 == null){
            temp.next = h2;
        } else {
            temp.next = h1;
        }
        return newHearNode;
    }

    // 使用 栈 的先进后出特点，实现逆序打印
    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        // 创建一个栈，将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        // 将链表的所有节点压入栈
        while (temp != null){
            stack.push(temp);
            temp = temp.next;// 这样就可以压入下一个节点
        }
        // 将栈中的节点进行打印，pop 出栈
        while (stack.size() > 0){
            System.out.println(stack.pop());// stack的特点是先进后出
        }
    }

    public static void reverseList(HeroNode head){
        // 如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null){
            return;
        }
        // 定义一个辅助的指针，帮助我们遍历原来的链表
        HeroNode temp = head.next;
        HeroNode next = null;// 指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        // 遍历原来的链表
        // 每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        while (temp != null){
            next = temp.next;// 先暂时保存当前节点的下一个节点，因为后面需要使用
            temp.next = reverseHead.next;// 将temp的下一个节点指向新的链表的最前端
            reverseHead.next = temp;
            temp = next;// 让temp后移
        }
        // 将head.next 指向 reverseHead.next  实现单链表的反转
        head.next = reverseHead.next;

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

    public static void printList(HeroNode head){
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
