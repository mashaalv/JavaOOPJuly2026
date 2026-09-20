package ru.academits.alaeva.list;

import java.util.NoSuchElementException;

public class List<E> {
    private ListItem<E> head;
    private int count; // количество элементов в списке

    // получение размера списка
    public int getSize() {
        return count;
    }

    // получение значения первого элемента
    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException("Список пуст.");
        }

        return head.getData();
    }

    // ============= проверка индекса
    private void checkIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Недопустимый индекс: " + index + " допуситмый диапазон индексов: [0; " + (count - 1) + "].");
        }
    }

    // ============ метод получения узла по индексу
    private ListItem<E> getNodeAt(int index) {
        //  checkIndex(index); в выз. методах!!!
        ListItem<E> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }

    // получение значения по указанному индексу================
    public E getData(int index) {
        checkIndex(index);

        return getNodeAt(index).getData();
    }


    // Изменение значения по индексу пусть выдает старое значение.
    public E setData(int index, E newData) {
        checkIndex(index);

        ListItem<E> node = getNodeAt(index);

        E oldData = node.getData();
        node.setData(newData);

        return oldData;
    }

    // вставка элемента в начало
    public void addFirst(E data) {
        head = new ListItem<>(data, head);
        count++;
    }

    // вставка элемента по индексу
    public void add(int index, E value) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Недопустимый index: " + index + ". Допустимый диапазон [0; " + count + "].");
        }

        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Недопустимый индекс: " + index
                    + ". Допустимый диапазон: [0, " + count + "].");
        }


        if (index == 0) {
            addFirst(value);
            return;
        }

        ListItem<E> previousNode = getNodeAt(index - 1);

        previousNode.setNext(new ListItem<>(value, previousNode.getNext()));
        count++;
    }

    // удаление первого элемента, пусть выдает значение элемента
    public E removeFirst() {
        if (head == null) {
            throw new IllegalStateException("Список пуст.");
        }

        E oldFirstData = head.getData();
        head = head.getNext();
        count--;

        return oldFirstData;
    }

    // удаление элемента по индексу, пусть выдает значение элемента
    public E remove(int index) {
        checkIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        ListItem<E> previousNode = getNodeAt(index - 1);
        ListItem<E> nodeToRemove = previousNode.getNext();
        previousNode.setNext(nodeToRemove.getNext());
        count--;

        return nodeToRemove.getData();
    }

    // удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean removeByValue(E data) {/// ////////////////////////////////
        if (head == null) {
            return false;
        }

        if (data.equals(head.getData())) {
            removeFirst();
            return true;
        }

        if (data == null) {
            if (head.getData() == null) {
                removeFirst();
                return true;
            }
        }

        ListItem<E> previousNode = head;
        ListItem<E> currentNode = head.getNext();

        while (currentNode != null) {
            if (data.equals(currentNode.getData())) {
                previousNode.setNext(currentNode.getNext());
                count--;
                return true;
            }

            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        return false;
    }

    // разворот списка за линейное время
    public void reverse() {
        if (head == null || head.getNext() == null) {
            return;
        }

        ListItem<E> previousItem = null;
        ListItem<E> currentItem = head;
        ListItem<E> nextItem = null;

        while (currentItem != null) {
            nextItem = currentItem.getNext();
            currentItem.setNext(previousItem);
            previousItem = currentItem;
            currentItem = nextItem;
        }

        head = previousItem;
    }

    // копирование списка
    public List<E> copy() {
        // создаем новый пустой список
        List<E> newList = new List<>();

        if (this.head == null) {
            return newList;
        }

        // копируем голову исходного списка
        newList.head = new ListItem<>(this.head.getData());
        // в исходном списке берем второй элемент
        ListItem<E> currentItem = this.head.getNext();
        ListItem<E> currentCopy = newList.head;

        while (currentItem != null) {
            // копируем след. элемент и связываем с предыдущим в копии списка:
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

        ListItem<E> current = head;

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