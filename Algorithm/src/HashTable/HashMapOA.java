package HashTable;
//Hash table Open Addressing
//Using Linear Probing

public class HashMapOA {
	
	private final static int TABLE_SIZE = 128;
	
    HashEntry[] table;

    HashMapOA() {
          table = new HashEntry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
    }
    //Search 
    public int get(int key) {
    	
    	  //Division method
          int hash = (key % TABLE_SIZE);
          int initialHash = -1;

          //當hash值或key不符合,就找下一個, Traversal
          while (hash != initialHash && (table[hash] == DeletedEntry.getUniqueDeletedEntry() || table[hash] != null && table[hash].getKey() != key)) {

                if (initialHash == -1)

                 initialHash = hash;
                //h(k,i) = (h'(x) + i) mod m  
                hash = (hash + 1) % TABLE_SIZE;

          }
          
          if (table[hash] == null || hash == initialHash)
        	  
                return -1;
          else
                return table[hash].getValue();

    }


    //Insert
    public void put(int key, int value) {
    		
          int hash = (key % TABLE_SIZE);

          int initialHash = -1;

          int indexOfDeletedEntry = -1;
          
          
          while (hash != initialHash && (table[hash] == DeletedEntry.getUniqueDeletedEntry() || table[hash] != null && table[hash].getKey() != key)) {

                if (initialHash == -1)
                	
                      initialHash = hash;

                if (table[hash] == DeletedEntry.getUniqueDeletedEntry())

                      indexOfDeletedEntry = hash;

                hash = (hash + 1) % TABLE_SIZE;

          }

         //剛好為空,直接放入
          if ((table[hash] == null || hash == initialHash) && indexOfDeletedEntry != -1)

                table[indexOfDeletedEntry] = new HashEntry(key, value);
          //裡面有值,做替換
          else if (initialHash != hash)

                if (table[hash] != DeletedEntry.getUniqueDeletedEntry() && table[hash] != null && table[hash].getKey() == key)

                      table[hash].setValue(value);

                else

                      table[hash] = new HashEntry(key, value);

    }


    //Delete
    //與Search所使用的Solution差不多
    public void remove(int key) {

          int hash = (key % TABLE_SIZE);

          int initialHash = -1;
          //做Traversal 找到要刪除的值
          while (hash != initialHash && (table[hash] == DeletedEntry.getUniqueDeletedEntry() || table[hash] != null && table[hash].getKey() != key)) {
        	  
                if (initialHash == -1)
                    initialHash = hash;

                hash = (hash + 1) % TABLE_SIZE;

          }
          //如果hash不等於-1且不等於 null 刪除
          if (hash != initialHash && table[hash] != null)

                table[hash] = DeletedEntry.getUniqueDeletedEntry();

    }
}


