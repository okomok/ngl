

// Copyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ngl


private object Accumulate {
    def apply[A, B](v: Seq[A], __first: Int, __last: Int, init: B, __binary_op: (B, A) => B): B = {
        var __init = init
        ForEach(v, __first, __last, { (x: A) => __init = __binary_op(__init, x) })
        __init
    }
}
