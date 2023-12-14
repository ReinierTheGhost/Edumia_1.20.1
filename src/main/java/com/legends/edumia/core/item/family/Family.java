package com.legends.edumia.core.item.family;

import java.util.Comparator;
import java.util.List;

public abstract class Family<T> implements Comparator {
    private final List<T> members;

    public Family(List<T> members) {
        this.members = members;
    }

    public Family<T> add(T member) {
        if (!this.members.contains(member)) {
            this.members.add(member);
            this.members.sort(this);
        }

        return this;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
