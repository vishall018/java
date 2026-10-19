import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // Key: Roll Number (Integer), Value: Grade (Character)
        HashMap<Integer, Character> gradeBook = new HashMap<>();

        // 1. Put (Insert/Update)
        gradeBook.put(101, 'A');
        gradeBook.put(102, 'B');
        gradeBook.put(103, 'A');
        
        // Key collision example: updating grade for Roll No 102
        gradeBook.put(102, 'S'); // Overwrites 'B' with 'S'

        System.out.println("Gradebook: " + gradeBook);

        // 2. Get (Access)
        System.out.println("Grade of Roll 101: " + gradeBook.get(101));

        // 3. Safe Lookup using getOrDefault
        char unknownGrade = gradeBook.getOrDefault(104, 'F');
        System.out.println("Grade of Roll 104 (Not present): " + unknownGrade);

        // 4. Check Presence
        if (gradeBook.containsKey(103)) {
            System.out.println("Roll Number 103 is present in records.");
        }

        // 5. Remove
        gradeBook.remove(102);
        System.out.println("After deleting Roll 102: " + gradeBook);

        // 6. Traversing HashMap (Using Entry Set)
        System.out.println("--- Full Grade Report ---");
        for (Map.Entry<Integer, Character> entry : gradeBook.entrySet()) {
            System.out.println("Roll No: " + entry.getKey() + " | Grade: " + entry.getValue());
        }
    }
}