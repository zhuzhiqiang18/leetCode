package com.zzq.leetcode._2_AddTwoNumbers;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers test = new AddTwoNumbers();

        ListNode a=new ListNode(2);
        ListNode b=new ListNode(4);
        ListNode c=new ListNode(3);
        a.next=b;
        b.next=c;

        ListNode aa=new ListNode(5);
        ListNode bb=new ListNode(6);
        ListNode cc=new ListNode(4);
        aa.next=bb;
        bb.next=cc;


        ListNode node= test.addTwoNumbers(a,aa);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }

    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode reLisNode=listNode;
        int flag=0;
        while (l1!=null||l2!=null){
            ListNode temp= new ListNode(0);

            temp.val+=flag;
            flag=0;
            //大于10
            if(l1!=null&&l2!=null){
                temp.val+=l1.val+l2.val;
                l1=l1.next;
                l2=l2.next;
            }else if(l1==null){
                temp.val+=l2.val;
                l1=null;
                l2=l2.next;
            }else if(l2==null){
                temp.val+=l1.val;
                l2=null;
                l1=l1.next;
            }
            //判断是否满10进1
            if(temp.val>=10){
                flag=1;
                temp.val-=10;
            }

            listNode.next=temp;
            listNode=temp;
        }

        if(flag!=0){
            listNode.next=new ListNode(flag);
        }
        return reLisNode.next;
    }

}
