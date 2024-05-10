class Renshu {

    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    // ここに続きを実装していく。

    // 1からnまでの整数の和を計算する関数
    public int sumUpToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // aからbまでの整数の和を計算する関数
    public int sumFromPtoQ(int a, int b) {
        if (a > b) {
            return -1; // pがqより大きい場合、-1を返す
        }
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += i;
        }
        return sum;
    }

    // 配列aのindexから最後までの和を計算する関数
    public int sumFromArrayIndex(int[] a, int index) {
        if (index < 0 || index >= a.length) {
            return -1; // 無効なindexの場合、-1を返す
        }
        int sum = 0;
        for (int i = index; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    // 配列aから最大値を選択する関数
    public int selectMaxValue(int[] a) {
        if (a == null || a.length == 0) {
            return Integer.MIN_VALUE; // 配列がnullまたは空の場合、最小値を返す
        }
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    // 配列aから最小値を選択する関数
    public int selectMinValue(int[] a) {
        if (a == null || a.length == 0) {
            return Integer.MAX_VALUE; // 配列がnullまたは空の場合、最大値を返す
        }
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    // 配列aから最大値のインデックスを選択する関数
    public int selectMaxIndex(int[] a) {
        if (a == null || a.length == 0) {
            return -1; // 配列がnullまたは空の場合、-1を返す
        }
        int maxIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // 配列aから最小値のインデックスを選択する関数
    public int selectMinIndex(int[] a) {
        if (a == null || a.length == 0) {
            return -1; // 配列がnullまたは空の場合、-1を返す
        }
        int minIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    // 配列aのi番目とj番目の要素を交換する関数
    public void swapArrayElements(int[] a, int i, int j) {
        if (a == null || i < 0 || i >= a.length || j < 0 || j >= a.length) {
            return; // 無効なインデックスの場合は何もしない
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 2つの配列の要素を交換する関数
    public boolean swapTwoArrays(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return false; // 配列がnullまたは長さが異なる場合は交換しない
        }
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            a[i] = b[i];
            b[i] = temp;
        }
        return true;
    }
}