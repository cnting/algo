package offer.practice

import java.util.*

/**
 * Created by cnting on 2020/5/28
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
class Offer8 {
    //用来增加
    val stack1 = Stack<Int>()
    //用来删除
    val stack2 = Stack<Int>()

    fun appendTail(value: Int) {
        stack1.push(value)
    }

    fun deleteHead(): Int {
        if (stack2.isNotEmpty()){
            return stack2.pop()
        }
        if(stack1.isEmpty()){
            return -1
        }
        while (stack1.isNotEmpty()){
            stack2.push(stack1.pop())
        }
        return stack2.pop()
    }
}

fun main() {
    val obj = Offer8()
    obj.appendTail(1)
    println(obj.deleteHead())
    obj.appendTail(2)
    obj.appendTail(3)
    obj.appendTail(4)
    println(obj.deleteHead())
    println(obj.deleteHead())
    println(obj.deleteHead())
    println(obj.deleteHead())
}