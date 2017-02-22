/**
 * 
 */
package genericCheckpointing.xml;

import genericCheckpointing.util.SerializableObject;

/**
 * <p>
 * This interface defines methods required to Serialize an object.
 * </p>
 * 
 * 
 *
 */
public interface SerStrategyI {

	public String processInput(SerializableObject serializableObject);

}
