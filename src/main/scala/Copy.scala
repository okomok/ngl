

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ngl


// Note:
// v.foreach(w.writer(0)) would be enough if java didn't love heap.
//
// v.foreach(aStream.put(_)) can be written as
// v.copy(0, v.size, Output(aStream.put(_)), 0)


private object Copy {
    def apply[A, B >: A](v : Seq[A], __first: Int, __last: Int, ^ : Seq[B], result: Int): Int = {
        CopyIf(v, __first, __last, ^, result, { (x: A) => true })
    }
}

private object CopyIf {
    def apply[A, B >: A](v : Seq[A], __first: Int, __last: Int, ^ : Seq[B], result: Int, __pred: A => Boolean): Int = {
        var __result = result
        ForEach(v, __first, __last, { (x: A) => if (__pred(x)) { ^(__result) = x; __result += 1 } })
        __result
    }
}
