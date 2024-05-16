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

    // バブルソートを実行する関数
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; i < j; j--) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    // クイックソートを実行する関数
    public void quickSort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private void quicksort(int[] array, int l, int r) {
        // 整列する要素が一つならなにもしない
        if (l >= r)
            return;

        // ピボットvを基準に分割
        int v = partition(array, l, r);

        // 左の部分をソート
        quicksort(array, l, v - 1);

        // 右の部分をソート
        quicksort(array, v + 1, r);
    }

    private int partition(int[] array, int l, int r) {
        // 右端の要素をピボットとする。
        int pivot = array[r];

        // ポインタiとjを初期化する
        int i = l - 1;
        int j = r;

        while (true) {
            // ポインタiを右に進める
            while (array[++i] < pivot)
                ;

            // ポインタjを左へ進める
            while (l < j && pivot < array[--j])
                ;

            // ポイントiとjがぶつかったらループ抜ける
            if (i >= j)
                break;

            // iの要素とjの要素を交換する
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }

        // a[i]とピボットを交換する
        int tmp = array[i];
        array[i] = array[r];
        array[r] = tmp;

        return i;

    }
}