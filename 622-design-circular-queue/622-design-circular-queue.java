class MyCircularQueue {

//     List<Integer> queue;
//     int k;
//     int front;
//     int rear;
    
//     public MyCircularQueue(int k) {
//         this.queue = new ArrayList<>();
//         this.k = k;
//         this.front = 0;
//         this.rear = 0;
//         this.queue.add(-1);
//     }
    
//     public boolean enQueue(int value) {

//         if (front == rear && queue.get(front) == -1) {
//             queue.set(rear, value);
//             return true;
//         }
        
//         if (rear - front == k - 1) {
//             return false;
//         }
//         rear ++;
//         //queue.set(rear, value);
//         queue.add(value);
//         return true;
//     }
    
//     public boolean deQueue() {
//         if (front == rear && queue.get(front) == -1) {
//             return false;
//         }
//         if (front == rear && queue.get(front) != -1) {
//             queue.set(front, -1);
//             return true;
//         }
//         queue.set(front, -1);
//         front ++;
//         return true;
//     }
    
//     public int Front() {
//         if (front == rear && queue.get(front) == -1) {
//             return -1;
//         }
//         return queue.get(front);
//     }
    
//     public int Rear() {
//         if (front == rear && queue.get(front) == -1) {
//             return -1;
//         }
//         return queue.get(rear);
//     }
    
//     public boolean isEmpty() {
//         return front == rear && queue.get(front) == -1;
//     }
    
//     public boolean isFull() {
//         return rear - front == k - 1;
//     }
            final int[] a;
        int front = 0, rear = -1, len = 0;

        public MyCircularQueue(int k) { a = new int[k];}

        public boolean enQueue(int val) {
            if (!isFull()) {
                rear = (rear + 1) % a.length;
                a[rear] = val;
                len++;
                return true;
            } else return false;
        }

        public boolean deQueue() {
            if (!isEmpty()) {
                front = (front + 1) % a.length;
                len--;
                return true;
            } else return false;
        }

        public int Front() { return isEmpty() ? -1 : a[front];}

        public int Rear() {return isEmpty() ? -1 : a[rear];}

        public boolean isEmpty() { return len == 0;}

        public boolean isFull() { return len == a.length;}
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */