/*

  Serializable vs Parsable

  Serializable
  We want to be able to take an object and change it into bytes.
  How do I take objects and transform them into something more easily storable?

*/

import java.io.Serializable;

// A marker interface; we don’t need to implement anything.
// It means “yes, I can be transformed into something that can live on disk”
public class Person implements Serializable
{
  public string firstName;
  public string lastName;
  public Person spouse;

  // toString is a form of serialization
  public String toString() {
    return “[Person firstName:” + firstName +
           “ lastName: “ + lastName +
           “ spouse: “ + spouse.toString() + “]”;
  }
}

Person ted = new Person();
ted.firstName = “Ted”; ted.lastName = “Neward”;

Person charlotte = new Person();
ted.firstName = “Charlotte”; ted.lastName = “Neward”;

ted.spouse = charlotte; charlotte.spouse = ted;

// ser stands for serialized object

// ByteArray writes it to memory
// FileOutputStream fos = new FileOutputStream(“person.ser”);

ByteArrayOutputStream fos = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(fos);
oos.writeObject(ted);
byte[] serializedTed = fos.getyBteArray();

/*

  Parcelable
  A way we can serialize objects when Android calls a parcel.
  On the Android platform, it’s more efficient than serializable.

  Parcels aren’t capable to write to disk; serializable can do FileOutputStream().
*/