package com.core.tools.utils;

import cn.hutool.core.collection.CollectionUtil;
import com.core.tools.entity.City;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：[2,1]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000
//
//
//
//
public class Solution {
    public static void main(String[] args) {
        BigDecimal zero = BigDecimal.ZERO;
        System.out.println(zero.toString());
    }

    /**
     * 汉罗塔分析<br/>
     * 1. 将A所有元素移动到C <br/>
     * 2. 一次只能移动一个并且，大的不能压小的<br/>
     * 3. 分析规律<br/>
     * 只有一个元素直接移动<br/>
     * 如果有两个元素，按照大的不能压小的原则<br/>
     * 优先级<br/>
     * 对于目标柱C来说， C -> A -> B<br/>
     * 对于临时柱B来说， B -> C -> A<br/>
     * 对于原柱A来说，   A -> B -> C<br/>
     * 一旦有一个柱子为空则将移动权转移给原柱 A<br/>
     * <br/>
     * 实现<br/>
     *  递归实现
     * @param A 原柱
     * @param B 临时柱
     * @param C 目标柱
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        //如果 A B 柱为空，则返回C柱
        if (A.isEmpty() && B.isEmpty()){
            return;
        }
        //需要移动元素
        Integer remove = A.remove(A.size() - 1);

    }

    //如何实现快慢指针和链表反转
    public static boolean isPalindrome(ListNode head) {
        ListNode node1, node2;
        node2 = node1 = head;
        while (node2 != null && node2.next != null){
            node1 = node1.next;
            node2 = node2.next.next;
        }
        if (node1 == null){
            return true;
        }

        //后半段链表
        node2 = head;
        //反转前半段链表
        node1 = reverse(null, node1);
        while (node1 != null){
            if (node1.val != node2.val){
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode fort, ListNode curr){
        if (curr == null){
            return fort;
        }
        ListNode next = curr.next;
        curr.next = fort;
        return reverse(curr, next);
    }

    /**
     * 两数据合并，非递减
     *
     * @param nums1 arr1
     * @param m     nums1.length-n
     * @param nums2 arr2
     * @param n     nums2.length
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return;
        }
        if (m == 0){
            int i = 0;
            while (i< n){
                nums1[i] = nums2[i];
                i++;
            }
            return;
        }
        int p = 0, q = 0;
        while (p+q <= m+n){

            if (q == n){
                break;
            }
            if (p+q>m+n){
                break;
            }
            int p1 = nums1[p];
            int q1 = nums2[q];
            if (p1 > q1) {
                int temp = m+q;
                while (temp > m-q-1) {
                    int tempVue = nums1[temp-1];
                    nums1[temp] = tempVue;
                    temp--;
                }
                nums1[p] = q1;
                q++;p++;
            }else if (p== m+q-1 && nums1[p] < nums2[q]){
                nums1[++p] = nums2[q];
                q++;
            }else {
                p++;
            }
        }
    }

    /**
     * 计算并返回 x 的 算术平方根 。(非负)
     *
     * @param x x
     * @return Sqrt
     */
    public static int mySqrt(int x) {
        int p = 1;
        int q = x / 2 + 1;
        return mySqrt(p, q, x);
    }

    public static int mySqrt(int p, int q, int x) {
        float num = q;
        float square = num * num;
        if (square <= x && square >= (x / 2)) {
            return q;
        }
        q = q / 2 + 1;
        return mySqrt(p, q, x);
    }

    /**
     * 数字相加
     *
     * @param num1 "123"
     * @param num2 "23"
     * @return "146"
     */
    public static String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int temp = 0;
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        while (index2 >= 0 || index1 >= 0 || temp != 0) {
            int i = index1 < 0 ? 0 : num1.charAt(index1) - '0';
            int j = index2 < 0 ? 0 : num2.charAt(index2) - '0';
            int sum = i + j + temp;
            temp = sum / 10;
            builder.append(sum % 10);
            index1--;
            index2--;
        }
        return builder.reverse().toString();
    }

    public ListNode reverseList(ListNode head) {
        return head;
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}