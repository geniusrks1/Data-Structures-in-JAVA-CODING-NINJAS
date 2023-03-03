import.java.util.ArrayList;
public class Map<K,V> {
ArrayList <Map<K,V>> buckets;
int count;
int numBuckets;
public Map() {
buckets = new ArrayList<>();
numBuckets = 20;
for(int i=0;i<numBuckets;i++) {
buckets.add(null);
}
}
private int getBucketIndex(K,Key) {
int hc = Key.hashCode();
int index = hc%numBuckets;
return index;
}
  
  public int size() {
return count;
}
public V getValue(K Value) {
}
public void insert (K value,V Value) {
int bucketIndex = getBucketIndex(Key);
MapNode<K,V> head = buckets.get(bucketIndex);
MapNode<K,V> prev = null;
while(head! = null) {
if(head.key.equals(key)) {
if(prev! = null) {
prev.next = head.next;
} else {
buckets.set(bucketIndex,head.next);
}
}
prev = head;
head = head.next;
}
  
  
  
  return null;
}
// element is not there.insert at 0th position of linked list
head = buckets.get(bucketIndex);
MapNode<K,V> head = new MapNode<>(Key,Value);
newNode.next = head;
buckets.set(bucketIndex , newNode);
count++;
}
