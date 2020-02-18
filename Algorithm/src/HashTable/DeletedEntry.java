package HashTable;
//Hash table Open addressing
public class DeletedEntry extends HashEntry {
    private static DeletedEntry entry = null;

    private DeletedEntry() {
    	//key & value = -1
          super(-1, -1);
    }

    public static DeletedEntry getUniqueDeletedEntry() {
    	//如果為null, key 和 value 宣告 -1
          if (entry == null)
        	  entry = new DeletedEntry();
          
          return entry;

    }
}
