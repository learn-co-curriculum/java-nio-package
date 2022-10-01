# Java NIO Package

## Learning Goals

- Learning Goal 1
- Learning Goal 2


### File IO Solutions

It is important to know that there are **many** ways to read and write to a file
in Java. Some of these ways may not make sense to us yet, as we have yet to
cover a topic called "streams". Other ways would use the `java.nio` package
instead of the `java.io` package. We won't go into the differences between the
two packages here, but consider this alternative to reading from a file using
the `Path`, `Paths`, and `Files` class in the `java.nio` package:

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

The first line in the `main()` method specifies the file path in a similar way
to the `File file = new File(String pathname)`. We then feed the static
method `readString()` the `Path` object. The `readString()` method will then
read all the content from the file into a `String` and then close the file once
all the content has been read. Believe it or not, this solution of reading from
a file will give us the same output as our solution before when we used the
`Scanner` object!

For more information on these `java.nio` classes, please see the documentation
below. When it comes to the labs following this lesson, feel free to use any
solution that best fits the problem as long as it meets the requirements.

## Introduction

A 1-2 sentence summary of what will be covered.

## Topic 1

Discuss the topic of the reading. Break into sections and sub-sections as
appropriate to help with the reader's orientation with the material and future
referencing.

## Topic 2

Discuss the topic of the reading. Break into sections and sub-sections as
appropriate to help with the reader's orientation with the material and future
referencing.

## Conclusion

A short one or two paragraph summary of the contents of the lessons, recapping
the learning goals.

## Resources

- [Java 11 Files](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html)
- [Java 11 Path](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Path.html)
- [Java 11 Paths](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Paths.html)
