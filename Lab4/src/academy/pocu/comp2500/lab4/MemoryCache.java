package academy.pocu.comp2500.lab4;

import java.util.HashMap;

public class MemoryCache {

    private static int maxInstanceCount = 0x7FFFFFFF;

    private static HashMap<String, Node<String, MemoryCache>> caches = new HashMap<>();
    private static MyLinkedList<String, MemoryCache> cacheList;

    private static EvictionPolicy currPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
    private final String driveName;

    private HashMap<String, Node<String, String>> entry;
    private MyLinkedList<String, String> entryList;
    private int maxEntryCount;


    private MemoryCache(String driveName) {
        entry = new HashMap<>();
        entryList = new MyLinkedList<>();
        this.driveName = driveName;
        maxEntryCount = 0x7FFFFFFF;
    }

    public static MemoryCache getInstance(String driveName) {

        if (caches.isEmpty()) {
            cacheList = new MyLinkedList<>();
        }

        if (caches.containsKey(driveName)) {
            Node<String, MemoryCache> node = caches.get(driveName);
            cacheList.moveUsedNodeToLast(node);
            return node.getValue();
        }

        MemoryCache instance = new MemoryCache(driveName);
        Node<String, MemoryCache> node = new Node<>(driveName, instance);
        cutOffOverListedCache(maxInstanceCount - 1);

        cacheList.addNode(node);
        caches.put(driveName, node);

        return instance;
    }

    public static void clear() {
        if (caches.isEmpty()) {
            return;
        }
        caches.clear();
        cacheList.clear();
    }

    public static void setMaxInstanceCount(int maxCount) {
        maxInstanceCount = maxCount;
        if (!caches.isEmpty()) {
            cutOffOverListedCache(maxCount);
        }
    }
    public void setEvictionPolicy(EvictionPolicy policy) {
        currPolicy = policy;
    }

    public void addEntry(String key, String value) {

        if (entry.containsKey(key)) {
            Node<String, String> node = entry.get(key);
            node.setValue(value);
            entryList.moveUsedNodeToLast(node);                        // 사용 되었으니 맨 뒤로 (entry)
            //cacheList.moveUsedNodeToLast(caches.get(this.driveName));  // 사용 되었으니 맨 뒤로 (cache)
            return;
        }

        cutOffOverListedEntry(maxEntryCount - 1);

        Node<String, String> newNode = new Node<>(key, value);
        entry.put(key, newNode);
        entryList.addNode(newNode);
    }


    public String getEntryOrNull(String key) {
        Node<String, String> node = entry.get(key);

        if (node == null) {
            return null;
        }
        entryList.moveUsedNodeToLast(node);

        return node.getValue();
    }

    public void setMaxEntryCount(int maxEntryCount) {
        this.maxEntryCount = maxEntryCount;
        if (!entry.isEmpty()) {
            cutOffOverListedEntry(maxEntryCount);
        }
    }

    private static void removeCache(Node<String, MemoryCache> targetNode) {
        caches.remove(targetNode.getKey());
        cacheList.removeNode(targetNode);
    }
    private void removeEntry(Node<String, String> targetNode) {
        entry.remove(targetNode.getKey());
        entryList.removeNode(targetNode);
    }

    private static void cutOffOverListedCache(int maxCount) {
        int elementCount = cacheList.getElementCount();
        Node<String, MemoryCache> targetNode;

        while (elementCount > maxCount) {
            switch (currPolicy) {
                case FIRST_IN_FIRST_OUT:
                    targetNode = cacheList.getFirstCreatedNode();
                    removeCache(targetNode);
                    break;
                case LAST_IN_FIRST_OUT:
                    targetNode = cacheList.getLastCreatedNode();
                    removeCache(targetNode);
                    break;
                case LEAST_RECENTLY_USED:
                    targetNode = cacheList.getLRUNode();
                    removeCache(targetNode);
                    break;
                default:
                    assert (false);
                    break;
            }

            --elementCount;
        }
    }
    private void cutOffOverListedEntry(int maxCount) {
        int elementCount = entryList.getElementCount();
        Node<String, String> targetNode;

        while (elementCount > maxCount) {
            switch (currPolicy) {
                case FIRST_IN_FIRST_OUT:
                    targetNode = entryList.getFirstCreatedNode();
                    removeEntry(targetNode);
                    break;
                case LAST_IN_FIRST_OUT:
                    targetNode = entryList.getLastCreatedNode();
                    removeEntry(targetNode);
                    break;
                case LEAST_RECENTLY_USED:
                    targetNode = entryList.getLRUNode();
                    removeEntry(targetNode);
                    break;
                default:
                    assert (false);
                    break;
            }

            --elementCount;
        }
    }
}
