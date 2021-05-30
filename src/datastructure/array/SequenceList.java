package datastructure.array;

/**
 * 动态数组（顺序表）
 *
 * @param <E>
 * @author rsw
 */
public class SequenceList<E> {

    /** 存储对象的一维数组 */
    private E[] data;

    /** 顺序表的元素个数 */
    private int size;

    /**
     * 构造函数，传入数组的容量capacity
     *
     * @param capacity 容量
     */
    @SuppressWarnings("unchecked")
    public SequenceList(int capacity) {
        //先声明Object类型的数组，然后在进行强制转换
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public SequenceList() {
        //调用有参的构造方法
        this(10);
    }

    /**
     * 传入一个数组，将其转为动态数组
     *
     * @param arr 传入的数组
     */
    @SuppressWarnings("unchecked")
    public SequenceList(E[] arr) {
        data = (E[]) new Object[arr.length];
        //数组拷贝
        System.arraycopy(arr, 0, data, 0, arr.length);
        size = arr.length;
    }

    /**
     * 获取数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组中的元素个数
     *
     * @return /
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组是否为空
     *
     * @return /
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在index索引的位置插入一个新元素e
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        //如果超出原来数组的空间，那么对其扩容（调用扩容的方法）
        if (size == data.length) {
            resize(2 * data.length);
        }

        //index之后的元素统一向后移一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        //维护元素数量
        size++;
    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param e /
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在所有元素前添加一个新元素
     *
     * @param e /
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 获取index索引位置的元素
     *
     * @param index 索引位置
     * @return 目标查询元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 获取最后一个元素
     *
     * @return /
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取第一个元素(调用get()可以方便抛出异常)
     *
     * @return /
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 修改index索引位置的元素为e
     *
     * @param index /
     * @param e     /
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     *
     * @param e /
     * @return /
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     *
     * @param e /
     * @return /
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return - 1;
    }

    /**
     * 从数组中删除index位置的元素, 返回删除的元素
     *
     * @param index /
     * @return /
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        E ret = data[index];
        //index后的元素统一向前移一位
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        //泛型，之前删除的元素的引用仍然存在（不是必须，程序优化）
        data[size] = null;
        //当数组实际元素减小到空间的一半的时候，对其进行缩小
        //if(size == data.length / 2)
        /*
            解决当一半的时候一次添加，一次删除，造成的一直扩容和减小的操作，
            增加必须要扩容，所以可以让缩容变得更懒时在进行，即1/4时
            data.length / 2 != 0防止数组大小最后变成0，造成异常
        */
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 从数组中删除第一个元素, 返回删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素, 返回删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     *
     * @param e /
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != - 1) {
            remove(index);
        }
    }

    /**
     * 根据索引交换数组的元素
     *
     * @param i 索引1
     * @param j 索引2
     */
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;

    }

    /**
     * 打印输出当前的数组信息
     *
     * @return /
     */
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    /**
     * 均摊复杂度
     * 9次addL ast操作，触发resize， 总共进行了17次基本操作
     * 假设capacity=n, n+1次addL ast,触发resize, 总共进行2n+ 1次基本操作
     * 平均，每次addLast操作，进行2次基本操作
     * 使数组的容量变成动态
     * 将数组空间的容量变成newCapacity大小（私有方法，不允许随便调用）
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}

