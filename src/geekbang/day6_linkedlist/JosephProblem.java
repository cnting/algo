package geekbang.day6_linkedlist;

/**
 * 约瑟夫环：人们站在一个等待被处决的圈子里。 计数从圆圈中的指定点开始，并沿指定方向围绕圆圈进行。 在跳过指定数量的人之后，执行下一个人。
 * 对剩下的人重复该过程，从下一个人开始，朝同一方向跳过相同数量的人，直到只剩下一个人，并被释放
 * 问题：给定人数、起点、方向和要跳过的数字，选择初始圆圈中的位置以避免被处决
 */
class JosephProblem {

    public static void main(String[] args) {
        System.out.println("===============");
        System.out.println("最后幸免的人:" + getRightPosition(10, 3, 2));
        System.out.println("===============");
    }

    private static int getRightPosition(int sum, int startPosition, int jumpCount) {
        if (jumpCount <= 0) {
            throw new IllegalArgumentException("jumpCount无效");
        }
        // 1.放到循环链表中
        Person firstPerson = generateCircle(sum);
        // 2.找到开始person
        int start = 0;
        Person person = firstPerson;
        while (start < startPosition - 1) {
            person = person.nextPerson;
            start++;
        }
        // 3.处决
        int jump = 1;
        while (person.nextPerson != null) {
            if (jump % (jumpCount+1) == 0) {
                if (person.nextPerson == person.prePerson) {
                    person = person.nextPerson;
                    break;
                }
                person.nextPerson.prePerson = person.prePerson;
                person.prePerson.nextPerson = person.nextPerson;
            }
            person = person.nextPerson;
            jump++;
        }

        return person.position;
    }

    private static Person generateCircle(int sum) {
        Person person = new Person(0);
        Person firstPerson = person;
        for (int i = 1; i < sum; i++) {
            Person nextPerson = new Person(i);
            person.nextPerson = nextPerson;
            nextPerson.prePerson = person;
            person = person.nextPerson;
        }
        person.nextPerson = firstPerson;
        firstPerson.prePerson = person;
        return firstPerson;
    }

}

class Person {
    int position;
    Person prePerson;
    Person nextPerson;

    public Person(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            return position == ((Person) obj).position;
        }
        return false;
    }

    @Override
    public String toString() {
        return "position:" + position + ",pre:" + (prePerson == null ? "null" : prePerson.position) + ",next:"
                + (nextPerson == null ? "null" : nextPerson.position);
    }
}