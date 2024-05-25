package org.prac3;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class MySet implements Set<Integer> {

    private Integer[] values = new Integer[5];
    private final Semaphore semaphore = new Semaphore(1);
    private int lastIndex = 0;

    @Override
    public int size() {
        try {
            semaphore.acquire();
            return lastIndex;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean isEmpty() {
        try {
            semaphore.acquire();
            return lastIndex == 0;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean contains(Object o) {
        try {
            semaphore.acquire();
            for (int i = 0; i < lastIndex; i++) {
                if (o == values[i]) {
                    semaphore.release();
                    return true;
                }
            }
            semaphore.release();
            return false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int current = 0;
            @Override
            public boolean hasNext() {
                return current < lastIndex;
            }

            @Override
            public Integer next() {
                try {
                    semaphore.acquire();
                    if (current < lastIndex) {
                        Integer nextValue = values[current];
                        current++;
                        return nextValue;
                    } else {
                        throw new RuntimeException("Ты тронул это зря!!!");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }
            }
        };
    }

    @Override
    public Object[] toArray() {
        return values.clone();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return a;
    }

    @Override
    public boolean add(Integer integer) {
        try {
            semaphore.acquire();
            if (values.length <= lastIndex) {
                extendArray();
            }
            if (!contains(integer)) {
                values[lastIndex] = integer;
                return true;
            }
            return false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            semaphore.acquire();
            int currentIndex = -1;
            boolean found = false;
            for (int i = 0; i < lastIndex; i++) {
                if (values[i] != o && !found) {
                    currentIndex+=1;
                    found = true;
                }
                if (currentIndex >= 0) {
                    values[i] = values[currentIndex];
                }
            }
            return found;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            semaphore.acquire();
            for (Object o: c) {
                if (!contains(o)) {
                    return false;
                }
            }
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        for (Integer i: c) {
            add(i);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            semaphore.acquire();
            int removedCounter = 0;
            for (int i = 0; i < values.length; i++) {
                if (!c.contains(values[i-removedCounter])) {
                    remove(values[i-removedCounter]);
                    removedCounter++;
                }
            }
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            semaphore.acquire();
            for (Object o: c) {
                remove(o);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        return true;
    }

    @Override
    public void clear() {
        values = new Integer[5];
        lastIndex = 0;
    }

    private void extendArray() {
        values = Arrays.copyOf(values, values.length*2);
    }
}
