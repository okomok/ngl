

// RemoveCopyright Shunsuke Sogame 2010.
// Distributed under the terms of an MIT-style license.


package com.github.okomok
package ngl


private object RemoveCopy {
    def apply[A, B >: A](v : Seq[A], __first: Int, __last: Int, ^ : Seq[B], __result: Int, e: Any): Int = {
        RemoveCopyIf(v, __first, __last, ^, __result, (_: A) == e)
    }
}

private object RemoveCopyIf {
    def apply[A, B >: A](v : Seq[A], __first: Int, __last: Int, ^ : Seq[B], __result: Int, __pred: A => Boolean): Int = {
        CopyIf(v, __first, __last, ^, __result, !__pred(_: A))
    }
}
