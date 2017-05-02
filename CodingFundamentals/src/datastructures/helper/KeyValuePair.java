package datastructures.helper;


public class KeyValuePair<K,V> {
		private K key;
		private V value;

		public KeyValuePair(K key, V value) {
			this.setKey(key);
			this.setValue(value);
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		
		public boolean equals(KeyValuePair<K, V> other) {
			return this.key == other.key && this.value == other.value;
			
		}
		
		@Override
		public String toString() {		
			if (this.value == null)
				return String.format("(%s,-)", this.key);
			return String.format("(%s,%s)", this.key, this.value);
		}
	}
	