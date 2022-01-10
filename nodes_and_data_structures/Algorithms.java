package nodes_and_data_structures;

import main_programs.*;

//phần thuật toán sắp xếp trộn:
public class Algorithms {

    public static Product[] mSort(Product[] a) {
        int n = a.length;
        if (n == 1) {return a;}
        Product[] subL = new Product[n/2];
        Product[] subR = new Product[n-(subL.length)];
        for (int i = 0; i < n/2; i++) {subL[i] = a[i];}
        for (int j = 0, i = (n/2); i < n; j++, i++) {subR[j] = a[i];}
        subL = mSort(subL);
        subR = mSort(subR);
        return merge(subL, subR);
    }

    private static Product[] merge(Product[] a, Product[] b) {
        int n = a.length;
        int m = b.length;
        Product[] k = new Product[n+m];
        int f = 0; int s = 0; int c = 0;
        while (f < n && s < m) {
            if (a[f].compareTo(b[s]) <= 0) {
                k[c] = a[f];
                f++;
            } else {
                k[c] = b[s];
                s++;
            }
            c++;
        }
        if (f < n) {
            while (f < n) {
                k[c] = a[f];
                c++; f++;
            }
        }
        if (s < m) {
            while (s < m) {
                k[c] = b[s];
                c++; s++;
            }
        }
        return k;
    }

}