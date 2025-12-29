# Java & Computer Science Notes

## BufferedReader vs InputStreamReader

| Item        | BufferedReader                                                                | InputStreamReader                                                              |
| ----------- | ----------------------------------------------------------------------------- | ------------------------------------------------------------------------------ |
| Purpose     | Reads text from a character-input stream efficiently by buffering characters. | Converts bytes from an input stream into characters using a specified charset. |
| Key Feature | Provides `readLine()` for reading entire lines easily.                        | Provides character decoding from byte streams.                                 |
| Usage       | Usually wrapped around an `InputStreamReader` for performance.                | Often wrapped by `BufferedReader` to improve efficiency.                       |
| Example     | `new BufferedReader(new InputStreamReader(System.in))`                        | `new InputStreamReader(System.in)`                                             |

---

## char vs String

| Item        | char                                | String                                      |
| ----------- | ----------------------------------- | ------------------------------------------- |
| Type        | Primitive data type.                | Reference type (object).                    |
| Represents  | A single 16-bit Unicode character.  | A sequence of characters.                   |
| Declaration | `char c = 'A';`                     | `String s = "Hello";`                       |
| Mutability  | Immutable (fixed single character). | Immutable but can hold multiple characters. |

---

## Stack vs Heap

| Concept      | Stack                            | Heap                          |
| ------------ | -------------------------------- | ----------------------------- |
| Memory Type  | Static memory allocation.        | Dynamic memory allocation.    |
| Used For     | Local variables, function calls. | Objects and global variables. |
| Lifetime     | Managed automatically (LIFO).    | Managed by garbage collector. |
| Access Speed | Faster                           | Slower                        |
| Example      | Primitive values, references.    | All `new` objects.            |

---

## Process vs Program

| Item         | Process                                    | Program                                              |
| ------------ | ------------------------------------------ | ---------------------------------------------------- |
| Definition   | An executing instance of a program.        | A passive collection of instructions stored on disk. |
| State        | Active (has resources, memory, CPU time).  | Inactive (only code and data).                       |
| Multiplicity | One program can create multiple processes. | A single program file.                               |

---

## getOrDefault vs containsKey

| Method                            | Description                                                                    | Example                            |
| --------------------------------- | ------------------------------------------------------------------------------ | ---------------------------------- |
| `getOrDefault(key, defaultValue)` | Returns the value for the key if present; otherwise returns the default value. | `map.getOrDefault("id", 0)`        |
| `containsKey(key)`                | Checks if the key exists in the map, returns a boolean.                        | `if (map.containsKey("id")) {...}` |

---

## `String.compareTo(String)` Definition

Compares two strings lexicographically based on Unicode values of each character.

- Returns `0` → if both strings are equal.
- Returns a **positive** number → if the caller string is lexicographically greater.
- Returns a **negative** number → if the caller string is lexicographically smaller.

Example:
“apple”.compareTo(“banana”); // returns negative “banana”.compareTo(“apple”); // returns positive “apple”.compareTo(“apple”); // returns 0

---

## `Arrays.sort` Definition

- Sorts the specified array into ascending order.
- Uses **Dual-Pivot Quicksort** for primitive types and **Timsort** for objects.
- Can be customized with a comparator for complex sorting rules.

Example:
int[] arr = {3, 1, 2}; Arrays.sort(arr); // arr =

---

## Binary Search Definition

A search algorithm that finds the position of a target value within a **sorted array**.

- Repeatedly divides the search interval in half.
- Time Complexity: \( O(\log n) \)
- Returns index of the target, or a negative value if not found.

Example:
int index = Arrays.binarySearch(arr, key);

---

## long vs Integer

| Type          | long                     | int             |
| ------------- | ------------------------ | --------------- |
| Size          | 64 bits                  | 32 bits         |
| Range         | -2⁶³ to 2⁶³ - 1          | -2³¹ to 2³¹ - 1 |
| Wrapper Class | `Long`                   | `Integer`       |
| Example       | `long l = 12345678900L;` | `int i = 1234;` |

---
