package org.verifyway;

import java.util.Collection;
import java.util.Map;

/**
 * 从 spring框架中拷贝出来，用于进行类参数验证使用
 *
 * @author yuijnshui
 * @Title: AssertSpringFramework
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/16下午7:34
 */
public abstract class AssertSpringFramework {

    /**
     * AssertSpringFramework a boolean expression, throwing {@code IllegalArgumentException}
     * if the test result is {@code false}.
     * <pre class="code">AssertSpringFramework.isTrue(i &gt; 0, "The value must be greater than zero");</pre>
     *
     * @param expression a boolean expression
     * @param message    the exception message to use if the assertion fails
     * @throws IllegalArgumentException if expression is {@code false}
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * AssertSpringFramework a boolean expression, throwing {@code IllegalArgumentException}
     * if the test result is {@code false}.
     * <pre class="code">AssertSpringFramework.isTrue(i &gt; 0);</pre>
     *
     * @param expression a boolean expression
     * @throws IllegalArgumentException if expression is {@code false}
     */
    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    /**
     * AssertSpringFramework that an object is {@code null} .
     * <pre class="code">AssertSpringFramework.isNull(value, "The value must be null");</pre>
     *
     * @param object  the object to check
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the object is not {@code null}
     */
    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * AssertSpringFramework that an object is {@code null} .
     * <pre class="code">AssertSpringFramework.isNull(value);</pre>
     *
     * @param object the object to check
     * @throws IllegalArgumentException if the object is not {@code null}
     */
    public static void isNull(Object object) {
        isNull(object, "[Assertion failed] - the object argument must be null");
    }

    /**
     * AssertSpringFramework that an object is not {@code null} .
     * <pre class="code">AssertSpringFramework.notNull(clazz, "The class must not be null");</pre>
     *
     * @param object  the object to check
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the object is {@code null}
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * AssertSpringFramework that an object is not {@code null} .
     * <pre class="code">AssertSpringFramework.notNull(clazz);</pre>
     *
     * @param object the object to check
     * @throws IllegalArgumentException if the object is {@code null}
     */
    public static void notNull(Object object) {
        notNull(object, "[Assertion failed] - this argument is required; it must not be null");
    }

    /**
     * AssertSpringFramework that the given String is not empty; that is,
     * it must not be {@code null} and not the empty String.
     * <pre class="code">AssertSpringFramework.hasLength(name, "Name must not be empty");</pre>
     *
     * @param text    the String to check
     * @param message the exception message to use if the assertion fails
     */
    public static void hasLength(String text, String message) {
        if (!hasLength((CharSequence) text)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }


    /**
     * AssertSpringFramework that the given String has valid text content; that is, it must not
     * be {@code null} and must contain at least one non-whitespace character.
     * <pre class="code">AssertSpringFramework.hasText(name, "'name' must not be empty");</pre>
     *
     * @param text    the String to check
     * @param message the exception message to use if the assertion fails
     */
    public static void hasText(String text, String message) {
        if (!hasText((CharSequence) text)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static boolean hasText(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * AssertSpringFramework that the given String has valid text content; that is, it must not
     * be {@code null} and must contain at least one non-whitespace character.
     * <pre class="code">AssertSpringFramework.hasText(name, "'name' must not be empty");</pre>
     *
     * @param text the String to check
     */
    public static void hasText(String text) {
        hasText(text,
                "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
    }

    /**
     * AssertSpringFramework that the given text does not contain the given substring.
     * <pre class="code">AssertSpringFramework.doesNotContain(name, "rod", "Name must not contain 'rod'");</pre>
     *
     * @param textToSearch the text to search
     * @param substring    the substring to find within the text
     * @param message      the exception message to use if the assertion fails
     */
    public static void doesNotContain(String textToSearch, String substring, String message) {
        if (hasLength(textToSearch) && hasLength(substring) &&
                textToSearch.contains(substring)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static boolean hasLength(String str) {
        return hasLength((CharSequence) str);
    }

    /**
     * AssertSpringFramework that the given text does not contain the given substring.
     * <pre class="code">AssertSpringFramework.doesNotContain(name, "rod");</pre>
     *
     * @param textToSearch the text to search
     * @param substring    the substring to find within the text
     */
    public static void doesNotContain(String textToSearch, String substring) {
        doesNotContain(textToSearch, substring,
                "[Assertion failed] - this String argument must not contain the substring [" + substring + "]");
    }


    /**
     * AssertSpringFramework that an array has elements; that is, it must not be
     * {@code null} and must have at least one element.
     * <pre class="code">AssertSpringFramework.notEmpty(array, "The array must have elements");</pre>
     *
     * @param array   the array to check
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the object array is {@code null} or has no elements
     */
    public static void notEmpty(Object[] array, String message) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static boolean isEmpty(Object[] array) {
        return (array == null || array.length == 0);
    }

    /**
     * AssertSpringFramework that an array has elements; that is, it must not be
     * {@code null} and must have at least one element.
     * <pre class="code">AssertSpringFramework.notEmpty(array);</pre>
     *
     * @param array the array to check
     * @throws IllegalArgumentException if the object array is {@code null} or has no elements
     */
    public static void notEmpty(Object[] array) {
        notEmpty(array, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
    }

    /**
     * AssertSpringFramework that an array has no null elements.
     * Note: Does not complain if the array is empty!
     * <pre class="code">AssertSpringFramework.noNullElements(array, "The array must have non-null elements");</pre>
     *
     * @param array   the array to check
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the object array contains a {@code null} element
     */
    public static void noNullElements(Object[] array, String message) {
        if (array != null) {
            for (Object element : array) {
                if (element == null) {
                    throw new IllegalArgumentException(message);
                }
            }
        }
    }

    /**
     * AssertSpringFramework that an array has no null elements.
     * Note: Does not complain if the array is empty!
     * <pre class="code">AssertSpringFramework.noNullElements(array);</pre>
     *
     * @param array the array to check
     * @throws IllegalArgumentException if the object array contains a {@code null} element
     */
    public static void noNullElements(Object[] array) {
        noNullElements(array, "[Assertion failed] - this array must not contain any null elements");
    }

    /**
     * AssertSpringFramework that a collection has elements; that is, it must not be
     * {@code null} and must have at least one element.
     * <pre class="code">AssertSpringFramework.notEmpty(collection, "Collection must have elements");</pre>
     *
     * @param collection the collection to check
     * @param message    the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the collection is {@code null} or has no elements
     */
    public static void notEmpty(Collection<?> collection, String message) {
        if (isEmpty(collection)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    /**
     * AssertSpringFramework that a collection has elements; that is, it must not be
     * {@code null} and must have at least one element.
     * <pre class="code">AssertSpringFramework.notEmpty(collection, "Collection must have elements");</pre>
     *
     * @param collection the collection to check
     * @throws IllegalArgumentException if the collection is {@code null} or has no elements
     */
    public static void notEmpty(Collection<?> collection) {
        notEmpty(collection,
                "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }

    /**
     * AssertSpringFramework that a Map has entries; that is, it must not be {@code null}
     * and must have at least one entry.
     * <pre class="code">AssertSpringFramework.notEmpty(map, "Map must have entries");</pre>
     *
     * @param map     the map to check
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the map is {@code null} or has no entries
     */
    public static void notEmpty(Map<?, ?> map, String message) {
        if (isEmpty(map)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    /**
     * AssertSpringFramework that a Map has entries; that is, it must not be {@code null}
     * and must have at least one entry.
     * <pre class="code">AssertSpringFramework.notEmpty(map);</pre>
     *
     * @param map the map to check
     * @throws IllegalArgumentException if the map is {@code null} or has no entries
     */
    public static void notEmpty(Map<?, ?> map) {
        notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
    }


    /**
     * AssertSpringFramework that the provided object is an instance of the provided class.
     * <pre class="code">AssertSpringFramework.instanceOf(Foo.class, foo);</pre>
     *
     * @param clazz the required class
     * @param obj   the object to check
     * @throws IllegalArgumentException if the object is not an instance of clazz
     * @see Class#isInstance
     */
    public static void isInstanceOf(Class<?> clazz, Object obj) {
        isInstanceOf(clazz, obj, "");
    }

    /**
     * AssertSpringFramework that the provided object is an instance of the provided class.
     * <pre class="code">AssertSpringFramework.instanceOf(Foo.class, foo);</pre>
     *
     * @param type    the type to check against
     * @param obj     the object to check
     * @param message a message which will be prepended to the message produced by
     *                the function itself, and which may be used to provide context. It should
     *                normally end in a ": " or ". " so that the function generate message looks
     *                ok when prepended to it.
     * @throws IllegalArgumentException if the object is not an instance of clazz
     * @see Class#isInstance
     */
    public static void isInstanceOf(Class<?> type, Object obj, String message) {
        notNull(type, "Type to check against must not be null");
        if (!type.isInstance(obj)) {
            throw new IllegalArgumentException(
                    (hasLength(message) ? message + " " : "") +
                            "Object of class [" + (obj != null ? obj.getClass().getName() : "null") +
                            "] must be an instance of " + type);
        }
    }

    /**
     * AssertSpringFramework that {@code superType.isAssignableFrom(subType)} is {@code true}.
     * <pre class="code">AssertSpringFramework.isAssignable(Number.class, myClass);</pre>
     *
     * @param superType the super type to check
     * @param subType   the sub type to check
     * @throws IllegalArgumentException if the classes are not assignable
     */
    public static void isAssignable(Class<?> superType, Class<?> subType) {
        isAssignable(superType, subType, "");
    }

    /**
     * AssertSpringFramework that {@code superType.isAssignableFrom(subType)} is {@code true}.
     * <pre class="code">AssertSpringFramework.isAssignable(Number.class, myClass);</pre>
     *
     * @param superType the super type to check against
     * @param subType   the sub type to check
     * @param message   a message which will be prepended to the message produced by
     *                  the function itself, and which may be used to provide context. It should
     *                  normally end in a ": " or ". " so that the function generate message looks
     *                  ok when prepended to it.
     * @throws IllegalArgumentException if the classes are not assignable
     */
    public static void isAssignable(Class<?> superType, Class<?> subType, String message) {
        notNull(superType, "Type to check against must not be null");
        if (subType == null || !superType.isAssignableFrom(subType)) {
            throw new IllegalArgumentException(message + subType + " is not assignable to " + superType);
        }
    }


    /**
     * AssertSpringFramework a boolean expression, throwing {@code IllegalStateException}
     * if the test result is {@code false}. Call isTrue if you wish to
     * throw IllegalArgumentException on an assertion failure.
     * <pre class="code">AssertSpringFramework.state(id == null, "The id property must not already be initialized");</pre>
     *
     * @param expression a boolean expression
     * @param message    the exception message to use if the assertion fails
     * @throws IllegalStateException if expression is {@code false}
     */
    public static void state(boolean expression, String message) {
        if (!expression) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * AssertSpringFramework a boolean expression, throwing {@link IllegalStateException}
     * if the test result is {@code false}.
     * <p>Call {@link #isTrue(boolean)} if you wish to
     * throw {@link IllegalArgumentException} on an assertion failure.
     * <pre class="code">AssertSpringFramework.state(id == null);</pre>
     *
     * @param expression a boolean expression
     * @throws IllegalStateException if the supplied expression is {@code false}
     */
    public static void state(boolean expression) {
        state(expression, "[Assertion failed] - this state invariant must be true");
    }

}
