package ru.academits.alaeva.list;

public class List<T> {
    private ListItem<T> head;
    private int count;// count

    // Конструктор - инициализация пустого списка
    public List() {
        head = null;
        count = 0;
    }

    // получение размера списка
    public int getSize() {
        return count;
    }

    // получение значения первого элемента
    public T getFirst() {
        if (head == null) {
            throw new IllegalStateException("Список пуст.");
        }

        return head.getData();
    }

    // ============= проверка индекса
    private void checkIndex(int index) {
        if (count == 0) {
            throw new IllegalStateException("Список пуст.");
        }

        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Недопустимый индекс: " + index + " текущий размер списка: " + count);
        }
    }

    // ============ метод получения узла по индексу
    public ListItem<T> getNodeAt(int index) {
        checkIndex(index);
        ListItem<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }

    // получение значения по указанному индексу================
    public T getData(int index) {
        return getNodeAt(index).getData();
    }

    // Изменение значения по индексу пусть выдает старое значение.
    public T setData(int index, T newData) {
        ListItem<T> node = getNodeAt(index);
        T oldData = node.getData();
        node.setData(newData);

        return oldData;
    }

    // вставка элемента в начало
    public void addFirst(T value) {
        ListItem<T> newNode = new ListItem<>(value, head);
        head = newNode;
        count++;
    }

    // вставка элемента по индексу
    public void add(int index, T value) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Недопустимый index " + index + "Размер списка. " + count);
        }

        if (index == 0) {
            addFirst(value);
            return;
        }

        ListItem<T> prevNode = getNodeAt(index - 1);
        ListItem<T> newNode = new ListItem<>(value, prevNode.getNext());

        prevNode.setNext(newNode);
        count++;
    }

    // удаление первого элемента, пусть выдает значение элемента
    public T removeFirst() {
        if (head == null) {
            throw new IllegalStateException("Список пуст.");
        }

        T oldFirstData = head.getData();
        head = head.getNext();
        count--;

        return oldFirstData;
    }

    // удаление элемента по индексу, пусть выдает значение элемента
    public T remove(int index) {
        checkIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        ListItem<T> prevNode = getNodeAt(index - 1);
        ListItem<T> nodeToRemove = prevNode.getNext();
        prevNode.setNext(nodeToRemove.getNext());
        count--;

        return nodeToRemove.getData();
    }

    // удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean removeByValue(T value) {
        if (head == null) {
            return false;
        }

        if (value.equals(head.getData())) {
            removeFirst();
            return true;
        }

        ListItem<T> prev = head;
        ListItem<T> current = head.getNext();

        while (current != null) {
            if (value.equals(current.getData())) {
                prev.setNext(current.getNext());
                count--;
                return true;
            }

            prev = prev.getNext();
            current = current.getNext();
        }

        return false;
    }

    // разворот списка за линейное время
    public void reverse() {
        if (head == null || head.getNext() == null) {
            return;
        }

        ListItem<T> prevItem = null;
        ListItem<T> currentItem = head;
        ListItem<T> nextItem = null;

        while (currentItem != null) {
            nextItem = currentItem.getNext();
            currentItem.setNext(prevItem);
            prevItem = currentItem;
            currentItem = nextItem;
        }

        head = prevItem;
    }

    // копирование списка
    public List<T> copy() {
        // cоздаем новый пустой список
        List<T> newList = new List<>();

        if (this.head == null) {
            return newList;
        }

        // копируем голову исходного списка
        newList.head = new ListItem<>(this.head.getData());
        // в исхдодном списке берем второй элемент
        ListItem<T> currentItem = this.head.getNext();
        ListItem<T> currentCopy = newList.head;

        while (currentItem != null) {
            // копируем след. элемент и связываем с предудщим в копии списка:
            currentCopy.setNext(new ListItem<>(currentItem.getData()));
            currentCopy = currentCopy.getNext();
            newList.count++;
            currentItem = currentItem.getNext();
        }

        return newList;
    }

    // ================================  toString()
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        ListItem<T> current = head;

        while (current != null) {
            stringBuilder.append(current.getData()).append(", ");
            current = current.getNext();
        }

        if (head != null) {
            stringBuilder.setLength(stringBuilder.length() - 2);
        }

        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}