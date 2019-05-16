import org.junit.Test;
import static java.lang.System.out;

/**
 * @author lorem
 */
public class NodeNodeNext {
    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    @Test
    public void test() {
        winner(41, 3);
    }

    void winner(int n, int m) {
        Node head = new Node(1);
        Node last = head;
        /** 一条单链数据 */
        for (int i = 2; i <= n; i++) {
            last = (last.next = new Node(i));
        }
        /**回调指向，形成环形链*/
        last.next = head;
        out.println("依次死亡的序号：");
        while (last.value != last.next.value) {
            for (int i = 1; i < m; i++) {
                last = last.next;
            }
            out.print(last.next.value + " ");
            last.next = last.next.next;
        }
        out.println("\n" + "最后存活的序号：");
        out.printf("%d", last.value);
    }
}
