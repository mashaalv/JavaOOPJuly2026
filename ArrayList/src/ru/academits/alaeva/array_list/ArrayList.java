package ru.academits.alaeva.array_list;

import java.util.*;

public class ArrayList<E> implements List<E> {
    private E[] items;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    // ===================================== конструкторы
    public ArrayList() {
        //noinspection unchecked
        items = (E[]) new Object[DEFAULT_CAPACITY];// capacity == вместимость, размер списка size - это количество элементов
        size = 0; // размер списка
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Размерность списка должна быть больше или равна 0, передано:" + capacity);
        }

        //noinspection unchecked
        items = (E[]) new Object[capacity];
    }

    // ==================== методы list
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // == вспомогательный метод checkIndex
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс: " + index + ". Допустимый диапазон индексов: [0; " + (size - 1) + "].");
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс: " + index + ". Допустимый диапазон индексов: [0; " + size + "].");
        }
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) items[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        // Сохраним старый элемент в переменную
        E oldElement = (E) items[index];
        // запишем новый элемент
        items[index] = element;
        // нужно вернуть старый элемент (List)
        return oldElement;
    }

    // === вспомогательный метод increaseCapacity
    private void increaseCapacity() {
        if (items.length == 0) {
            //noinspection unchecked
            items = (E[]) new Object[DEFAULT_CAPACITY];
            return;
        }

        items = Arrays.copyOf(items, items.length * 2);
    }

    // ======================== метод add =======================
    @Override
    public boolean add(E item) {
        if (size == items.length) {
            increaseCapacity();
        }
        items[size] = item;
        ++size;
        return true;
    }

    @Override
    public void add(int index, E item) {
        checkIndexForAdd(index);

        if (size == items.length) {
            increaseCapacity();
        }
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        ++size;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldValue = items[index];

        // если не последний элемент, то копируем после индекса
        if (index < size - 1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }

        items[size - 1] = null;
        --size;
        return oldValue;
    }

    public void ensureCapacity(int minCapacity) {
        int itemsLength = items.length;
        int newCapacity;

        if (minCapacity <= itemsLength) {
            return;
        }

        if (itemsLength == 0) {
            newCapacity = Math.max(minCapacity, DEFAULT_CAPACITY);
        } else {
            newCapacity = Math.max(itemsLength * 2, minCapacity);
        }
        items = Arrays.copyOf(items, newCapacity);
    }

    public void trimToSize() {
        int itemsLength = items.length;

        if (size < itemsLength) {
            items = Arrays.copyOf(items, size);
        }
    }

    // == вспомогательный метод capacity
    public int capacity() {
        return items.length;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        for (int i = 0; i < size - 1; i++) {
            stringBuilder.append(items[i]).append(", ");

        }

        stringBuilder.append(items[size - 1]).append(']');

        return stringBuilder.toString();
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }

        size = 0;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == null) {
                if (items[i] == null) {
                    return i;
                }
            } else {
                if (o.equals(items[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (o == null) {
                if (items[i] == null) {
                    return i;
                }
            } else {
                if (o.equals(items[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);

        if (i >= 0) {
            remove(i);
            return true;
        }

        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    /*   @Override
       public <T> T[] toArray(T[] a) {
           return null;
       }
   */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return addAll(size, collection);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        checkIndexForAdd(index);

        Object[] array = collection.toArray();
        int arraySize = array.length;

        if (arraySize == 0) {
            return false;
        }

        ensureCapacity(size + arraySize);

        System.arraycopy(items, index, items, index + arraySize, size - index);

        for (int i = 0; i < arraySize; i++) {
            //noinspection unchecked
            items[index + i] = (E) array[i];
        }

        size = size + arraySize;

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isChanged = false;

        for (int i = 0; i < size; i++) {
            if (c.contains(items[i])) {
                remove(i);
                i--;
                isChanged = true;
            }
        }

        return isChanged;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isChanged = false;

        for (int i = 0; i < size; i++) {
            if (!c.contains(items[i])) {
                remove(i);
                i--;
                isChanged = true;
            }
        }

        return isChanged;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<E> {
        private int cursor = 0; // позиция следующего элемента
        private int lastReturned = -1; // позиция возвращаемого

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            if (cursor >= size) {
                throw new NoSuchElementException();
            }

            lastReturned = cursor;
            return (E) items[cursor++];
        }

        @Override
        public void remove() {
            if (lastReturned < 0) {
                throw new IllegalStateException();
            }

            System.arraycopy(items, lastReturned + 1, items, lastReturned, size - lastReturned - 1);
            size--;
            items[size] = null;
            cursor = lastReturned;
            lastReturned = -1;
        }
    }
}