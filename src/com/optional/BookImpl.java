package com.optional;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.NoSuchElementException;
import java.util.Optional;

public class BookImpl {
    public static final String BOOK_STATUS = "UNKNOWN";

    private static Optional<Book> fetchBookInstance(Method method) {
        if (Modifier.isStatic(method.getModifiers())) {
            return Optional.empty();
        }
        return Optional.of(new Book());
    }

    public String findStatus() {
        Optional<String> status = Optional.of("test"); // this is prone to be empty
        status.ifPresent(System.out::println);
        status.ifPresentOrElse(System.out::println,
                () -> System.out.println("Status not found ..."));

        return status.orElse(BOOK_STATUS);
    }

    // Prefer
    // Throwing NoSuchElementException
    public String findStatus2() {
        Optional<String> status = Optional.of("test");; // this is prone to be empty
        return status.orElseThrow(
                () -> new NoSuchElementException("Status cannot be found"));
    }

    // Prefer (JDK 10+)
    // Throwing NoSuchElementException
    public String findStatus3() {
        Optional<String> status = Optional.of("test"); // this is prone to be empty
        return status.orElseThrow();
    }

    public static void main(String args[]){

        // Avoid
        //  Optional<Book> book = null;

        // Prefer
        Optional<Book> book = Optional.empty();
        // Prefer
        if (book.isPresent()) {
            Book theBook = book.get();
            // do something with "theBook"
            System.out.println("something is print....");
        } else {
            // do something that does not call book.get()
            System.out.println("book has not value...");
        }


    }
}
