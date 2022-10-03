# Java NIO Package

## Learning Goals

- Learn about the classes in the `java.nio` package and how they provide another
  alternative to reading and writing files in Java.

## New Input Output Package

In Java version 4, Java introduced a new package to help with input and output
functionality - The `java.nio` package. NIO stands for new input output. It
should be noted that this package was not introduced to replace the `java.io`
package, but rather an alternative. The `java.nio` package also was updated in
Java 7, providing us even more utility classes to work with! We won't go into
the differences between the two packages here, but we'll look at a few new ways
to read and write files.

## Path

So far, we have been working with the `File` class, which is part of the
`java.io` package. In the `java.nio` package, we'll introduce the `Path`
interface. The `Path` interface essentially performs all the same functions as
the `File` class, and we can easily convert between the two using the `toFile()`
and `toPath()` methods.

To construct a `Path`, we'll make use of the `Paths` class, which exclusively
consists of static methods that return a `Path`:

```java
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIOMain {
    public static void main(String[] args) {
        Path path = Paths.get("simple.txt");
    }
}
```

As we can see, we are specifying a relative path. But we could also specify an
absolute path if we wanted to do so.

To learn more about the `Path` interface, check out the documentation here:
[Java 11 Path](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Path.html)
Let's learn more about the actual reading and writing functionalities now!

## Files Utility Methods

As mentioned before, the `java.nio` package was updated in Java 7, and with that
update we were introduced to the `Files` class. This class consists exclusively
of static methods that operate on files, directories, or other types of files.
It contains a bunch of useful methods we could use, such as `createDirectory()`
if we wanted to create a new file directory or checking the file permissions
with `isReadable()` and `isWritable()`. It even contains methods for us to read
from a file and write to a file. Those are the methods we'll turn our focus to,
but for more information on the `Files` class and its methods, check out the
documentation here:
[Java 11 Files](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html)

### Writing to a File

The `Files` class has quite a few `write()` methods for us to use if we want to
write data to a file. In this lesson, we'll look at a new method to Java 11, the
`writeString()` method:

```java
package write;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIOMain {

    public static void main(String[] args) {
        Path path = Paths.get("simple.txt");
        try {
            Files.writeString(path, "example of writing to a file.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
```

There's a couple of things to note in the code above:

- The `writeString()` method could throw an `IOException`, as we have seen with
  our other file IO methods. But this time we don't have to worry about using a
  try-with-resources statement. The method will open and close the resource
  under the hood for us!
- Since the `writeString()` method is a static method, it will take in a `Path`
  instance along with a character sequence. It can take in other parameters as
  well; however, those are optional.

Now if we run the code above, it will produce the `simple.txt` file that we
have been working with:

![simple-text-file-content](https://curriculum-content.s3.amazonaws.com/java-mod-3/file-input-output/write-to-file-content.png)

### Reading from a File

The `Files` class also has a method called `readString()` to help us read data
from a file. It will take in a `Path` as a parameter and then read all the
content from the file into a `String`. The `readString()` method ensures that
the file is closed when all content has been read or an `IOException` is thrown.

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIOMain {

    public static void main(String[] args) {
        Path path = Paths.get("simple.txt");
        try {
            String content = Files.readString(path);

            System.out.println(content);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
```

If we run the code above, we'll see that it prints the content of the
`simple.txt` file that we just wrote to:

```plaintext
example of writing to a file.
```

To demonstrate another helpful method, let's write some more lines out to our
`simple.txt` file:

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileIOMain {

    public static void main(String[] args) {
        Path path = Paths.get("simple.txt");
        List<String> names = new ArrayList<String>(Arrays.asList(
                "Leslie",
                "Ron",
                "Ann"
        ));

        String listAsString = "";
        for (String name : names) {
            listAsString = listAsString.concat(name).concat("\n");
        }

        try {
           Files.writeString(path, listAsString);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
```

Now suppose we want to read all of the lines in our `simple.txt`. We could use
the `readString()` method again to return a `String` object. Or we could use the
`readAllLines()` method, which will read each line in a file and store it in a
`List<String>`.

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileIOMain {

    public static void main(String[] args) {
        Path path = Paths.get("simple.txt");
        List<String> linesInFile;
        try {
            linesInFile = Files.readAllLines(path);

            System.out.println("There are " + linesInFile.size() + " lines in the file.");
            for (String line : linesInFile) {
                System.out.println(line);
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
```

Currently, the `simple.txt` file has the names Leslie, Ron, and Ann in the file,
each on a separate line. So let's see what the output of this code is when we
use the `readAllLines()` method:

```plaintext
There are 3 lines in the file.
Leslie
Ron
Ann

```

## Summary

As we have seen in this lesson and the past couple of lessons, there are many
ways to read and write files in Java. When it comes to the labs following this
lesson, unless specified, feel free to use any of these solutions to reading and
writing files that best fits the problem as long as it meets the requirements.

## Resources

- [Java 11 Path](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Path.html)
- [Java 11 Paths](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Paths.html)
- [Java 11 Files](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html)
