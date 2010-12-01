

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ngltest


import com.github.okomok.ngl


class ExampleTest extends org.scalatest.junit.JUnit3Suite {

    def testTrivial {
        val numbers = Array(5, 2, 4, 3, 1, 6)
        ngl.partial_sort(numbers, 0, 3, 6)
        assert(java.util.Arrays.equals(numbers, Array(1, 2, 3, 5, 4, 6)))
    }

}