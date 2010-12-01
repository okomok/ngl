
# ngl 0.1.0

`ngl`(Nonstandard Generics Library) ports C++ STL algorithms to Scala.
The implementation is mainly based upon [STLport]:

    val numbers = Array(5, 2, 4, 3, 1, 6)
    ngl.partial_sort(numbers, 0, 3, 6)
    assert(java.util.Arrays.equals(numbers, Array(1, 2, 3, 5, 4, 6)))




## Concepts

Following JVM memory management, `ngl` doesn't port STL iterators.
Instead `ngl` algorithms traverse the _Range_ which corresponds to a pair of random-access-iterators.


### Range

_Range_ is a triple represented by `(ngl.Seq[A], Int, Int)`.


### OutputRange

_OutputRange_ is a pair represented by `(ngl.Seq[A], Int)`.


These concepts don't appear as Scala types; for maximum efficiency.




## Seq Synopsis

`ngl.Seq` is a trivial array interface:

    trait Seq[A] {
        def begin: Int
        def end: Int
        def apply(i: Int): A
        def update(i: Int, x: A): Unit
    }

`Seq` doesn't always guarantee indices in `[0, length-of-Seq)`.
You must call `begin` and `end` in polymorphic methods.




## Signature

For example, STL contains the `copy` function:

    template<class Iterator, class OutputIterator>
    Iterator copy(Iterator first, Iterator last, OutputIterator result);

In `ngl` it is declared as:

    def copy[A](in: Seq[A], first: Int, last: Int)(out: Seq[_ >: A], result: Int): Int




## Setup Dependencies for sbt

Append this in your project definition:

    val mada = "com.github.okomok" %% "ngl" % "0.1.0"
    val okomokSnapshots = "okomok snapshots" at "http://okomok.github.com/maven-repo/releases"

When you use `arm` or `reactive` package,
setup the continuations plugin following [this](http://code.google.com/p/simple-build-tool/wiki/CompilerPlugins "CompilerPlugins").





## Links

* [STLport]
* [Browse Source]
* [Browse Test Source]
* [The Scala Programming Language]

Shunsuke Sogame <<okomok@gmail.com>>


[MIT License]: http://www.opensource.org/licenses/mit-license.php "MIT License"
[STLport]: http://www.stlport.org/ "STLport"
[Browse Source]: http://github.com/okomok/ngl/tree/master/src/main/scala "Browse Source"
[Browse Test Source]: http://github.com/okomok/ngl/tree/master/src/test/scala "Browse Test Source"
[The Scala Programming Language]: http://www.scala-lang.org/ "The Scala Programming Language"
