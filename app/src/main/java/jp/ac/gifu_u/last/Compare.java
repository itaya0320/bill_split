package jp.ac.gifu_u.last;

import java.util.Comparator;

public class Compare implements Comparator<Calculatedata> {
    @Override
    public int compare(Calculatedata a,Calculatedata b){
        return a.money < b.money ? 1 : -1;
    }
}
