package datastructures;

import datastructures.helper.KeyValuePair;

public class HashMap<K, V extends Object> {
	private KeyValuePair<K,V>[] array;
	private ArrayList<V> values;
	private ArrayList<K> keys;
	
	@SuppressWarnings("unchecked")
	public HashMap() {
		array =  new KeyValuePair[10];
		values = new ArrayList<V>();
		keys = new ArrayList<K>();
	}
	
	public void put(K key, V value) {
		int hashedKey = index(key);	
		put(hashedKey, key, value);		
	}
	
	private void put(int hashedKey, K key, V value) {
		array[hashedKey] = new KeyValuePair<K,V>(key, value);
		values.add(value);
		keys.add(key);		
	}

	public V get(K key) {	
		KeyValuePair<K, V> n =  array[index(key)];
		if (n != null)
			return n.getValue();
		return null;
	}	
	
	private int index(K key) {
		int k =  Math.abs(key.hashCode()) % array.length;	
	
		while(k < array.length && array[k] != null && !array[k].getKey().equals(key)) 
			k++;
		return k;			
	}

	public boolean containsKey(K key) {		
		return (get(key) != null);
	}

	public ArrayList<V> values() {		
		return values;
	}	
	public ArrayList<K> keys() {		
		return keys;
	}		
}