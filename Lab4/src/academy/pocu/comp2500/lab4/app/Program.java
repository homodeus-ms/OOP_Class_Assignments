package academy.pocu.comp2500.lab4.app;

import academy.pocu.comp2500.lab4.EvictionPolicy;
import academy.pocu.comp2500.lab4.MemoryCache;

public class Program {

    public static void main(String[] args) {
        MemoryCache.clear();
        //MemoryCache.setMaxInstanceCount(5); // 여기 삭제하고도 잘 작동하는지??

        MemoryCache memCacheA = MemoryCache.getInstance("A");
        memCacheA.setEvictionPolicy(EvictionPolicy.LAST_IN_FIRST_OUT);
        //assert (EvictionPolicy.LAST_IN_FIRST_OUT == memCacheA.getCurrPolicy());
        MemoryCache memCacheB = MemoryCache.getInstance("B");
        MemoryCache memCacheC = MemoryCache.getInstance("C");
        MemoryCache memCacheD = MemoryCache.getInstance("D");
        MemoryCache memCacheE = MemoryCache.getInstance("E");


        assert memCacheA != null;
        assert memCacheB != null;
        assert memCacheC != null;
        assert memCacheD != null;
        assert memCacheE != null;

        assert memCacheA == MemoryCache.getInstance("A");
        assert memCacheB == MemoryCache.getInstance("B");
        assert memCacheC == MemoryCache.getInstance("C");
        assert memCacheD == MemoryCache.getInstance("D");
        assert memCacheE == MemoryCache.getInstance("E");


        /*memCacheA.addEntry("test", "test");
        assert memCacheA.getEntryOrNull("test").equals("test");
        memCacheA.addEntry("test", "test2");
        assert memCacheA.getEntryOrNull("test").equals("test2");

        memCacheB.addEntry("test", "test");
        assert memCacheB.getEntryOrNull("test").equals("test");*/

        MemoryCache.setMaxInstanceCount(3);

        // 구현방식에 따라 testSwitch가 true일 때 통과할 수도 있고 false일 때 통과할 수 도 있음.
        boolean testSwitch = true;
        if (testSwitch) {
            assert memCacheC == MemoryCache.getInstance("C");
            assert memCacheD != MemoryCache.getInstance("D");
            assert memCacheE != MemoryCache.getInstance("E");
            assert memCacheA == MemoryCache.getInstance("A");
            assert memCacheB == MemoryCache.getInstance("B");
        } else {
            assert memCacheC == MemoryCache.getInstance("A");
            assert memCacheD == MemoryCache.getInstance("B");
            assert memCacheE == MemoryCache.getInstance("E");
            assert memCacheA != MemoryCache.getInstance("C");
            assert memCacheB != MemoryCache.getInstance("D");
        }



        System.out.println("No Assert!");
    }


}
