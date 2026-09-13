package ru.academits.alaeva.array_list;

import java.util.*;

public class ArrayList<E> implements List<E> {
    private E[] items;
    private int size;

    // конструктор
    public ArrayList() {
        //noinspection unchecked
        items = (E[]) new Object[10];// capacity == вместимость, размер списка size - это количество элементов, разные вещи
        size = 0; // размер списка
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Размерность списка больше или равна 0, передано:" + capacity);
        }

        //noinspection unchecked
        items = (E[]) new Object[capacity];
    }

    // ==================== методы list
    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // == вспомогательный метод checkIndex
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс, размерность списка: " + size);
        }
    }

    private void checkIndexForAdd(int index) {   // для add(int, E): 0 <= index <= size
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс, размерность списка: " + size);
        }
    }

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
        // вернуть старый элемент - как в List
        return oldElement;
    }

    // === вспомогательный метод increaseCapacity
    private void increaseCapacity() {
        if (items.length == 0) {
            //noinspection unchecked
            items = (E[]) new Object[10];
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
        // TODO: Сдвинь элементы вправо на 1 позицию, начиная с index (используй System.arraycopy).
        // TODO: Вставь element, увеличь size.
    }

    // ====================================================остальные методы лист
    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }


/*    public void ensureCapacity(int minCapacity) { }

    public void trimToSize() {  }*/


    //  @Override public boolean remove(Object o) { throw new UnsupportedOperationException(); }
}
