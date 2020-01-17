package HashTable;

//Hash table-Collision resolution by chaining (closed addressing) 
//Using Division method

public class HashMap {
	private final static int TABLE_SIZE = 128;

	 

    LinkedHashEntry[] table;



    HashMap() {

          table = new LinkedHashEntry[TABLE_SIZE];

          for (int i = 0; i < TABLE_SIZE; i++)

                table[i] = null;

    }


    //Search
    public int get(int key) {

          int hash = (key % TABLE_SIZE);

          if (table[hash] == null)

                return -1;

          else {

                LinkedHashEntry entry = table[hash];
                
                //Traversal
                
                while (entry != null && entry.getKey() != key)

                      entry = entry.getNext();

                if (entry == null)

                      return -1;

                else

                      return entry.getValue();

          }

    }


    //Insert
    public void put(int key, int value) {

          int hash = (key % TABLE_SIZE);

          if (table[hash] == null)

                table[hash] = new LinkedHashEntry(key, value);

          else {

                LinkedHashEntry entry = table[hash];
                
                
                //Traversal
                while (entry.getNext() != null && entry.getKey() != key)

                      entry = entry.getNext();
                
                //Insert First node
                if (entry.getKey() == key)

                      entry.setValue(value);
                
                //Create Chaining
                else

                      entry.setNext(new LinkedHashEntry(key, value));

          }

    }


    //Delete (Same as Linkedlist Delete)
    public void remove(int key) {

          int hash = (key % TABLE_SIZE);

          if (table[hash] != null) {

                LinkedHashEntry prevEntry = null;

                LinkedHashEntry entry = table[hash];
                
                
                //Traversal
                while (entry.getNext() != null && entry.getKey() != key) {

                      prevEntry = entry;

                      entry = entry.getNext();

                }

                if (entry.getKey() == key) {
                	
                	 //Delete the First node	
                      if (prevEntry == null)

                           table[hash] = entry.getNext();
                      
                      //Delete not the first node
                      else

                           prevEntry.setNext(entry.getNext());

                }

          }

    }
}
