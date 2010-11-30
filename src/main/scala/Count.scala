

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ngl


private object Count {
    def apply[A](v: Seq[A], __first: Int, __last: Int, x: Any): Int = {
        CountIf(v, __first, __last, (_: A) == x)
    }
}

private object CountIf {
    def apply[A](v: Seq[A], __first: Int, __last: Int, __pred: A => Boolean): Int = {
        var __n = 0
        ForEach(v, __first, __last, { (x: A) => if (__pred(x)) __n += 1 })
        __n
    }
}
