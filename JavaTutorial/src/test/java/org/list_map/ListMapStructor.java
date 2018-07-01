package org.list_map;

import java.util.*;

public class ListMapStructor {

    public void list(){
        Collection collection = new ArrayList();
        List list = new ArrayList<>();
        List vector = new Vector();
        List linkedList = new LinkedList();

        Set set=null;
        HashSet hashSet=null;
        LinkedHashSet linkedHashSet=null;
        TreeSet treeSet=null;


        Map map=null;
        HashMap hashMap=null;
        LinkedHashMap linkedHashMap=null;
        Hashtable hashtable=null;
        TreeMap treeMap=null;


        Collection colSet = new Set() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
    }
}
