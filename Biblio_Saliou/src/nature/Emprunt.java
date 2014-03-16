/**
 * 
 */
package nature;

/**
 * @author salioubah
 *
 */
public class Emprunt {
    
	private int key;
	private String name;
	
	
	
	public Emprunt(int key, String name) {
		this.name = name;
		this.key = key;
	}



	public int getKey() {
		return key;
	}



	public String getName() {
		return name;
	}



	@Override
	public String toString() {
		return "Emprunt [name=" + name + "]";
	}
	
	

	

}
