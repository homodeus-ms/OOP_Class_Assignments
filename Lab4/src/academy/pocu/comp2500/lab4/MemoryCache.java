package academy.pocu.comp2500.lab4;

import java.util.HashMap;


public class MemoryCache {

    private static int maxInstanceCount = 0x7FFFFFFF;

    private static EvictionPolicy currPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
    private static HashMap<String, Node<String, MemoryCache>> caches = new HashMap<>();
    private static MyLinkedList<String, MemoryCache> cacheList;

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

        if (cacheList.getElementCount() >= maxInstanceCount) {
            Node<String, MemoryCache> targetNode;

            switch (currPolicy) {

                case FIRST_IN_FIRST_OUT:
                    targetNode = cacheList.getFirstCreatedNode();
                    assert (targetNode != null) : "get First Node can't be null";
                    removeCache(targetNode);
                    break;
                case LAST_IN_FIRST_OUT:
                    targetNode = cacheList.getLastCreatedNode();
                    assert (targetNode != null) : "get Last Node can't be null";
                    removeCache(targetNode);
                    break;
                case LEAST_RECENTLY_USED:
                    targetNode = cacheList.getLRUNode();
                    assert (targetNode != null) : "get First Node Can't be null";
                    removeCache(targetNode);
                    break;
                default:
                    assert (false);
                    break;
            }
        }

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
        if (caches.isEmpty()) {
            return;
        }
        int elementCount = cacheList.getElementCount();

        while (elementCount > maxCount) {
            Node<String, MemoryCache> targetNode = cacheList.getLRUNode();
            assert (targetNode != null);
            removeCache(targetNode);
            --elementCount;
        }
    }
    public static void setEvictionPolicy(EvictionPolicy policy) {
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

        if (entryList.getElementCount() >= maxEntryCount) {
            Node<String, String> targetNode;

            switch (currPolicy) {

                case FIRST_IN_FIRST_OUT:
                    targetNode = entryList.getFirstCreatedNode();
                    assert (targetNode != null) : "get First Node can't be null";
                    removeEntry(targetNode);
                    break;
                case LAST_IN_FIRST_OUT:
                    targetNode = entryList.getLastCreatedNode();
                    assert (targetNode != null) : "get Last Node can't be null";
                    removeEntry(targetNode);
                    break;
                case LEAST_RECENTLY_USED:
                    targetNode = entryList.getLRUNode();
                    assert (targetNode != null) : "get First Node Can't be null";
                    removeEntry(targetNode);
                    break;
                default:
                    assert (false);
                    break;
            }
        }
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

        int elementCount = entryList.getElementCount();
        while (elementCount > maxEntryCount) {
            Node<String, String> targetNode = entryList.getLRUNode();
            assert (targetNode != null);
            removeEntry(targetNode);
            --elementCount;
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

}
