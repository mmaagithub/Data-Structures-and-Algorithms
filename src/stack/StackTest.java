package stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackTest {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();
    public void push(Integer node) {
        //两个队列都为空时，优先考虑queue1
    		   queue1.add(node);
    }

    public int pop() {
        //两个栈都为空时，没有元素可以弹出
        if (queue1.isEmpty()&&queue2.isEmpty()) {
            try {
                throw new Exception("stack is empty");
            } catch (Exception e) {
            }
        }
        //如果queue1为空，queue2有元素， 将queue2的元素依次放入queue1中，直到最后一个元素，我们弹出。
        if (queue1.isEmpty()) {
            while (queue2.size()>1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
 
        if (queue2.isEmpty()) {
            while (queue1.size()>1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        return (Integer) null;
    }
	
    public static void main(String[] args) {
        StackTest s = new StackTest();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.push(5);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}