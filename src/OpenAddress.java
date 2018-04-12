
public class OpenAddress {
	
	
	private static final String PREVIOUSLY_USED = "PREVIOUSLY_USED";
	private static final int TABLE_SIZE = 31;
	private static final String UNUSED = null;
	private String []table;	
	
	public OpenAddress() {
		table = new String[TABLE_SIZE];
		for (int i = 0; i < table.length ; i++) {
			table[i] = UNUSED;
		}
		
	}
	
	public String get(int k) {
		return table[k];
	}
	
	public int algoHash(String v) {
		int cn = 0;
		char c = v.charAt(0);
		cn = (int)c;
		int position = (3*cn) % TABLE_SIZE;		
		return position;
		
	}
	public void put(String v) {
		// an int isn't used in my hash algo
		// hashalgo uses first char to locate an index.
		
		int position =  algoHash(v);
		if (table[position] == null|| table[position] == "PREVIOUSLY_USED") {
			table[position] = v;
		}else {
			// Linear probing
			System.out.println("collision Occured");
			while(table[position] != null || table[position] == "PREVIOUSLY_USED") {
				position = position + 1;	
				if(position == TABLE_SIZE +1) {
					//loop around
					position = 0;
				}
			}
			table[position] = v;				
		}		
	}
	
	
	public boolean contains(String k) {
		int pos = algoHash(k);
		if(table[pos] == null) {		
			return false;
		}
		if(table[pos].equals(k)) {
			return true;
		}else {
			int searching = pos + 1;
			while(searching != pos) {
				if(table[searching] == k) {
					return true;
				}
				if(searching == TABLE_SIZE -1 ) {
					//loop back around
					searching = 0;
				}
				searching++;
			}
		}
		return false;
	}
	

	public void delete(String k) {
		int pos = algoHash(k);
		boolean found = false;
		if(table[pos] == null) {		
			System.out.println("Not found");
			return;
		}
		if(table[pos].equals(k)) {
			table[pos] = PREVIOUSLY_USED;
			found = true;
		}else {
			int searching = pos + 1;
			
			while(searching != pos & searching != TABLE_SIZE) {
				if(table[searching] == k) {
					table[searching] = PREVIOUSLY_USED;
					found = true;
				}
				if(searching >= TABLE_SIZE -1 ) {
					//loop back around
					searching = 0;
				}
				searching++;
			}
		}
		
		if (found == false) {
			System.out.println("Not found");
		}
		System.out.println("deleted found");
		
	}
	

	
	
	public void printHash() {
		
		for (int i = 0; i < table.length; i++) {
			if(table[i] != null)
				System.out.print(i + "\t" + table[i] + "\n");	
			else 
				continue;		
		}
			
	}

}
