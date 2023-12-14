package com.legends.edumia.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

public class OptimizedList<T> implements List<T> {
    private List<T> backing = Collections.emptyList();

    public OptimizedList() {
    }

    public void trim() {
        if (this.backing instanceof ArrayList) {
            ((ArrayList)this.backing).trimToSize();
        }

    }

    public int size() {
        return this.backing.size();
    }

    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    public boolean contains(Object o) {
        return this.backing.contains(o);
    }

    public Iterator<T> iterator() {
        return this.backing.iterator();
    }

    public Object[] toArray() {
        return this.backing.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return this.backing.toArray(a);
    }

    public boolean add(T t) {
        if (this.backing.isEmpty()) {
            this.backing = Collections.singletonList(t);
            return true;
        } else if (this.backing.size() == 1) {
            this.backing = new ArrayList(this.backing);
            this.backing.add(t);
            return true;
        } else {
            return this.backing.add(t);
        }
    }

    public boolean remove(Object o) {
        if (this.backing.isEmpty()) {
            return false;
        } else if (this.backing.size() == 1) {
            if (this.backing.get(0).equals(o)) {
                this.backing = Collections.emptyList();
                return true;
            } else {
                return false;
            }
        } else {
            return this.backing.remove(o);
        }
    }

    public boolean containsAll(Collection<?> c) {
        return this.backing.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return this.backing.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return this.backing.addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return this.backing.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        if (this.backing.isEmpty()) {
            return false;
        } else if (this.backing.size() == 1) {
            if (!c.contains(this.backing.get(0))) {
                this.backing = Collections.emptyList();
                return true;
            } else {
                return false;
            }
        } else {
            return this.backing.retainAll(c);
        }
    }

    public void sort(Comparator<? super T> comparator) {
        if (this.backing.size() > 1) {
            this.backing.sort(comparator);
        }
    }

    public void replaceAll(UnaryOperator<T> operator) {
        if (!this.backing.isEmpty()) {
            if (this.backing.size() == 1) {
                this.set(0, operator.apply(this.backing.get(0)));
            } else {
                this.backing.replaceAll(operator);
            }
        }
    }

    public void clear() {
        if (!this.backing.isEmpty()) {
            if (this.backing.size() == 1) {
                this.backing = Collections.emptyList();
            } else {
                this.backing.clear();
            }
        }
    }

    public T get(int index) {
        return this.backing.get(index);
    }

    public T set(int index, T element) {
        if (this.backing.isEmpty()) {
            throw this.outOfBounds(0, index);
        } else if (this.backing.size() == 1) {
            if (index != 0) {
                throw this.outOfBounds(1, index);
            } else {
                T previous = this.backing.get(0);
                this.backing = Collections.singletonList(element);
                return previous;
            }
        } else {
            return this.backing.set(index, element);
        }
    }

    public void add(int index, T element) {
        if (this.backing.isEmpty()) {
            if (index != 0) {
                throw this.outOfBounds(0, index);
            } else {
                this.backing = Collections.singletonList(element);
            }
        } else if (this.backing.size() == 1) {
            if (index >= 0 && index <= 1) {
                List<T> next = new ArrayList();
                next.add(index == 0 ? element : this.backing.get(0));
                next.add(index == 0 ? this.backing.get(0) : element);
                this.backing = next;
            } else {
                throw this.outOfBounds(1, index);
            }
        } else {
            this.backing.add(index, element);
        }
    }

    public T remove(int index) {
        if (this.backing.isEmpty()) {
            throw this.outOfBounds(0, index);
        } else if (this.backing.size() == 1) {
            if (index != 0) {
                throw this.outOfBounds(1, index);
            } else {
                T previous = this.backing.get(0);
                this.backing = Collections.emptyList();
                return previous;
            }
        } else {
            return this.backing.remove(index);
        }
    }

    public int indexOf(Object o) {
        return this.backing.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return this.backing.lastIndexOf(o);
    }

    public ListIterator<T> listIterator() {
        return this.backing.listIterator();
    }

    public ListIterator<T> listIterator(int index) {
        return this.backing.listIterator(index);
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return this.backing.subList(fromIndex, toIndex);
    }

    private IndexOutOfBoundsException outOfBounds(int size, int index) {
        return new IndexOutOfBoundsException("Size: " + size + ", Index:" + index);
    }

    @SafeVarargs
    public static <T> com.legends.edumia.core.util.OptimizedList<T> of(T... values) {
        com.legends.edumia.core.util.OptimizedList<T> list = new com.legends.edumia.core.util.OptimizedList();
        Collections.addAll(list, values);
        return list;
    }
}
