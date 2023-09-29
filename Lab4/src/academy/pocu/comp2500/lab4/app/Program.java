package academy.pocu.comp2500.lab4.app;

import academy.pocu.comp2500.lab4.EvictionPolicy;
import academy.pocu.comp2500.lab4.MemoryCache;

import java.util.ArrayList;
import java.util.Random;

public class Program {

    public static void main(String[] args) {
        {
            /*
             * COMP2500 202005 Lab4 시간복잡도 테스트 케이스(seolbeen)
             *
             * maxN: 총 반복 횟수
             * count: setMaxInstanceCount/setMaxEntryCount에서 사용하는 매개 변수
             * step: step 만큼의 시간 측정
             */
            int maxN = 100000;
            int count = 70000;
            int step = 10000;

            System.out.printf("===================================\n");
            System.out.printf("Time complexity test(MAX N: %d)\n", maxN);
            System.out.printf("===================================\n");
            ArrayList<String> strings = new ArrayList<>(maxN);
            for (int i = 0; i < maxN; i++) {
                strings.add(Integer.toString(i));
            }

            // initialization for instance test
            MemoryCache.clear();
            MemoryCache.setMaxInstanceCount(count);

            // test getInstance()
            System.out.printf("\ngetInstance() test\n");
            for (int n = 0; n < maxN; n += step) {
                System.out.printf("%6d ~ %6d: ", n, n + step - 1);

                long start = System.currentTimeMillis();
                for (int i = n; i < n + step; i++) {
                    MemoryCache.getInstance(strings.get(i));
                }
                long end = System.currentTimeMillis();

                System.out.printf("%dms\n", end - start);
            }

            // initialization for entry test
            MemoryCache.clear();
            MemoryCache.setMaxInstanceCount(3);

            MemoryCache memCacheFifo = MemoryCache.getInstance("FIFO");
            MemoryCache memCacheFilo = MemoryCache.getInstance("FILO");
            MemoryCache memCacheLru = MemoryCache.getInstance("LRU");

            memCacheFifo.setEvictionPolicy(EvictionPolicy.FIRST_IN_FIRST_OUT);
            memCacheFilo.setEvictionPolicy(EvictionPolicy.LAST_IN_FIRST_OUT);
            memCacheLru.setEvictionPolicy(EvictionPolicy.LEAST_RECENTLY_USED);

            memCacheFifo.setMaxEntryCount(count);
            memCacheFilo.setMaxEntryCount(count);
            memCacheLru.setMaxEntryCount(count);

            // test addEntry()
            System.out.printf("\naddEntry() test [FIFO / FILO / LRU]\n");
            for (int n = 0; n < maxN; n += step) {
                System.out.printf("%6d ~ %6d: ", n, n + step - 1);

                long startFifo = System.currentTimeMillis();
                for (int i = n; i < n + step; i++) {
                    memCacheFifo.addEntry(strings.get(i), strings.get(i));
                }
                long endFifo = System.currentTimeMillis();

                long startFilo = System.currentTimeMillis();
                for (int i = n; i < n + step; i++) {
                    memCacheFilo.addEntry(strings.get(i), strings.get(i));
                }
                long endFilo = System.currentTimeMillis();

                long startLru = System.currentTimeMillis();
                for (int i = n; i < n + step; i++) {
                    memCacheLru.addEntry(strings.get(i), strings.get(i));
                }
                long endLru = System.currentTimeMillis();

                System.out.printf("%dms / %dms / %dms\n", endFifo - startFifo, endFilo - startFilo, endLru - startLru);
            }

            // test getEntryOrNull()
            System.out.printf("\ngetEntryOrNull() test [FIFO / FILO / LRU]\n");
            for (int n = 0; n < maxN; n += step) {
                System.out.printf("%6d ~ %6d: ", n, n + step - 1);

                long startFifo = System.currentTimeMillis();
                for (int i = n; i < n + step; i++) {
                    memCacheFifo.getEntryOrNull(strings.get(i));
                }
                long endFifo = System.currentTimeMillis();

                long startFilo = System.currentTimeMillis();
                for (int i = n; i < n + step; i++) {
                    memCacheFilo.getEntryOrNull(strings.get(i));
                }
                long endFilo = System.currentTimeMillis();

                long startLru = System.currentTimeMillis();
                for (int i = n; i < n + step; i++) {
                    memCacheLru.getEntryOrNull(strings.get(i));
                }
                long endLru = System.currentTimeMillis();

                System.out.printf("%dms / %dms / %dms\n", endFifo - startFifo, endFilo - startFilo, endLru - startLru);
            }
        }

        System.out.println("No Assert!");
    }


}
