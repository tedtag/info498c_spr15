@JSONSerializable
class Person {
    public Person spouse;
}

Person ted = new Person();
Person charlotte = new Person();
ted.spouse = charlotte;
charlotte.spouse = ted;

[
    {
        "firstName": "Ted",
        "lastName" : "Meward",
        "spouse"   : "http://www.persons.org/perosns/1"
    },
    {
        "firstName": "Charlotte",
        "lastName" : "Neward",
        "spouse"   : "http://www.persons.org/perosns/0"
    }
]

Mongo DB would use an "OID" or an object identifier.

[
    {
        "firstName": "Ted",
        "lastName" : "Meward",
        "spouse"   : {
            "_id": "1234567ABC12345"
        }
    },
    {
        "firstName": "Charlotte",
        "lastName" : "Neward",
        "spouse"   : {
            "_id": "1234567ABC12346"
        }
    }
]

JSONObject person = new JSONObject();
person.put("firstName", ted.getFirstName());
person.put("lastName", ted.getLastName());
person.put("spouse", charlotte);